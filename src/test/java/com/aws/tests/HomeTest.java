package com.aws.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aws.pages.HomePage;
import com.aws.utilities.ConfigReader;

public class HomeTest extends TestBase {

	@Test(priority = 2)
	public void searchTest() {
		extentLogger = report.createTest("search Test");
		extentLogger.info("search for item in homepage");
		driver.get(ConfigReader.getProperty("url"));
		HomePage homePage = new HomePage();
		homePage.search.sendKeys("wigs" + Keys.ENTER);
		extentLogger.info("after search get title of new page.");
		String title = driver.getTitle();
		Assert.assertEquals("Amazon.com: wigs", title, "title verification: ");
		extentLogger.pass("verifies the title of the page");
	}

	@Test(priority = 1)
	public void dealsTest() {
		extentLogger = report.createTest("deal Test");
		driver.get(ConfigReader.getProperty("url"));
		HomePage homePage = new HomePage();
		extentLogger.info("go to deals module and verify title");
		homePage.deals.click();
		String title = driver.getTitle();
		Assert.assertEquals("Gold Box Deals | Today's Deals - Amazon.com", title.trim(), "deals verification: ");
		extentLogger.pass("verified the title after deals");
	}

	@Test(priority = 3)
	public void mytestDelete() {
		extentLogger = report.createTest("mytest");
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println("------------------------BROWSER NAME: " + browserName);
		assertTrue(2 == 3);
		extentLogger.pass("verifies 2==2");
	}
}
