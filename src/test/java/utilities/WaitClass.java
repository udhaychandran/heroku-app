package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
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
	
}
