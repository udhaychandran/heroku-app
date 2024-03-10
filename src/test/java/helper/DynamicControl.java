package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.SetupTeardown;

public class DynamicControl extends SetupTeardown{

	WebDriverWait wait;
	WebElement element;
	@Test
	public void dynamicControl() {
		
		try {
		//Click on the link
		driver.findElement(By.linkText("Dynamic Controls")).click();
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));
		//Remove the checkbox
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(2000);
		//String removeText = driver.findElement(By.id("message")).getText();
		//Assert.assertEquals("It's gone!", removeText);
		//Add the checkbox
		//driver.findElement(By.xpath("//button[@type='button' and @onclick='swapCheckbox()']")).click();
		//String addText = driver.findElement(By.id("message")).getText();
		//Assert.assertEquals("It's Back!", addText);
		//element = wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
