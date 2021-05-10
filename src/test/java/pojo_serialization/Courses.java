package pojo_serialization;

import java.util.List;

public class Courses {

	private List<WebAutomation> webAutomation;
	private List<MobileAutomation> mobileAutomation;
	
	
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<MobileAutomation> getMobileAutomation() {
		return mobileAutomation;
	}
	public void setMobileAutomation(List<MobileAutomation> mobileAutomation) {
		this.mobileAutomation = mobileAutomation;
	}
	
	
	
}