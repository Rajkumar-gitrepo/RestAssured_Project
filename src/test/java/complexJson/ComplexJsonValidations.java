package complexJson;

import org.testng.Assert;
import org.testng.annotations.Test;

import generics.Payloads;
import io.restassured.path.json.JsonPath;

public class ComplexJsonValidations {

	@Test
	public void jsonHandling() {
		int sum = 0;

		JsonPath js = new JsonPath(Payloads.complexJsonArrayPayload());

		// purchaseAmount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);

		int courseCount = js.getInt("courses.size()");
		System.out.println(courseCount);

		for (int i = 0; i < courseCount; i++) {
			System.out.println(js.get("courses[" + i + "].title"));
			System.out.println(js.get("courses[" + i + "].price"));
		}

		// Get Cypress/Selenium/RPA course price dynamically

		for (int i = 0; i < courseCount; i++) {
			String courseName = js.get("courses[" + i + "].title");
			if (courseName.equals("selenium")) {
				System.out.println(js.get("courses[" + i + "].price"));
			}

		}

		// All the courses prices should be equal to total price
		for (int i = 0; i < courseCount; i++) {
			int coursePrices = js.getInt("courses[" + i + "].price");
			int courseCopies = js.getInt("courses[" + i + "].price");
			sum = sum + coursePrices * courseCopies;
		}
		System.out.println("Total price of courses is = " + sum);

		Assert.assertEquals(purchaseAmount, sum);

	}
}
