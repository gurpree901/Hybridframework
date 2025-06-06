package pageobjectclasess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends Basepage {
	
	//constructor
	
	WebDriver driver;
	
	public AccountRegistration(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//input[@id='input-firstname']") WebElement Firstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement Email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement confirmpwd;
	//@FindBy(xpath="//label[normalize-space()='Yes']") WebElement radiobtn;
	@FindBy(xpath="//input[@name='agree']") WebElement Agree;
	@FindBy(xpath="//input[@value='Continue']") WebElement button;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confmsg;
	
	//Action methods
	
	public void setfirstname(String fname)
	{
		Firstname.sendKeys(fname);
	}
	
	public void setlastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void setmail(String mail)
	{
		Email.sendKeys(mail);
	}
	
	public void settelephone(String phone)
	{
		telephone.sendKeys(phone);
	}
	
	public void setpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void setconfrmpwd(String confp)
	{
		confirmpwd.sendKeys(confp);
	}
	
	public void checkagree()
	{
		Agree.click();
	}
	
	public void submitbutton()
	{
		button.click();
	}
	
	public String confirmationmsg()
	{
		try
		{
			return (confmsg.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}

}
