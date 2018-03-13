package adding.user.input.forms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddDoctorPage {

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

	@FindBy(id = ("specialisation"))
	private WebElement inputSpecialisation;
	
	
	public void clearFields() {
		inputName.clear();
		inputSurname.clear();
		inputUsername.clear();
		inputPassword.clear();
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

	public void selectSpecialisation(String value) {
		Select spec = new Select(inputSpecialisation);
		spec.selectByIndex(Integer.parseInt(value));
	}

	public void clickButtonSave() {
		buttonSave.click();
	}

	public void clickButtonCancel() {
		buttonCancel.click();
	}

}
