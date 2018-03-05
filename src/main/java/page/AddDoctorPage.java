package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddDoctorPage extends AbstractPage {
	public AddDoctorPage(WebDriver driver) {
		super(driver);
	}
	
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
	
	public void enterSpecialisation(String value) {
		inputSpecialisation.sendKeys(value);
	}
	
	public void selectSpecialisation(){
		Select spec = new Select(inputSpecialisation);
		spec.selectByIndex(2);
	}
	
	
	public void clickButtonSave() {
		buttonSave.click();
	}
	
	public void clickButtonCancel() {
		buttonCancel.click();
	}
	
}
