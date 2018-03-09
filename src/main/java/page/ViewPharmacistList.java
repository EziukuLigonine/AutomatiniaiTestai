package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewPharmacistList{

	@FindBy(className = ("glyphicon-wrench"))
	private WebElement buttonEditPharmacist;
	
	@FindBy(className = ("glyphicon-eye-open"))
	private WebElement buttonViewPharmacist;

	public void clickButtonEditPharmacist() {
		buttonEditPharmacist.click();
	}
	
	public void clickButtonViewPharmacist() {
		buttonViewPharmacist.click();
	}
}
