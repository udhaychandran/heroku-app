package helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.Functions;
import utilities.SetupTeardown;

public class StoreTableToMaps extends SetupTeardown {

	String fileName = "./src/test/java/resources/basicInfo.properties";
	Functions func = new Functions();
	Properties prop = Functions.readProperties(fileName);
	
	@Test
	public void readTable() {
		driver.get(prop.getProperty("url"));
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		
		//Locate the table
		WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
		
		//Initialize Map
		Map<String, List<String>> hMap = new HashMap<>();
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		List<WebElement> header = rows.get(0).findElements(By.tagName("th"));
		
		List<String> columns = new ArrayList<String>();
		for (WebElement cells: header )
		{
			columns.add(cells.getText());
			System.out.println(cells.getText());
		}
		
		
		
	}
}
