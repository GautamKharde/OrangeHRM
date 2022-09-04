package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory or Object Repository
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	WebElement forgetPasswordLink;

	@FindBy(xpath = "//img[@alt='company-branding']")
	WebElement companyLogoImg;
	
	
	
	//Initializing the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateOrangeHRMImg() {
		return companyLogoImg.isDisplayed();
	}
	
	public HomePage validateLogin(String UserName, String Password) {
		username.sendKeys(UserName);
		password.sendKeys(Password);
		loginButton.click();
		
		return new HomePage();
	}
	
	
	
}
