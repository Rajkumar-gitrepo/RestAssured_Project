package pojo_serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization {

public static void main(String[] args) throws IOException  {
		
		
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
		
		//Serializing Java object as Body(String) using Jackson databind
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonFormat = objectMapper.writeValueAsString(pojo);
		
		System.out.println(jsonFormat);
		
		//Genaring Json file from Pojo
		File outputJsonFile = new File("./src/test/java/pojo_serialization/payload.json");
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputJsonFile, pojo);
		
	}
}
