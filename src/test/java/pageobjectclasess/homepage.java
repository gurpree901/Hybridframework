package pageobjectclasess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homepage extends Basepage {
	
	WebDriver driver;
	//constructor
	public homepage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkMyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkregister;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement lnklogin;
	
	//Action methods
	
	public void clickmyaccount()
	{
		lnkMyaccount.click();
	}
	
	public void Clickregister()
	{
		lnkregister.click();
	}
	
	public void clicklogin()
	{
		lnklogin.click();
	}

}
