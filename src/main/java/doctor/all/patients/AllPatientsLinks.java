package doctor.all.patients;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllPatientsLinks {
	
	@FindBy(xpath = ("//*[@class='glyphicon glyphicon-wrench']"))
	private WebElement buttonEditPatient;
	
	@FindBy(xpath = ("//*[@class='glyphicon glyphicon-eye-open']"))
	private WebElement buttonViewPatient;
	
	public void clickButtonEditPatient() {
		buttonEditPatient.click();
	}
	
	public void clickButtonViewPatient() {
		buttonViewPatient.click();
	}	
	
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

	@FindBy(xpath = ("//button[1]"))
	private WebElement buttonPrescription;
	
	public void clickPrescription() {
		buttonPrescription.click();
	}
	
	@FindBy(xpath = ("//button[2]"))
	private WebElement buttonMedicalRecord;
	
	public void clickMedicalRecord() {
		buttonMedicalRecord.click();
	}

}
