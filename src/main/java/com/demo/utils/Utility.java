package com.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.demo.constant.Constants;

public class Utility {

	private Properties prop = null;
	InputStream input = null;
	public static Map <String, String> languageMap = new HashMap<String, String>();

   static {
       populateLanguageMaop();
   }

	
	public Properties getPropertyObject() {
		if (null == prop) {
			return loadProperties(Constants.CONFIG_FILE);
		}
		return prop;
	}
	

	public Properties loadProperties(String filename) {
		prop = new Properties();
		
		try {
			FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/resources/"+filename);
			prop.load(inputStream);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException io) {
			System.out.println("IO Exception.....");
			io.printStackTrace();
		}

		return prop;
	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	/**
	 * 
	 * @param pathName
	 * @return destination
	 */
	public String createTestFolder(String pathName) {
		String destination = null;
		File files = new File(pathName);
		if (!files.exists()) {
			files.mkdirs();
		}
		destination = files.getPath();
		return destination;
	}

	/**
	 * @param
	 * @return dateText
	 */

	public String getTodayDate() {
		String dateText = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		dateText = formater.format(calendar.getTime());
		return dateText;
	}
	
	/**
	 * This method creates map of country code and language
	 */
	 
	public static void populateLanguageMaop(){
		languageMap.put("de", "Deutsch");
		languageMap.put("en", "English");
		languageMap.put("nl", "Nederlands");
		
	}
	
	public static void main(String a[])
	{
		new Utility().getPropertyObject();
	}

}
