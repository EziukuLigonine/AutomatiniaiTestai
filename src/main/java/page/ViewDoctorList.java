package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewDoctorList {
	
	@FindBy(className = ("glyphicon-wrench"))
	private WebElement buttonEditDoctor;
	
	@FindBy(className = ("glyphicon-eye-open"))
	private WebElement buttonViewDoctor;
	
	public void clickButtonEditDoctor() {
		buttonEditDoctor.click();
	}
	
	public void clickButtonViewDoctor() {
		buttonViewDoctor.click();
	}
	
}
