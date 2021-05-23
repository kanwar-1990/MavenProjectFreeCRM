package com.crm.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.Util.TestUtil;
import com.crm.qa.Util.WebEventListener;

public class TestBase {
	// declaring variables outside as everyone can use it
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	// to read the properties , for config
	// creating an constructor
	public TestBase() throws IOException {

		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"C:\\Users\\knwrp\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\"
						+ "crm\\qa\\config\\config.properties");

		prop.load(ip);
	}

	public static void intialization() throws IOException {

		// prop.get property is used to read the file in obj.repostry created by u.
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("driver.chrome.webdriver", "C:\\Users\\knwrp\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("driver.gecko.webdriver", "C:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();

		// have created a class in util package , in case we need to increase the load
		// time
		// all static variable is created
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

	}

}
