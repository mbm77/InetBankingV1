package com.inetbanking.utilities;

import java.io.File;
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
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReports;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {
		extentReports = new ExtentReports();

		String timestamp = new SimpleDateFormat("yyyy-MM-dd.HH.mm.ss").format(new Date());// timestamp
		String repName = "Test-Report-" + timestamp + ".html";
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output\\" + repName);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Host name", "localhost");
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("user", "mbm");

		sparkReporter.config().setDocumentTitle("InetBanking Test Project");// Title of Report
		sparkReporter.config().setReportName("Functional Test Report");// name of the report
		sparkReporter.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult tr) {
		logger = extentReports.createTest(tr.getName());
		extentReports
		.createTest(tr.getName())
		.log(Status.PASS,
				MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

		//extentReports.flush();
		/*
		 * try { Desktop.getDesktop().browse(new
		 * File(System.getProperty("user.dir")+"\\test-output\\"+repName).toURI()); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	public void onTestFailure(ITestResult tr) {
		logger = extentReports.createTest(tr.getName());
		extentReports.createTest(tr.getName()).log(Status.FAIL,
				MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/" + tr.getName() + ".png";
		File file = new File(screenshotPath);
		if (file.exists()) {
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
		}
		//extentReports.flush();
	}
	
	public void onTestFinish() {
		extentReports.flush();
	}

}
