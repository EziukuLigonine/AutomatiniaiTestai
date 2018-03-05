package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewDoctorList extends AbstractPage {
	public ViewDoctorList(WebDriver driver) {
		super(driver);
	}

	//tikrinta 2018 02 19: reikia pataisyti kad imtu glyphicon-wrench, glyphicon-eye-open, 
	//glyphicon-trash su atitinkamu id nes kitu atveju ima ta kuri randa pirmiausia 
	
	@FindBy(className = ("glyphicon-wrench"))
	private WebElement buttonEditDoctor;
	
	@FindBy(className = ("glyphicon-eye-open"))
	private WebElement buttonViewDoctor;
	
	@FindBy(className = ("glyphicon-trash"))
	private WebElement buttonRemoveDoctor;
	
	public void clickButtonEditDoctor() {
		buttonEditDoctor.click();
	}
	
	public void clickButtonViewDoctor() {
		buttonViewDoctor.click();
	}

	public void clickButtonRemoveDoctor() {
		buttonRemoveDoctor.click();
	}

	
}
