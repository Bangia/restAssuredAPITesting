package restAssuredAPITesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	
	@Test
	void addRegisterStudent() {
		
		//Specify base URI
		RestAssured.baseURI="https://reqres.in";
		
		//create request
		RequestSpecification httpRequest = RestAssured.given();
		
		//response object
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name","Nitin");
		requestParams.put("job", "QA TEAM MEMBER");
		
//		requestParams.put("UserName","neilsharma");
//		requestParams.put("Password","diplosums");
//		requestParams.put("Email","deep@yopmail.com");
		
		//Header
		httpRequest.header("Content-Type","application/json");
		
		//Body as json string to convert params to JSONString format
		httpRequest.body(requestParams.toJSONString());
		
		//response object
		
		Response response = httpRequest.request(Method.POST,"/api/users");
		
		
		//capture response body
		
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);
		
		//verify status code
		
		int statusCode = response.getStatusCode();
		System.out.println("STATUS CODE : "+statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//extract data from JSON using JSON path only particulat fields
		
		String creationData = response.jsonPath().get("job");
		System.out.println("DATA CREATED DATE :"+creationData);
		
		
		
	
	}

}
