package sps.auto.testai;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import adding.user.input.forms.AddAdminPage;
import adding.user.input.forms.AddDoctorPage;
import adding.user.input.forms.AddPatientPage;
import adding.user.input.forms.AddPharmacistPage;
import assign.patient.todoctor.AssignDoctorList;
import assign.patient.todoctor.AssignPatient;
import data.providers.TestDataProviders;
import home.and.login.HomePage;
import home.and.login.LoginPage;
import main.page.viewlists.ViewPatientList;
/**
* This class contains tests that cover requirement FR1
* @author  TurboEziukai
* @since   2018-03-13
*/

public class FR_1{
	
	protected static WebDriver driver = new ChromeDriver();

	@BeforeSuite
	public static void setup() {
//		driver.manage().window().maximize();
		driver.get("http://localhost:8081");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@AfterSuite
	public static void closeBrowser() {
		driver.quit();
	}

	// Pagefactory
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	HomePage homepage = PageFactory.initElements(driver, HomePage.class);
	AddAdminPage addadminpage = PageFactory.initElements(driver, AddAdminPage.class);
	AddDoctorPage adddoctorpage = PageFactory.initElements(driver, AddDoctorPage.class);
	AddPatientPage addpatientpage = PageFactory.initElements(driver, AddPatientPage.class);
	AddPharmacistPage addpharmacistpage = PageFactory.initElements(driver, AddPharmacistPage.class);
	ViewPatientList viewpatientlist = PageFactory.initElements(driver, ViewPatientList.class);
	AssignPatient assignpatient = PageFactory.initElements(driver, AssignPatient.class);
	AssignDoctorList assigndoctorlist = PageFactory.initElements(driver, AssignDoctorList.class);

	// Log in to system as Admin
	
	/**
	 * Log in to system as Admin.
	 * Admin user is created and stored in database before running this test
	 * @Result Admin user will log in to the system and the main page is shown.
	 */
	
	@Test(priority = 1)
	public void loginAsAdmin() {
		loginpage.enterVardas("Adminas");
		loginpage.enterPassword("Adminas");
		loginpage.clickLoginPirmyn();

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(homepage.getLinkMeniu()));

	}

	// Adding Admin users
	
	/**
	 * Admin user adds other Admins users to the system
	 * @Result Users are created by Admin user (pre-built)
	 */
	
	@Test(priority = 2, dataProvider = "Admin", dataProviderClass = TestDataProviders.class, enabled = true)
	public void addUserAdministratorius(String name, String surname, String username, String password) {

		homepage.clickLinkMeniu();
		homepage.clickLinkAdministratorius();

		addadminpage.enterName(name);
		addadminpage.enterSurname(surname);
		addadminpage.enterUsername(username);
		addadminpage.enterPassword(password);
		addadminpage.clickButtonSave();

		new WebDriverWait(driver, 2000).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	// Adding Doctor user
	
	/**
	 * Admin user adds Doctor users to the system
	 * @Result Users are created by Admin user (pre-built)
	 */
	
	@Test(priority = 3, dataProvider = "Doctor", dataProviderClass = TestDataProviders.class, enabled = true)
	public void addUserGydytojas(String name, String surname, String username, String password, String spec) {

		homepage.clickLinkMeniu();
		homepage.clickLinkGydytojas();

		adddoctorpage.enterName(name);
		adddoctorpage.enterSurname(surname);
		adddoctorpage.enterUsername(username);
		adddoctorpage.enterPassword(password);
		adddoctorpage.selectSpecialisation(spec);
		adddoctorpage.clickButtonSave();

		new WebDriverWait(driver, 2000).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	// Adding Patient user
	
	/**
	 * Admin user adds Patient users to the system
	 * @Result Users are created by Admin user (pre-built)
	 */
	
	@Test(priority = 4, dataProvider = "Patient", dataProviderClass = TestDataProviders.class, enabled = true)
	public void addUserPacientas(String name, String surname, String username, String password, String AK, String DoB) 
			throws InterruptedException {

		homepage.clickLinkMeniu();
		homepage.clickLinkPacientas();
		
		addpatientpage.enterName(name);
		addpatientpage.enterSurname(surname);
		addpatientpage.enterUsername(username);
		addpatientpage.enterPassword(password);
		addpatientpage.enterPersonalId(AK);
		addpatientpage.enterBirthday(DoB);
		addpatientpage.clickButtonSave();
		
		new WebDriverWait(driver, 2000).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		new WebDriverWait(driver, 2000).until(ExpectedConditions.elementToBeClickable(homepage.getLinkMeniu()));
	}

	// Adding Pharmacist user
	
	/**
	 * Admin user adds Pharmacist users to the system
	 * @Result Users are created by Admin user (pre-built)
	 */
	
	@Test(priority = 5, dataProvider = "Pharmacist", dataProviderClass = TestDataProviders.class, enabled = true)
	public void addUserVaistininkas(String name, String surname, String username, String password, String typ,
			String company) {

		homepage.clickLinkMeniu();
		homepage.clickLinkVaistininkas();

		addpharmacistpage.enterName(name);
		addpharmacistpage.enterSurname(surname);
		addpharmacistpage.enterUsername(username);
		addpharmacistpage.enterPassword(password);
		addpharmacistpage.selectCompanyType(typ);
		addpharmacistpage.enterCompanyName(company);
		addpharmacistpage.clickButtonSave();

		new WebDriverWait(driver, 2000).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	// Admin can assign patient to the doctor
	
	/**
	 * Admin assigns Patient user to doctor
	 * @Result Patient user is assigned by Admin user (pre-built)
	 */
	
	@Test(priority = 6, enabled = true)
	public void AssigningPatientToDoctor() {

		homepage.clickLinkMeniu();
		homepage.clickLinkPacientuSarasas();
		
		viewpatientlist.clickButtonViewPatient();

		assignpatient.clickButtonAssign();

		assigndoctorlist.clickButtonAssignDoct();

		new WebDriverWait(driver, 3000).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
}
