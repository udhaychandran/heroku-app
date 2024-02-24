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
	
	@Test
	public void acncestorXpath() throws InterruptedException {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize(); 	
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='dropbtn']//following::input[1]")).click();
		Thread.sleep(3000);
		}
}
