package apiCalls;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import generics.Payloads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class CreatePassenger extends BaseTest {

	
	@Test
	public static String newPassenger() {
		RestAssured.baseURI = pro.getProperty("url");

		String response = given().contentType("application/json").body(Payloads.newUserCreation()).when()
				.post("/v1/passenger").then().assertThat().statusCode(200).log().all().extract().response().asString();

		JsonPath js = new JsonPath(response);

		String name = js.get("name");
		String id = js.get("_id");
		assertEquals("rajkumar", name);
		System.out.println("Name is = " + name);
		System.out.println("The id is = " + id);
		return id;
	}
}
