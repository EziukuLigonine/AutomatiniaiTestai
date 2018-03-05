package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddPharmacistPage extends AbstractPage {
	public AddPharmacistPage(WebDriver driver) {
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
	
	@FindBy(id = ("companyType"))
	private WebElement inputCompanyType;
	
	@FindBy(id = ("companyName"))
	private WebElement inputCompanyName;
	
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
	
	public void enterCompanyType(String value) {
		inputCompanyType.sendKeys(value);
	}
	
	
	public void selectCompanyType(){
		Select typ = new Select(inputCompanyType);
		typ.selectByIndex(3);
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
