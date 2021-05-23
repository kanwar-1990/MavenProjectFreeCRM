package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.TestBase.TestBase;

public class DealsPage extends TestBase {

	@FindBy(xpath="//input[@id='title']")
	WebElement UpdateTitle;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement UpdateCompany;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement SaveButtonClick;

	public DealsPage() throws IOException {
		super();

		PageFactory.initElements(driver, this);
	}

	public void validateDealsDataUpdation(String title,String Company) {
		
		UpdateTitle.sendKeys(title);
		UpdateCompany.sendKeys(Company);
		SaveButtonClick.click();

	}

}
