package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.base.BasePage;

public class SearchPage extends BasePage{
	
	@FindBy(css="input#searchInput")
	public static WebElement searchField;
	
	@FindBy(css="select#searchLanguage")
	public static WebElement languageSelectFiled;
	
	@FindBy(css="i.sprite.svg-search-icon")
	public static WebElement searchButton;
	

	@FindBy(css="h1.firstHeading")
	public static WebElement firstHeading;
	
}
