package com.swap.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@name='uid']")
	@CacheLookup
	WebElement userName;
	
	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	@CacheLookup
	WebElement login;

	public void setUserName(String uname) {
		userName.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void login() {
		login.click();
	}
	
	
}
