package helper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import POM.ContextMenuPOM;
import utilities.Functions;
import utilities.SetupTeardown;

public class ContextMenu extends SetupTeardown {

	ContextMenuPOM contextMenuPOM;
	Functions func = new Functions();
	WebDriverWait wait;
	private String folderName = "ContentMenu";
	@Test
	public void contextMenuTest() {
		try {
			contextMenuPOM = new ContextMenuPOM(driver);
			contextMenuPOM.contextMenuLinkClick();
			WebElement element = driver.findElement(By.xpath("//div[@id='hot-spot']"));
			//contextMenuPOM.contextMenuLinkClick();
			Thread.sleep(5000);
			func.takeScreenShot(driver, folderName,folderName, "ContextMenu_Alert");
			Actions act = new Actions(driver);
			act.contextClick(element).perform();
			Thread.sleep(5000);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			String text = alert.getText();
			alert.accept();
			extentTest.pass("ContextMenu method is passed");
			
			}
		catch (Exception e) {
			extentTest.fail("Add method is passed");
		}
		
		
		
		
	}
}
