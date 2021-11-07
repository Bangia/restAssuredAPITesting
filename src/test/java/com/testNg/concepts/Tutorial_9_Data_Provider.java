package com.testNg.concepts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tutorial_9_Data_Provider {

	@Test(dataProvider="LoginDataProvider")
	public void loginTest(String email, String pwd) {
		System.out.println(email+ "  " +pwd);
		
	}
	
	@Test(dataProvider="AddEmployee",dataProviderClass=Custom_DataProvider.class)
	public void addEmployee(String name, String department) {
		System.out.println(name+"  "+department);
	}
	
	
	
	@DataProvider(name="LoginDataProvider")
	public Object[][] getData(){
		Object[][] data = {
				
				{"abc8@gmail.com", "abc8"},
				{"abc9@gmail.com", "abc9"},
				{"abc10@gmail.com", "abc10"}
				
		};
		return data;
	}
	
	
}

