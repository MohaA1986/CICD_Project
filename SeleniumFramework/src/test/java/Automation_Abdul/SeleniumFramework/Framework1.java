package Automation_Abdul.SeleniumFramework;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import AbstractComponents.AbstractComponents;
import Automation_Abdul_SeleniumFramework.PageObject.ConfirmationPage;
import Automation_Abdul_SeleniumFramework.PageObject.LandingPage;
import Automation_Abdul_SeleniumFramework.PageObject.MyCart;
import Automation_Abdul_SeleniumFramework.PageObject.PaymentPage;
import Automation_Abdul_SeleniumFramework.PageObject.ProductCatalogue;


public class Framework1 extends BaseTest {

	
	@Test
	public void PlaceOrder() throws InterruptedException, IOException  {

		
		String productName = "ADIDAS ORIGINAL";
		//String webLink = "https://rahulshettyacademy.com/client";
		String userName = "edtd_2020@yahoo.com";
		String password = "Ab@123456";
		
		
		//LandingPage landingPage = launchApplication(webLink);
		landingPage.EnterUserName(userName);
		landingPage.EnterPassword(password);
		ProductCatalogue productCatalogue = landingPage.Login();
		
		//List<WebElement> products = obj2.getProductList();
		productCatalogue.addToCart(productName);
		Thread.sleep(3000);
		MyCart myCart = productCatalogue.goToCart();
		
		Assert.assertTrue(myCart.checkProductInTheCart(productName));
		PaymentPage paymentPage = myCart.clickOnCheckout();
		
		paymentPage.selectCountry("ind");
		ConfirmationPage confirmationPage = paymentPage.placeOrder();
				

		Assert.assertTrue(confirmationPage.getConfirmationMessage().equalsIgnoreCase("Thankyou for the order."));
		
		
		String orderId = driver.findElement(By.cssSelector(".ng-star-inserted:nth-of-type(3)")).getText();
		String[] id = orderId.split(" ");
		String i = id[1];
		//System.out.println(i);
		

		

		}

	}
