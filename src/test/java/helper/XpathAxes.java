package helper;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.SetupTeardown;

public class XpathAxes {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void setUp() {
		try {
			WebDriverManager.chromedriver().clearDriverCache().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize(); 	
			Thread.sleep(3000);
			driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void childXpath() throws InterruptedException {
		try {
			
			driver.findElement(By.xpath("//div[@class='container']/child::input[@name='name'][1]")).sendKeys("Test");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
	public void followingXpath() {
		
	}
}
