package restAssuredAPITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_007_GET_Autherization {
	
	
	
	@Test
	public void AuthenticateTest() {
		
		//BASE URI
		RestAssured.baseURI="http://need82.in";
		
		
		//STEPS 1 : FOR BASIC AUTHENTICATION
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("TestQA");
		authScheme.setPassword("TestPassword");
		
		//STEP 2 : FOR PASSING REST ASSURED OBJECTS
		RestAssured.authentication= authScheme;
		
		
		//Request Create method
		RequestSpecification httpRequest = RestAssured.given();
		
		//Create JSON Object using post
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("id", "vinod5357.kumar@yandex.com");
		requestParams.put("password", "Password1@");
		
		//Header
		httpRequest.header("Content-type","application/json");
		

		//Body as json string to convert params to JSONString format
		httpRequest.body(requestParams.toJSONString());
		
		//Response creation method
		
		Response response = httpRequest.request(Method.POST,"/api/login/login.do");
		
		//print response body
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);
		
		//print status code as getStatusCode
		int statusCode = response.getStatusCode();
		System.out.println("STATUS CODE : "+ statusCode);
		
		
		
	}

}
