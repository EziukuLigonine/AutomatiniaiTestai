package sps.requirement.fr1;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.providers.TestDataProviders;
import page.AddAdminPage;
import page.HomePage;
import test.AbstractTest;

public class Requirement_fr1 extends AbstractTest {

	AddAdminPage addadminpage = new AddAdminPage(driver);
	HomePage homepage = new HomePage(driver);

	@Test(priority=1)
	public void login() {
		driver.get("http://localhost:8081");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Adminas");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Adminas");
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	}

	@Test(priority=2,dataProvider = "Admin", dataProviderClass = TestDataProviders.class, enabled = true)
	public void addUserAdministratorius(String name, String surname, String username, String password) {

		driver.findElement(By.linkText("Meniu")).click();
		driver.findElement(By.linkText("Administratorius")).click();

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("surname")).sendKeys(surname);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	@Test(priority=3,dataProvider = "Doctor", dataProviderClass = TestDataProviders.class,enabled = false)
	public void addUserGydytojas(String name, String surname, String username, String password) {

		driver.findElement(By.linkText("Meniu")).click();
		driver.findElement(By.linkText("Gydytojas")).click();

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("surname")).sendKeys(surname);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		Select special = new Select(driver.findElement(By.id("specialisation")));
		special.selectByIndex(new Random().nextInt(74));

		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	@Test(priority=4,dataProvider = "Patient", dataProviderClass = TestDataProviders.class, enabled = false)
	public void addUserPacientas(String name, String surname, String username, String password,
			String AK, String DoB, String DoctUser) {

		driver.findElement(By.linkText("Meniu")).click();
		driver.findElement(By.linkText("Pacientas")).click();

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("surname")).sendKeys(surname);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("personalId")).sendKeys(AK);
		driver.findElement(By.id("dateOfBirth")).sendKeys(DoB);
		driver.findElement(By.id("doctorUsername")).sendKeys(DoctUser);

		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	@Test(priority=5,dataProvider = "Pharmacist", dataProviderClass = TestDataProviders.class, enabled = false)
	public void addUserGydytojas(String name, String surname, String username, String password,String company) {

		driver.findElement(By.linkText("Meniu")).click();
		driver.findElement(By.linkText("Vaistininkas")).click();

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("surname")).sendKeys(surname);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		Select special = new Select(driver.findElement(By.id("companyType")));
		special.selectByIndex(new Random().nextInt(5));
		
		driver.findElement(By.id("companyName")).sendKeys(company);

		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	

}
