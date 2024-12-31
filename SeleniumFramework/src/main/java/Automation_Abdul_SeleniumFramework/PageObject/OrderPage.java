package Automation_Abdul_SeleniumFramework.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	
	WebDriver driver;
	
	public OrderPage(WebDriver d) {
		
		super(d);
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	@FindBy (xpath = "//tr/td[2]")
	List<WebElement> orderList;
	
	
	//By orderEl = By.xpath("//tr/td[1]"); 
	
	public Boolean verifyOrderList(String prodName) {
			
		Boolean oList = orderList.stream().anyMatch(order -> order.getText().equalsIgnoreCase(prodName));
		
		return oList;
		
	}
	
	
		

}
