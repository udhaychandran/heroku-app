package utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupTeardown {
	
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static String className;
	public static WebDriver driver;
	public WebDriverWait wait;
	public SetupTeardown() {
		this.driver=driver;
	}
	
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) {
				
			if (browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().clearDriverCache().setup();
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.manage().window().maximize(); 	
				driver.get("https://the-internet.herokuapp.com/");
			}
			if (browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.chromedriver().clearDriverCache().setup();
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.manage().window().maximize(); 	
				driver.get("https://the-internet.herokuapp.com/");
			}
			
		}
		
	
 	@AfterTest
 	public void tearDown() {
 		driver.quit();
 		System.out.println("After test executed");
 	}
	
	public void waitForSometime() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
}
