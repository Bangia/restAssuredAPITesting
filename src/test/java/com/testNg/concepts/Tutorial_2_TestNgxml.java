package com.testNg.concepts;

import org.testng.annotations.Test;

public class Tutorial_2_TestNgxml {

	
/*
What is TestNg XML file? usage
How to create TestNg XML
How to run test from XML file
TestNg reports	
	
 */
	
	
	/*
	1. Setup - Open browser and application
	2. login
	3. teardown - close 
	 
	 
	 */

		@Test (priority = 1)
		public void setup() {
			System.out.println("Opening Browser");
		}
		
		@Test (priority = 3)
		void searchCustomer() {
			System.out.println("This is Search Customer Test");
		}
		
		@Test (priority = 2)
		void addCustomer() {
			System.out.println("This is Add Customer Test");
		}
		
		@Test (priority = 4)
		void teardown() {
			System.out.println("Closing Browser");
		}
}
