package helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.SetupTeardown;

public class DropDown extends SetupTeardown{

	@Test
	public void dropDown() {
		
		try
		{
			driver.findElement(By.linkText("Dropdown")).click();
			Thread.sleep(2000);
			Select select = new Select(driver.findElement(By.id("dropdown")));
			List<WebElement> listDropDown = select.getOptions();
			for(WebElement list:listDropDown)
			{
				System.out.println(list.getText());
			}
			select.selectByVisibleText("Option 1");
			Thread.sleep(2000);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
