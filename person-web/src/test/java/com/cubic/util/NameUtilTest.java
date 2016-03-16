package com.cubic.util;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NameUtilTest {
	private NameUtil nameUtil = new NameUtil();
	private String firstName = "pratap";
	private String lastName = "sapkota";

	@Before
	public void setup() throws Exception {
		firstName = "pratap";
		lastName = "sapkota";
	}

	@Test
	public void testGetFullName() {
		String result = nameUtil.getFullName(firstName, lastName);
		assertEquals("pratap,sapkota", result);
		assertThat(result, allOf(containsString("pratap"), containsString("sapkota")));
	}

	@Test
	public void testGetFullName1() {
		lastName = null;
		String result = nameUtil.getFullName(firstName, lastName);
		assertThat(result, anyOf(containsString("Test"), startsWith("pratap")));
		assertThat(result, both(containsString("pratap")).and(startsWith("pratap")));
		assertThat(result, either(containsString("pratap")).or(startsWith("pratap")));
	}

}
