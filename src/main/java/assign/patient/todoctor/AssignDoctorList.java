package assign.patient.todoctor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssignDoctorList {
	
	@FindBy(xpath = ("//button[@class='btn btn-success']"))
	private WebElement buttonAssignDoct;

	public void clickButtonAssignDoct() {
		buttonAssignDoct.click();
	}

}
