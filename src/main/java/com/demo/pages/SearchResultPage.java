package com.demo.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.base.BasePage;

public class SearchResultPage extends BasePage{
	
	@FindBy(css="h1.firstHeading")
	public static WebElement firstHeading;
	
	@FindBy(tagName="a")
	public static List<WebElement> langugeWebelementList;
	
	
}
