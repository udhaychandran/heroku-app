package helper;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POM.AddElementPOM;
import utilities.Functions;
import utilities.SetupTeardown;

public class AddElement extends SetupTeardown{

	AddElementPOM addElement;
	Functions func = new Functions();
	String folderName = "AddElement";
	@Test(priority = 0)
	public void addElement() throws InterruptedException, IOException {
		Thread.sleep(2000);
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
