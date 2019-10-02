package com.demo.autotest.steps;


import org.openqa.selenium.WebElement;

import com.demo.base.BaseStep;
import com.demo.common.ActionHandler;
import com.demo.common.AssertHandler;
import com.demo.pages.SearchResultPage;

import cucumber.api.java.en.When;
import junit.framework.Assert;

public class SearchResultStep extends BaseStep{
	
	
	@When("^I verify the title \"(.*)\" on result page$")
	public void iVerifyTheTitle(String title)
	{
		ActionHandler.waitForPageLoad();
		AssertHandler.assertResultTrue(searchResultPage.firstHeading.getText().equalsIgnoreCase(title), "Title not matching");	  
	}
	
	@When("^I see the \"(.*)\" link on result page$")
	public void iSeeTheLink(String link){

		ActionHandler.waitForPageLoad();
		String language = utils.languageMap.get(link);		
	    WebElement el = SearchResultPage.langugeWebelementList.stream()
		.filter(web -> web.getText().equals(language))
		.findAny()
		.get();
	    	    
	    AssertHandler.assertResultTrue(el != null, "Link not Found for country -"+link);
	    
	}
	
	
	
	@When("^I click on \"(.*)\" link$")
	public void iClickOtherLink(String link){
		
		ActionHandler.waitForPageLoad();
		
		String language = utils.languageMap.get(link);
	    WebElement el = SearchResultPage.langugeWebelementList.stream()
		.filter(web -> web.getText().equals(language))
		.findAny()
		.get();
	    
		if(el != null)
		{
			el.click();
		}
		else {
			Assert.fail("Could not click on link -"+language);
		}

	}
	
	
}
