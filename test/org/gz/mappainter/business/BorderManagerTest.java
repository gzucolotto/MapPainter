package org.gz.mappainter.business;

import java.util.HashSet;

import org.gz.mappainter.model.Border;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.gz.mappainter.business.utils.Utils;

public class BorderManagerTest {

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
	
	private String toString(HashSet hs) {
		return Utils.toString(hs);
	}
	
	@Test
	public void testCreateBorders1x1() {
		int[][] map = {{1}};
		
		BorderManager bm = new BorderManager(map);
		bm.createBorders(0, 0);
		
		Border north = new Border(0, 0, 0, 1);
		Border south = new Border(1, 0, 1, 1);
		Border east = new Border(0, 1, 1, 1);
		Border west = new Border(0, 0, 1, 0);
		
		Assert.assertTrue(bm.borders.contains(north));
		Assert.assertTrue(bm.borders.contains(south));
		Assert.assertTrue(bm.borders.contains(east));
		Assert.assertTrue(bm.borders.contains(west));
		Assert.assertEquals(4, bm.borders.size());
	}
	
	@Test
	public void testCreateBorders1x2() {
		int[][] map = {{1, 1}};
		
		BorderManager bm = new BorderManager(map);
		bm.createBorders(0, 0);
		
		Border north1 = new Border(0, 0, 0, 1);
		Border south1 = new Border(1, 0, 1, 1);
		Border north2 = new Border(0, 1, 0, 2);
		Border south2 = new Border(1, 1, 1, 2);
		Border east = new Border(0, 2, 1, 2);
		Border west = new Border(0, 0, 1, 0);
		
		System.out.println(toString(bm.borders));
		
		Assert.assertTrue(bm.borders.contains(north1));
		Assert.assertTrue(bm.borders.contains(south1));
		Assert.assertTrue(bm.borders.contains(west));
		
		bm.createBorders(0, 1);
		System.out.println(toString(bm.borders));
		Assert.assertTrue(bm.borders.contains(north2));
		Assert.assertTrue(bm.borders.contains(south2));
		Assert.assertTrue(bm.borders.contains(east));
		
		Assert.assertEquals(6, bm.borders.size());
	}
	
	@Test
	public void testCreateBorders2x1() {
		int[][] map = {{1}, {1}};
		
		BorderManager bm = new BorderManager(map);
		bm.createBorders(0, 0);
		
		Border north = new Border(0, 0, 0, 1);
		Border south = new Border(2, 0, 2, 1);
		Border west1 = new Border(0, 0, 1, 0);
		Border west2 = new Border(1, 0, 2, 0);
		Border east1 = new Border(0, 1, 1, 1);
		Border east2 = new Border(1, 1, 2, 1);
		
		System.out.println(toString(bm.borders));
		
		Assert.assertTrue(bm.borders.contains(north));
		Assert.assertTrue(bm.borders.contains(east1));
		Assert.assertTrue(bm.borders.contains(west1));
		
		bm.createBorders(1, 0);
		System.out.println(toString(bm.borders));
		Assert.assertTrue(bm.borders.contains(south));
		Assert.assertTrue(bm.borders.contains(west2));
		Assert.assertTrue(bm.borders.contains(east2));
		
		Assert.assertEquals(6, bm.borders.size());
	}
	
	@Test
	public void testCreateBorders1x2_distinct() {
		int[][] map = {{1, 2}};
		
		BorderManager bm = new BorderManager(map);
		bm.createBorders(0, 0);
		
		Border north1 = new Border(0, 0, 0, 1);
		Border south1 = new Border(1, 0, 1, 1);
		Border north2 = new Border(0, 1, 0, 2);
		Border south2 = new Border(1, 1, 1, 2);
		Border east = new Border(0, 2, 1, 2);
		Border west = new Border(0, 0, 1, 0);
		Border midle = new Border(0, 1, 1, 1);
		
		System.out.println(toString(bm.borders));
		
		Assert.assertTrue(bm.borders.contains(north1));
		Assert.assertTrue(bm.borders.contains(south1));
		Assert.assertTrue(bm.borders.contains(west));
		Assert.assertTrue(bm.borders.contains(midle));
		
		bm.createBorders(0, 1);
		System.out.println(toString(bm.borders));
		Assert.assertTrue(bm.borders.contains(north2));
		Assert.assertTrue(bm.borders.contains(south2));
		Assert.assertTrue(bm.borders.contains(east));
		
		Assert.assertEquals(7, bm.borders.size());
	}
	
	@Test
	public void testCreateBorders2x1_distinct() {
		int[][] map = {{1}, {2}};
		
		BorderManager bm = new BorderManager(map);
		bm.createBorders(0, 0);
		
		Border north = new Border(0, 0, 0, 1);
		Border south = new Border(2, 0, 2, 1);
		Border midle = new Border(1, 0, 1, 1);
		Border west1 = new Border(0, 0, 1, 0);
		Border west2 = new Border(1, 0, 2, 0);
		Border east1 = new Border(0, 1, 1, 1);
		Border east2 = new Border(1, 1, 2, 1);
		
		System.out.println(toString(bm.borders));
		
		Assert.assertTrue(bm.borders.contains(north));
		Assert.assertTrue(bm.borders.contains(east1));
		Assert.assertTrue(bm.borders.contains(west1));
		Assert.assertTrue(bm.borders.contains(midle));
		
		bm.createBorders(1, 0);
		System.out.println(toString(bm.borders));
		Assert.assertTrue(bm.borders.contains(south));
		Assert.assertTrue(bm.borders.contains(west2));
		Assert.assertTrue(bm.borders.contains(east2));
		
		Assert.assertEquals(7, bm.borders.size());
	}
	
	@Test
	public void testCreateBorders2x2() {
		int[][] map = {{1, 1}, {1, 1}};
		
		BorderManager bm = new BorderManager(map);
		bm.createBorders(0, 0);
		bm.createBorders(1, 0);
		bm.createBorders(0, 1);
		bm.createBorders(1, 1);
		
		Border north1 = new Border(0, 0, 0, 1);
		Border south1 = new Border(2, 0, 2, 1);
		Border north2 = new Border(0, 1, 0, 2);
		Border south2 = new Border(2, 1, 2, 2);
		Border west1 = new Border(0, 0, 1, 0);
		Border west2 = new Border(1, 0, 2, 0);
		Border east1 = new Border(0, 2, 1, 2);
		Border east2 = new Border(1, 2, 2, 2);
		
		System.out.println(toString(bm.borders));
		
		Assert.assertTrue(bm.borders.contains(north1));
		Assert.assertTrue(bm.borders.contains(east1));
		Assert.assertTrue(bm.borders.contains(west1));
		Assert.assertTrue(bm.borders.contains(north2));
		Assert.assertTrue(bm.borders.contains(south1));
		Assert.assertTrue(bm.borders.contains(south2));
		Assert.assertTrue(bm.borders.contains(west2));
		Assert.assertTrue(bm.borders.contains(east2));
		
		Assert.assertEquals(8, bm.borders.size());
	}

}
