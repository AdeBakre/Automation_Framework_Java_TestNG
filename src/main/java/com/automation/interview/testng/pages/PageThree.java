package com.automation.interview.testng.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.interview.testng.base.BaseHelper;
import com.automation.interview.testng.base.BasePage;
import com.automation.interview.testng.base.BaseUtility;

public class PageThree extends BasePage{
	
	BaseUtility baseUtility = new BaseUtility();
	
	public PageThree(){
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css=".arrow.arrow-right")
	private WebElement nextPageButton;
	
	public void clickOnNext(){

		BaseHelper.click(nextPageButton);

	}
}
