package pojo_serialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class Deserialization {

public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		
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
		
		 
		 ObjectMapper objectmapper = new ObjectMapper();
		 String call = responce.asString();
		 objectmapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		 
		 Pojo pj = objectmapper.readValue(call, Pojo.class);
		 
		System.out.println(pj.getInstructor());
		System.out.println(pj.getUrl());
		System.out.println(pj.getCourse().getMobileAutomation().get(0).getCourseTitle());
		 
		 
		 
		 
		 
		 
}		 
}
