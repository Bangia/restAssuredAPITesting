package dataDriven;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DDT_001_POST_CREATE_USER {

	@Test(dataProvider="empdataProvider")
	public void dataDriveCreateuserTestcase(String name, String job) {
		
		//Base URI
		RestAssured.baseURI="https://reqres.in";
		
		//Request creation
		RequestSpecification httpRequest = RestAssured.given();
		
		//JSON OBJECT for body
		JSONObject requestParams = new JSONObject();
		
		//Key , value relation which we can use as post request
		requestParams.put("name", name);
		requestParams.put("job", job);
		
		
		//Header
		httpRequest.header("Content-type","application/json");
		
		//Body
		httpRequest.body(requestParams.toJSONString());
		
		//Create response
		Response response = httpRequest.request(Method.POST,"/api/users");
		
		//Capture response
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);
		
		//Assertion for verification
		Assert.assertEquals(responseBody.contains(name), true);
		Assert.assertEquals(responseBody.contains(job),true);
		
		
		//Status code
		int statusCode = response.getStatusCode();
		System.out.println("Actual Status code : "+ statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//Second Method creation for data driven approach using DataProvider annotations
		
		
		
		
	}
	
	@DataProvider(name="empdataProvider")
	String[][]  getEmployee()
	{
		
		String empData[][]= 
			{
				{"abc123","SOFTWARE DEVLOPER"},
				{"xyz123","UX DESIGNER"},
				{"pqr123","UI DESIGNER"}
			};
		return (empData);
	}
}
