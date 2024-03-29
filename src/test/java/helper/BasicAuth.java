package helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import POM.BasicAuthPOM;
import utilities.ExtentReport;
import utilities.SetupTeardown;

public class BasicAuth extends SetupTeardown{

	BasicAuthPOM basicAuthPOM;
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	@Test(priority = 0)
	public void basicAuth() throws InterruptedException {
		extentTest = ExtentReport.createTest("folderName"+"_"+dateFormat.format(date)+".html"); 
		basicAuthPOM = new BasicAuthPOM(driver);
		Thread.sleep(1000);
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		//driver.switchTo().alert().sendKeys("admin");
		extentTest.pass("Basic auth method is passed");
	}
}
