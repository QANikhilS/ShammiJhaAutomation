
package com.facebook.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.facebook.genericpages.Masterclass;
import com.facebook.pages.LoginPage;

public class LoginTestCases extends Masterclass{
	
	public LoginTestCases() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void VerifyLogin() throws Exception
	{
		LoginPage.DoLogin();
		
        Assert.assertEquals(configprop.getProperty("nikhilusername"), driver.findElement(By.xpath(locaterprop.getProperty("nikhilusername"))).getText());
        System.out.println("Logged in to user Nikhil Shivarkar.");
    	log.info("User Nikhil Shivarkar is logged in successfully");
	}
	

}
