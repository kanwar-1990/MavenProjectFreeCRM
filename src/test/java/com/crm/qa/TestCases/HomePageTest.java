package com.crm.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.Util.TestUtil;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	public LoginPage LoginPage;
	public HomePage HomePage;
	TestUtil TestUtil;

	public HomePageTest() throws IOException {
		super();
	}

	ContactsPage ContactsPage;

	@BeforeMethod
	public void SetUp() throws IOException {
		intialization();
		LoginPage = new LoginPage();
		TestUtil = new TestUtil();

		// LoginPage Object is created to use LoginMethod to puch usrname and password

		HomePage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.SwitchFrame();
	}

	@Test(priority = 1)
	public void CheckingHomePageTittle() {
		// Since the panel where tittle and other links are in mainpanel, we had to use
		// switchframe, which we created in Util method, to call that we needed to use TestUtil method
		Boolean Title = HomePage.LogoNameHomePage();
		Assert.assertTrue(Title);

	}

	@Test(priority = 2)
	public void ClickContactlink() throws IOException {
		HomePage.ClickOnContactsLink();
	}

	@Test(priority = 3)
	public void ClickDealsLink() throws IOException {
		HomePage.ClickOnDealLinkPage();
	}

	@Test(priority = 4)
	public void ClickonTaskLink() throws IOException {

		HomePage.ClickOnTaskPage();
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
