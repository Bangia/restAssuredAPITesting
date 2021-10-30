package com.testNg.concepts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC_2_TestNg_Annotations {

	@BeforeClass
	void beforeClass() {
		System.out.println("This will execute before the class");
	}
	
	@AfterClass
	void afterClass() {
		System.out.println("This will execute after the class");
	}
	
	@BeforeMethod
	void beforeMethod() {
		System.out.println("This will execute before every test method...");
	}
	
	@AfterMethod
	void afterMethod() {
		System.out.println("This will execute after every completion test method...");
	}
	
	
	@Test
	public void test3() {
		
		System.out.println("This is test3...");
	}
	
	@Test
	public void test4() {
		System.out.println("This is test4...");
	}
	
	@BeforeSuite
	void beforSuite() {
		System.out.println("This will execute before the test suite");
	}
	
	@AfterSuite
	void afterSuite() {
		System.out.println("This will execute after the test suite");
	}
	
}
