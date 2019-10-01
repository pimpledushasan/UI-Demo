package com.demo.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.base.BaseDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;




public class AssertHandler extends BaseHandler
{
	

	private static final Logger logger = LoggerFactory.getLogger(AssertHandler.class.getName());
	
	
	public static void assertResultTrue(boolean result, String message)
	{
		assertTrue(message, result);
	}
	
}
