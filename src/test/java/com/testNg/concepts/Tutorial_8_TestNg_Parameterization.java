package com.testNg.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Tutorial_8_TestNg_Parameterization {

public WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser","url"}) //For dynamic URL and Browser
	void setup(String browser, String app) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/hashstudioz/Downloads/chromedriver");
			driver = new ChromeDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/hashstudioz/Downloads/chromedriver");
			driver = new FirefoxDriver();
			
		}
		else {
			System.setProperty("webdriver.chrome.driver", "/Users/hashstudioz/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
		
		driver.get(app);
		
		
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
		
		Assert.assertEquals("OrangeHRM", webTitle,"Title Not displayed");
	}
	
	
	@AfterClass
	void teardown() {
		driver.quit();
	}
}
