package com.testNg.concepts;

import org.testng.annotations.Test;

public class Tutorial_4_priority_disabling_tests {

	@Test(priority=1)
	void TestCase_One() {
		
		System.out.println("This is Test Case_1");
	}
	
	@Test (priority=4)
	void TestCase_Two() {
			
			System.out.println("This is Test Case_2");
		}
	
	@Test (priority=2)
	void TestCase_Three() {
		
		System.out.println("This is Test Case_3");
	}
	
	@Test (priority=3, enabled=false)
 	void TestCase_Four() {
			
			System.out.println("This is Test Case_4");
		}
}
