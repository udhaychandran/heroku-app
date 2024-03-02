package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.SetupTeardown;

public class ContextMenuPOM extends SetupTeardown{

	@FindBy(how = How.LINK_TEXT,using="Context Menu")
	public WebElement contextMenuLink;
	
	@FindBy(how = How.XPATH,using="//div[@id='hot-spot']")
	public String moveToBoxLoc;
	
	public ContextMenuPOM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void contextMenuLinkClick() {
		contextMenuLink.click();
	}
	
	public String moveToBox() {
		return moveToBoxLoc;
	}
	
}
