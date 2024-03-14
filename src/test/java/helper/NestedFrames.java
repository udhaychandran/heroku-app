package helper;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.Functions;
import utilities.SetupTeardown;

public class NestedFrames extends SetupTeardown{

	Functions func = new Functions();
	String folderName = "NestedFrame";
	@Test
	public void frameOperation() {
			
		try {
			driver.findElement(By.linkText("Frames")).click();
			func.takeScreenShot(driver, folderName, "FrameLinkClick");
			Thread.sleep(3000);
			driver.findElement(By.linkText("Nested Frames")).click();
			Thread.sleep(3000);
			func.takeScreenShot(driver, folderName, "NestedFrameLinkClick");
			Thread.sleep(3000);
			//Find Total Number of Frames
				driver.switchTo().frame("frame-left");
				System.out.println("Switched to Frame1");
				driver.switchTo().defaultContent();
				System.out.println("Switched to default");
			
			
		}
		catch(Exception e)
		{
			// TODO: handle exception
		}
	}
}
