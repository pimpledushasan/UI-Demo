package com.demo.common;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.base.BaseDriver;

public class BaseHandler {
	
    private static final Logger logger = LoggerFactory.getLogger(BaseHandler.class.getName());

    public static JavascriptExecutor js;
    public static final int numberOfTries = 2;
	
    public static boolean IsElementPresentByCSS(String css) {
	    try {
	        BaseDriver.getDriver().findElement(By.cssSelector(css));
	        return true;
	    } catch (NoSuchElementException nex) {
	        return false;
	    }
    }
}