package adding.user.input.forms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddPharmacistPage {
	
	@FindBy(xpath = ("//button[@class='btn btn-success']"))
	private WebElement buttonSave;
	
	@FindBy(xpath = ("//button[@class='btn btn-default']"))
	private WebElement buttonCancel;

	@FindBy(id = ("name"))
	private WebElement inputName;
	
	@FindBy(id = ("surname"))
	private WebElement inputSurname;
	
	@FindBy(id = ("username"))
	private WebElement inputUsername;
	
	@FindBy(id = ("password"))
	private WebElement inputPassword;
	
	@FindBy(id = ("companyType"))
	private WebElement inputCompanyType;
	
	@FindBy(id = ("companyName"))
	private WebElement inputCompanyName;
	
	
	public void clearFields() {
		inputName.clear();
		inputSurname.click();
		inputUsername.click();
		inputPassword.click();
		inputCompanyName.clear();
	}
	
	public void enterName(String value) {
		inputName.sendKeys(value);
	}
	
	public void enterSurname(String value) {
		inputSurname.sendKeys(value);
	}
	
	public void enterUsername(String value) {
		inputUsername.sendKeys(value);
	}
	
	public void enterPassword(String value) {
		inputPassword.sendKeys(value);
	}
	
	public void selectCompanyType(String value){
		Select typ = new Select(inputCompanyType);
		typ.selectByVisibleText(value);
	}

	public void enterCompanyName(String value) {
		inputCompanyName.sendKeys(value);
	}
	
	public void clickButtonSave() {
		buttonSave.click();
	}
	
	public void clickButtonCancel() {
		buttonCancel.click();
	}
	
}
