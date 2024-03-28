package helper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import POM.ABTestingPOM;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentReport;
import utilities.Functions;
import utilities.SetupTeardown;

public class ABTesting extends SetupTeardown {

	ABTestingPOM abTestingPOM;
	String fileName = "./src/test/java/resources/basicInfo.properties";
	Functions func = new Functions();
	Properties prop = Functions.readProperties(fileName);
	String folderName = "ABTesting";
	private static String className = "ABTesting";	
	SetupTeardown setupTearDown;
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	
	public ABTesting() {
		super();
	}
	@Test(priority = 0)
	public void abTesting(){
		
		try {
			
			extentTest = ExtentReport.createTest("report/abTesting"+dateFormat.format(date)+".html"); 
			abTestingPOM = new ABTestingPOM(driver);
			driver.get(prop.getProperty("url"));
			abTestingPOM.abTesting();
			Thread.sleep(2000);
			func.takeScreenShot(driver, folderName, "ABTestingPage");
			extentTest.pass("Browser Launched");
			
		}
		catch (Exception e) {
			extentTest.fail("Failed ABTesting");
		}
		
		
	}
	@Test(priority = 1)
	public void switchToElementalSelenium() {
		
		try {
			abTestingPOM = new ABTestingPOM(driver);
			abTestingPOM.elementSeleniumLink();
			func.takeScreenShot(driver, folderName, "Elemental_Selenium");
			extentTest.pass("Select Link is visible");
			String parentWindow = driver.getWindowHandle();
			Set<String> childWindow = driver.getWindowHandles();
			for (String handle: childWindow)
			{	
				if(!parentWindow.equals(handle))
				{
					Thread.sleep(2000);
					driver.switchTo().window(handle);
					extentTest.pass("Switch to child window");
					Thread.sleep(2000);
					driver.findElement(By.id("email")).sendKeys("Test");
					func.takeScreenShot(driver, folderName, "Elemental_SeleniumPage");
					Thread.sleep(2000);
					driver.switchTo().window(parentWindow);
				}
			}
		}
		catch (Exception e)
		{
			
		}
		
	
	}
	
}
