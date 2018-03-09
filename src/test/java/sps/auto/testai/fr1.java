package sps.auto.testai;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import data.providers.TestDataProviders;
import page.AddAdminPage;
import page.AddDoctorPage;
import page.AddPatientPage;
import page.AddPharmacistPage;
import page.HomePage;
import page.LoginPage;

public class fr1 {

	protected static WebDriver driver = new FirefoxDriver();

	@BeforeClass
	public static void setup() {
		driver.manage().window().maximize();
		driver.get("http://localhost:8081");
	}

	@AfterClass
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

	// Log in to system as Admin
	@Test(priority = 1)
	public void loginAsAdmin() {
		loginpage.enterVardas("Adminas");
		loginpage.enterPassword("Adminas");
		loginpage.clickLoginPirmyn();

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(homepage.getLinkMeniu()));

	}

	// Adding Admin users
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
	@Test(priority = 4, dataProvider = "Patient", dataProviderClass = TestDataProviders.class, enabled = true)
	public void addUserPacientas(String name, String surname, String username, String password, String AK, String DoB,
			String DoctUser) {

		homepage.clickLinkMeniu();
		homepage.clickLinkPacientas();

		addpatientpage.enterName(name);
		addpatientpage.enterSurname(surname);
		addpatientpage.enterUsername(username);
		addpatientpage.enterPassword(password);
		addpatientpage.enterPersonalId(AK);
		addpatientpage.enterBirthday(DoB);
		addpatientpage.enterDoctorUsername(DoctUser);
		addpatientpage.clickButtonSave();

		new WebDriverWait(driver, 2000).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	// Adding Pharmacist user
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

}
