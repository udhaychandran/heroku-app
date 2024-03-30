package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.Functions;
import utilities.SetupTeardown;

public class Frame extends SetupTeardown{

	Functions func = new Functions();
	String folderName = "Frame";
	@Test
	public void frameOperation() {
			
		try {
			driver.findElement(By.linkText("Frames")).click();
			func.takeScreenShot(driver, folderName,folderName, "FrameLinkClick");
			Thread.sleep(3000);
			driver.findElement(By.linkText("iFrame")).click();
			Thread.sleep(3000);
			func.takeScreenShot(driver, folderName, folderName,"iFrameLinkClick");
			Thread.sleep(3000);
			//Find Total Number of Frames
			int iFrame = driver.findElements(By.tagName("iframe")).size();
			System.out.println(iFrame);
			driver.switchTo().frame("mce_0_ifr");
			driver.findElement(By.id("tinymce")).clear();
			System.out.println("Switch");
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			// TODO: handle exception
		}
	}
}
