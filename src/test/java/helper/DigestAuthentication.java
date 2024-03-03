package helper;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utilities.Functions;
import utilities.SetupTeardown;

public class DigestAuthentication extends SetupTeardown {

	Functions func = new Functions();
	private String folderName="Digest Authentication";
	@Test
	public void digestAuth() {
		
		try {
			driver.findElement(By.linkText("Digest Authentication")).click();
			driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
			func.takeScreenShot(driver, folderName, "DigestAuth");
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
