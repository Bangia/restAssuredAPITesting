package restAssuredAPITesting;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_004_GET_ALL_HEADERS {
	
	
	@Test
	void weatherHeaders() {
		
		//BASE URI
		RestAssured.baseURI ="http://api.weatherapi.com";
		
		
		//RequestSpecification object usig given method
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response get
		Response response = httpRequest.request(Method.GET,"/v1/timezone.json?key=f671895cc9134089add75219210809&q=Delhi");
		
		//print response
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);
		
		//Capture Status Code from response
		
		int statusCode = response.getStatusCode();
		System.out.println("STATUS CODE IS :"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
		//Print All headers code starts here using Headers class
		
		Headers allheaders = response.headers();
		
		for(Header header:allheaders) 
		{
			System.out.println(header.getName()+"  :  "+header.getValue());
			
		}
		
		
		
	}
	

}
