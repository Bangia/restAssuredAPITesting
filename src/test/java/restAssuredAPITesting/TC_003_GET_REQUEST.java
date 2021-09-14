package restAssuredAPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_GET_REQUEST {

	
	@Test
	void weatherAPIvaidateheaders() {
		
		
		//URI Passed as base uri
		RestAssured.baseURI = "http://api.weatherapi.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/v1/current.json?key=f671895cc9134089add75219210809&q=London&aqi=yes");
		
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);
		
		
		//Capture details Headers from response
		
		String headerResponse = response.header("Content-Type");
		System.out.println("content type from response is : "+headerResponse);
		Assert.assertEquals(headerResponse, "application/json");
		
		//Capture content Encoding Headers from response
		
		String contentEncoding = response.header("Content-Encoding");
		System.out.println("content type from response is : "+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
		
		
		
		
		
	}
}
