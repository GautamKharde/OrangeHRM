package com.OrangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.pages.HomePage;
import com.OrangeHRM.qa.pages.LoginPage;
import com.OrangeHRM.qa.pages.PIMAddEmpPage;
import com.OrangeHRM.qa.pages.PIMPage;

public class PIMPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	PIMPage pimPage;
	PIMAddEmpPage pimAddEmpPage;
	
	public PIMPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		initilization();
		loginPage = new LoginPage();
		pimAddEmpPage = new PIMAddEmpPage();
		homePage=loginPage.validateLogin(prope.getProperty("Username"), prope.getProperty("Password"));
		pimPage=homePage.clickOnPIMPageLink();
	}
	
	@Test(priority = 1)
	public void verifyPIMPageLabelTest() {
		boolean flag =pimPage.VerifyPIMPageLabel();
		Assert.assertTrue(flag, "PIM Page Label is Missing On Page");
	}
	
	@Test(priority = 2)
	public void verifyAddEmployeePageLinkTest() {
		pimAddEmpPage = pimPage.VerifyAddEmployeePageLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
