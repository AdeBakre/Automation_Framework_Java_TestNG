package com.automation.interview.testng.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;

public class BaseDriver extends EventFiringWebDriver{
	
	
	private static String driverPath = "src/main/resources/_drivers/";
	private static RemoteWebDriver _driver;
	private static DesiredCapabilities _capabilities;
	private static DriverService _service;
	private static String chrome = "chromedriver";
	private static String firefox = "geckodriver";
	private static String driverClass = System.getProperty("driverClass");
	
	public static final String browser = "firefox";
	
	static{
		switch(browser.toLowerCase()){
		case "chrome":
			setWebDrivertoChrome();
			break;
		case "firefox":
			setWebDriverToFirefox();
			break;
		default:
			setWebDrivertoChrome();
		}
		
	}
	
	@AfterTest
	public void tearDown(){
		
	  	   try{
	  		   
		        if(_driver != null) {
		        
		            _driver.close();
	   		}}
	   		catch(Exception ex){
	   			ex.printStackTrace();
	   		}
	   		finally {
				_driver.quit();
			}
	}
	
	public static void setWebDriverToFirefox(){
		
		System.setProperty("webdriver.gecko.driver", driverPath+firefox);
		_capabilities = DesiredCapabilities.firefox();
		_capabilities.setCapability("marionette", true);
		_driver = new FirefoxDriver();
	}
	
	public static void setWebDrivertoChrome(){
		
		System.setProperty("webdriver.chrome.driver", driverPath+chrome);
		_service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(driverPath+chrome))
				.usingAnyFreePort().build();
		try{
			_service.start();
		}
		catch(IOException err){
			throw new IllegalStateException(err.getMessage());
		}
		
		_capabilities = DesiredCapabilities.chrome();
		_driver = new RemoteWebDriver(_service.getUrl(),_capabilities);
		
	}
	
	public BaseDriver(){
		super(getDriver());
		manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	}
	
    public static RemoteWebDriver getDriver() {
        if ((_driver == null) && (!"noBrowser".equals(driverClass))) {
            throw new IllegalStateException("Selenium client is not initialised.");
        }
       
        _driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       _driver.manage().window().maximize();
        return _driver;
    }
	

}
