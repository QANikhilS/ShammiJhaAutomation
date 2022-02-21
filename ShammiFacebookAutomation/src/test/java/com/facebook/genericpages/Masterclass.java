package com.facebook.genericpages;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Masterclass {
	
	public static WebDriver driver ;
	public static Properties locaterprop;
	public static Properties configprop;
	public static Logger log;

	
	public void  Masterclass2() throws Exception   
	{
		
		// Configure properties file	
	   FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Repository\\configuration.properties");	
	   configprop = new Properties();
	   configprop.load(fis);
	
	   // Configure Locators file	
	   FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir")+"\\Repository\\Locators.properties");	
	   locaterprop = new Properties();
	   locaterprop.load(fis2);
	
	   // configure Log4j properties file.
		log = Logger.getLogger(Masterclass.class);	
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\log4j.properties");
	   
	   
	   //Browser Selection
	   if(configprop.getProperty("browser").equalsIgnoreCase("chrome"))
	   {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\browserdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("Chrome browser is opened");
	   }
	   
	   else if(configprop.getProperty("browser").equalsIgnoreCase("firefox"))
	   {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\browserdrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		log.info("Firefox browser is opened");
	   }
	   
	   else if(configprop.getProperty("browser").equalsIgnoreCase("edge"))
	   {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\browserdrivers\\edgedriver.exe");
		driver = new EdgeDriver();
		log.info("Edge browser is opened");
	   }
	   
	   driver.manage().window().maximize();
	   log.info("Browser is maximized");
	   
	   driver.get(configprop.getProperty("baseURL"));
	   log.info("Instagram is opened. Login page is displayed to user.");
	   
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	
	
	//@AfterClass
	public void teardown() throws Exception
	{
		Thread.sleep(4000);
		driver.quit();
	}
}
