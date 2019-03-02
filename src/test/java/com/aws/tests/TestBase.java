package com.aws.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aws.utilities.ConfigReader;
import com.aws.utilities.Driver;


public abstract class TestBase {
	protected WebDriver driver;
	protected Actions actions;

	
	@BeforeTest
	public void setUpTest() {

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
	public void tearDown() {
		Driver.closeDriver();
	}

	@AfterTest
	public void tearDownTest() {
	}

}
