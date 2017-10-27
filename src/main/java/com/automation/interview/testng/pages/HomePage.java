package com.automation.interview.testng.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.interview.testng.base.BaseHelper;
import com.automation.interview.testng.base.BasePage;
import com.automation.interview.testng.base.BaseUtility;

public class HomePage extends BasePage {
	
	
	public HomePage(){
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css=".Tiles>li:first-child")
	private WebElement firstWhitePaper;
	
	public void navigateToHomePage(){
		dr.get("http://www.thebioagency.com/news-and-views/white-papers/");
	}
	
	public void clickOnFirstPaper(){
		
		BaseHelper.click(firstWhitePaper);
	}
}
