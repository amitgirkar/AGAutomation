package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotation {
	
	/*
	 * 1. Before - Suite, Test, Class, Method (pre-condition) 2. Test - Test
	 * condition 3. After - Method, Class, Test, Suite (post-condition)
	 */
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is before class Annotation");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is before test Annotation");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is before method Annotation");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is before suite Annotation");
	}
	
	@Test
	public void demo() {
		System.out.println("This is demo method");
	}
	
	@Test
	public void demo2() {
		System.out.println("This is demo2 method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This is after class Annotation");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("This is after test Annotation");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is after method Annotation");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("This is after suite Annotation");
	}
}
