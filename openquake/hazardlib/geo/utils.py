# -*- coding: utf-8 -*-
# vim: tabstop=4 shiftwidth=4 softtabstop=4
#
# Copyright (C) 2012-2018 GEM Foundation
#
# OpenQuake is free software: you can redistribute it and/or modify it
# under the terms of the GNU Affero General Public License as published
# by the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# OpenQuake is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Affero General Public License for more details.
#
# You should have received a copy of the GNU Affero General Public License
# along with OpenQuake. If not, see <http://www.gnu.org/licenses/>.

"""
Module :mod:`openquake.hazardlib.geo.utils` contains functions that are common
to several geographical primitives and some other low-level spatial operations.
"""
import logging
import operator
import collections
import rtree
import numpy
import shapely.geometry

from openquake.hazardlib.geo import geodetic
from openquake.hazardlib.geo.geodetic import EARTH_RADIUS, geodetic_distance
from openquake.baselib.slots import with_slots

U32 = numpy.uint32
SphericalBB = collections.namedtuple('SphericalBB', 'west east north south')


class SiteAssociationError(Exception):
    """Raised when there are no sites close enough"""


class _GeographicObjects(object):
    """
    Store a collection of geographic objects, i.e. objects with lons, lats.
    It is possible to extract the closest object to a given location by
    calling the method .get_closest(lon, lat).
    """
    def __init__(self, objects):
        self.objects = objects
        if hasattr(objects, 'lons'):
            self.lons = objects.lons
            self.lats = objects.lats
        elif isinstance(objects, numpy.ndarray):
            self.lons = objects['lon']
            self.lats = objects['lat']

        self.proj = OrthographicProjection.from_lons_lats(
            self.lons, self.lats)
        xs, ys = self.proj(self.lons, self.lats)
        self.index = rtree.index.Index()
        # no http://toblerity.org/rtree/performance.html#use-stream-loading!
        for i, (x, y) in enumerate(zip(xs, ys)):
            self.index.insert(i, (x, y, x, y))

    def get_closest(self, lon, lat):
        """
        Get the closest object to the given longitude and latitude
        and its distance.

        :param lon: longitude in degrees
        :param lat: latitude in degrees
        :param max_distance: distance in km (or None)
        """
        x, y = self.proj(lon, lat)
        idx = list(self.index.nearest((x, y, x, y), 1))[0]
        min_dist = geodetic_distance(
            lon, lat, self.lons[idx], self.lats[idx])
        return self.objects[idx], min_dist

    def assoc(self, sitecol, assoc_dist, mode):
        """
        :param sitecol: a (filtered) site collection
        :param assoc_dist: the maximum distance for association
        :param mode: 'strict', 'warn' or 'filter'
        :returns: (filtered site collection, filtered objects)
        """
        assert mode in 'strict warn filter', mode
        dic = {}
        for sid, lon, lat in zip(sitecol.sids, sitecol.lons, sitecol.lats):
            obj, distance = self.get_closest(lon, lat)
            if assoc_dist is None:
                dic[sid] = obj  # associate all
            elif distance <= assoc_dist:
                dic[sid] = obj  # associate within
            elif mode == 'warn':
                dic[sid] = obj  # associate outside
                logging.warn('Association to %s km from site (%s %s)',
                             distance, lon, lat)
            elif mode == 'filter':
                pass  # do not associate
            elif mode == 'strict':
                raise SiteAssociationError(
                    'There is nothing closer than %s km '
                    'to site (%s %s)' % (assoc_dist, lon, lat))
        if not dic:
            raise SiteAssociationError(
                'No sites could be associated within %s km' % assoc_dist)
        return (sitecol.filtered(dic),
                numpy.array([dic[sid] for sid in sorted(dic)]))

    def assoc2(self, assets_by_site, assoc_dist, mode):
        """
        Associated a list of assets by site to the site collection used
        to instantiate GeographicObjects.

        :param assets_by_sites: a list of lists of assets
        :param assoc_dist: the maximum distance for association
        :param mode: 'strict' or 'warn'
        :returns: (filtered site collection, filtered assets by site)
        """
        assert mode in 'strict warn', mode
        self.objects.filtered  # self.objects must be a SiteCollection
        assets_by_sid = collections.defaultdict(list)
        for assets in assets_by_site:
            lon, lat = assets[0].location
            obj, distance = self.get_closest(lon, lat)
            if distance <= assoc_dist:
                # keep the assets, otherwise discard them
                assets_by_sid[obj['sids']].extend(assets)
            elif mode == 'strict':
                raise SiteAssociationError(
                    'There is nothing closer than %s km '
                    'to site (%s %s)' % (assoc_dist, lon, lat))
            elif mode == 'warn':
                logging.warn('Discarding %s, lon=%.5f, lat=%.5f',
                             assets, lon, lat)
        sids = sorted(assets_by_sid)
        if not sids:
            raise SiteAssociationError(
                'Could not associate any site to any assets within the '
                'asset_hazard_distance of %s km' % assoc_dist)
        assets_by_site = [
            sorted(assets_by_sid[sid], key=operator.attrgetter('ordinal'))
            for sid in sids]
        return self.objects.filtered(sids), assets_by_site


def get_min_distance(mesh1, mesh2):
    """
    Get the minimum distance between 2D meshes by using rtree
    """
    go = _GeographicObjects(mesh1)
    min_dist = min(go.get_closest(lon, lat)[1]
                   for lon, lat in zip(mesh2.lons, mesh2.lats))
    return min_dist


def assoc(objects, sitecol, assoc_dist, mode):
    """
    Associate geographic objects to a site collection.

    :param objects:
        something with .lons, .lats or ['lon'] ['lat'], or a list of lists
        of objects with a .location attribute (i.e. assets_by_site)
    :param assoc_dist:
        the maximum distance for association
    :param mode:
        if 'strict' fail if at least one site is not associated
        if 'error' fail if all sites are not associated
    :returns: (filtered site collection, filtered objects)
    """
    if isinstance(objects, numpy.ndarray) or hasattr(objects, 'lons'):
        # objects is a geo array with lon, lat fields or a mesh-like instance
        return _GeographicObjects(objects).assoc(sitecol, assoc_dist, mode)
    else:  # objects is the list assets_by_site
        return _GeographicObjects(sitecol).assoc2(objects, assoc_dist, mode)


def clean_points(points):
    """
    Given a list of :class:`~openquake.hazardlib.geo.point.Point` objects,
    return a new list with adjacent duplicate points removed.
    """
    if not points:
        return points

    result = [points[0]]
    for point in points:
        if point != result[-1]:
            result.append(point)
    return result


def line_intersects_itself(lons, lats, closed_shape=False):
    """
    Return ``True`` if line of points intersects itself.
    Line with the last point repeating the first one considered
    intersecting itself.

    The line is defined by lists (or numpy arrays) of points'
    longitudes and latitudes (depth is not taken into account).

    :param closed_shape:
        If ``True`` the line will be checked twice: first time with
        its original shape and second time with the points sequence
        being shifted by one point (the last point becomes first,
        the first turns second and so on). This is useful for
        checking that the sequence of points defines a valid
        :class:`~openquake.hazardlib.geo.polygon.Polygon`.
    """
    assert len(lons) == len(lats)

    if len(lons) <= 3:
        # line can not intersect itself unless there are
        # at least four points
        return False

    west, east, north, south = get_spherical_bounding_box(lons, lats)
    proj = get_orthographic_projection(west, east, north, south)

    xx, yy = proj(lons, lats)
    if not shapely.geometry.LineString(list(zip(xx, yy))).is_simple:
        return True

    if closed_shape:
        xx, yy = proj(numpy.roll(lons, 1), numpy.roll(lats, 1))
        if not shapely.geometry.LineString(list(zip(xx, yy))).is_simple:
            return True

    return False


def get_longitudinal_extent(lon1, lon2):
    """
    Return the distance between two longitude values as an angular measure.
    Parameters represent two longitude values in degrees.

    :return:
        Float, the angle between ``lon1`` and ``lon2`` in degrees. Value
        is positive if ``lon2`` is on the east from ``lon1`` and negative
        otherwise. Absolute value of the result doesn't exceed 180 for
        valid parameters values.
    """
    return (lon2 - lon1 + 180) % 360 - 180


def get_spherical_bounding_box(lons, lats):
    """
    Given a collection of points find and return the bounding box,
    as a pair of longitudes and a pair of latitudes.

    Parameters define longitudes and latitudes of a point collection
    respectively in a form of lists or numpy arrays.

    :return:
        A tuple of four items. These items represent western, eastern,
        northern and southern borders of the bounding box respectively.
        Values are floats in decimal degrees.
    :raises ValueError:
        If points collection has the longitudinal extent of more than
        180 degrees (it is impossible to define a single hemisphere
        bound to poles that would contain the whole collection).
    """
    north, south = numpy.max(lats), numpy.min(lats)
    west, east = numpy.min(lons), numpy.max(lons)
    assert (-180 <= west <= 180) and (-180 <= east <= 180), (west, east)
    if get_longitudinal_extent(west, east) < 0:
        # points are lying on both sides of the international date line
        # (meridian 180). the actual west longitude is the lowest positive
        # longitude and east one is the highest negative.
        if hasattr(lons, 'flatten'):
            # fixes test_surface_crossing_international_date_line
            lons = lons.flatten()
        west = min(lon for lon in lons if lon > 0)
        east = max(lon for lon in lons if lon < 0)
        if not all((get_longitudinal_extent(west, lon) >= 0
                    and get_longitudinal_extent(lon, east) >= 0)
                   for lon in lons):
            raise ValueError('points collection has longitudinal extent '
                             'wider than 180 deg')
    return SphericalBB(west, east, north, south)


@with_slots
class OrthographicProjection(object):
    """
    Callable object to compute orthographic projections. See the docstring
    of get_orthographic_projection.
    """
    _slots_ = ('west east north south lambda0 phi0 '
               'cos_phi0 sin_phi0 sin_pi_over_4').split()

    @classmethod
    def from_lons_lats(cls, lons, lats):
        return cls(*get_spherical_bounding_box(lons, lats))

    def __init__(self, west, east, north, south):
        self.west = west
        self.east = east
        self.north = north
        self.south = south
        self.lambda0, self.phi0 = numpy.radians(
            get_middle_point(west, north, east, south))
        self.cos_phi0 = numpy.cos(self.phi0)
        self.sin_phi0 = numpy.sin(self.phi0)
        self.sin_pi_over_4 = (2 ** 0.5) / 2

    def __call__(self, lons, lats, reverse=False):
        if not reverse:
            lambdas, phis = numpy.radians(lons), numpy.radians(lats)
            cos_phis = numpy.cos(phis)
            lambdas -= self.lambda0
            # calculate the sine of the distance between projection center
            # and each of the points to project
            sin_dist = numpy.sqrt(
                numpy.sin((self.phi0 - phis) / 2.0) ** 2.0
                + self.cos_phi0 * cos_phis * numpy.sin(lambdas / 2.0) ** 2.0
            )
            if (sin_dist > self.sin_pi_over_4).any():
                raise ValueError('some points are too far from the projection '
                                 'center lon=%s lat=%s' %
                                 (numpy.degrees(self.lambda0),
                                  numpy.degrees(self.phi0)))
            xx = numpy.cos(phis) * numpy.sin(lambdas)
            yy = (self.cos_phi0 * numpy.sin(phis) - self.sin_phi0 * cos_phis
                  * numpy.cos(lambdas))
            return xx * EARTH_RADIUS, yy * EARTH_RADIUS
        else:
            # "reverse" mode, arguments are actually abscissae
            # and ordinates in 2d space
            xx, yy = lons / EARTH_RADIUS, lats / EARTH_RADIUS
            cos_c = numpy.sqrt(1 - (xx ** 2 + yy ** 2))
            phis = numpy.arcsin(cos_c * self.sin_phi0 + yy * self.cos_phi0)
            lambdas = numpy.arctan2(
                xx, self.cos_phi0 * cos_c - yy * self.sin_phi0)
            xx = numpy.degrees(self.lambda0 + lambdas)
            yy = numpy.degrees(phis)
            # shift longitudes greater than 180 back into the western
            # hemisphere, that is in range [0, -180], and longitudes
            # smaller than -180, to the heastern emisphere [0, 180]
            idx = xx >= 180.
            xx[idx] = xx[idx] - 360.
            idx = xx <= -180.
            xx[idx] = xx[idx] + 360.
            return xx, yy


def get_orthographic_projection(west, east, north, south):
    """
    Create and return a projection object for a given bounding box.

    :returns:
        callable OrthographicProjection object that can perform both forward
        and reverse projection (converting from longitudes and latitudes to x
        and y values on 2d-space and vice versa). The call takes three
        arguments: first two are numpy arrays of longitudes and latitudes *or*
        abscissae and ordinates of points to project and the third one
        is a boolean that allows to choose what operation is requested --
        is it forward or reverse one. ``True`` value given to third
        positional argument (or keyword argument "reverse") indicates
        that the projection of points in 2d space back to earth surface
        is needed. The default value for "reverse" argument is ``False``,
        which means forward projection (degrees to kilometers).

        Raises ``ValueError`` in forward projection
        mode if any of the target points is further than 90 degree
        (along the great circle arc) from the projection center.

    Parameters are given as floats, representing decimal degrees (first two
    are longitudes and last two are latitudes). They define a bounding box
    in a spherical coordinates of the collection of points that is about
    to be projected. The center point of the projection (coordinates (0, 0)
    in Cartesian space) is set to the middle point of that bounding box.
    The resulting projection is defined for spherical coordinates that are
    not further from the bounding box center than 90 degree on the great
    circle arc.

    The result projection is of type `Orthographic
    <http://mathworld.wolfram.com/OrthographicProjection.html>`_.
    This projection is prone to distance, area and angle distortions
    everywhere outside of the center point, but still can be used for
    checking shapes: verifying if line intersects itself (like in
    :func:`line_intersects_itself`) or if point is inside of a polygon
    (like in :meth:`openquake.hazardlib.geo.polygon.Polygon.discretize`). It
    can be also used for measuring distance to an extent of around 700
    kilometers (error doesn't exceed 1 km up until then).
    """
    return OrthographicProjection(west, east, north, south)


def get_middle_point(lon1, lat1, lon2, lat2):
    """
    Given two points return the point exactly in the middle lying on the same
    great circle arc.

    Parameters are point coordinates in degrees.

    :returns:
        Tuple of longitude and latitude of the point in the middle.
    """
    if lon1 == lon2 and lat1 == lat2:
        return lon1, lat1
    dist = geodetic.geodetic_distance(lon1, lat1, lon2, lat2)
    azimuth = geodetic.azimuth(lon1, lat1, lon2, lat2)
    return geodetic.point_at(lon1, lat1, azimuth, dist / 2.0)


def spherical_to_cartesian(lons, lats, depths):
    """
    Return the position vectors (in Cartesian coordinates) of list of spherical
    coordinates.

    For equations see: http://mathworld.wolfram.com/SphericalCoordinates.html.

    Parameters are components of spherical coordinates in a form of scalars,
    lists or numpy arrays. ``depths`` can be ``None`` in which case it's
    considered zero for all points.

    :returns:
        ``numpy.array`` of 3d vectors representing points' coordinates in
        Cartesian space. The array has the same shape as parameter arrays.
        In particular it means that if ``lons`` and ``lats`` are scalars,
        the result is a single 3d vector. Vector of length ``1`` represents
        distance of 1 km.

    See also :func:`cartesian_to_spherical`.
    """
    phi = numpy.radians(lons)
    theta = numpy.radians(lats)
    if depths is None:
        rr = EARTH_RADIUS
    else:
        rr = EARTH_RADIUS - numpy.array(depths)
    cos_theta_r = rr * numpy.cos(theta)
    xx = cos_theta_r * numpy.cos(phi)
    yy = cos_theta_r * numpy.sin(phi)
    zz = rr * numpy.sin(theta)
    vectors = numpy.array([xx.transpose(), yy.transpose(), zz.transpose()]) \
                   .transpose()
    return vectors


def cartesian_to_spherical(vectors):
    """
    Return the spherical coordinates for coordinates in Cartesian space.

    This function does an opposite to :func:`spherical_to_cartesian`.

    :param vectors:
        Array of 3d vectors in Cartesian space.
    :returns:
        Tuple of three arrays of the same shape as ``vectors`` representing
        longitude (decimal degrees), latitude (decimal degrees) and depth (km)
        in specified order.
    """
    rr = numpy.sqrt(numpy.sum(vectors * vectors, axis=-1))
    xx, yy, zz = vectors.transpose()
    xx = xx.transpose()
    yy = yy.transpose()
    zz = zz.transpose()
    lats = numpy.degrees(numpy.arcsin((zz / rr).clip(-1., 1.)))
    lons = numpy.degrees(numpy.arctan2(yy, xx))
    depths = EARTH_RADIUS - rr
    return lons, lats, depths


def triangle_area(e1, e2, e3):
    """
    Get the area of triangle formed by three vectors.

    Parameters are three three-dimensional numpy arrays representing
    vectors of triangle's edges in Cartesian space.

    :returns:
        Float number, the area of the triangle in squared units of coordinates,
        or numpy array of shape of edges with one dimension less.

    Uses Heron formula, see http://mathworld.wolfram.com/HeronsFormula.html.
    """
    # calculating edges length
    e1_length = numpy.sqrt(numpy.sum(e1 * e1, axis=-1))
    e2_length = numpy.sqrt(numpy.sum(e2 * e2, axis=-1))
    e3_length = numpy.sqrt(numpy.sum(e3 * e3, axis=-1))
    # calculating half perimeter
    s = (e1_length + e2_length + e3_length) / 2.0
    # applying Heron's formula
    return numpy.sqrt(s * (s - e1_length) * (s - e2_length) * (s - e3_length))


def normalized(vector):
    """
    Get unit vector for a given one.

    :param vector:
        Numpy vector as coordinates in Cartesian space, or an array of such.
    :returns:
        Numpy array of the same shape and structure where all vectors are
        normalized. That is, each coordinate component is divided by its
        vector's length.
    """
    length = numpy.sum(vector * vector, axis=-1)
    length = numpy.sqrt(length.reshape(length.shape + (1, )))
    return vector / length


def point_to_polygon_distance(polygon, pxx, pyy):
    """
    Calculate the distance to polygon for each point of the collection
    on the 2d Cartesian plane.

    :param polygon:
        Shapely "Polygon" geometry object.
    :param pxx:
        List or numpy array of abscissae values of points to calculate
        the distance from.
    :param pyy:
        Same structure as ``pxx``, but with ordinate values.
    :returns:
        Numpy array of distances in units of coordinate system. Points
        that lie inside the polygon have zero distance.
    """
    pxx = numpy.array(pxx)
    pyy = numpy.array(pyy)
    assert pxx.shape == pyy.shape
    if pxx.ndim == 0:
        pxx = pxx.reshape((1, ))
        pyy = pyy.reshape((1, ))
    result = numpy.array([
        polygon.distance(shapely.geometry.Point(pxx.item(i), pyy.item(i)))
        for i in range(pxx.size)
    ])
    return result.reshape(pxx.shape)


def fix_lon(lon):
    """
    :returns: a valid longitude in the range -180 <= lon < 180

    >>> fix_lon(11)
    11
    >>> fix_lon(181)
    -179
    >>> fix_lon(-182)
    178
    """
    return (lon + 180) % 360 - 180


def cross_idl(lon1, lon2):
    """
    Return True if two longitude values define line crossing international date
    line.

    >>> cross_idl(-45, 45)
    False
    >>> cross_idl(-180, -179)
    False
    >>> cross_idl(180, 179)
    False
    >>> cross_idl(45, -45)
    False
    >>> cross_idl(0, 0)
    False
    >>> cross_idl(-170, 170)
    True
    >>> cross_idl(170, -170)
    True
    >>> cross_idl(-180, 180)
    True
    """
    # a line crosses the international date line if the end positions
    # have different sign and they are more than 180 degrees longitude apart
    return lon1 * lon2 < 0 and abs(lon1 - lon2) > 180


def normalize_lons(lon1, lon2):
    """
    An international date line safe way of returning a range of longitudes.

    >>> normalize_lons(20, 30)  # no IDL within the range
    [(20, 30)]
    >>> normalize_lons(-17, +17)  # no IDL within the range
    [(-17, 17)]
    >>> normalize_lons(-178, +179)
    [(-180, -178), (179, 180)]
    >>> normalize_lons(178, +181)
    [(-180, -179), (178, 180)]
    >>> normalize_lons(-181, -179)
    [(-180, -179), (179, 180)]
    >>> normalize_lons(-183, -176)
    [(-180, -176), (177, 180)]
    """
    l1, l2 = fix_lon(lon1), fix_lon(lon2)
    if l1 > l2:  # exchange lons
        l1, l2 = l2, l1
    delta = l2 - l1
    if l1 < 0 and l2 > 0 and delta > 180:
        return [(-180, l1), (l2, 180)]
    elif l1 > 0 and l2 > 180 and delta < 180:
        return [(l1, 180), (-180, l2 - 360)]
    elif l1 < -180 and l2 < 0 and delta < 180:
        return [(l1 + 360, 180), (l2, -180)]
    return [(l1, l2)]


def plane_fit(points):
    """
    This fits an n-dimensional plane to a set of points. See
    http://stackoverflow.com/questions/12299540/plane-fitting-to-4-or-more-xyz-points

    :parameter points:
        An instance of :class:~numpy.ndarray. The number of columns must be
        equal to three.
    :return:
         A point on the plane and the normal to the plane.
    """
    points = numpy.transpose(points)
    points = numpy.reshape(points, (numpy.shape(points)[0], -1))
    assert points.shape[0] < points.shape[1], points.shape
    ctr = points.mean(axis=1)
    x = points - ctr[:, None]
    M = numpy.dot(x, x.T)
    return ctr, numpy.linalg.svd(M)[0][:, -1]
