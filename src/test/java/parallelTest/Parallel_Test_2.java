package parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Parallel_Test_2 {

	WebDriver driver;
	
	@Test
	void loginTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/hashstudioz/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}
	
	
}
