package com.aws.regression;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.aws.tests.TestBase;

public class Test1 extends TestBase {

	@Test()
	public void mytest() {
		extentLogger = report.createTest("mytest");
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println("------------------------BROWSER NAME: " + browserName);
		assertTrue(2 == 3);
		extentLogger.pass("verifies 2==2");
	}
}
