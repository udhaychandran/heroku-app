package helper;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Functions;

public class DropDown1 {
	Functions func = new Functions();
	WebDriver driver;
	@Test
	public void dropDown() {
		String folderName = "DropDown_Index";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		WebElement dropDown = driver.findElement(By.cssSelector("select#first"));
		Select s = new Select(dropDown);
		List<WebElement> ele = s.getOptions();
		s.selectByIndex(ele.size()-1);
		try {
			func.takeScreenShot(driver, folderName, folderName,"dropdown_last");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
