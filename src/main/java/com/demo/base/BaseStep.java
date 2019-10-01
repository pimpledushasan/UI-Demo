package com.demo.base;


import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.demo.pages.SearchPage;
import com.demo.pages.SearchResultPage;
import com.demo.utils.Utility;


public class BaseStep 
{

	protected static Utility utils = new Utility();
	protected static BasePage basePage=new BasePage();;
	protected static SearchPage searchPage = new SearchPage();
	protected static SearchResultPage searchResultPage = new SearchResultPage();	
	
	protected static Properties propObj = utils.getPropertyObject();
	protected static WebDriver driver;

	/**
	 * No Argument Constructor
	 */
	public BaseStep(){
			driver = BaseDriver.getDriver();
        	initializePageFactory();
	} 
	
	/**
	 * Initializing page objects
	 */
	public void initializePageFactory()
	{
		searchPage = PageFactory.initElements(driver, SearchPage.class);
		searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
	}
	
	/**
	 * this method takes the screenshot and stror in the folder
	 * @param name
	 * @return
	 */
    public File saveFailScreenshotsToFolder(String name)

    {
    	
    	String folderDestination = utils.createTestFolder(System.getProperty("user.dir")+"/screenshots/"+utils.getTodayDate());
    	String imagePath = "/"+name+".png";
    
    	File destination = null;
		try{
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			destination = new File(folderDestination+imagePath);
			FileUtils.copyFile(source, destination);   
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		return destination;
    }
    
    

}
