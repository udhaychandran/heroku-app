package helper;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.github.dockerjava.api.model.Image;

import utilities.Functions;
import utilities.SetupTeardown;

public class DragandDrop extends SetupTeardown {

	Functions func = new Functions();
	private String folderName = "DragAndDrop";
	@Test
	public void dragDrop() {
		
		
		try {
		
		driver.findElement(By.linkText("Drag and Drop")).click();
		//func.takeScreenShot(driver, folderName, "DragandDrop");
		Shutterbug.shootPage(driver).withName("Expected").save();
		WebElement dragA = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement dragB = driver.findElement(By.xpath("//div[@id='column-b']"));
		System.out.println("Drag A&B Locators are theres");
		Actions act = new Actions(driver);
		act.dragAndDrop(dragA, dragB).perform();
		File image = new File(".\\screenshots\\Expected.png");
	     BufferedImage expectedImage = ImageIO.read(image);
	     boolean status = Shutterbug.shootPage(driver).withName("Actual").equals(expectedImage);                
	     Assert.assertTrue(status);   
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
