package com.OrangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.pages.HomePage;
import com.OrangeHRM.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initilization();
		loginPage = new LoginPage();
	}
	
	
	@Test(priority = 1)
	public void loinPageTitleTest() {
		String actualTitle =loginPage.validateLoginPageTitle();
		String expectedTitle = "OrangeHRM";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 2, enabled = false)
	public void OrangeHRMImageTest() {
		boolean flag =loginPage.validateOrangeHRMImg();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		homePage =loginPage.validateLogin(prope.getProperty("Username"), prope.getProperty("Password"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
