package com.OrangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.pages.AdminPage;
import com.OrangeHRM.qa.pages.HomePage;
import com.OrangeHRM.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initilization();
		loginPage = new LoginPage();
		adminPage = new AdminPage();
		homePage = loginPage.validateLogin(prope.getProperty("Username"), prope.getProperty("Password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String actualTitle =homePage.verifyHomePageTitle();
		String expectedTitle = "OrangeHRM";
		Assert.assertEquals(actualTitle, expectedTitle, "Home Page title not matched");
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest() {
		boolean flag =homePage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void verifyAdimLinkTest() {
		adminPage =homePage.clickonAdminLink();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
