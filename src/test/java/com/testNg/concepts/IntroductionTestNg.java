package com.testNg.concepts;

import org.testng.annotations.Test;

public class IntroductionTestNg {

/*
1. Setup - Open browser and application
2. login
3. teardown - close 
 
 
 */

	@Test (priority = 1)
	public void setup() {
		System.out.println("Opening Browser");
	}
	
	@Test (priority = 2)
	void login() {
		System.out.println("This is set Login test");
	}
	
	@Test (priority = 3)
	void teardown() {
		System.out.println("Closing Browser");
	}

}
