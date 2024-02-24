package utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupTeardown {
	
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	
	public static WebDriver driver;
	public WebDriverWait wait;
	public SetupTeardown() {
		this.driver=driver;
	}
	@BeforeClass
	public void setUp() {
		try {
			extentReport = new ExtentReports(System.getProperty("user.dir")+"\\\\ExtentReportResults.html");
			extentTest = extentReport.startTest("SetupTeardown");
			WebDriverManager.chromedriver().clearDriverCache().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize(); 	
						extentTest.log(LogStatus.PASS, "THe Browser is launched");
		}
		catch (Exception e) {
			// TODO: handle exception
			extentTest.log(LogStatus.FAIL, "Experiencigng an issue while launching the browser. Please Check!");
		}
		
	}
	
//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//		System.out.println("After test executed");
//	}
	
	public void waitForSometime() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
}
