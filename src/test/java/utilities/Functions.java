package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Functions {

	
	public void takeScreenShot(WebDriver driver, String folderName,String subFolder, String fileName) throws IOException {
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./Screenshot/"+folderName+"/"+"/"+subFolder+"_"+dateFormat.format(date)+"/"+fileName+".png"));
	}
	
	public static Properties readProperties(String filePath) {
		Properties properties = new Properties();
        FileInputStream fis = null;

		try
		{
			 fis = new FileInputStream(filePath);
	         properties.load(fis);
		
		}
		catch (IOException e) {
		e.printStackTrace();
        
		}
		return properties;
		
	}
	
}
