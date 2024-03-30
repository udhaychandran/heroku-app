package helper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	static String folderName = "AddElement";
	Properties prop = Functions.readProperties(fileName);
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	
	@Test(priority = 0)
	public void addElement() throws InterruptedException, IOException {
		
		extentTest = extentReports.createTest(folderName+"_"+dateFormat.format(date)+".html");
		Thread.sleep(2000);
		driver.get(prop.getProperty("url"));
		addElement = new AddElementPOM(driver);
		addElement.addDeleteElementLink();
		func.takeScreenShot(driver, folderName, folderName,"Add/DeleteElementLink");
		addElement.addElement();
		func.takeScreenShot(driver, folderName,folderName, "AddElement");
		extentTest.pass("Add method is passed");
		Thread.sleep(2000);
	}
	@Test(priority = 1)
	public void deleteElement() throws InterruptedException, IOException {
		addElement = new AddElementPOM(driver);
		addElement.deleteElement();
		func.takeScreenShot(driver, folderName,folderName, "DeleteElement");
		extentTest.pass("Add method is passed");
		Thread.sleep(1000);
	}
}
