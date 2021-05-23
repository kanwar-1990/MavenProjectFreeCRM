package com.crm.qa.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.Util.TestUtil;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.DealsPage;

public class DealsPageContact extends TestBase

{

	public DealsPageContact() throws IOException {
		super();
	}

	static public LoginPage LoginPage;
	static public HomePage HomePage;
	DealsPage DealsPage;
	
	TestUtil TestUtil;
	String sheetName = "Deals";


	@BeforeMethod
	public void Setup() throws IOException {

		intialization();
		LoginPage = new LoginPage();
		TestUtil = new TestUtil();
		 DealsPage=new DealsPage();
        ContactsPage ContactPage=new ContactsPage();
		// LoginPage Object is created to use LoginMethod to puch usrname and password

		HomePage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.SwitchFrame();
      // DealsPage=HomePage.ClickOnDealLinkPage();
	}

	@DataProvider

	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}


	
	
	@Test(priority=1, dataProvider = "getCRMTestData")
	public void ValidatingDealsPage(String title, String Company) throws IOException {

		HomePage.NewDealsPageClick();

		DealsPage.validateDealsDataUpdation(title,Company);

	}
	

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
