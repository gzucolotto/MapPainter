package org.gz.mappainter.utils;


import org.gz.mappainter.business.utils.MatrixFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MatrixFactoryTest {

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

	private static void assertDimensions(int v, int h) {
		int[][] m = MatrixFactory.getMatrix(v, h);
		Assert.assertEquals(v, m.length);
		Assert.assertEquals(h, m[0].length);
	}
	
	@Test
	public void testDefault() {
		int[][] m = MatrixFactory.getMatrix(0, 0);
		Assert.assertEquals(2, m.length);
		Assert.assertEquals(2, m[0].length);
	}
	
	@Test
	public void test2x2() {
		assertDimensions(2, 2);
	}
	
	@Test
	public void test5x4() {
		assertDimensions(5, 4);
	}
	
	@Test
	public void test10x10() {
		assertDimensions(10, 10);
	}

}
