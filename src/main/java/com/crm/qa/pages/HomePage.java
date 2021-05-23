package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.TestBase.TestBase;

public class HomePage extends TestBase {

	// Creating Page Factory

	@FindBy(xpath = "//td[@class='logo_text']")
	WebElement UserLogoName;

	@FindBy(xpath = "//a[normalize-space()='Contacts']")
	WebElement ContactLinks;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement DealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement TaskLinks;

	@FindBy(xpath = "//a[normalize-space()='New Contact']")
	WebElement NewContactsLinks;



	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}

	public boolean LogoNameHomePage() {
		return UserLogoName.isDisplayed();
	}

	public ContactsPage ClickOnContactsLink() throws IOException {
		ContactLinks.click();
		return new ContactsPage();

	}

	public DealsPage ClickOnDealLinkPage() throws IOException {
		DealsLink.click();
		return new DealsPage();
	}

	public TaskPage ClickOnTaskPage() throws IOException {
		TaskLinks.click();
		return new TaskPage();
	}

	public void NewContactsLink() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(ContactLinks).build().perform();
		NewContactsLinks.click();
	}

	public DealsPage DealsPageclick() throws IOException {
		DealsLink.click();
	return new DealsPage();
	
	}
	
	public void NewDealsPageClick()
	{
	Actions action=new Actions(driver);
	action.moveToElement(DealsLink).build().perform();
	driver.findElement(By.xpath("//a[normalize-space()='New Deal']")).click();
	
	}
	
	
}
