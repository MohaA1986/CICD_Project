package Automation_Abdul_SeleniumFramework.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import AbstractComponents.AbstractComponents;

public class MyCart extends AbstractComponents  {
	
	WebDriver driver;
	
	public MyCart(WebDriver d) {
		
		super(d);
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	@FindBy (css = ".cartSection h3")
	List <WebElement> cartProducts;
	
	@FindBy (css = ".totalRow button")
	WebElement checkoutButton;
	
	
	public List<WebElement> getCartProductList() {
		
		//waitUntilVisible(productEl);
		return cartProducts;	
	}
	
	public boolean checkProductInTheCart(String productName) {
		
		boolean cart = cartProducts.stream().anyMatch(cartProduct ->
		cartProduct.getText().equalsIgnoreCase(productName));
		//Assert.assertTrue(cart);
		return cart;

	}
	
	public PaymentPage clickOnCheckout() {
		
		checkoutButton.click();
		return new PaymentPage(driver);
		
	}
	
		

}
