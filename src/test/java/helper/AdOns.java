package helper;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import POM.AdOn_POM;
import utilities.Functions;
import utilities.SetupTeardown;
import utilities.WaitClass;

public class AdOns extends SetupTeardown  {

	Functions func = new Functions();
	String folderName = "AdOns";
	WaitClass waitClass = new WaitClass();
	@Test
	public void adOn() {
		try
		{
			AdOn_POM adOn_POM = new AdOn_POM(driver);
			driver.findElement(By.linkText("Entry Ad")).click();
			waitClass.waitForSometime();
			waitClass.waitForSometime();
			func.takeScreenShot(driver, folderName,folderName, "AdOn");
			waitClass.waitForElementToBeClicable(adOn_POM.closeButton);
			adOn_POM.closeButtonClick();
			func.takeScreenShot(driver, folderName,folderName, "AdOn_Dismiss");
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
