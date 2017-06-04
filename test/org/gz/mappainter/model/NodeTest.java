package org.gz.mappainter.model;

import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NodeTest {

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
	public void testComparableSequence() {
		Node a = new Node(1);
		a.index = 1;
		
		Node b = new Node(2);
		b.index = 2;
		
		Node c = new Node(3);
		c.index = -1;
		
		a.addNeighbor(b);
		a.addNeighbor(c);
		b.addNeighbor(c);
		
		Assert.assertEquals(-1, a.compareTo(b));
		Assert.assertEquals(1, a.compareTo(c));
		Assert.assertEquals(1, b.compareTo(a));
		
		Iterator<Node> it = a.getSortedNeighbours().iterator();
		Node n = it.next();
		while (it.hasNext()) {
			Node next = it.next();
			System.out.println("n=" + n + ", next=" + next);
			Assert.assertTrue("Nodes sorted out of order...", n.index < next.index);
			n = next;
		}
	}
	
	@Test
	public void testNeighborSequence() {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		
		a.addNeighbor(b);
		a.addNeighbor(c);
		
		c.index = 1;
		b.index = 3;
		
		Iterator<Node> it = a.getSortedNeighbours().iterator();
		Node n = it.next();
		while (it.hasNext()) {
			Node next = it.next();
			System.out.println("n=" + n + ", next=" + next);
			Assert.assertTrue("Nodes sorted out of order...", n.index < next.index);
			n = next;
		}
	}

}
