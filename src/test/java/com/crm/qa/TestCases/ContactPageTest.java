package com.crm.qa.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.wildfly.common.Assert;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.Util.TestUtil;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactPageTest extends TestBase {

	LoginPage LoginPage;
	ContactsPage ContactPage;
	HomePage HomePage;
	TestUtil TestUtil;
	String sheetName="Contacts"; //Create Sheet ---Need to give Sheet Name

	public ContactPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void SetUp() throws IOException {

		intialization();
		LoginPage = new LoginPage();
		TestUtil TestUtil = new TestUtil();
		ContactsPage ContactsPage = new ContactsPage();
		HomePage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.SwitchFrame();
	    	ContactPage = HomePage.ClickOnContactsLink();

	}

	/*@Test(priority = 1)
	public void DisplayContactInfo() {
		Assert.assertTrue(ContactPage.DisplayingContactInfo());
		
	}*/
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName, String company) throws InterruptedException{
		
		
		HomePage.NewContactsLink();
		
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		ContactPage.createContactList( firstName, lastName, company);

	}

	@AfterMethod public void TearDown() { driver.quit();
	  }
	 
}
