package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.TestBase.TestBase;

public class LoginPage extends TestBase {
	// Page Factory --Object Repositry
	//this are page object

	// we need to define the elements with the help of findby method

	@FindBy(name = "username")
	WebElement UserName;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement SubmitButn;

	@FindBy(xpath = "//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement CrmLogo;

	// we will instalize all the elements of the login page

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// page factory will intialize all the elements of this class --with driver

		// this--will point at current class objects -- u can also right instead of
		// this---LoginPage.class
		}
	
	public boolean validationLogo()
	{
		return CrmLogo.isDisplayed();
	}

	
	public String GetvalidTitle()
	{
		return driver.getTitle();
	}

	public HomePage Login(String un,String pwd) throws IOException {
		
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		SubmitButn.click();
	
		/*// why this is returning home class page, after entering,usr and password clicking on 
		submit button it enters home page*/
	return new HomePage();
	
	}
	

}
