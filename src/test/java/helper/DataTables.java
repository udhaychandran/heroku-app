package helper;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.SetupTeardown;

public class DataTables extends SetupTeardown {

@Test
public void TC353() {
	
	try
	{
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		Thread.sleep(3000);
		//List<WebElement> element = driver.findElements(By.xpath("//table[@id='table1']//tr//th"));
		//System.out.println(element.size());
		WebElement tables = driver.findElement(By.xpath("//table[@id='table1']"));
		List<WebElement> rows = tables.findElements(By.tagName("tr"));
		for (WebElement rowValue: rows)
		{
			List<WebElement> colValue = rowValue.findElements(By.tagName("td"));
			for(WebElement col: colValue)
			{
				System.out.println(col.getText());
			}
		}
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	
	
}
}
