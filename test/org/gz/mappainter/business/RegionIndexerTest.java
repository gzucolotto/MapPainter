package org.gz.mappainter.business;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RegionIndexerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1x1() {
		int[][] map = {{100}};
		MapNormalizer ri = new MapNormalizer(map);
		
		ri.indexRegions();
		int[][] indexMap = ri.getIndexMap();
		
		Assert.assertEquals(1, indexMap[0][0]);
		Assert.assertEquals(100, map[0][0]);
	}
	
	@Test
	public void test2x2() {
		int[][] map = {{100, 100}, {100, 200}};
		MapNormalizer ri = new MapNormalizer(map);
		
		ri.indexRegions();
		int[][] indexMap = ri.getIndexMap();
		
		Assert.assertEquals(1, indexMap[0][0]);
		Assert.assertEquals(1, indexMap[0][1]);
		Assert.assertEquals(1, indexMap[1][0]);
		Assert.assertEquals(2, indexMap[1][1]);
		
		Assert.assertEquals(100, map[0][0]);
		Assert.assertEquals(100, map[0][1]);
		Assert.assertEquals(100, map[1][0]);
		Assert.assertEquals(200, map[1][1]);
	}

}
