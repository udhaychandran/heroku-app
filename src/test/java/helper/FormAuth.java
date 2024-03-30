package helper;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import POM.FormAuth_POM;
import utilities.Functions;
import utilities.SetupTeardown;
import utilities.WaitClass;

public class FormAuth extends SetupTeardown{

	String folderName = "FormAuth";
	String filePath = "./src/test/java/resources/formAuth.properties";
	WaitClass waitClass = new WaitClass();
	Functions func = new Functions();
	Properties prop = Functions.readProperties(filePath);
	FormAuth_POM formAuthPOM;
	@Test
	public void formAuth() {
		try {
			
			extentTest = extentReports.createTest(folderName);
			formAuthPOM = new FormAuth_POM(driver);
			waitClass.scrollBy();
			formAuthPOM.clickFormAuth();
			//driver.findElement(By.linkText("Form Authentication")).click();
			extentTest.log(Status.PASS, "Form Auth link is clicked");
			func.takeScreenShot(driver, folderName, folderName, "FormAuthPage");
			//Enter username
			formAuthPOM.enteruserName(prop.getProperty("userName"));
			extentTest.log(Status.PASS, "Username entered");
			//Enter password
			formAuthPOM.enterPassword(prop.getProperty("password"));
			extentTest.log(Status.PASS, "Password entered");
			//CLick Login
			formAuthPOM.clickLoginForm();
			extentTest.log(Status.PASS, "Clicked Login");		
			String expectedLoginMessage = "You logged into a secure area! ×";
			WebElement loginMessage = driver.findElement(By.xpath("//div[@id='flash']"));
			String actualMessage = loginMessage.getText();
			System.out.println(actualMessage);
			//Assert.assertEquals(actualMessage, expectedLoginMessage);
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
