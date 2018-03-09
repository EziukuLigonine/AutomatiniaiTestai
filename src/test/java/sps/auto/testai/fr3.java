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
import page.HomePage;
import page.LoginPage;
import page.MedicalRecord;

public class fr3 {

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
	MedicalRecord medicalrecord = PageFactory.initElements(driver, MedicalRecord.class);

	// Log in to system as Doctor
	@Test(priority = 1)
	public void loginAsDoctor() {
		loginpage.enterVardas("Petras");
		loginpage.enterPassword("Petraitis");
		loginpage.clickLoginPirmyn();

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(homepage.getLinkMeniu()));
		
		homepage.clickLinkMeniu();
		homepage.clickAddMedicalRecord();
	}

	// Adding Medical record
	@Test(priority = 2, dataProvider = "MedicalRecord", dataProviderClass = TestDataProviders.class, enabled = true)
	public void addMedicalRecord(String AK, String minut, String TLK, String VLK, String rep, String doctor,
			String visit) {

		medicalrecord.enterPersonalId(AK);
		medicalrecord.selectDuration(minut);
		medicalrecord.enterTlk(TLK);
		medicalrecord.selectVlk(VLK);
		medicalrecord.selectRepeat(rep);
		medicalrecord.enterDoctorUsername(doctor);
		medicalrecord.enterDescription(visit);
		medicalrecord.clickButtonSave();

		new WebDriverWait(driver, 2000).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

}
