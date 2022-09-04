package com.OrangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.pages.HomePage;
import com.OrangeHRM.qa.pages.LoginPage;
import com.OrangeHRM.qa.pages.PIMAddEmpPage;
import com.OrangeHRM.qa.pages.PIMPage;
import com.OrangeHRM.qa.util.TestUtil;

public class PIMAddEmpPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	PIMPage pimPage;
	PIMAddEmpPage pimAddEmpPage;
	TestUtil testUtil;
	
	String sheetName = "EmployeeList";
	
	public PIMAddEmpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		initilization();
		loginPage = new LoginPage();
		homePage=loginPage.validateLogin(prope.getProperty("Username"), prope.getProperty("Password"));
		pimPage=homePage.clickOnPIMPageLink();
		pimAddEmpPage=pimPage.VerifyAddEmployeePageLink();
		

	}
	@Test(priority = 1)
	public void VerifyAddEmpLabelTest() {
		boolean flag = pimAddEmpPage.VerifyaAddEmployeeLabel();
		Assert.assertTrue(flag, "Add Employee Lable is Missing");
	}
	
	
	@DataProvider
	public Object[][] getEmployeeTestData() {
		Object data[][] =TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	
	@Test(priority = 2, dataProvider = "getEmployeeTestData")
	public void VefiryAddNewEmployeeTest(String FirstName, String MiddleName, String LastName) {
		//pimAddEmpPage.VefiryAddEmployee("Manoj","Mahadeo", "Khedkar");
		pimAddEmpPage.VefiryAddEmployee(FirstName, MiddleName, LastName);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
