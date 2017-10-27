package com.automation.interview.testng.base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static com.automation.interview.testng.base.BaseDriver.getDriver;

import java.util.concurrent.TimeUnit;

public class BaseHelper extends EventFiringWebDriver{
	
	static BaseUtility baseUtility = new BaseUtility();
	RemoteWebDriver driver = getDriver();
	
	public BaseHelper(){
		super(getDriver());
	}
	
	protected static WebElement inTo(WebElement input){
		return input;
	}
	
    public static void inputText(String value, WebElement input) {
    	
    	if(input.getText()!=null){
    		input.clear();
    	}     
        inTo(input).sendKeys(value);
    }
    
    public static void clickEnter (WebElement element){
    	
    	element.sendKeys(Keys.ENTER);
    }
    
    private static Wait<RemoteWebDriver> fluentWait() {
        return new FluentWait<>(getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);            
    }
    
    private static WebElement waitUntilVisibilityOfElement(final WebElement element) {
        return fluentWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public static void click(final WebElement element) {
        waitUntilVisibilityOfElement(element).click();
    }
    
    

}
