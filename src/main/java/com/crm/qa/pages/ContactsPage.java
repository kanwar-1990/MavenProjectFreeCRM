package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.TestBase.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement ContactInfo;

	@FindBy(name = "first_name")
	WebElement FirName;
	@FindBy(name = "surname")
	WebElement LasName;
	@FindBy(name = "client_lookup")
	WebElement Company;
	@FindBy(xpath="//input[@value='Save']")
	WebElement SaveAfterUpdate;

	// after finding element we need to intialize them
	public ContactsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);//

	}

	public boolean DisplayingContactInfo()

	{

		return ContactInfo.isDisplayed();
	}

	public void createContactList(String FrName, String LstName, String Comp) {

		/*Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);*/
		FirName.sendKeys(FrName);
		LasName.sendKeys(LstName);
		Company.sendKeys(Comp);
		SaveAfterUpdate.click();
        
	}

}
