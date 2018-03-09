package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath = ("//input[@type='text']"))
	private WebElement loginVardas;
	
	public void enterVardas(String value) {
		loginVardas.sendKeys(value);
	}
	
	@FindBy(xpath = ("//input[@type='password']"))
	private WebElement loginPassword;
	
	public void enterPassword(String value) {
		loginPassword.sendKeys(value);
	}
	
	@FindBy(xpath = ("//button[@class='btn btn-success']"))
	private WebElement loginPirmyn;
	
	public void clickLoginPirmyn() {
		loginPirmyn.click();
	}
	



}
