package org.gz.mappainter.business;

import java.util.HashMap;
import java.util.HashSet;

import org.gz.mappainter.business.utils.Utils;
import org.gz.mappainter.model.Border;
import org.gz.mappainter.model.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RegionDelimiterTest {

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
	public void test1x1() {
		int[][] map = {{1}};
		RegionDelimiter rd = new RegionDelimiter(map);
		
		rd.generateRegions();
		
		HashSet<Border> borders = rd.getBorders();
		Assert.assertFalse(borders.isEmpty());
		Assert.assertEquals(4, borders.size());
		
		HashSet<Node> nodes = rd.getNodes();
		Assert.assertFalse(nodes.isEmpty());
		Assert.assertEquals(1, nodes.size());
	}
	
	@Test
	public void test1x2() {
		int[][] map = {{1, 1}};
		RegionDelimiter rd = new RegionDelimiter(map);
		
		rd.generateRegions();
		
		HashSet<Border> borders = rd.getBorders();
		System.out.println("Borders: " + toString(borders));
		
		HashSet<Node> nodes = rd.getNodes();
		System.out.println("Nodes: " + toString(nodes));
		
		Assert.assertFalse(borders.isEmpty());
		Assert.assertEquals(6, borders.size());
		
		
		Assert.assertFalse(nodes.isEmpty());
		Assert.assertEquals(1, nodes.size());
	}
	
	@Test
	public void test2x1() {
		int[][] map = {{1}, {1}};
		RegionDelimiter rd = new RegionDelimiter(map);
		
		rd.generateRegions();
		
		HashSet<Border> borders = rd.getBorders();
		System.out.println("Borders: " + toString(borders));
		
		HashSet<Node> nodes = rd.getNodes();
		System.out.println("Nodes: " + toString(nodes));
		
		Assert.assertFalse(borders.isEmpty());
		Assert.assertEquals(6, borders.size());
		
		
		Assert.assertFalse(nodes.isEmpty());
		Assert.assertEquals(1, nodes.size());
	}
	
	@Test
	public void test2x2() {
		int[][] map = {{1, 1}, {1, 1}};
		RegionDelimiter rd = new RegionDelimiter(map);
		
		rd.generateRegions();
		
		HashSet<Border> borders = rd.getBorders();
		System.out.println("Borders: " + toString(borders));
		
		HashSet<Node> nodes = rd.getNodes();
		System.out.println("Nodes: " + toString(nodes));
		
		Assert.assertFalse(borders.isEmpty());
		Assert.assertEquals(8, borders.size());
		
		
		Assert.assertFalse(nodes.isEmpty());
		Assert.assertEquals(1, nodes.size());
	}
	
	@Test
	public void test10x10_various_error_neigboring_9_10() {
		int[][] map = {
				{1, 1, 2, 3, 4, 5, 6, 7, 8, 8},
				{1, 2, 2, 3, 4, 5, 6, 7, 8, 8},
				{2, 2, 3, 3, 4, 5, 6, 7, 7, 7},
				{2, 3, 3, 4, 4, 5, 6, 7, 7, 7},
				{3, 3, 4, 4, 5, 5, 6, 6, 6, 6},
				{4, 4, 4, 5, 5, 6, 6, 6, 6, 6},
				{5, 5, 5, 5, 6, 6, 6, 9, 9, 6},
				{6, 6, 6, 6, 6, 6, 6, 10, 10, 6},
				{6, 6, 6, 6, 6, 6, 6, 10, 10, 10},
				{6, 6, 6, 6, 6, 6, 6, 6, 6, 10}};
		
		RegionDelimiter rd = new RegionDelimiter(map);
		rd.generateRegions();
		rd.doIndexNodes();
		HashMap<Integer, Node> indexedNodes = rd.getIndexedNodes();
		
		HashSet<Node> nodes = rd.getNodes();
		System.out.println("Nodes: " + toString(nodes));
		Assert.assertEquals(10, nodes.size());
		
		Node n6 = indexedNodes.get(6);
		Node n9 = indexedNodes.get(9);
		Node n10 = indexedNodes.get(10);
		System.out.println("n10=" + n10.toString());
		System.out.println("n10.neighbors=" + n10.getSortedNeighbours());
		
		Assert.assertTrue(n6.getSortedNeighbours().contains(n9));
		Assert.assertTrue(n6.getSortedNeighbours().contains(n10));
		Assert.assertTrue(n9.getSortedNeighbours().contains(n10));
		Assert.assertTrue(n10.getSortedNeighbours().contains(n9));
		Assert.assertTrue(n10.getSortedNeighbours().contains(n6));
		
		Boolean allDiff = (((n6.getIndex() != n9.getIndex()) && (n9.getIndex() != n10.getIndex())) && (n6.getIndex() != n10.getIndex()));
		Assert.assertTrue("All conected nodes should have distinct indexes.", allDiff);
	}
	
	@Test
	public void test5x4_various() {
		int[][] map = {
				{6, 7, 7, 7},
				{6, 6, 6, 6},
				{6, 9, 9, 6},
				{6, 10, 10, 6},
				{6, 10, 10, 10},
				{6, 6, 6, 10}};
		
		RegionDelimiter rd = new RegionDelimiter(map);
		rd.generateRegions();
		rd.doIndexNodes();
		
		HashSet<Node> nodes = rd.getNodes();
		System.out.println("Nodes: " + toString(nodes));
		Assert.assertEquals(4, nodes.size());
	}

}
