package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPOM {

	private static WebDriver driver;
	
	@FindBy(how = How.LINK_TEXT, using ="Checkboxes")
	public WebElement checkBoxesLink;
	
	@FindBy(how = How.XPATH, using ="//input[@type='checkbox'][1]")
	public WebElement checkBoxOne;
	
	@FindBy(how = How.XPATH, using ="//input[@type='checkbox'][2]")
	public WebElement checkBoxTwo;
	
	public CheckboxesPOM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickCheckBoxLink() {
		checkBoxesLink.click();
	}
	
	public void clickCheckBoxOne() {
		checkBoxOne.click();
	}
	
	public void clickCheckBoxTwo() {
		checkBoxTwo.click();
	}
}
