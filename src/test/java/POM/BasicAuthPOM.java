package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BasicAuthPOM {
	
	private static WebDriver driver;
	@FindBy(how=How.LINK_TEXT,using="Basic Auth")
	public WebElement basicAuthLink;
		
	public BasicAuthPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void basicAuthLink() {
		basicAuthLink.click();
	}
	
}
