package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddPatientPage extends AbstractPage {
	public AddPatientPage(WebDriver driver) {
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
	
	@FindBy(id = ("personalId"))
	private WebElement inputPersonalId;
	
	@FindBy(id = ("dateOfBirth"))
	private WebElement inputBirthday;
	
	@FindBy(id = ("doctorUsername"))
	private WebElement inputDoctorUsername;
	
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
	
	public void enterPersonalId(String value) {
		inputPersonalId.sendKeys(value);
	}
	
	//variantas nr.1
	public void enterBirthday(String value) {
		inputBirthday.sendKeys(value);
	}
	
	//variantas nr.2
	public void selectBirthday(){
		Select dob = new Select(inputBirthday);
		dob.getFirstSelectedOption();
	}
	
	public void enterDoctorUsername(String value) {
		inputDoctorUsername.sendKeys(value);
	}
	
	public void clickButtonSave() {
		buttonSave.click();
	}
	
	public void clickButtonCancel() {
		buttonCancel.click();
	}
	
}
