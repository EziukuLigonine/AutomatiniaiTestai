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
import page.AddPrescription;
import page.HomePage;
import page.LoginPage;

public class fr4 {

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
	AddPrescription prescription = PageFactory.initElements(driver, AddPrescription.class);

	// Log in to system as Doctor
	@Test(priority = 1)
	public void loginAsDoctor() {
		loginpage.enterVardas("Petras");
		loginpage.enterPassword("Petraitis");
		loginpage.clickLoginPirmyn();

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(homepage.getLinkMeniu()));

		homepage.clickLinkMeniu();
		homepage.clickAddPrescription();
	}

	// Adding Prescription record
	@Test(priority = 2, dataProvider = "Prescription", dataProviderClass = TestDataProviders.class, enabled = true)
	public void addPrescription 
(String AK, String activemat, String activematquant, String unitas, String descript, String doctorusr,String dateuntil) {

		prescription.enterPersonalId(AK);
		prescription.enterActiveMat(activemat);
		prescription.enterActiveMatQuant(activematquant);
		prescription.selectUnit(unitas);
		prescription.enterPrescriptionDesc(descript);
		prescription.enterDoctorUsr(doctorusr);
		prescription.enterInputValidUntil(dateuntil);
		prescription.clickButtonSave();

		new WebDriverWait(driver, 2000).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

}
