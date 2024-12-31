package Automation_Abdul_SeleniumFramework.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver d) {
		
		super(d);
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	@FindBy (id = "userEmail")
	WebElement userEmail;
	
	@FindBy (id = "userPassword")
	WebElement passwordEl;
	
	@FindBy (id = "login")
	WebElement login;	
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	By toastEl = By.cssSelector("[class*='flyInOut']");
	
	
	public ProductCatalogue Login() {
		login.click();	
		return new ProductCatalogue(driver);
	}
	
	public void EnterUserName(String userName) {
		userEmail.sendKeys(userName);
		
	}

	public void EnterPassword(String password) {
		passwordEl.sendKeys(password);
		
	}
	
	public void GoTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String verifyEmail() {
		
		waitUntilVisible(toastEl);
		System.out.println(errorMessage.getText());
		return errorMessage.getText();
	}
	

}
