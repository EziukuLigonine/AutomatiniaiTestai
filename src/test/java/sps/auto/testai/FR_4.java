package sps.auto.testai;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import data.providers.TestDataProviders;
import doctor.all.patients.AllPatientsLinks;
import doctor.can.add.AddPrescription;
import home.and.login.HomePage;
import home.and.login.LoginPage;

/**
* This class contains tests that cover requirement FR4.
* @author  TurboEziukai
* @since   2018-03-13
*/

public class FR_4 {

	protected static WebDriver driver = new ChromeDriver();

	@BeforeClass
	public static void setup() {
		driver.manage().window().maximize();
		driver.get("http://localhost:8081");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}

	// Pagefactory
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	HomePage homepage = PageFactory.initElements(driver, HomePage.class);
	AddPrescription prescription = PageFactory.initElements(driver, AddPrescription.class);
	AllPatientsLinks allpatienslinks = PageFactory.initElements(driver, AllPatientsLinks.class);

	// Log in to system as Doctor
	
	/**
	 * Log in to system as Doctor.
	 * @Result Doctor user will log in to the system and the main page is shown.
	 */
	
	
	@Test(priority = 1)
	public void loginAsDoctor() {
		loginpage.enterVardas("doctorpetras");
		loginpage.enterPassword("docpetras");
		loginpage.clickLoginPirmyn();

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(homepage.getLinkMeniu()));
	}

	// Adding Prescription record
	
	/**
	 * Doctor user adds new prescription  to the system
	 * @Result A new prescription is added and shown in "Mano receptai"
	 */
	
	@Test(priority = 2, dataProvider = "Prescription", dataProviderClass = TestDataProviders.class, enabled = true)
	public void addPrescription 
(String activemat, String activematquant, String unitas, String descript, String dateuntil) {

		homepage.clickLinkMeniu();
		homepage.clickVisiPacientai();
		
		allpatienslinks.clickButtonViewPatient();
		allpatienslinks.clickPrescription();

		prescription.enterActiveMat(activemat);
		prescription.enterActiveMatQuant(activematquant);
		prescription.selectUnit(unitas);
		prescription.enterPrescriptionDesc(descript);
		prescription.enterInputValidUntil(dateuntil);
		prescription.clickButtonSave();

		new WebDriverWait(driver, 2000).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

}
