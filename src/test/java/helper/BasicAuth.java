package helper;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import POM.BasicAuthPOM;
import utilities.SetupTeardown;

public class BasicAuth extends SetupTeardown{

	BasicAuthPOM basicAuthPOM;
	
	@Test(priority = 0)
	public void basicAuth() throws InterruptedException {
		basicAuthPOM = new BasicAuthPOM(driver);
		Thread.sleep(1000);
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		//driver.switchTo().alert().sendKeys("admin");
	}
}
