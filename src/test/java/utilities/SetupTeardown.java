package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.beust.jcommander.Parameter;

import POM.AdOn_POM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupTeardown {
	
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static String className;
	public static WebDriver driver;
	public WebDriverWait wait;
	Functions func = new Functions();
	
	public SetupTeardown() {
		
	}	
	@BeforeTest
	public static WebDriver setUp() {
		AdOn_POM adOn_POM = new AdOn_POM(driver);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		if (driver==null)
		{
			extentReports = ExtentReport.getInstance("Report/Reports_"+dateFormat.format(date));
			WebDriverManager.chromedriver().clearDriverCache().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize(); 	
			driver.get("https://the-internet.herokuapp.com/");
						
		}
		return driver;
		
		}
		
	
 	@AfterTest
 	public void tearDown() throws IOException {
 		if (driver!=null)
 		{
 			driver.quit();
 			System.out.println("driver quit");
 	 		extentReports.flush();	
 		}
 		
 	}
}
