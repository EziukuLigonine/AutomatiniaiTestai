package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewAdminList {

	@FindBy(className = ("glyphicon-wrench"))
	private WebElement buttonEditAdmin;
	
	@FindBy(className = ("glyphicon-eye-open"))
	private WebElement buttonViewAdmin;
	
	public void clickButtonEditAdmin() {
		buttonEditAdmin.click();
	}
	
	public void clickButtonViewAdmin() {
		buttonViewAdmin.click();
	}
	
}
