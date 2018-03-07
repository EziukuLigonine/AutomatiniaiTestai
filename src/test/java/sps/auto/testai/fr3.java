package sps.auto.testai;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import data.providers.TestDataProviders;
import test.AbstractTest;

public class fr3 extends AbstractTest {

	@Test(priority = 1)
	public void login() {
		driver.get("http://localhost:8081");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Petras");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Petraitis");
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.linkText("Meniu")).click();
		driver.findElement(By.linkText("Išrašyti ligos istoriją")).click();
	}

	@Test(priority = 2, dataProvider = "MedicalRecord", dataProviderClass = TestDataProviders.class, enabled = true)
	public void addMedicalRecord(String AK, String minut ,String TLK, String VLK, String rep, String doctor, String visit)
			throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 3000);

		driver.findElement(By.id("personalId")).sendKeys(AK);

		Select trukme = new Select(driver.findElement(By.id("duration")));
		trukme.selectByVisibleText(minut);

		driver.findElement(By.id("tlk")).sendKeys(TLK);

		Select vlk = new Select(driver.findElement(By.id("vlk")));
		vlk.selectByVisibleText(VLK);

		Select repeat = new Select(driver.findElement(By.id("repeated")));
		repeat.selectByVisibleText(rep);

		driver.findElement(By.id("doctorUsername")).sendKeys(doctor);

		driver.findElement(By.id("appDesc")).sendKeys(visit);

		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

}
