package pageobjectclasess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccount extends Basepage{
    //constructor
	public Myaccount(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement myaccount;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logout;
	
	//Action methods
	
	public boolean ismyaccountexist()
	{ 
		try {
			
			return(myaccount.isDisplayed());

		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public void clicklogout()
	{
		logout.click();
	}
		
		
		
		
	

}
