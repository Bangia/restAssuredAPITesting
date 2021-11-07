package com.testNg.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tutorial_7_TestNg_Assertions {

	public WebDriver driver;
	
	@BeforeClass
	void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/hashstudioz/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
	}
	
	@Test(priority=2)
	void logoTest() {
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
		Assert.assertTrue(logo.isDisplayed(),"Logo not displayed on the Page");
		
	}
	
	@Test(priority=1)
	void homePageTitle() {
		String webTitle = driver.getTitle();
		System.out.println(webTitle);
		
		Assert.assertEquals("OrangeHRM123", webTitle,"Title Not displayed");
	}
	
	
	@AfterClass
	void teardown() {
		driver.quit();
	}
	
	
}
