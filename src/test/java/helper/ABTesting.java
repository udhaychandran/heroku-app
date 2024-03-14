package helper;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import POM.ABTestingPOM;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Functions;
import utilities.SetupTeardown;

public class ABTesting extends SetupTeardown {

	//WebDriver driver;
	ABTestingPOM abTestingPOM;
	String fileName = "./src/test/java/resources/basicInfo.properties";
	Functions func = new Functions();
	Properties prop = Functions.readProperties(fileName);
	String folderName = "ABTesting";
	private static String className = "ABTesting";	
	SetupTeardown setupTearDown;
	@Test(priority = 0)
	public void abTesting(){
		
		try {
			abTestingPOM = new ABTestingPOM(driver);
			abTestingPOM.abTesting();
			Thread.sleep(2000);
			func.takeScreenShot(driver, folderName, "ABTestingPage");
			
		}
		catch (Exception e) {
			
		}
		
		
	}
	@Test(priority = 1)
	public void switchToElementalSelenium() {
		
		try {
			abTestingPOM = new ABTestingPOM(driver);
			abTestingPOM.elementSeleniumLink();
			func.takeScreenShot(driver, folderName, "Elemental_Selenium");
			
			String parentWindow = driver.getWindowHandle();
			Set<String> childWindow = driver.getWindowHandles();
			for (String handle: childWindow)
			{	
				if(!parentWindow.equals(handle))
				{
					Thread.sleep(2000);
					driver.switchTo().window(handle);
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
