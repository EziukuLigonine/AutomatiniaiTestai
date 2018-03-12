package home.and.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePassPage {
	
	
	@FindBy(xpath = ("//button[@class='btn btn-success']"))
	private WebElement buttonSave;

	public void clickButtonSave() {
		buttonSave.click();
	}
	
	@FindBy(id = ("matchingPass"))
	private WebElement inputCurrentPass;
	
	public void enterCurrentPass(String value) {
		inputCurrentPass.sendKeys(value);
	}

	@FindBy(id = ("newPassword"))
	private WebElement inputNewPass;
	
	public void enterNewPass(String value) {
		inputNewPass.sendKeys(value);
	}
	
	@FindBy(id = ("repeatedPassword"))
	private WebElement inputRepeatPass;
	
	public void enterRepeatPass(String value) {
		inputRepeatPass.sendKeys(value);
	}
	
	public void clearAllFields() {
		inputCurrentPass.clear();
		inputNewPass.clear();
		inputRepeatPass.clear();
	}
	

}
