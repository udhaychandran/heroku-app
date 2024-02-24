package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddElementPOM {
	
	private static WebDriver driver;
	
	@FindBy(how =How.LINK_TEXT,using ="Add/Remove Elements")
	public WebElement addDeleteElementLink;
	
	@FindBy(how = How.XPATH,using ="//button[text()='Add Element']")
	public WebElement addElement;
	
	@FindBy(how = How.XPATH,using ="//button[text()='Delete']")
	public WebElement deleteElement;
	
	public AddElementPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addDeleteElementLink() {
		addDeleteElementLink.click();
	}
	public void addElement() {
		addElement.click();
	}
	
	public void deleteElement() {
		deleteElement.click();
	}
	
}
