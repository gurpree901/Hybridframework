package pageobjectclasess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage {
    
	//constructor
	public Loginpage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement button;
	
	//Action methods
	public void setmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void setpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clicklogin()
	{
		button.click();
	}

}
