# nhlib: A New Hazard Library
# Copyright (C) 2012 GEM Foundation
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU Affero General Public License as
# published by the Free Software Foundation, either version 3 of the
# License, or (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Affero General Public License for more details.
#
# You should have received a copy of the GNU Affero General Public License
# along with this program.  If not, see <http://www.gnu.org/licenses/>.

from nhlib.gsim.akkar_bommer_2010 import AkB_2010_AttenRel
from tests.gsim.utils import BaseGSIMTestCase

class AkkarBommer2010TestCase(BaseGSIMTestCase):
    GSIM_CLASS = AkB_2010_AttenRel
    
    # Test data were obtained from a tool given by the authors
    # The data of the values of the mean PGA and SA are in m/s2.
     
    def test_mean_normal(self):
        self.check('AKBO10/AK10_MEDIAN_NM.csv',
                    max_discrep_percentage=0.6) 

    def test_mean_reverse(self):
        self.check('AKBO10/AK10_MEDIAN_RV.csv',
                    max_discrep_percentage=0.6)
                   
    def test_mean_strike_slip(self):
        self.check('AKBO10/AK10_MEDIAN_SS.csv',
                    max_discrep_percentage=0.6)
                    
    def test_std_intra(self):
        self.check('AKBO10/AK10_STD_INTRA.csv',
                    max_discrep_percentage=0.1)
                    
    def test_std_inter(self):
        self.check('AKBO10/AK10_STD_INTER.csv',
                    max_discrep_percentage=0.1)
                    
    def test_std_total(self):
        self.check('AKBO10/AK10_STD_TOTAL.csv',
                    max_discrep_percentage=0.1)

