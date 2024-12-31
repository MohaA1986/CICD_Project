package Automation_Abdul.SeleniumFramework;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Automation_Abdul_SeleniumFramework.PageObject.LandingPage;





public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String productName = "ZARA COAT 3";
		driver.get("https://rahulshettyacademy.com/client");
		
		
		LandingPage obj1 = new LandingPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("edtd_2020@yahoo.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ab@123456");
		driver.findElement(By.id("login")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));
		List<WebElement> cards = driver.findElements(By.cssSelector(".card-body"));
		
		
		WebElement car = cards.stream().filter(card-> 
		card.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		car.findElement(By.cssSelector("button:last-of-type")).click();
		
		
		/*
		for (int i=0; i<cards.size(); i++)
		{
				
			if (cards.get(i).getText().contains("ZARA COAT 3"))
					{		
					cards.get(i).findElement(By.cssSelector("button:last-of-type")).click();
					break;
			}	
			
		}
		*/
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//button[@class = 'btn btn-custom'] /i[@class = 'fa fa-shopping-cart']")).click();
		
		
		//.cartSection
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		boolean cart = cartProducts.stream().anyMatch(cartProduct ->
		cartProduct.findElement(By.xpath("//h3[text()='ZARA COAT 3']")).getText().equals(productName));
		Assert.assertTrue(cart);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		//.form-group input
		
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("ind");
		
		//ta-item list-group-item ng-star-inserted 1
		
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String cMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
//		System.out.println(cMsg);
		
	
		Assert.assertTrue(cMsg.equalsIgnoreCase("Thankyou for the order."));
		
		
		String orderId = driver.findElement(By.cssSelector(".ng-star-inserted:nth-of-type(3)")).getText();
		String[] id = orderId.split(" ");
		String i = id[1];
		//System.out.println(i);
		
		driver.close();
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		

	}

}
