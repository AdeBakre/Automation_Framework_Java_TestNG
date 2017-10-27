package com.automation.interview.testng.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.interview.testng.base.BaseHelper;
import com.automation.interview.testng.base.BasePage;
import com.automation.interview.testng.base.BaseUtility;

public class PageOne extends BasePage{
	
	BaseUtility baseUtility = new BaseUtility();
	
	public PageOne(){
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css=".icon-wrapper")
	private WebElement nextButton;
	
	private String getPageTitle(){
		
		return dr.getTitle();	
	}
	
	
	public void clickOnNext(){
		
		System.out.println("Page One title is:"+getPageTitle());
		BaseHelper.click(nextButton);
	}
	
	

}
