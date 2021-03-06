package com.demo.common;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.demo.base.BaseDriver;


public class ActionHandler extends EventFiringWebDriver {

	
	static RemoteWebDriver driver = BaseDriver.getDriver();
	
	public ActionHandler(){
		super(driver);
	}
	
	
	/**
	 * This method waits until the page is loaded.
	 */
	public static void waitForPageLoad()
	{
		boolean pageLoaded = false;
		while(!pageLoaded) {
			pageLoaded = ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
		}
	}
	
    /**
     * Finds an input element containing the specified text using either
     * name or id attribute value.
     * @param text
     * @return
     */
	protected WebElement inputField(String text){
		try{
			return driver.findElement(By.xpath("//input[contains(@name,'"+text+"']"));
		}catch(java.util.NoSuchElementException err){
			WebElement tagName = driver.findElement(By.tagName("input"));
			
			if(tagName.getAttribute("id").contains(text)){
				return tagName;
				}else{
					throw err;
			
			}
		}
	}
	
    /**
     * Acts as a place holder for entering value into an input element
     * @param input
     * @return
     */
	protected static WebElement inTo(WebElement input){
		return input;
	}
	
    /**
     * Types a text value into an input field.
     * Note: to ensure transparency, initial value is cleared.
     * @param value
     * @param input
     */
    public static void inputText(String value, WebElement input) {
    	
    	if(input.getText()!=null){
    		input.clear();
    	}     
        inTo(input).sendKeys(value);
    }
         
    
    public static void mouseHoverItem(WebElement element){
    
	        Actions mouseOver = new Actions(BaseDriver.getDriver());
	        mouseOver.moveToElement(element).perform();
    }
    
    public static void click(final WebElement element) {
        waitUntilVisibilityOfElement(element).click();
    }
    
  
    
   
   private static Wait<RemoteWebDriver> fluentWait() {
       return new FluentWait<>(driver)
               .withTimeout(15, TimeUnit.SECONDS)
               .pollingEvery(1, TimeUnit.SECONDS)
               .ignoring(NoSuchElementException.class)
               .ignoring(StaleElementReferenceException.class);            
   }
   

   private static WebElement waitUntilVisibilityOfElement(final WebElement element) {
       return fluentWait().until(ExpectedConditions.elementToBeClickable(element));
   }

   /**
    * Avvoid to use this wait. only use if required.
    * @param seconds
    */
	public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	
	/**
	 * Get dropdown vale
	 * @param element
	 * @return
	 */
	public static String getDropDownValue(WebElement element)
	{
	
		Select dropdown = null;
		String value = null;

		dropdown = new Select(element);
		
		try{
			value = dropdown.getFirstSelectedOption().getAttribute("value");		
			String val = dropdown.getFirstSelectedOption().getText();

		}
		catch (WebDriverException ee)
		{
			value = dropdown.getFirstSelectedOption().getAttribute("value");
		}
		catch (NullPointerException ee)
		{
			Assert.fail();
		}
		return value;

	}


}





