package restAssuredAPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_005_GET_VALIDATE_JSON_RESPONSE {
	
	
	@Test
	public void validateJsonTestCase() {
		//verification JSON response data that data is valid or not
		
		//Base URI
		RestAssured.baseURI = "http://api.weatherapi.com";
		
		//request creation
		RequestSpecification httpRequest = RestAssured.given();
		
		//response creation
		Response response = httpRequest.request(Method.GET,"/v1/timezone.json?key=f671895cc9134089add75219210809&q=Delhi");
		
		//Response PRINT in console
		String responseBody = response.getBody().asPrettyString();
		System.out.println("RESPONSE BODY IS :"+responseBody);
		
		//verify India present in response or not
		Assert.assertEquals(responseBody.contains("India"),true);
		
		
		
		
	}
	

}
