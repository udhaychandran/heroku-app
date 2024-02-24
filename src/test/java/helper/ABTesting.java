package helper;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import POM.ABTestingPOM;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Functions;
import utilities.SetupTeardown;

public class ABTesting extends SetupTeardown {

	//WebDriver driver;
	ABTestingPOM abTestingPOM;
	Functions func = new Functions();
	String folderName = "ABTesting";
	SetupTeardown setupTearDown;
	@Test(priority = 0)
	public void abTesting(){
		
		try {
			abTestingPOM = new ABTestingPOM(driver);
			abTestingPOM.abTesting();
			Thread.sleep(2000);
			func.takeScreenShot(driver, folderName, "ABTestingPage");
			extentTest.log(LogStatus.PASS, "ABTesting Link is clicked");
		}
		catch (Exception e) {
			extentTest.log(LogStatus.FAIL, "ABTesting Link is has some issues");
		}
		
		
	}
	@Test(priority = 1)
	public void switchToElementalSelenium() {
		
		try {
			abTestingPOM = new ABTestingPOM(driver);
			abTestingPOM.elementSeleniumLink();
			func.takeScreenShot(driver, folderName, "Elemental_Selenium");
			extentTest.log(LogStatus.PASS, "Switched to Elemental selenium link");
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
			extentTest.log(LogStatus.FAIL, "Failed to switch to Elemental selenium link");
		}
		
	
	}
	
}
