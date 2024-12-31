package Automation_Abdul.SeleniumFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Automation_Abdul_SeleniumFramework.PageObject.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(fs);
		//String browserName = prop.getProperty("browser");
		
		String browserName = System.getProperty("browser")!= null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if (browserName.contains("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			
			if (browserName.contains("headless")){

				options.addArguments("headless");
			}

			
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\moham\\OneDrive\\Desktop\\Resume\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver(options);
			
		}else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C://Users//moham//OneDrive//Desktop//Resume//Selenium//geckodriver-v0.35.0-win-aarch64//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		
		
		driver = initializeDriver();
		landingPage = new LandingPage(driver);	
		landingPage.GoTo();
		return landingPage;
			
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		
	}
	
	

}
