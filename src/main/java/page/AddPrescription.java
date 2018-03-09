package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddPrescription {
	
	
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
	
	@FindBy(id = ("activeMat"))
	private WebElement ActiveMat;

	public void enterActiveMat(String value) {
		ActiveMat.sendKeys(value);
	}
	
	@FindBy(id = ("activeMatQuantity"))
	private WebElement ActiveMatQuant;

	public void enterActiveMatQuant(String value) {
		ActiveMatQuant.sendKeys(value);
	}
	
	@FindBy(id = ("unit"))
	private WebElement Unit;
	
	public void selectUnit(String value) {
		Select  unitas = new Select(Unit);
		unitas.selectByVisibleText(value);
	}

	@FindBy(id = ("desc"))
	private WebElement Descript;

	public void enterPrescriptionDesc(String value) {
		Descript.sendKeys(value);
	}
	
	@FindBy(id = ("doctorUsername"))
	private WebElement inputDoctorUsr;
	
	public void enterDoctorUsr(String value) {
		inputDoctorUsr.sendKeys(value);
	}
	
	@FindBy(id = ("validUntil"))
	private WebElement inputValidUntil;
	
	public void enterInputValidUntil(String value) {
		inputValidUntil.sendKeys(value);
	}
	
	public void selectValidUntil(String value) {
		Select  valid = new Select(inputValidUntil);
		valid.selectByVisibleText(value);
	}

}
