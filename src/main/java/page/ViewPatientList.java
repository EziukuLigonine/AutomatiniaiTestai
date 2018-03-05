package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewPatientList extends AbstractPage {
	public ViewPatientList(WebDriver driver) {
		super(driver);
	}

	//tikrinta 2018 02 19: reikia pataisyti kad imtu glyphicon-wrench, glyphicon-eye-open, 
	//glyphicon-trash su atitinkamu id nes kitu atveju ima ta kuri randa pirmiausia 
	
	@FindBy(className = ("glyphicon-wrench"))
	private WebElement buttonEditPatient;
	
	@FindBy(className = ("glyphicon-eye-open"))
	private WebElement buttonViewPatient;
	
	@FindBy(className = ("glyphicon-trash"))
	private WebElement buttonRemovePatient;
	
	public void clickButtonEditPatient() {
		buttonEditPatient.click();
	}
	
	public void clickButtonViewPatient() {
		buttonViewPatient.click();
	}

	public void clickButtonRemovePatient() {
		buttonRemovePatient.click();
	}

	
}
