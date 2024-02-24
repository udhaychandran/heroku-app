package helper;


import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.Timeout;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.SetupTeardown;

public class Robot {
	WebDriver driver;
	Robot robot = new Robot();
	public void setUp() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize(); 	
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test
	public void keyPress(int vkEnter) {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		robot.keyPress(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
	}
}
