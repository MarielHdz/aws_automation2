package com.aws.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aws.utilities.BrowserUtils;
import com.aws.utilities.ConfigReader;
import com.aws.utilities.Driver;

public abstract class TestBase {
	protected WebDriver driver;
	protected Actions actions;
	protected ExtentReports report;
	protected ExtentHtmlReporter htmlReporter;
	protected ExtentTest extentLogger;

	@BeforeTest
	public void setUpTest() {
		report = new ExtentReports();
		String filePath = System.getProperty("user.dir")+"/test-output/report.html";
		htmlReporter = new ExtentHtmlReporter(filePath);		
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Env", "staging");
		report.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
		report.setSystemInfo("EnvwithSystem", System.getProperty("os.name"));	
		htmlReporter.config().setReportName("aws automated test reports");
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		driver = Driver.getDriver();
		actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigReader.getProperty("url"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			String scshotLocation = BrowserUtils.getScreenshot(result.getName());
			extentLogger.fail(result.getName());
			extentLogger.addScreenCaptureFromPath(scshotLocation);
			extentLogger.fail(result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP) {
			extentLogger.skip("Test case skipped is " + result.getName());
		}
		Driver.closeDriver();
	}

	@AfterTest
	public void tearDownTest() {
		report.flush();
	}

}
