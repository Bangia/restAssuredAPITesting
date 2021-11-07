package Listeners_TestNg;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Listeners_TestNg.Custom_Listeners.class)
public class Listeners_Test1 {

	@Test
	void test1() {
		System.out.println("This is test1");
		Assert.assertEquals("A", "A");
	
	}
	
	@Test
	void test2() {
		System.out.println("This is test2");
		Assert.assertEquals("A", "B");
	
	}
	
	@Test
	void test3() {
		System.out.println("This is test3");
		throw new SkipException("This is Skip exception...");
	
	}
}
