package com.crm.qa.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriverBasic {

	@Test(dataProvider = "FreeCrm")
	public void WordPress(String username, String password) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.getTitle();

	}

	@DataProvider(name = "FreeCrm")
	public Object[][] passData() {
		// As u can use anytype of Data to create as multiple input is required , we may
		// use Object
		// to avoid writing multiple time, we use in excel sheet
		Object[][] obj = new Object[3][2];
		obj[0][0] = "admin";
		obj[0][1] = "     ";

		obj[1][0] = "groupautomation";
		obj[1][1] = "Test@12345";
		return obj;
	}

}
