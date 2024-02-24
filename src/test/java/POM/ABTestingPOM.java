package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ABTestingPOM {
	
	private static WebDriver driver;
	@FindBy(how=How.LINK_TEXT,using="A/B Testing")
	public WebElement abTesting;
	
	@FindBy(how=How.LINK_TEXT,using="Elemental Selenium")
	public WebElement elementSeleniumLink;
		
	public ABTestingPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void abTesting() {
		abTesting.click();
	}
	
	public void elementSeleniumLink() {
		elementSeleniumLink.click();
	}
}
