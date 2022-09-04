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

public class AdminAddUserPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
	AdminAddUserPage adminAddUserPage;
	
	public AdminAddUserPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		initilization();
		loginPage = new LoginPage();
		adminPage = new AdminPage();
		//adminAddUserPage = new AdminAddUserPage();
		homePage = loginPage.validateLogin(prope.getProperty("Username"), prope.getProperty("Password"));
		adminPage = homePage.clickonAdminLink();
		adminAddUserPage=adminPage.vefiryAddUser();
	}
	
	
	@Test
	public void verifyAddUserLabelTest() {
		boolean flag =adminAddUserPage.verifyAddUserLabel();
		Assert.assertTrue(flag, "Add User Label is missing ");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
