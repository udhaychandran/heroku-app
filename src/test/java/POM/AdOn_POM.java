package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdOn_POM {

	private static WebDriver driver;
	
	@FindBy(how =How.XPATH, using="//div[@class='modal-foote']//p[text()='Close']")
	public WebElement closeButton;
	
	public AdOn_POM(WebDriver driver) {
		this.driver = driver;
	}
	
	public void closeButtonClick() {
		closeButton.click();
	}
}
