package Automation_Abdul_SeleniumFramework.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents  {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver d) {
		
		super(d);
		this.driver = d;
		PageFactory.initElements(d, this);
		
	}
	
	
	@FindBy (css = ".card-body")
	List <WebElement> productList;
	
	@FindBy (css = ".ng-animating")
	WebElement circle;
	
	@FindBy (xpath = "//button[@class = 'btn btn-custom'] /i[@class = 'fa fa-shopping-cart']")
	WebElement cart;

	@FindBy (css = ".btn.btn-custom[routerlink='/dashboard/myorders']")
	WebElement orders;
	
	
	By productEl = By.cssSelector(".card-body");
	By addToCartEl = By.cssSelector("button:last-of-type");
	By toast = By.cssSelector("#toast-container");
	By cartEl = By.xpath("//button[@class = 'btn btn-custom'] /i[@class = 'fa fa-shopping-cart']");
		
	
	//List<WebElement> cards = driver.findElements(By.cssSelector(".card-body"));
	
	
	public List<WebElement> getProductList() {
		
		waitUntilVisible(productEl);
		return productList;	
	}
	
	public WebElement getProductByName(String productName) {
		
		WebElement prod = productList.stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
		
		//prod.findElement(By.cssSelector("button:last-of-type")).click();
	}
	
	public void addToCart(String pNam) {
		
		getProductByName(pNam).findElement(addToCartEl).click();
		waitUntilVisible(toast);
		waitUntilDisappear(circle);
		
	}
	
	public MyCart goToCart() {
		waitUntilVisible(cartEl);
		cart.click();
		return new MyCart(driver);
	}
	
	public void gotoOrders() {
		orders.click();
		
	}
	
	

}
