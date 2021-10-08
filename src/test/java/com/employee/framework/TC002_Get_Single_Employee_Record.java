package com.employee.framework;



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
	
	//Check Response Body
	@Test
	void checkResponseBody() {
		logger.info("********** Check Response Body **************");
		String responseBody = response.getBody().asPrettyString();
		logger.info("Response Body==>"+responseBody);
		Assert.assertEquals(responseBody.contains(empID),true);
		
	}
	
	
	//Check Status Code
	@Test
	void checkStatusCode() {
		logger.info("********** Check Status Code **************");
		int statusCode = response.getStatusCode();
		logger.info("Status Code ==>"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
	}
	
	//Check Response Time
	@Test
	void checkResponseTime() {
		logger.info("********** Check Response Time **************");
		long responseTime = response.getTime();
		logger.info("Response Time is ==>" + responseTime);
		Assert.assertTrue(responseTime >2000);
	}
	
	//Check status Line
	@Test
	void checkStatusLine() {
	   logger.info("********** Check Status Line **************");
	   String statusLine = response.getStatusLine();
	   logger.info("Status Line is ==>" + statusLine);
	   
	   
		
	}
	
	//Check Server Type
	@Test
    void checkServerType() {
    	logger.info("********** Check Server Type **************");
    	String serverType = response.header("Server");
		logger.info("Server Type is =>" +serverType); 
		Assert.assertEquals(serverType, "cloudflare");
	}
	
	
	//Check content Type
	@Test
    void checkContentType() {
    	logger.info("********** Check Content Type **************");
    	String contentType = response.header("Content-Type");
    	logger.info("Content Type is ==>"+contentType);
    	Assert.assertEquals(contentType, "application/json");
	}
	
	
	//Check content length
	@Test
    void checkContentLength() {
    	logger.info("********** Check Content length **************");
    	String contentLength = response.header("Content-Length");
    	//Assert.assertTrue(Integer.parseInt(contentLength) <1500);
	}
	
	
	
	@AfterClass
	void tearDown() {
		logger.info("********** Finished TC002_Get_Single_Employee_Record **************");
	}
	
	
}
