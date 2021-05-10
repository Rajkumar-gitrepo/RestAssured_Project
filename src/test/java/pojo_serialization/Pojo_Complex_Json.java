package pojo_serialization;

import java.util.ArrayList;
import java.util.List;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Pojo_Complex_Json {

	public static void main(String[] args) {
		
		
		List<WebAutomation> webAutomation = new ArrayList<WebAutomation>();
		WebAutomation web = new WebAutomation();
		web.setCourseTitle("selenium");
		web.setPrice(5000);
		
		webAutomation.add(web);
		
		List<MobileAutomation> mobileAutomation = new ArrayList<MobileAutomation>();
		MobileAutomation mob = new MobileAutomation();
		mob.setCourseTitle("appium");
		mob.setPrice(6000);
		
		mobileAutomation.add(mob);
		
		
		Courses course = new Courses();
		course.setWebAutomation(webAutomation);
		course.setMobileAutomation(mobileAutomation);
       
		
		
		Pojo pojo = new Pojo();
		pojo.setInstructor("rajkumar");
		pojo.setUrl("www.rajkumartesting.com");
		pojo.setLinkedin("rajkumar89_linkedin");
		pojo.setCourse(course);
		
		
		 Response responce = given().contentType("application/json").body(pojo)
		.when().post("https://reqres.in/api/users")
		.then().assertThat().statusCode(201).log().all().extract().response();
		
		
		String call = responce.asString();
		
		JsonPath js = new JsonPath(call);
		
		String mobileCourseTitle = js.get("course.mobileAutomation[0].courseTitle");
		
		System.out.println(mobileCourseTitle);
		assertEquals(mobileCourseTitle, "appium");
		
	}
	
  }
