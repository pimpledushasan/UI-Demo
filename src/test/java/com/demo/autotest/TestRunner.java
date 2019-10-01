package com.demo.autotest;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.demo.base.BaseDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features="src/test/resources/features",
		glue="com.demo.autotest.steps",
		tags = {"@wiki"},
		plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"}					
	)

public class TestRunner 
{

	public static RemoteWebDriver dr = BaseDriver.getDriver(); 


	/**
	 * Thie method quits webdriver.
	 */
   @AfterClass
    public static void tearDown()
    {
        try{
             if(dr != null) {
                 dr.close();
             }
         }
         catch(Exception ex){
                 ex.printStackTrace();
         }
         finally {
             dr.quit();
         }
    }
}


