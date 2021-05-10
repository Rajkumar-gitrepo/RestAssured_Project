package apiCalls;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import generics.Payloads;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OAuth2_CreatePassenger {

	@Test
	public void newPassenger() {
         
		 Response response = given().contentType("application/json").auth().oauth2(OAuth2_Authentication_Token.tokenGenerate()).body(Payloads.newUserCreation())
		.when().post("https://api.instantwebtools.net/v2/passenger")
		.then().assertThat().statusCode(200).log().all().extract().response();
		
		 String res = response.toString();
		
		 JsonPath js = new JsonPath(res);
		 
		 String name = js.get("name");
		 assertEquals(name, "rajkumar");
		
		
	}
}
