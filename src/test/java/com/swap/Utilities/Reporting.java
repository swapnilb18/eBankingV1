package com.swap.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest logger;

	@Override
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report_" + timeStamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/" + repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Host Name", "Localhost");
		extentReport.setSystemInfo("User", "Swapnil");
		extentReport.setSystemInfo("Environment", "SIT");

		htmlReporter.config().setDocumentTitle("INet Banking Project");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

	}

	@Override
	public void onTestSuccess(ITestResult tr) {

		logger = extentReport.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		logger = extentReport.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		String snapPath = System.getProperty("user.dir") + "/Screenshots/" + tr.getName() + ".png";
		File snap = new File(snapPath);

		if (snap.exists()) {
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(snapPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		logger = extentReport.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extentReport.flush();
	}

}
