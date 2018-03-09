package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewPatientList {

	@FindBy(className = ("glyphicon-wrench"))
	private WebElement buttonEditPatient;
	
	@FindBy(className = ("glyphicon-eye-open"))
	private WebElement buttonViewPatient;
	
	public void clickButtonEditPatient() {
		buttonEditPatient.click();
	}
	
	public void clickButtonViewPatient() {
		buttonViewPatient.click();
	}
	
}
