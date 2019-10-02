package com.demo.common;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class AssertHandler extends BaseHandler
{
	

	private static final Logger logger = LoggerFactory.getLogger(AssertHandler.class.getName());
	
	
	public static void assertResultTrue(boolean result, String message)
	{
		assertTrue(message, result);
	}
	
}
