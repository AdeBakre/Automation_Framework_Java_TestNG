package com.automation.interview.testng.base;

import org.openqa.selenium.remote.RemoteWebDriver;
import static com.automation.interview.testng.base.BaseDriver.getDriver;

public class BasePage {
	
	
	public static RemoteWebDriver dr = getDriver();
	
	public BasePage(){
		super();
	}
	
}
