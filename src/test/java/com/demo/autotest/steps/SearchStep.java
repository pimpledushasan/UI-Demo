package com.demo.autotest.steps;


import com.demo.base.BaseStep;
import com.demo.common.AssertHandler;
import com.demo.common.ActionHandler;

import cucumber.api.java.en.When;

public class SearchStep extends BaseStep{


	@When("^I verify the default language selected is \"(.*)\"$")
	public void iVerifyLanguageSelected(String lang){
	 
	  String langSelected = ActionHandler.getDropDownValue(searchPage.languageSelectFiled);
	  AssertHandler.assertResultTrue(langSelected.equalsIgnoreCase(lang), "Language not selected by Default - "+lang);
	}
	

	@When("^I enter \"(.*)\" in search field$")
	public void iEnterSearchTitle(String searchTitle){
		ActionHandler.inputText(searchTitle, searchPage.searchField);		
	}
	
	@When("^I click on \"(.*)\" button$")
	public void clickON(String button){
		ActionHandler.click(searchPage.searchButton);
	}
	
}
