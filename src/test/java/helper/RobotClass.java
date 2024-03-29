package helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Functions;
import utilities.SetupTeardown;

public class RobotClass extends SetupTeardown{
	
	//WebDriver driver;
	WebDriverWait wait = null;
	Functions func = new Functions();
	String folderName="Robot";
	@Test
	public void keyEvent() {
		try {
			driver.findElement(By.linkText("Key Presses")).click();
			//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Elemental Selenium")));
			Robot robot = new Robot();
//			robot.keyPress(KeyEvent.VK_SHIFT);
//			String keyEventShift = driver.findElement(By.xpath("*//p[@id='result']")).getText();  	
//			System.out.println(keyEventShift);
//			Assert.assertEquals(keyEventShift, "You entered: SHIFT");	
			robot.keyPress(KeyEvent.VK_SHIFT);
			driver.findElement(By.xpath("*//input[@id='target']")).sendKeys("");
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			robot.keyPress(KeyEvent.VK_U);
			robot.keyPress(KeyEvent.VK_D);
			robot.keyPress(KeyEvent.VK_H);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyPress(KeyEvent.VK_Y);
			robot.keyPress(KeyEvent.VK_A);
			func.takeScreenShot(driver, folderName, "keyEventShift");
			robot.keyRelease(KeyEvent.VK_SHIFT);
			
			//Press Caps
			robot.keyPress(KeyEvent.VK_CAPS_LOCK);
			String capsText = driver.findElement(By.xpath("//p[contains(text(),'CAPS_LOCK')]")).getText();
			System.out.println(capsText);
			Assert.assertEquals(capsText, "You entered: CAPS_LOCK");
			Thread.sleep(5000);
			robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(5000);
			
			//Mouse action
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(5000);
			robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
			Thread.sleep(5000);
			robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
			
			//Get Attribiute
			WebElement textEntered = driver.findElement(By.id("target"));
			System.out.println(textEntered.getAttribute("text"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
