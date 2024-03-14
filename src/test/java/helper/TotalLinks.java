package helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.SetupTeardown;

public class TotalLinks extends SetupTeardown {

	@Test
	public void countLinks() {
		
		List<WebElement> total = driver.findElements(By.tagName("a"));
		System.out.println(total.size());
	}
}
