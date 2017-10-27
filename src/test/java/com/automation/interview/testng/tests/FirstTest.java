package com.automation.interview.testng.tests;

import org.testng.annotations.Test;
import com.automation.interview.testng.pages.*;


public class FirstTest {
	
	HomePage homePage = new HomePage();
	PageOne pageOne = new PageOne();
	PageTwo pageTwo = new PageTwo();
	PageThree pageThree = new PageThree();
	FormPage formPage = new FormPage();
	
	@Test
	public void firstTestMethod(){
			
		homePage.navigateToHomePage();
		homePage.clickOnFirstPaper();
		pageOne.clickOnNext();
		pageTwo.clickOnNext();
		pageThree.clickOnNext();
		formPage.fillOutForm("John Silver", "QA Person", "BioEnergy ", "abc@email.com");
		formPage.clickOnSubmit();
		
		
	}
	
	

}
