package cucumber.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import Automation_Abdul.SeleniumFramework.BaseTest;
import Automation_Abdul_SeleniumFramework.PageObject.ConfirmationPage;
import Automation_Abdul_SeleniumFramework.PageObject.LandingPage;
import Automation_Abdul_SeleniumFramework.PageObject.MyCart;
import Automation_Abdul_SeleniumFramework.PageObject.PaymentPage;
import Automation_Abdul_SeleniumFramework.PageObject.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionImplementation extends BaseTest {
	
	
	public LandingPage landingpage;
	public ProductCatalogue productCatalogue;
	public MyCart myCart;
	public PaymentPage paymentPage;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce page.")
	public void i_landed_on_ecommerce_page() throws IOException {
		
		landingpage = launchApplication();
		
	}
	
	
	@Given("^I logged in with the (.+) and (.+)$")
	public void i_logged_in_with_username_password(String userName, String password) {
		
		landingPage.EnterUserName(userName);
		landingPage.EnterPassword(password);
		productCatalogue = landingPage.Login();
		
	}
	
	@When("^I add the (.+) in the cart$")
	public void add_product_to_cart(String productName) throws InterruptedException {
		productCatalogue.addToCart(productName);
		Thread.sleep(3000);
		myCart = productCatalogue.goToCart();
		
	}
	
	
	@When("^Check the (.+) in the cart and submit purchase$")
	public void check_and_submit_order(String productName) {
		Assert.assertTrue(myCart.checkProductInTheCart(productName));
		paymentPage = myCart.clickOnCheckout();
		
	}
	
	@Then("Verify the confirmation message {string} in the confirmation page.")
	public void verify_confirmation_message(String string) {
		paymentPage.selectCountry("ind");
		confirmationPage = paymentPage.placeOrder();
		Assert.assertTrue(confirmationPage.getConfirmationMessage().equalsIgnoreCase(string));
		driver.close();
		
	}
	
	@Then("I verify the {string} error message.")
	public void verify_the_login_error_message(String string) {
		
		String errTxt = landingPage.verifyEmail().toLowerCase();
		Assert.assertEquals(errTxt, string);
		driver.close();
	}
	
	

}
