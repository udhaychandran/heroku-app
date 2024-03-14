package helper;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import POM.AddElementPOM;
import utilities.Functions;
import utilities.SetupTeardown;

public class AddElement extends SetupTeardown{

	AddElementPOM addElement;
	Functions func = new Functions();
	//Properties prop = new Properties();
	String fileName = "./src/test/java/resources/basicInfo.properties";
	String folderName = "AddElement";
	Properties prop = Functions.readProperties(fileName);
	@Test(priority = 0)
	public void addElement() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		driver.get(prop.getProperty("url"));
		addElement = new AddElementPOM(driver);
		addElement.addDeleteElementLink();
		func.takeScreenShot(driver, folderName, "Add/DeleteElementLink");
		addElement.addElement();
		func.takeScreenShot(driver, folderName, "AddElement");
		Thread.sleep(2000);
	}
	@Test(priority = 1)
	public void deleteElement() throws InterruptedException, IOException {
		addElement = new AddElementPOM(driver);
		addElement.deleteElement();
		func.takeScreenShot(driver, folderName, "DeleteElement");
		Thread.sleep(1000);
	}
}
