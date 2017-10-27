package com.automation.interview.testng.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.interview.testng.base.BaseHelper;
import com.automation.interview.testng.base.BasePage;
import com.automation.interview.testng.base.BaseUtility;

public class FormPage extends BasePage{

	BaseUtility baseUtility = new BaseUtility();
	
	public FormPage(){
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="Name")
	private WebElement nameField;
	
	@FindBy(id="JobTitle")
	private WebElement jobTitleField;
	
	@FindBy(id="Company")
	private WebElement companyField;
	
	@FindBy(id="Email")
	private WebElement emailField;
	
	@FindBy(xpath="html/body/div[1]/div/main/div/section/div[1]/div/form/fieldset[1]/div[6]/button")
	private WebElement submitButton;
	
	public void fillOutForm(String name, String jobTitle, String company, String email){
		
		BaseHelper.inputText(name, nameField);
		BaseHelper.inputText(jobTitle, jobTitleField);
		BaseHelper.inputText(company, companyField);
		BaseHelper.inputText(email, emailField);
	}
	
	public void clickOnSubmit(){
		
		BaseHelper.click(submitButton);
	}
}
