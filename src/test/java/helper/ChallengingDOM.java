package helper;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import POM.ChallengingDOMPOM;
import utilities.Functions;
import utilities.SetupTeardown;

public class ChallengingDOM extends SetupTeardown{
	
	Functions func = new Functions();
	private static String folderName = "ChallengingDOM";
	ChallengingDOMPOM challengingDOMPOM;
	@Test
	public void challengingDOM() throws IOException {
		
		challengingDOMPOM = new ChallengingDOMPOM(driver);
		challengingDOMPOM.challengeingDOMClick();
		func.takeScreenShot(driver, folderName, "challengingDOMLink");
		//Get Total number of rows
		List<WebElement> rowNumber = driver.findElements(By.xpath("//table//thead//tr//th"));
		int rowCount = rowNumber.size();
		System.out.println("The total number of rows in the table is: "+rowCount);
		
		//Get total number of columns
		List<WebElement> columnNumber = driver.findElements(By.xpath("//table//tbody//tr//td"));
		int columnCount = columnNumber.size();
		System.out.println("The total number of column in the table is: "+columnCount);
		
		//Get the table values
		WebElement table = driver.findElement(By.xpath("//div[@class='large-10 columns']//table"));
		
		List <WebElement> getRows = table.findElements(By.tagName("tr"));
		for(WebElement rows: getRows)
		{
			List<WebElement> getColumn = rows.findElements(By.tagName("td"));
			for(WebElement columns: getColumn)
			{
				System.out.println(columns.getText());
			}
		}
	
	}
}
