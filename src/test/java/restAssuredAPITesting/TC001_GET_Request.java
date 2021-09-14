package restAssuredAPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {

	
	@Test
	void getweatherdetails() {
		
		//specify base url
		
		RestAssured.baseURI= "http://demoqa.com/utilities/weather/city";
		
		//request object creations
		RequestSpecification httprequest = RestAssured.given();
		
		//response object
		
		Response response = httprequest.request(Method.GET,"/Hyderabad");
		
		//print response in console window
		
		String responsebody = response.getBody().asPrettyString();
		System.out.println("RESPONSE BODY IS :"+ responsebody);
		
		//STATUS CODE VALIDATION STARTS
		
		int statusCode = response.getStatusCode();
		System.out.println("STATUS CODE IS "+ statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
		//status line verifications
		
		String statusLine = response.getStatusLine();
		System.out.println("Sstatus LineE IS "+ statusLine);
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
}
