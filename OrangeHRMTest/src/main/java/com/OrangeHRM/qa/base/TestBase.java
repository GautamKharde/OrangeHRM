package com.OrangeHRM.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.OrangeHRM.qa.util.TestUtil;
import com.OrangeHRM.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prope;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListner;

	public TestBase() {
		prope = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Eclipse TestNG Programes\\OrangeHRMTest\\src\\main\\java\\com\\OrangeHRM\\qa\\config\\config.properties");
			prope.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initilization() {
		String browserName = prope.getProperty("Browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Eclipse TestNG Programes\\OrangeHRMTest\\Binary\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Eclipse TestNG Programes\\OrangeHRMTest\\Binary\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("gecko")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Eclipse TestNG Programes\\OrangeHRMTest\\Binary\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		e_driver =new EventFiringWebDriver(driver);
		eventListner =new WebEventListener();
		e_driver.register(eventListner);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.get(prope.getProperty("url"));

	}
}
