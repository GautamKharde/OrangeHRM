package com.OrangeHRM.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.OrangeHRM.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;

//	public void switchToFrame() {
//		driver.switchTo().frame("");
//	}

	public static String TESTDATA_SHEET_PATH = "C:\\Eclipse TestNG Programes\\OrangeHRMTest\\src\\main\\java\\com\\OrangeHRM\\qa\\testdata\\Book4.xlsx";

	static XSSFWorkbook xssfWorkbook;
	static XSSFSheet xssfSheet;

	public static Object[][] getTestData(String sheeetName) {
		FileInputStream file = null;

		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			xssfWorkbook = (XSSFWorkbook) WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		xssfSheet = xssfWorkbook.getSheet(sheeetName);
		Object[][] data = new Object[xssfSheet.getLastRowNum()][xssfSheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < xssfSheet.getLastRowNum(); i++) {
			for (int k = 0; k < xssfSheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = xssfSheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
	
	public static void takeScreenShotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
