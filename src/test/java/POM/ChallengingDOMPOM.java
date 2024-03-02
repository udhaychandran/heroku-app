package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.SetupTeardown;

public class ChallengingDOMPOM extends SetupTeardown{

	@FindBy(how = How.LINK_TEXT,using ="Challenging DOM")
	public WebElement challengingDomLink;
	
	@FindBy(how = How.XPATH,using ="//table//thead//tr//th")
	public  String rowLocator;
	
	@FindBy(how = How.XPATH,using ="//table//tbody//tr//td")
	public WebElement columnLocator;
	
	public ChallengingDOMPOM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void challengeingDOMClick() {
		challengingDomLink.click();
	}
	
	public void rowLocatorCount() {
		driver.findElement(By.xpath(rowLocator));
	}
}
