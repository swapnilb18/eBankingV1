package com.swap.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {

	WebDriver driver;

	public NewCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='name']")
	@CacheLookup
	WebElement cname;

	@FindBy(xpath = "//input[@value='m']")
	@CacheLookup
	WebElement male;

	@FindBy(xpath = "//input[@value='f']")
	@CacheLookup
	WebElement female;

	@FindBy(xpath = "//input[@id='dob']")
	@CacheLookup
	WebElement dob;

	@FindBy(xpath = "//textarea[@name='addr']")
	@CacheLookup
	WebElement address;

	@FindBy(xpath = "//input[@name='city']")
	@CacheLookup
	WebElement city;

	@FindBy(xpath = "//input[@name='state']")
	@CacheLookup
	WebElement state;

	@FindBy(xpath = "//input[@name='pinno']")
	@CacheLookup
	WebElement pin;

	@FindBy(xpath = "//input[@name='telephoneno']")
	@CacheLookup
	WebElement mobile;

	@FindBy(xpath = "//input[@name='emailid']")
	@CacheLookup
	WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//input[@name='sub']")
	@CacheLookup
	WebElement submit;

	@FindBy(xpath = "//input[@name='res']")
	@CacheLookup
	WebElement reset;

	public void setCname(String name) {
		cname.sendKeys(name);
	}

	public void setGender(String gender) {
		if (gender.equalsIgnoreCase("Male")) {
			male.click();
		} else {
			female.click();
		}
	}

	public void setDob(String dd, String mm, String yyyy) {

		dob.sendKeys(dd);
		dob.sendKeys(mm);
		Robot r;
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
		} catch (AWTException e) {
			System.out.println(e.getMessage());
		}
		dob.sendKeys(yyyy);
	}

	public void setAddress(String addr) {
		address.sendKeys(addr);
	}

	public void setCity(String cityName) {
		city.sendKeys(cityName);
	}

	public void setState(String stateName) {
		state.sendKeys(stateName);
	}

	public void setPin(String pinNo) {
		pin.sendKeys(pinNo);
	}

	public void setMobile(String mob) {
		mobile.sendKeys(mob);
	}

	public void setEmail(String mail) {
		email.sendKeys(mail);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickSubmit() {
		submit.click();
	}

	public void clickReset() {
		reset.click();
		;
	}

}
