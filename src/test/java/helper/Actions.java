package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.SetupTeardown;

public class Actions extends SetupTeardown{

	@Test
	public void doubleClick(WebElement element2) {
		
		WebElement element = driver.findElement(By.linkText("Inputs"));	
		Actions act = new Actions();
		act.doubleClick(element);
	}
}