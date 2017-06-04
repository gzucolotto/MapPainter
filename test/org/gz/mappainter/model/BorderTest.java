package org.gz.mappainter.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BorderTest {

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
	public void testBuild() {
		Border a = new Border(0, 0, 0, 1);
		
		Assert.assertNotNull(a);
		Assert.assertNotNull(a.getA());
		Assert.assertNotNull(a.getB());
	}
	
	@Test
	public void testEquality() {
		Border x = new Border(0, 1, 0, 0);
		Border y = new Border(0, 0, 0, 1);
		Border z = new Border(0, 0, 0, 1);
		
		Assert.assertEquals(x, y);
		Assert.assertEquals(y, z);
		
		Assert.assertEquals(x.hashCode(), y.hashCode());
		Assert.assertEquals(z.hashCode(), y.hashCode());
	}

}
