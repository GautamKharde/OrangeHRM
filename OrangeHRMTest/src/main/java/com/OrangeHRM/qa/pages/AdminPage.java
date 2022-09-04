package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class AdminPage extends TestBase{
	
	//page objects or object repository
	
	@FindBy(xpath = "//span//h6[text()='Admin']")
	WebElement adminPagelbel;
	
	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement AddButton;
	
	//Initilization the page objects
	
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyAdminLabel() {
		return adminPagelbel.isDisplayed();
	}
	
	public AdminAddUserPage vefiryAddUser() {
		AddButton.click();
		
		return new AdminAddUserPage();
	}
}
