package Automation_Abdul_SeleniumFramework.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents  {
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver d) {
		
		super(d);
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	@FindBy (css = ".hero-primary")
	WebElement confirmMsg;
	
	//String cMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	public String getConfirmationMessage() {
		return confirmMsg.getText();
		
	}
	
		

}
