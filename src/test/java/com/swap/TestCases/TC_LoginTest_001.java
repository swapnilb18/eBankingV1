package com.swap.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swap.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.setUserName(uname);
		logger.info("Entered Username....");

		loginPage.setPassword(password);
		logger.info("Entered Password....");

		loginPage.login();
		logger.info("Clicked on Login button....");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Test case passed....");
		} else {
			takeSnap(driver, "loginTest");
			logger.info("Screenshot taken....");
			Assert.assertTrue(false);
			logger.info("Test case failed....");
		}

	}
}
