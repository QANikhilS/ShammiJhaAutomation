package com.facebook.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.facebook.pages.HomePage;

public class HomePageTestCases extends HomePage {

	public HomePageTestCases() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//@Test()
	public void searchUser() throws Exception 
	{
		searchVanita();
		Thread.sleep(3000);
		String expectedProfile = configprop.getProperty("vapage");
		String ActualUsernameOnProfilePage = driver.getCurrentUrl();
		if (ActualUsernameOnProfilePage.equalsIgnoreCase(expectedProfile)) {
			System.out.println(" User " + expectedProfile + " has found ");
		} else {
			System.out.println(" Invalid user " + ActualUsernameOnProfilePage);
		}        
	}

	//@Test()
	public void verifyLogout() throws Exception 
	{	
		homeTOdm();
		boolean sendmessage = driver.findElement(By.xpath("sendmessagebuttonfromDMpage")).isDisplayed();
		if (sendmessage == true) {
			System.out.println("Navigated to DirectMessage page successfully.");
		} else {
			System.out.println(" FAILED to navigate to Direct Inbox page. ");
		}
		logout();
	}

	
	@Test()
	public void verifyHomepageTOdmPage() throws Exception
	{
		homeTOdm();
		Thread.sleep(5000);
		if (driver.findElement(By.linkText("Forgot password?")).isDisplayed()) {
			System.out.println("User Logged out successfully");
		} else {
			System.out.println("Log out operation is failed. User has not logged out from the application.");
		}
	}

}
