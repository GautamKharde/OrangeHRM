package com.OrangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.pages.AdminAddUserPage;
import com.OrangeHRM.qa.pages.AdminPage;
import com.OrangeHRM.qa.pages.HomePage;
import com.OrangeHRM.qa.pages.LoginPage;

public class AdminPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
	AdminAddUserPage adminAddUserPage;
	
	public AdminPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		initilization();
		loginPage = new LoginPage();
		adminPage = new AdminPage();
		adminAddUserPage = new AdminAddUserPage();
		homePage = loginPage.validateLogin(prope.getProperty("Username"), prope.getProperty("Password"));
		adminPage = homePage.clickonAdminLink();
	}
	
	
	@Test(priority = 1)
	public void verifyAdmipagenLabelTest() {
		boolean flag =adminPage.verifyAdminLabel();
		Assert.assertTrue(flag, "Admin Page label is missing on page");
	}
	
	
	
	@Test(priority = 2)
	public void vefiryAddUser() {
		adminAddUserPage =adminPage.vefiryAddUser();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
