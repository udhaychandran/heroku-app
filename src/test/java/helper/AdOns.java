package helper;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utilities.Functions;
import utilities.SetupTeardown;

public class AdOns extends SetupTeardown  {

	Functions func = new Functions();
	String folderName = "AdOns";
	@Test
	public void adOn() {
		try
		{
			driver.findElement(By.linkText("Entry Ad")).click();
			waitForSometime();
			func.takeScreenShot(driver, folderName, "AdOn");
			driver.findElement(By.xpath("//div[@class='modal-footer']//p[text()='Close']")).click();
			func.takeScreenShot(driver, folderName, "AdOn_Dismiss");
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
