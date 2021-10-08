package com.employee.framework;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_Employee_Record extends TestBase {

	@BeforeClass
	void get_Single_Employee_By_empId() throws InterruptedException {
		logger.info("********** Started TC002_Get_Single_Employee_Record **************");
	    RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	    //Request
	    httpRequest = RestAssured.given();
	    //response 
	    response = httpRequest.request(Method.GET, "/employee/"+empID);
	    
	    Thread.sleep(3000);
	    
	    
	}
	
	@Test
	void checkResponseBody() {
		logger.info("********** Check Response Body **************");
		String responseBody = response.getBody().asPrettyString();
		logger.info("Response Body==>"+responseBody);
		Assert.assertEquals(responseBody.contains(empID),true);
		
	}
	
	@Test
	void checkStatusCode() {
		logger.info("********** Check Status Code **************");
		int statusCode = response.getStatusCode();
		logger.info("Status Code ==>"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	void checkResponseTime() {
		logger.info("********** Check Response Time **************");
		long responseTime = response.getTime();
		logger.info("Response Time is ==>" + responseTime);
		Assert.assertTrue(responseTime <2000);
	}
	
	
	//Check status Line
	void checkStatusLine() {
	   logger.info("********** Check Status Line **************");
	   String statusLine = response.getStatusLine();
	   logger.info("Status Line is ==>" + statusLine);
	   
	   
		
	}
	
	
	//Check content Type
    void checkContentType() {
    	logger.info("********** Check Content Type **************");
	}
	
	//Check content length
    void checkContentLength() {
    	logger.info("********** Check Content length **************");
	}
	
	
	
	@AfterClass
	void tearDown() {
		logger.info("********** Finished TC002_Get_Single_Employee_Record **************");
	}
	
	
}
