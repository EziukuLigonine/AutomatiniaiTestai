package main.page.viewlists;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewPatientList {

	@FindBy(xpath = ("//*[@class='glyphicon glyphicon-wrench']"))
	private WebElement buttonEditPatient;
	
	@FindBy(xpath = ("//*[@class='glyphicon glyphicon-eye-open']"))
	private WebElement buttonViewPatient;
	
	public void clickButtonEditPatient() {
		buttonEditPatient.click();
	}
	
	public void clickButtonViewPatient() {
		buttonViewPatient.click();
	}	
}
