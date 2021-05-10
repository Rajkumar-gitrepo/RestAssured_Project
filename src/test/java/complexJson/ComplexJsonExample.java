package complexJson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ComplexJsonExample {
	
	@Test
	public void complxJsonValidations() throws IOException
	{

	   String jsonBodyFile = new String(Files.readAllBytes(Paths.get("./src/test/java/generics/ComplexJsonFile.txt")));
	  
	   
	   JsonPath js = new JsonPath(jsonBodyFile);
	   
	   String strengthMg = js.get("problems[0].Diabetes[0].medications[0].medicationsClasses[0].className[0].associatedDrug[0].strength");
	   
	   System.out.println(strengthMg);
	   
	   String labs = js.get("problems[0].Diabetes[0].labs[0].missing_field");
	   
	   System.out.println(labs);
	   
	   
	   
	}
}
