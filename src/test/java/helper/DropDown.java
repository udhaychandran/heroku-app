package helper;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utilities.Functions;
import utilities.SetupTeardown;

public class DropDown extends SetupTeardown{

	Functions func = new Functions();
	String folderName = "DropDown";
	@Test
	public void dropDown() {
		
		try
		{
			extentTest = extentReports.createTest("DropDown");
			driver.findElement(By.linkText("Dropdown")).click();
			Thread.sleep(2000);
			Select select = new Select(driver.findElement(By.id("dropdown")));
			List<WebElement> listDropDown = select.getOptions();
			for(WebElement list:listDropDown)
			{
				if(list.getText().equals("Option 1")) {
					list.click();
				}
			}
			func.takeScreenShot(driver, folderName, folderName, "OptionSelected");
			extentTest.log(Status.PASS, "The option is selected");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement selectedValue = select.getFirstSelectedOption();
			String dropValue = selectedValue.getText();
			System.out.println("The Selected value in dropdown is "+dropValue);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
