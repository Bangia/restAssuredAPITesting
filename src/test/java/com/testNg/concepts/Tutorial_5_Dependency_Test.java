package com.testNg.concepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tutorial_5_Dependency_Test {

	@Test
	void startCar() {
		System.out.println("CAR STARTED !!!");
		Assert.fail();		
	}
	
	@Test(dependsOnMethods= {"startCar"})
	void driverCar() {
		System.out.println("CAR DRIVING !!!");
		
	}
	
	@Test(dependsOnMethods= {"driverCar"})
	void stopCar() {
		System.out.println("CAR STOP !!!");
		
	}
	
	@Test(dependsOnMethods= {"driverCar", "stopCar"},alwaysRun=true)
	void parkCar() {
		System.out.println("CAR PARKED !!!");
		
	}
	
}
