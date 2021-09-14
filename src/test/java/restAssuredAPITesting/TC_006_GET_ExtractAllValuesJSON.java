package restAssuredAPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_006_GET_ExtractAllValuesJSON {

	@Test
	public void validateAllNodesJSON() {
		
		//Base URI
		RestAssured.baseURI="http://api.weatherapi.com";
		
		//Request specification
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response
		Response response = httpRequest.request(Method.GET,"/v1/timezone.json?key=f671895cc9134089add75219210809&q=Delhi");
		
		//Print response in console
		String responseBody = response.getBody().asPrettyString();
		System.out.println("Response body is :"+responseBody);
		
		
		//Extract values from JSON response using JSON path
		
		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("location.name"));
		System.out.println(jsonpath.get("location.region"));
		System.out.println(jsonpath.get("location.country"));
		System.out.println(jsonpath.get("location.lat"));
		System.out.println(jsonpath.get("location.lon"));
		System.out.println(jsonpath.get("location.tz_id"));
		System.out.println(jsonpath.get("location.localtime_epoch"));
		System.out.println(jsonpath.get("location.localtime"));
		
		//Actual v/s Expected values
		Assert.assertEquals(jsonpath.get("location.name"),"Delhi");
		
	
	
	}
	
	
	
	
}
