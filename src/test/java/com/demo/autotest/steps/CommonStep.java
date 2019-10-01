package com.demo.autotest.steps;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.demo.base.BaseDriver;
import com.demo.base.BaseStep;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;

public class CommonStep extends BaseStep{

	
	@Given("^I navigate to wikipedia search page$")
	public void navigateToPage() throws Exception {		
		//String url = utils.getPropertyObject().getProperty("url");		
		driver.get(utils.getPropertyObject().getProperty("url"));
	}

	/**
	 * This method copy screen shot into screeshot folder under project directory. enable it if you needed.
	 * @param scenario
	 */
	//@After
	public void captrueScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			saveFailScreenshotsToFolder(scenario.getName());
		}
	}
	
	/**
	 * This method embeds failure screen shot into the report.
	 * @param scenario
	 */
	@After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	      // Take a screenshot...
	      final byte[] screenshot = ((TakesScreenshot) BaseDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
	      scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
	    }
	}
	
	
}
