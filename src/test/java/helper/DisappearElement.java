package helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.Functions;
import utilities.SetupTeardown;

public class DisappearElement extends SetupTeardown{
	
	Functions func = new Functions();
	
	@Test
	public void disappearElement() {
		
		try {
		driver.findElement(By.linkText("Disappearing Elements")).click();
		List<WebElement>noOfElements = driver.findElements(By.xpath("//div[@class='example']//li"));
		int element = noOfElements.size();
		System.out.println(element);
		for (WebElement total: noOfElements)
		{
			System.out.println(total.getText());			
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
