package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewPharmacistList extends AbstractPage {
	public ViewPharmacistList(WebDriver driver) {
		super(driver);
	}

	//tikrinta 2018 02 19: reikia pataisyti kad imtu glyphicon-wrench, glyphicon-eye-open, 
	//glyphicon-trash su atitinkamu id nes kitu atveju ima ta kuri randa pirmiausia 
	
	@FindBy(className = ("glyphicon-wrench"))
	private WebElement buttonEditPharmacist;
	
	@FindBy(className = ("glyphicon-eye-open"))
	private WebElement buttonViewPharmacist;
	
	@FindBy(className = ("glyphicon-trash"))
	private WebElement buttonRemovePharmacist;
	
	public void clickButtonEditPharmacist() {
		buttonEditPharmacist.click();
	}
	
	public void clickButtonViewPharmacist() {
		buttonViewPharmacist.click();
	}

	public void clickButtonRemovePharmacist() {
		buttonRemovePharmacist.click();
	}

	
}
