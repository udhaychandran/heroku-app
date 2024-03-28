package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	
	public static ExtentReports getInstance(String reportPath) {
		
		if(extentReports==null)
		{
		extentReports = new ExtentReports();
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
		extentReports.attachReporter(extentSparkReporter);
		}
		return extentReports;
	}
	
	public static ExtentTest createTest(String testName) {
		
		extentTest = extentReports.createTest(testName);
		return extentTest;
		
	}
	public static void flushReport() {
		if(extentReports!=null)
		{
			extentReports.flush();
		}
	}
}

