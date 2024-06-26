package helper;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import POM.BrokenImagePOM;
import utilities.Functions;
import utilities.SetupTeardown;

public class BrokenImage extends SetupTeardown {
	
	BrokenImagePOM brokenImagePOM;
	private int invalidImgCount =0;
	String fileName = "./src/test/java/resources/basicInfo.properties";
	Properties prop = Functions.readProperties(fileName);
	
	@Test(priority =0)
	public void findBrokenImages() throws InterruptedException, ClientProtocolException, IOException {
		
		driver.get(prop.getProperty("url"));
		brokenImagePOM = new BrokenImagePOM(driver);
		brokenImagePOM.brokenImageLink();
		Thread.sleep(3000);
		List<WebElement> totalImg = driver.findElements(By.tagName("img"));
		//System.out.print(totalImg.size());
		
		for (WebElement total: totalImg)
		{
			if (total!=null)
			{
				countInActiveImage(total);
			}
		}
		System.out.println("Total broken images is: "+invalidImgCount);
		extentTest.pass("FindBrokenImg method is passed");
	}
	
	public void countInActiveImage(WebElement imgElement) throws ClientProtocolException, IOException  {
		
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(imgElement.getAttribute("src"));
		HttpResponse response = httpClient.execute(request);
		if (response.getStatusLine().getStatusCode()!=200)
		{
			invalidImgCount++;
		}
		
		
	}
}
