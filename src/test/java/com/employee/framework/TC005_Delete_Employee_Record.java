package com.employee.framework;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_Delete_Employee_Record extends TestBase{
	
	@BeforeClass
	void deleteEmployeeRecord() throws InterruptedException {
		logger.info("************* Started TC005_Delete_Employee_Record ***********");
		RestAssured.baseURI = "https://dummy.restapiexample.com/public/api/v1";
		
		//request
		httpRequest = RestAssured.given();
		
		//Fetch all employee record first
		response = httpRequest.request(Method.GET,"/employees");
	    
	    //first get the JSON Path object instance from the response interface
	    JsonPath jsonPathEvaluator = response.jsonPath();
	    
	  //capture id
	    String empID = jsonPathEvaluator.get("[0].id");
	    logger.info("Employee ID is ==> "+empID);
	    response = httpRequest.request(Method.DELETE,"/delete/"+empID);
	    
	    Thread.sleep(5000);
	
	}
	
	//Check Response Body
	@Test
	void checkResponseBody() {
		logger.info("********** Check Response Body **************");
		String responseBody = response.getBody().asPrettyString();
		logger.info("Response Body is ==>"+responseBody);
		Assert.assertEquals(responseBody.contains("Successfully! Record has been deleted"), true);
	}
	
	//Check Status Code
		@Test
		void checkStatusCode() {
			logger.info("********** Check Status Code **************");
			int statusCode = response.getStatusCode();
			logger.info("Status Code is ==>"+statusCode);
			Assert.assertEquals(statusCode, 200);
			
		}
		
		//check Status Line
		@Test
		void CheckstatusLine() {
			logger.info("********** check Status Line **************");
			String statusLine = response.getStatusLine();
			logger.info("Status Line is ==>"+statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		}
		
		//Check content Type
		@Test
		void checkContentType() {
			logger.info("********** Check content Type **************");
			String contentType = response.header("Content-Type");
			logger.info("content Type is ==>"+contentType);
			Assert.assertEquals(contentType, "application/json");
			
		}
		
		//Check Server Type
			@Test
		    void checkServerType() {
		    	logger.info("********** Check Server Type **************");
		    	String serverType = response.header("Server");
				logger.info("Server Type is =>" +serverType); 
				Assert.assertEquals(serverType, "cloudflare");
			}
			
//		//Check Response Time
//			@Test
//			void checkResponseTime() {
//				logger.info("********** Check Response Time **************");
//				long responseTime = response.getTime();
//				logger.info("Response Time is ==>" + responseTime);
//				Assert.assertTrue(responseTime >2000);
//			}
		
		//Check Content Encoding
		
			@Test
			void checkContentEncoding() {
				logger.info("********** Check Content Encoding **************");
				String contentEncoding = response.header("Content-Encoding");
				logger.info("Content Encoding is ==>" + contentEncoding);
				Assert.assertEquals(contentEncoding, "gzip");
			}

}
