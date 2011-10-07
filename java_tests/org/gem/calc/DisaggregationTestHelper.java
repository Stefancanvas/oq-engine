package org.gem.calc;

public class DisaggregationTestHelper
{
	public static final Double[] LAT_BIN_LIMS = {-0.6, -0.3, -0.1, 0.1, 0.3, 0.6};
	public static final Double[] LON_BIN_LIMS = {-0.6, -0.3, -0.1, 0.1, 0.3, 0.6};
	public static final Double[] MAG_BIN_LIMS = {5.0, 6.0, 7.0, 8.0, 9.0};
	public static final Double[] EPS_BIN_LIMS = {-3.5, -2.5, -1.5, -0.5, 0.5, 1.5, 2.5, 3.5};
	public static final Double[] DIST_BIN_LIMS = {0.0, 20.0, 40.0, 60.0};
	public static final double POE = 0.1;
	
	public static final double[][][][][] EXPECTED =
		{{{{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.007220216606498195, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.007220216606498195, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}}},
		 {{{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.007220216606498195, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.032490974729241874, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.021660649819494584, 0.0, 0.0, 0.0, 0.0},
		    {0.007220216606498195, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.010830324909747292, 0.0, 0.0, 0.0, 0.0},
		    {0.007220216606498195, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.010830324909747292, 0.0, 0.0, 0.0, 0.0},
		    {0.010830324909747292, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.010830324909747292, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.010830324909747292, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.007220216606498195, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}}},
		 {{{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.007220216606498195, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.09025270758122744, 0.0, 0.0, 0.0, 0.0},
		    {0.3574007220216607, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.01444043321299639, 0.0, 0.0, 0.0, 0.0},
		    {0.007220216606498195, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.06859205776173286, 0.0, 0.0, 0.0, 0.0},
		    {0.007220216606498195, 0.0, 0.0, 0.0, 0.0},
		    {0.05054151624548736, 0.0, 0.0, 0.0, 0.0},
		    {0.007220216606498195, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.010830324909747292, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.02527075812274368, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.010830324909747292, 0.0, 0.0, 0.0, 0.0},
		    {0.010830324909747292, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}}},
		 {{{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.01444043321299639, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.007220216606498195, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.007220216606498195, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.007220216606498195, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.010830324909747292, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}}},
		 {{{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.010830324909747292, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0036101083032490976, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}},
		  {{{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}},
		   {{0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0, 0.0, 0.0}}}}};
}
