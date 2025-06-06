package Testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import pageobjectclasess.AccountRegistration;
import pageobjectclasess.homepage;

public class TC_AccountRegistrationtest extends BaseClass{
	
	
	@Test(groups={"Regression","Master"}) 	 	
	public void verify_account_registration()
	{
		logger.info("*******starting TC_001 Account Resgistration Test******");
		try {
		homepage hp=new homepage(driver);
		hp.clickmyaccount();
		logger.info("**** click on Registration link*******");
		hp.Clickregister();
		
		AccountRegistration ac=new AccountRegistration(driver);
		logger.info("***** providing coustomer details ******");
		ac.setfirstname(randomString().toUpperCase());
		ac.setlastname(randomString().toUpperCase());
		ac.setmail(randomString()+"@gmail.com");
		ac.settelephone(randomNumber());
		String password=randomAlphanumeric();
		ac.setpassword(password);
		ac.setconfrmpwd(password);
		ac.checkagree();
		ac.submitbutton();
		}
		catch(Exception e)
		{
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		
		logger.info("******* TC_001 Account Registration test finished *****");
		//String confmsg=ac.confirmationmsg();
		//Assert.assertEquals(confmsg, "Your account has beeen created");
		
		
		
	}
		
	

	
	

}
