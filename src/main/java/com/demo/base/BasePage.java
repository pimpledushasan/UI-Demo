package com.demo.base;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.demo.utils.Utility;

public class BasePage {
	
  
	public static WebDriver driver = BaseDriver.getDriver();
	protected static Utility utils = new Utility();
	protected final static Logger logger = Logger.getLogger(BasePage.class);

  }

