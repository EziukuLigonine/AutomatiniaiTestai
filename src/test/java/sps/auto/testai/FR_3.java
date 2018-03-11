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
import doctor.can.add.AddMedicalRecord;
import home.and.login.HomePage;
import home.and.login.LoginPage;

public class FR_3 {

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
	AddMedicalRecord medicalrecord = PageFactory.initElements(driver, AddMedicalRecord.class);
	AllPatientsLinks allpatienslinks = PageFactory.initElements(driver, AllPatientsLinks.class);

	// Log in to system as Doctor
	@Test(priority = 1)
	public void loginAsDoctor() {
		loginpage.enterVardas("doctorpetras");
		loginpage.enterPassword("docpetras");
		loginpage.clickLoginPirmyn();

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(homepage.getLinkMeniu()));
	}

	// Adding Medical record
	@Test(priority = 2, dataProvider = "MedicalRecord", dataProviderClass = TestDataProviders.class, enabled = true)
	public void addMedicalRecord(String minut, String TLK, String VLK, String rep, String visit) {
		
		homepage.clickLinkMeniu();
		homepage.clickVisiPacientai();
		
		allpatienslinks.clickButtonViewPatient();
		allpatienslinks.clickMedicalRecord();	

		medicalrecord.selectDuration(minut);
		medicalrecord.enterTlk(TLK);
		medicalrecord.selectVlk(VLK);
		medicalrecord.selectRepeat(rep);
		medicalrecord.enterDescription(visit);
		medicalrecord.clickButtonSave();

		new WebDriverWait(driver, 2000).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

}
