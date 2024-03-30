package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitClass extends SetupTeardown{

	public WebDriverWait waitForSometime() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}
	
	public WebElement waitForElementToBeClicable(WebElement closeButton) {
		return wait.until(ExpectedConditions.elementToBeClickable(closeButton));
	}
	
	public void scrollBy() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500);");
	}
	
}
