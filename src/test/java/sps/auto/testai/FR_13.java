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
import home.and.login.ChangePassPage;
import home.and.login.HomePage;
import home.and.login.LoginPage;

public class FR_13 {

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
	ChangePassPage changepass = PageFactory.initElements(driver, ChangePassPage.class);


	// Changing password
	
	@Test(priority = 1, dataProvider = "ChangePassword", dataProviderClass = TestDataProviders.class, enabled = true)
	public void changePassword(String username, String currentPassword, String newPassword) 
			throws InterruptedException {
		
		loginpage.enterVardas(username);
		loginpage.enterPassword(currentPassword);
		loginpage.clickLoginPirmyn();

		Thread.sleep(1000);
		homepage.clickUserIcon();
		Thread.sleep(1000);
		homepage.clickChangePassword();
		
		changepass.clearAllFields();
		changepass.enterCurrentPass(currentPassword);
		changepass.enterNewPass(newPassword);
		changepass.enterRepeatPass(newPassword);
		changepass.clickButtonSave();
		
		new WebDriverWait(driver, 2000).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		homepage.clickUserIcon();
		homepage.clickAtsijungti();
	}

}
