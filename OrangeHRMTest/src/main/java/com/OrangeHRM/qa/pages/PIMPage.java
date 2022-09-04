package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class PIMPage extends TestBase{
	
	
	//Page Objects or objects repository
	@FindBy(xpath = "//h6[text()='PIM']")
	WebElement PIMPageLabel;
	
	
	@FindBy(xpath = "//a[text()='Add Employee']")
	WebElement AddEmployeePageLink;
	
	
	
	//Initilization
	public PIMPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean VerifyPIMPageLabel() {
		return PIMPageLabel.isDisplayed();
	}
	
	public PIMAddEmpPage VerifyAddEmployeePageLink() {
		AddEmployeePageLink.click();
		return new PIMAddEmpPage();
	}
	
	

}
