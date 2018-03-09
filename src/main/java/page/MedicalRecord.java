package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MedicalRecord {
	
	@FindBy(xpath = ("//button[@class='btn btn-success']"))
	private WebElement buttonSave;

	@FindBy(xpath = ("//button[@class='btn btn-default']"))
	private WebElement buttonCancel;
	
	
	public void clickButtonSave() {
		buttonSave.click();
	}

	public void clickButtonCancel() {
		buttonCancel.click();
	}

	@FindBy(id = ("personalId"))
	private WebElement PersonalId;

	public void enterPersonalId(String value) {
		PersonalId.sendKeys(value);
	}

	@FindBy(id = ("duration"))
	private WebElement Duration;

	public void selectDuration(String value) {
		Select trukme = new Select(Duration);
		trukme.selectByVisibleText(value);
	}

	@FindBy(id = ("tlk"))
	private WebElement Tlk;

	public void enterTlk(String value) {
		Tlk.sendKeys(value);
	}
	
	@FindBy(id = ("vlk"))
	private WebElement Vlk;
	
	public void selectVlk(String value) {
		Select vlk = new Select(Vlk);
		vlk.selectByVisibleText(value);
	}
	
	@FindBy(id = ("repeated"))
	private WebElement Repeat;
	
	public void selectRepeat(String value) {
		Select repeat = new Select(Repeat);
		repeat.selectByVisibleText(value);
	}

	@FindBy(id = ("doctorUsername"))
	private WebElement DoctorUsr;

	public void enterDoctorUsername(String value) {
		DoctorUsr.sendKeys(value);
	}
	
	@FindBy(id = ("appDesc"))
	private WebElement Description;

	public void enterDescription(String value) {
		Description.sendKeys(value);
	}
	

}
