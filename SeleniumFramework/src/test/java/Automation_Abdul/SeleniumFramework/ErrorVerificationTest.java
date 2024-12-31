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
import Automation_Abdul_SeleniumFramework.PageObject.OrderPage;
import Automation_Abdul_SeleniumFramework.PageObject.PaymentPage;
import Automation_Abdul_SeleniumFramework.PageObject.ProductCatalogue;


public class ErrorVerificationTest extends BaseTest {

	
	@Test
	public void checkOrderList() throws InterruptedException, IOException  {

		
		String productName = "ZARA COAT 3";
		String userName = "edtd_2020@yahoo.com";
		String password = "Ab@123456";
		
		landingPage.EnterUserName(userName);
		landingPage.EnterPassword(password);
		ProductCatalogue productCatalogue = landingPage.Login();
		
		productCatalogue.gotoOrders();
		OrderPage oPage = new OrderPage(driver);
		Boolean match = oPage.verifyOrderList(productName);
		Assert.assertTrue(match);
		
		}
	
	@Test
	public void emailValidation() {
		
		String userName = "adtd_2020@yahoo.com";
		String password = "Ab@123456";
		
		landingPage.EnterUserName(userName);
		landingPage.EnterPassword(password);
		ProductCatalogue productCatalogue = landingPage.Login();
		String errTxt = landingPage.verifyEmail().toLowerCase();
		
		Assert.assertEquals(errTxt, "incorrect email or password.");
	}

	}
