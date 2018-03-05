package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = ("Meniu"))
	private WebElement linkMeniu;
	
	public  void clickLinkMeniu() {
		linkMeniu.click();
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
	
	public  void clickLinkAdminSarasas() {
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
	
}
