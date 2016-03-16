package com.cubic.group;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cubic.util.MathUtilTest;
import com.cubic.util.NameUtilTest;

@RunWith(Categories.class)
@IncludeCategory(FuncMath.class)
@Suite.SuiteClasses({ MathUtilTest.class, NameUtilTest.class })
public class FuncMathTest {

}
