package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewAdminList extends AbstractPage {
	public ViewAdminList(WebDriver driver) {
		super(driver);
	}

	//tikrinta 2018 02 19: reikia pataisyti kad imtu glyphicon-wrench, glyphicon-eye-open, 
	//glyphicon-trash su atitinkamu id nes kitu atveju ima ta kuri randa pirmiausia 
	
	@FindBy(className = ("glyphicon-wrench"))
	private WebElement buttonEditAdmin;
	
	@FindBy(className = ("glyphicon-eye-open"))
	private WebElement buttonViewAdmin;
	
	@FindBy(className = ("glyphicon-trash"))
	private WebElement buttonRemoveAdmin;
	
	public void clickButtonEditAdmin() {
		buttonEditAdmin.click();
	}
	
	public void clickButtonViewAdmin() {
		buttonViewAdmin.click();
	}

	public void clickButtonRemoveAdmin() {
		buttonRemoveAdmin.click();
	}
	
}
