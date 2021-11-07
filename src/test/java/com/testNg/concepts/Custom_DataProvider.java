package com.testNg.concepts;

import org.testng.annotations.DataProvider;

public class Custom_DataProvider {

	@DataProvider(name="AddEmployee")
	public Object[][] createEmployee(){
		
		Object[][] addEmployee = 
			
		{
				{"Nitin","QA Team"},
				{"Aditya","Development Team"},
				{"Deepak","UI/UX Team"}
		};
		return addEmployee;
	}
	
}
