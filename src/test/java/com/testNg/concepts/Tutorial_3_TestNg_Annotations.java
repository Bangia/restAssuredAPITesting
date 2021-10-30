package com.testNg.concepts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tutorial_3_TestNg_Annotations {

	
	
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
	public void test1() {
		
		System.out.println("This is test1...");
	}
	
	@Test
	public void test2() {
		System.out.println("This is test2...");
	}
	
	@BeforeTest
	void beforeTest() {
		System.out.println("This will execute before the test");
	}
	
	@AfterTest
	void afterTest() {
		System.out.println("This will execute after the test.");
	}
	
}
