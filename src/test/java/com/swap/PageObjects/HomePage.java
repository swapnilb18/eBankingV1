package com.swap.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Log out']")
	@CacheLookup
	WebElement logout;

	@FindBy(xpath = "//a[text()='New Customer']")
	@CacheLookup
	WebElement newCustomer;

	@FindBy(xpath = "//a[text()='Edit Customer']")
	@CacheLookup
	WebElement editCustomer;

	@FindBy(xpath = "//a[text()='Delete Customer']")
	@CacheLookup
	WebElement deleteCustomer;

	@FindBy(xpath = "//a[text()='New Account']")
	@CacheLookup
	WebElement newAccount;

	@FindBy(xpath = "//a[text()='Edit Account']")
	@CacheLookup
	WebElement editAccount;

	@FindBy(xpath = "//a[text()='Delete Account']")
	@CacheLookup
	WebElement deleteAccount;

	@FindBy(xpath = "//a[text()='Deposit']")
	@CacheLookup
	WebElement deposit;

	@FindBy(xpath = "//a[text()='Withdrawal']")
	@CacheLookup
	WebElement withdrawl;

	@FindBy(xpath = "//a[text()='Fund Transfer']")
	@CacheLookup
	WebElement fundTransfer;

	@FindBy(xpath = "//a[text()='Change Password']")
	@CacheLookup
	WebElement changePassword;

	@FindBy(xpath = "//a[text()='Balance Enquiry']")
	@CacheLookup
	WebElement balanceEnquiry;

	@FindBy(xpath = "//a[text()='Mini Statement']")
	@CacheLookup
	WebElement miniStatement;

	@FindBy(xpath = "//a[text()='Customised Statement']")
	@CacheLookup
	WebElement customizedStatement;

	public void logout() {
		logout.click();
	}

	public void clickNewCustomer() {
		newCustomer.click();
	}

	public void editCustomer() {
		editCustomer.click();
	}

	public void deleteCustomer() {
		deleteCustomer.click();
	}

	public void newAccount() {
		newAccount.click();
	}

	public void editAccount() {
		editAccount.click();
	}

	public void deleteAccount() {
		deleteAccount.click();
	}

	public void deposit() {
		deposit.click();
	}

	public void withdrawl() {
		withdrawl.click();
	}

	public void fundTransfer() {
		fundTransfer.click();
	}

	public void changePassword() {
		changePassword.click();
	}

	public void balanceEnquiry() {
		balanceEnquiry.click();
	}

	public void miniStatement() {
		miniStatement.click();
	}

	public void customizedStatement() {
		customizedStatement.click();
	}

}
