package apiCalls;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeletePassenger extends BaseTest {

	@Test
	public void removeUser()
	{
		String passengerId = CreatePassenger.newPassenger();
		
		RestAssured.baseURI = pro.getProperty("url");
		
		 String response = given().contentType("application/json")
		.when().delete("/v1/passenger/"+passengerId)
		.then().assertThat().statusCode(200).header("Content-Type", "application/json; charset=utf-8").log().all().extract().response().asString();
		 
		 assertTrue(response.contains("Passenger data deleted successfully."));
		
		
	}
}
