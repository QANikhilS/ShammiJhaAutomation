package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.facebook.genericpages.Masterclass;

public class HomePage extends Masterclass {

	public HomePage() throws Exception {
		super();
	}
	
	
	
	public void searchVanita() throws Exception 
	{	
	   // driver.findElement(By.xpath(locaterprop.getProperty("HomePageSearchBox"))).click();
		driver.findElement(By.xpath(locaterprop.getProperty("HomePageSearchBox"))).sendKeys(configprop.getProperty("vusername"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(locaterprop.getProperty("HomePageSearchBox"))).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(locaterprop.getProperty("HomePageSearchBox"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	
	public static void logout() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath(locaterprop.getProperty("Profilebutton"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(locaterprop.getProperty("Logoutbutton"))).click();		
	}


	public static void homeTOdm() throws Exception
	{
		
	    Thread.sleep(3000);
        driver.findElement(By.xpath(locaterprop.getProperty("dmbutton"))).click();
        Thread.sleep(2000);
        logout();
	}
	
}
