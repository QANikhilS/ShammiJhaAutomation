package com.facebook.pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.facebook.genericpages.Masterclass;

public class LoginPage extends Masterclass{

	public LoginPage() throws Exception {}


	public static void enterusername()    // Method to enter username
	{
		driver.findElement(By.xpath(locaterprop.getProperty("username"))).sendKeys(configprop.getProperty("loginusername"));	
	}
	
	
	public static void enterpassword()     // Method to enter password
	{
		driver.findElement(By.xpath(locaterprop.getProperty("password"))).sendKeys(configprop.getProperty("loginpassword"));
	}
	
	
	public static void clickonSubmitButton()   //method to click on loginbutton.
	{
		driver.findElement(By.xpath(locaterprop.getProperty("login"))).click();
	}
	
	public static void SaveLoginInfor_NOTNOW()
	{
		driver.findElement(By.xpath(locaterprop.getProperty("SaveLoginInfo"))).click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void turnOnNotification_NOTNOW() 
	{
		driver.findElement(By.xpath(locaterprop.getProperty("TurnOnNotification"))).click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public static void DoLogin() throws Exception
	{
		enterusername();
        log.info("User entered username as - "+"'"+configprop.getProperty("loginusername")+"'");
		
		enterpassword();
		log.info("User entered password");
		
		clickonSubmitButton();
		log.info("User clicked on submit button to login");
	
		Thread.sleep(1000);
		SaveLoginInfor_NOTNOW();
		Thread.sleep(1000);
		turnOnNotification_NOTNOW(); 
		Thread.sleep(1000);
	}

}
