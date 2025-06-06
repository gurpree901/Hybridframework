package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.Dataproviders;
import basepackage.BaseClass;
import pageobjectclasess.Loginpage;
import pageobjectclasess.Myaccount;
import pageobjectclasess.homepage;

public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider="logindata",dataProviderClass=Dataproviders.class,groups="datadriven")
    public void test_login_DDT(String email,String pwd,String exp) {
    	
        // Homepage actions
    	logger.info("*******Login_DDT_Test started*******");
    	try {
        homepage hp = new homepage(driver);
        hp.clickmyaccount();
        hp.clicklogin();

        // Login page actions
        Loginpage lp = new Loginpage(driver);
        lp.setmail(email);      // assuming 'prop' is the Properties object
        lp.setpassword(pwd);
        lp.clicklogin();

        // My Account page validation
        Myaccount macc = new Myaccount(driver);
        boolean target_page = macc.ismyaccountexist();
        Assert.assertEquals(target_page, true, "Login failed");
        
        if(exp.equalsIgnoreCase("valid"))
        {
        	if(target_page==true)
        	{
        		Assert.assertTrue(true);
        		macc.clicklogout();
        	}
        	else
        	{
        		Assert.assertTrue(false);
        	}
        }
        
        if(exp.equalsIgnoreCase("invalid"))
        {
        	if(target_page==true)
        	{
        		macc.clicklogout();
        		Assert.assertTrue(false);
        	}
        	else
        	{
        		Assert.assertTrue(true);
        	}
        }
    	}
    	catch(Exception e)
    	{
    		Assert.fail();
    	}
        logger.info("********login_DDT_Test Finished********");
    }
}
