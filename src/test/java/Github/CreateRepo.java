package Github;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRepo {

        @Test
		public void test1() throws IOException
		{
			byte[] dataFile = Files.readAllBytes(Paths.get("githubdata.json"));

			RestAssured.baseURI = "https://api.github.com/user/repos";
			RequestSpecification request = RestAssured.given();
			Response response = request.auth().oauth2("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").contentType(ContentType.JSON)
					.accept(ContentType.JSON).body(dataFile).post();
			
			String body = response.getBody().asString();		
			System.out.println("response Body is"+ body);
			System.out.println("Response code : "+response.statusCode());
			
			Assert.assertEquals(response.statusCode(),201);
			
		}
		
	}
	

