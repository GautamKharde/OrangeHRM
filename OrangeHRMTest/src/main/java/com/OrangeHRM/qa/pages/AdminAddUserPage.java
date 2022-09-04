package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class AdminAddUserPage extends TestBase{
	
	@FindBy(xpath = "//div//h6[text()='Add User']")
	WebElement AddUserLabel;
	
	
	
	public AdminAddUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyAddUserLabel() {
		return AddUserLabel.isDisplayed();
	}
}
