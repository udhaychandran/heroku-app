package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BrokenImagePOM {

	private static WebDriver driver;
	
	@FindBy(how = How.LINK_TEXT,using = "Broken Images")
	public WebElement brokenImageLink;
	
	public BrokenImagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void brokenImageLink() {
		brokenImageLink.click();
	}
	
}
