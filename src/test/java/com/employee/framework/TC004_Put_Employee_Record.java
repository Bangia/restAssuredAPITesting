package com.employee.framework;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC004_Put_Employee_Record extends TestBase {
	
	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	String empJob = RestUtils.empJob();
	
	@BeforeClass
	void updateEmployeeRecord() throws InterruptedException {
	 logger.info("************* Started TC004_Update_Employee_Record ***********");
	 	
	 RestAssured.baseURI = "https://reqres.in/api";
	 //Request
	 httpRequest = RestAssured.given();
	 
	 //JSON object
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("name", empName);
	 requestParams.put("job", empJob);
	 
	 //Request Header
	 httpRequest.header("Content-Type","application/json");
	 
	 //add the json to the body of the request
	 httpRequest.body(requestParams.toJSONString());
	 
	 
	 //response
	 response = httpRequest.request(Method.PUT,"/users/"+ empID);
	 
	 Thread.sleep(5000);
	 
	}
	
	//Check Response Body
	@Test
	void checkResponseBody() {
		logger.info("****** Check Response Body ******");
		String responseBody = response.getBody().asPrettyString();
		logger.info("Response Body is ==>"+responseBody);
		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empJob), true);
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
			Assert.assertEquals(contentType, "application/json; charset=utf-8");
			
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
	
	@AfterClass
	void tearDown() {
		logger.info("************* Finished TC004_Update_Employee_Record ***********");
	}

}
