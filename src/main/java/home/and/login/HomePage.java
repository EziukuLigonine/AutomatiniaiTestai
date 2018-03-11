package home.and.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage{

	@FindBy(linkText = ("Meniu"))
	private WebElement linkMeniu;
	
	public  void clickLinkMeniu() {
		linkMeniu.click();
	}

	public WebElement getLinkMeniu() {
		return linkMeniu;
	}
	
	@FindBy(xpath = ("//*[@class='glyphicon glyphicon-user']"))
	private WebElement linkUserIcon;
	
	public  void clickUserIcon() {
		linkUserIcon.click();
	}
	
	@FindBy(linkText = ("Keisti slaptažodį"))
	private WebElement linkChangePassword;
	
	public  void clickChangePassword() {
		linkChangePassword.click();
	}

	@FindBy(linkText = ("Administratorius"))
	private WebElement linkAdministratorius;
	
	public  void clickLinkAdministratorius() {
		linkAdministratorius.click();
	}
	
	@FindBy(linkText = ("Gydytojas"))
	private WebElement linkGydytojas;
	
	public  void clickLinkGydytojas() {
		linkGydytojas.click();
	}
	
	@FindBy(linkText = ("Pacientas"))
	private WebElement linkPacientas;
	
	public  void clickLinkPacientas() {
		linkPacientas.click();
	}
	
	@FindBy(linkText = ("Vaistininkas"))
	private WebElement linkVaistininkas;
	
	public  void clickLinkVaistininkas() {
		linkVaistininkas.click();
	}
	
	@FindBy(linkText = ("Administratorių sąrašas"))
	private WebElement linkAdminuSarasas;
	
	public  void clickLinkAdminuSarasas() {
		linkAdminuSarasas.click();
	}
	
	@FindBy(linkText = ("Pacientų sąrašas"))
	private WebElement linkPacientuSarasas;
	
	public  void clickLinkPacientuSarasas() {
		linkPacientuSarasas.click();
	}
	
	@FindBy(linkText = ("Gydytojų sąrašas"))
	private WebElement linkGydytojuSarasas;
	
	public  void clickLinkGydytojuSarasas() {
		linkGydytojuSarasas.click();
	}
	
	@FindBy(linkText = ("Vaistininkų sąrašas"))
	private WebElement linkVaistininkuSarasas;
	
	public  void clickLinkVaistininkuSarasas() {
		linkVaistininkuSarasas.click();
	}
	
	@FindBy(linkText = ("Išrašyti ligos istoriją"))
	private WebElement linkAddMedicalRecord;
	
	public  void clickAddMedicalRecord() {
		linkAddMedicalRecord.click();
	}
		
	@FindBy(linkText = ("Išrašyti Receptą"))
	private WebElement linkAddPrescription;
	
	public  void clickAddPrescription() {
		linkAddPrescription.click();
	}
	
	
	@FindBy(linkText = ("Mano pacientai"))
	private WebElement linkManoPacientai;
	
	public  void clickManoPacientai() {
		linkManoPacientai.click();
	}
	
	@FindBy(linkText = ("Visi pacientai"))
	private WebElement linkVisiPacientai;
	
	public  void clickVisiPacientai() {
		linkVisiPacientai.click();
	}
	
	
}