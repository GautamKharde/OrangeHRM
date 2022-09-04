package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class PIMAddEmpPage extends TestBase {
	
	//Page Objects or Objects Repository
	@FindBy(xpath = "//h6[text()='Add Employee']")
	WebElement addEmployeeLabel;
	
	@FindBy(xpath = "//a[text()='Add Employee']")
	WebElement AddEmployeeLink;
	
	
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='middleName']")
	WebElement middleName;
	
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//button[text()=' Cancel ']")
	WebElement cancleButton;
	
	
	//Initilization
	
	public PIMAddEmpPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean VerifyaAddEmployeeLabel() {
		return addEmployeeLabel.isDisplayed();
	}
	
	public void VefiryAddEmployee(String ftName,  String mlName, String ltName) {
		firstName.sendKeys(ftName);
		middleName.sendKeys(mlName);
		lastName.sendKeys(ltName);
		submitButton.click();
		
	}
	
	
	
	

}
