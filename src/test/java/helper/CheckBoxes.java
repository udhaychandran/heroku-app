package helper;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import POM.CheckboxesPOM;
import utilities.SetupTeardown;

public class CheckBoxes extends SetupTeardown {

	CheckboxesPOM checkBoxPOM;
	int count =0;
	
	@Test
	public void validateCheckBox() {
		checkBoxPOM = new CheckboxesPOM(driver);
		checkBoxPOM.clickCheckBoxLink();
		checkBoxPOM.clickCheckBoxOne();
		List<WebElement> checkBoxXpath = driver.findElements(By.xpath("//input[@type='checkbox']"));
		//Find if a checkbox is already checked
		
		for (WebElement countCheckBox: checkBoxXpath)
		{
			if (countCheckBox.isSelected())
			{
				count++;
			}
		}
		System.out.println(count);
	}
}
