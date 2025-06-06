package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import pageobjectclasess.Loginpage;
import pageobjectclasess.Myaccount;
import pageobjectclasess.homepage;

public class TC_002LoginTest extends BaseClass{
	@Test(groups="sanity")
	public void testlogin()
	{
		logger.info("*******Starting TC_002_login Test********");
		//homepage
		try
		{
			homepage hp=new homepage(driver);
			hp.clickmyaccount();
			hp.clicklogin();
			
			//loginpage
			Loginpage lp=new Loginpage(driver);
			lp.setmail(p.getProperty("Email"));
			lp.setpassword(p.getProperty("password"));
			lp.clicklogin();
			
			//myaccount
			Myaccount macc=new Myaccount(driver);
		    boolean target_page=macc.ismyaccountexist();
		    Assert.assertEquals(target_page, true,"Login failed");

		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	    logger.info("******Finished TC_002 login Test *****");

		
		
	    
		
		
	}
	

}

