package RestAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	

	@Test
	public void test1()
	{
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		
		String body = response.getBody().asString();
		
		System.out.println("response Body is"+ body);
		
		System.out.println("name of employees : "+response.getBody().jsonPath().get("name"));
		
		System.out.println("Response header" +response.getHeader("Content-Type"));
		
		System.out.println("Response code : "+response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 200);
		
		
		//Print all the names of the employeees on the console
		
		JsonPath json= response.jsonPath();
		List<String> names = json.get("name");
		
		for(String name:names)
		{
			System.out.println("The name is "+ name);
		}
		
		
	}

}
