package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FormAuth_POM {

	private static WebDriver driver;
	@FindBy(how = How.LINK_TEXT,using="Form Authentication")
	public WebElement formAuthLink;
	
	@FindBy(how = How.XPATH,using="//button[@type='submit']")
	public WebElement loginLocator;
	
	@FindBy(how = How.NAME,using = "username" )
	public WebElement userNameLocator;
	
	@FindBy(how = How.NAME,using = "password" )
	public WebElement passwordLocator;
	
	public FormAuth_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFormAuth() {
		formAuthLink.click();
	}
	
	public void enteruserName(String userName) {
		userNameLocator.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		passwordLocator.sendKeys(password);
	}
	
	public void clickLoginForm() {
		loginLocator.click();
	}
	
}
