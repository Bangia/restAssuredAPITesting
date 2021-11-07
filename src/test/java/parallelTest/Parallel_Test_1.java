package parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Parallel_Test_1 {

	public WebDriver driver;
	
	@Test
	void logoTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/hashstudioz/Downloads/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
		Assert.assertTrue(logo.isDisplayed());
		Thread.sleep(5000);
		
	}
	
	@Test
	void homeTitle() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/hashstudioz/Downloads/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String titleWebApp = driver.getTitle();
		Assert.assertEquals(titleWebApp, "OrangeHRM");
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}
	
}
