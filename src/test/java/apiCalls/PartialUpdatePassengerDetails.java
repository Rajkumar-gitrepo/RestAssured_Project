package apiCalls;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.testng.annotations.Test;

import generics.Payloads;
import io.restassured.RestAssured;

public class PartialUpdatePassengerDetails extends BaseTest {

	@Test
	public void partialUpdate()
	{
		String passengerId = CreatePassenger.newPassenger();
		
		RestAssured.baseURI = pro.getProperty("url");
		
		String response = given().contentType("application/json").body(new File("./src/test/java/generics/payloadFile"))
		.when().patch("/v1/passenger/"+passengerId)
		.then().assertThat().statusCode(200).log().all().extract().response().asString();
		
		 assertTrue(response.contains("Passenger data updated successfully."));
	}
}
