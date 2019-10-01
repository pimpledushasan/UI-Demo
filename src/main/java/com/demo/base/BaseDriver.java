package com.demo.base;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseDriver extends EventFiringWebDriver {	
	private static String directory = System.getProperty("user.dir");
	private static String driverPath = directory+"/_drivers/";
	private static RemoteWebDriver _driver;
	private static DesiredCapabilities _capabilities;
	private static DriverService _service;
	
	private static String chrome = "chromedriver";
	private static String firefox = "geckodriver";
    
    //static Utility baseUtility = new Utility();  
    //static Properties prop = baseUtility.getPropertyObject();
	/*
    private static String platform = prop.getProperty("platform");
    public static final String browser = prop.getProperty ("browser");
    private static String incognito = prop.getProperty("incognito");
    public static final String URL = prop.getProperty("browserStack_URL");
    */
	public static int WAIT_IN_SEC = 5;
	private static  WebDriverWait wait =null;
	
	public static final String browser = "chrome";
    	static
    	{
			switch (browser.toLowerCase()){
				case "chrome":
					setWebDriverToChrome();
					break;
				case "firefox":
					setWebDriverToFirefox();
					break;		
			}
    	}
    	
    	 public static void setWebDriverToFirefox()
    	 {
              //add code here
    	 }                
              
    	public static void setWebDriverToChrome()
    	{
    		_driver = (RemoteWebDriver)createChromeDriver(); 
    	}  
		   
	   	  
	   public BaseDriver() {
	    	super(getDriver());
		    //super(_driver);
	        _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        _driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	    }	


	   	
	    public static RemoteWebDriver getDriver() 
	    {
	        return _driver;
	    }
	    
		private static WebDriver createChromeDriver() {
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		}
		
		
	    // VISIBILITY WAITS
	    public static WebElement waitForElement(By locator) {
		    return waitForElementToBeVisible(locator);
	    }
	   


	    public static WebElement waitForElementToBeVisible(By locator) {
		    
		return  getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));

	    }

	    
		public static WebDriverWait getWait(){
	
			if(wait==null || WAIT_IN_SEC==5){
					wait = new WebDriverWait(getDriver(), WAIT_IN_SEC);
			}
			return wait;
		}

		public static void setWait(int waitTimeInSec){
			WAIT_IN_SEC = waitTimeInSec;
			wait = new WebDriverWait(getDriver(), WAIT_IN_SEC);
			
		}
	    
    }


