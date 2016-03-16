package com.cubic.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.cubic.group.FuncMath;

public class MathUtilTest {

	@BeforeClass
	public static void test1() throws Exception {

	}

	@AfterClass
	public static void setUp() throws Exception {
		System.out.println("Inside Before Method call");
	}

	@Before
	public void Up() throws Exception {
		System.out.println("Inside After Method call");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Inside After Method call");
	}

	@Category({ FuncMath.class })
	@Test
	public void testAdd() {
		int value1 = 2, value2 = 5;
		MathUtil util = new MathUtil();
		int result = util.add(value1, value2);
		assertEquals(7, result);

	}

	@Test
	public void testDiff() {
		int value1 = 10, value2 = 5;
		MathUtil util = new MathUtil();
		int result = util.diff(value1, value2);
		assertEquals(5, result);

	}

	@Test
	public void testDiff1() {
		int value1 = -10, value2 = -5;
		MathUtil util = new MathUtil();
		int result = util.diff(value1, value2);
		assertEquals(-5, result);

	}

	@Test
	public void testMul() {
		int value1 = 10, value2 = 5;
		MathUtil util = new MathUtil();
		int result = util.mul(value1, value2);
		assertEquals(50, result);

	}

	@Test
	public void testdiv1() {
		int value1 = 10, value2 = 5;
		MathUtil util = new MathUtil();
		util.div(value1, value2);
	}

	@Test(expected = ArithmeticException.class)
	public void testdiv2() {
		int value1 = 10, value2 = 0;
		MathUtil util = new MathUtil();
		int result = util.div(value1, value2);
		util.div(10, value2);
	}

	@Test(timeout = 5000)
	public void testdiv3() {
		int value1 = 10, value2 = 0;
		MathUtil util = new MathUtil();
		try {
			// Thread.sleep(1000);
			util.div(value1, value2);
			fail("it should not reach here");
		} catch (Exception e) {

		}
		int result = util.div(value1, value2);
		util.div(10, value2);
	}
}
