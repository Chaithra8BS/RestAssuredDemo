package RestAPI;

import java.util.List;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	
	public void test1()	
	{
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("/13");
		
		System.out.println("Response code : "+response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 200);		
	}

}
