package apiCalls;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OAuth2_Authentication_Token {

	@Test
	public static String tokenGenerate() {
		Response response = given().contentType("application/x-www-form-urlencoded").body(
				"scope=offline_access&grant_type=password&username=api-user4@iwt.net&password=b3z0nV0cLO&client_id=0oahdhjkutaGcIK2M4x6")
				.when().post("https://dev-457931.okta.com/oauth2/aushd4c95QtFHsfWt4x6/v1/token").then().assertThat()
				.statusCode(200).log().all().extract().response();

		System.out.println(response);

		String responseInString = response.asString();

		JsonPath js = new JsonPath(responseInString);
		String accessToken = js.get("access_token");
		System.out.println("The Access Token is and lost for One Hour = " + accessToken);

		return accessToken;
	}

}
