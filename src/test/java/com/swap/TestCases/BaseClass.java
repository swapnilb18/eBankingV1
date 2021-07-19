package com.swap.TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.swap.Utilities.ReadConfig;

public class BaseClass {

	ReadConfig read = new ReadConfig();

	public String baseUrl = read.getApplicationUrl();
	public String uname = read.getUsername();
	public String password = read.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", read.getChromePath());
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", read.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", read.getEdgePath());
			driver = new EdgeDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", read.getChromePath());
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		logger = Logger.getLogger("Selenium_Project01");
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/Configurations/log4j.properties");
		
		driver.get(baseUrl);
		logger.info("URL Entered...");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void takeSnap(WebDriver driver,String tcName) {
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tcName+".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			System.out.println("File not found...:(");
		}
	}
	
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	
	public String randomNumber() {
		return RandomStringUtils.randomNumeric(5);
	}
}
