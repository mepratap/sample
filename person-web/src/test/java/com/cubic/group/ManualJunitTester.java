package com.cubic.group;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.cubic.util.MathUtilTest;
import com.cubic.util.NameUtilTest;

public class ManualJunitTester {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(MathUtilTest.class, NameUtilTest.class);

		for (Failure f : result.getFailures()) {
			System.out.println(f.getMessage());
		}
		System.out.println(result.wasSuccessful());
	}
}
