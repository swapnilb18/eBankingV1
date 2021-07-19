package com.swap.TestCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swap.PageObjects.HomePage;
import com.swap.PageObjects.LoginPage;
import com.swap.PageObjects.NewCustomer;

public class TC_NewCustomer_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		NewCustomer cust = new NewCustomer(driver);

		lp.setUserName(uname);
		logger.info("Username entered...");
		lp.setPassword(password);
		logger.info("Password entered...");
		lp.login();
		logger.info("Clicked on login...");

		hp.clickNewCustomer();
		logger.info("Clicked on New Customer...");

		cust.setCname("Salman Khan");
		logger.info("Customer name entered...");

		cust.setGender("Male");
		logger.info("Customer gender entered...");

		cust.setDob("15", "8", "1975");
		Thread.sleep(3000);
		logger.info("Customer DOB entered...");

		cust.setAddress("Marine Drive");
		logger.info("Customer address entered...");

		cust.setCity("Mumbai");
		logger.info("Customer city entered...");

		cust.setState("Maharashtra");
		logger.info("Customer state entered...");

		cust.setPin("114588");
		logger.info("Customer pin entered...");

		cust.setMobile("+919874859652");
		logger.info("Customer mobile entered...");

		cust.setEmail(randomString() + "@gmail.com");
		logger.info("Customer email entered...");

		cust.setPassword("salman123");
		logger.info("Customer password entered...");

		cust.clickSubmit();
		logger.info("Clicked on submit button...");

		Thread.sleep(3000);
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (result == true) {
			Assert.assertTrue(true);
			logger.info("Test Passed...");
		} else {
			logger.info("Test Failed...");
			takeSnap(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}

}
