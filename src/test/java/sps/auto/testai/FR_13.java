package sps.auto.testai;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import home.and.login.HomePage;
import home.and.login.LoginPage;

public class FR_13 {

	protected static WebDriver driver = new ChromeDriver();

	@BeforeClass
	public static void setup() {
		driver.manage().window().maximize();
		driver.get("http://localhost:8081");
	}

	@AfterClass
	public static void closeBrowser() {
//		driver.quit();
	}

	// Pagefactory
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	HomePage homepage = PageFactory.initElements(driver, HomePage.class);


	// Log in as Admin user and change password
	@Test
	public void changePasswordAdmin() {
		
		loginpage.enterVardas("Adminas");
		loginpage.enterPassword("Adminas");
		loginpage.clickLoginPirmyn();
//
//		homepage.clickUserIcon();
//		homepage.clickChangePassword();

	}

}
