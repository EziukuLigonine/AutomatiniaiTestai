package assign.patient.todoctor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssignPatient {
	
	@FindBy(xpath = ("//button[@class='btn btn-success']"))
	private WebElement buttonAssign;

	public void clickButtonAssign() {
		buttonAssign.click();
	}

}
