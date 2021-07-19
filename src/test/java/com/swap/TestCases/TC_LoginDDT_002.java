package com.swap.TestCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.swap.PageObjects.HomePage;
import com.swap.PageObjects.LoginPage;
import com.swap.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String uname, String password) {

		SoftAssert softAssert = new SoftAssert();

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("Username entered...: " + uname);
		lp.setPassword(password);
		logger.info("Password entered... : " + password);
		lp.login();
		logger.info("Clicked on login...");

		if (isAlertPresent()) {
			logger.info("Got alert...");
			driver.switchTo().alert().accept();
			logger.info("Alert accepted...");
			driver.switchTo().defaultContent();
			softAssert.assertTrue(false);
			logger.warn("Login failed... :(");
		} else {
			softAssert.assertTrue(true);
			logger.info("Login passed... :)");
			HomePage home = new HomePage(driver);
			home.logout();
			logger.info("Clicked on logout...");
			logger.info("Got alert...");
			driver.switchTo().alert().accept();
			logger.info("Alert accepted...");
			driver.switchTo().defaultContent();
		}
		softAssert.assertAll();
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() {
		String filePath = System.getProperty("user.dir") + "/src/test/java/com/swap/TestData/USername&passsword.xlsx";
		int rowCount = XLUtils.getRowCount(filePath, "Sheet1");
		int cellCount = XLUtils.getCellCount(filePath, "Sheet1", 1);
		String loginData[][] = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				String cellValue = XLUtils.getCellData(filePath, "Sheet1", i, j);
				loginData[i - 1][j] = cellValue;
			}
		}
		return loginData;
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
