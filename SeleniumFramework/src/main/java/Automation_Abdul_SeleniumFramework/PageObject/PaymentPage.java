package Automation_Abdul_SeleniumFramework.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import AbstractComponents.AbstractComponents;

public class PaymentPage extends AbstractComponents  {
	
	WebDriver driver;
	
	public PaymentPage(WebDriver d) {
		
		super(d);
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	@FindBy (css = ".form-group input")
	WebElement countryBox;

	@FindBy (css = ".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	@FindBy (css = ".action__submit")
	WebElement placeOrder;
	
	
	public void selectCountry(String countryText) {
		
		countryBox.sendKeys(countryText);	
		selectCountry.click();
		
	}
	
	public ConfirmationPage placeOrder() {
		
		placeOrder.click();
		return new ConfirmationPage(driver);
	}
	
		

}
