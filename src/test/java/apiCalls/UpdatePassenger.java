package apiCalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import generics.Payloads;
import io.restassured.RestAssured;

public class UpdatePassenger extends BaseTest {

	@Test(dataProvider="updatePasenger")
	public void changesInPassengetDetails(String name,String trips,String airline) {
		
		String passengerId = CreatePassenger.newPassenger();
		RestAssured.baseURI = pro.getProperty("url");

		String response = given().contentType("application/json").body(Payloads.passengerDetailsUpdate(name, trips, airline)).when()
				.put("/v1/passenger/"+passengerId).then().assertThat().statusCode(200).log().all().extract()
				.response().asString();
		System.out.println(response);
		

	}
}
