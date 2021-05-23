package com.crm.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	public LoginPage LoginPage;
	public HomePage HomePage;

	public LoginPageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws IOException {
		intialization();
		LoginPage = new LoginPage();

	}

	@Test(priority=1)
	public void validatingCRMlogo() {
		boolean loginPa = LoginPage.validationLogo();
		Assert.assertTrue(loginPa);
	}

	@Test(priority=2)
	public void GetCrmTittle() {
		String Tittle = LoginPage.GetvalidTitle();
		Assert.assertEquals(Tittle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority=3)
	public void LoginCrm() throws IOException {
		HomePage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("username"));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
