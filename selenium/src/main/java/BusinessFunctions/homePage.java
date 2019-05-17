package BusinessFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import common.common;

public class homePage {

	common browser;
	
	//constructor with one argument
	
	public homePage(common br)
	{
		browser=br;
	}
	
	//initializing and assigning of property file
	
	File file=new File("D:\\Mahesh\\selenium\\src\\main\\java\\ElementLocators\\homePage.properties");
	Properties prop=new Properties();
	
	//setup for properties file
	
	public void setupProperties() throws Exception {
		prop.load(new FileInputStream(file));
	}
	
	//login to application
	
	public void loginToApp(String username,String password)
	{
		browser.startchrome(prop.getProperty("\\selenium\\src\\main\\java\\ElementLocators\\homePage.properties"));
	}
}
