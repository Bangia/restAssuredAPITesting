package com.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	//create static method so that we can directly call the method ie public static
	
	
	//Dynamic Employee Name Generate code...
	
	public static String empName() {
		String generateName = RandomStringUtils.randomAlphanumeric(4);
		return("John "+ generateName);
		
	}
	
	
	//Dynamic Salary of Employee Code...
	public static String empSal() {
		String generateSalary = RandomStringUtils.randomNumeric(5);
		return(generateSalary); 
	}
	
	//Dynamic Age of Employee Code...
	public static String empAge() {
		String generateAge = RandomStringUtils.randomNumeric(2);
		return(generateAge);
	}
	
	

}
