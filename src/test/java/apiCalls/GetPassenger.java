package apiCalls;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class GetPassenger extends BaseTest{

	
	@Test
	public void retrivePassenger() {
		
		 String passengerId = CreatePassenger.newPassenger();
		
		 RestAssured.baseURI = pro.getProperty("url");
		 String response = given().contentType("application/json")
		.when().get("/v1/passenger/"+passengerId)
		.then().assertThat().statusCode(200).log().all().extract().response().asString();
		 
		 JsonPath js = new JsonPath(response);
		 String name = js.get("name");
		 assertEquals("rajkumar", name);
				 
	}
}
