package org.gz.mappainter.business;

import org.gz.mappainter.model.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class NodeManagerTest {

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
	public void testNodeIncluded() {
		NodeManager nm = new NodeManager();
		
		nm.addNode(1);
		Assert.assertFalse(nm.indexedNodes.isEmpty());
	}
	
	@Test
	public void testIndexes() {
		NodeManager nm = new NodeManager();
		
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		
		a.addNeighbor(b);
		a.addNeighbor(c);
		b.addNeighbor(c);
		
		nm.addIfNewNode(a);
		nm.addIfNewNode(b);
		nm.addIfNewNode(c);
		nm.doIndex();
		
		System.out.println(nm.toString());
		
		Assert.assertEquals(1, a.getIndex());
		Assert.assertEquals(2, b.getIndex());
		Assert.assertEquals(3, c.getIndex());
	}
	
	@Test
	public void testIndexes_oneMissing() {
		NodeManager nm = new NodeManager();
		
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		
		a.setIndex(1);
		c.setIndex(3);
		
		a.addNeighbor(b);
		a.addNeighbor(c);
		b.addNeighbor(c);
		
		nm.addIfNewNode(a);
		nm.addIfNewNode(b);
		nm.addIfNewNode(c);
		nm.doIndex();
		
		System.out.println(nm.toString());
		
		Assert.assertEquals(1, a.getIndex());
		Assert.assertEquals(2, b.getIndex());
		Assert.assertEquals(3, c.getIndex());
	}
	
	@Test
	public void testIndexes_initialMissing() {
		NodeManager nm = new NodeManager();
		
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		
		a.setIndex(2);
		c.setIndex(3);
		
		a.addNeighbor(b);
		a.addNeighbor(c);
		b.addNeighbor(c);
		
		nm.addIfNewNode(a);
		nm.addIfNewNode(b);
		nm.addIfNewNode(c);
		nm.doIndex();
		
		System.out.println(nm.toString());
		
		Assert.assertEquals(2, a.getIndex());
		Assert.assertEquals(1, b.getIndex());
		Assert.assertEquals(3, c.getIndex());
	}
	
	@Test
	public void testIndexe_FindLast() {
		NodeManager nm = new NodeManager();
		
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		
		f.addNeighbor(a);
		f.addNeighbor(b);
		f.addNeighbor(c);
		f.addNeighbor(d);
		f.addNeighbor(e);
		
		a.setIndex(1);
		b.setIndex(2);
		c.setIndex(3);
		d.setIndex(4);
		e.setIndex(5);
		
		nm.addIfNewNode(a);
		nm.addIfNewNode(b);
		nm.addIfNewNode(c);
		nm.addIfNewNode(d);
		nm.addIfNewNode(e);
		nm.addIfNewNode(f);
		nm.doIndex();
		
		System.out.println(nm.toString());
		
		Assert.assertEquals(6, f.getIndex());
	}
	
	@Test
	public void testIndexe_FindInitial() {
		NodeManager nm = new NodeManager();
		
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		
		f.addNeighbor(a);
		f.addNeighbor(b);
		f.addNeighbor(c);
		f.addNeighbor(d);
		f.addNeighbor(e);
		
		a.setIndex(6);
		b.setIndex(2);
		c.setIndex(3);
		d.setIndex(4);
		e.setIndex(5);
		
		nm.addIfNewNode(a);
		nm.addIfNewNode(b);
		nm.addIfNewNode(c);
		nm.addIfNewNode(d);
		nm.addIfNewNode(e);
		nm.addIfNewNode(f);
		nm.doIndex();
		
		System.out.println(nm.toString());
		
		Assert.assertEquals(1, f.getIndex());
	}

}
