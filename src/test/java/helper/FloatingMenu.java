package helper;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import freemarker.core.JavaScriptOutputFormat;
import utilities.Functions;
import utilities.SetupTeardown;

public class FloatingMenu extends SetupTeardown{

	Functions func = new Functions();
	String folderName = "FloatingMenu";
	@Test
	public void floatingMenu() {
		
		try {
			driver.findElement(By.linkText("Floating Menu")).click();
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Home']")));
			func.takeScreenShot(driver, folderName,folderName, "FloatingMenu");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,500);");
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			func.takeScreenShot(driver, folderName,folderName, "ScrollBy500");
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement floatingMenuPresence = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Home']")));
			//Verify the floating menu still there
			if (floatingMenuPresence.isDisplayed()==true)
			{
				System.out.println("The Menu is displayed");
			}
			else
			{
				System.out.println("The Menu is not displayed");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
