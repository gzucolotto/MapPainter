package org.gz.mappainter.utils;


import java.util.HashSet;

import org.gz.mappainter.business.utils.Utils;
import org.gz.mappainter.model.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UtilsTest {

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
	public void testMatrixToString() {
		int[][] m = {{1, 2}, {3, 4}};
		String response = Utils.toString(m);
		Assert.assertEquals("{{1, 2},{3, 4}};", response);
	}
	
	@Test
	public void testNodesToString() {
		HashSet<Node> hn = new HashSet<Node>();
		
		hn.add(new Node(1));
		hn.add(new Node(2));
		hn.add(new Node(3));
		
		String response = Utils.toString(hn);
		Assert.assertEquals("[(1,-1); (2,-1); (3,-1)]", response);
	}

}
