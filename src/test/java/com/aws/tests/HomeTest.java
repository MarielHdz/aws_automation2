package com.aws.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aws.pages.HomePage;
import com.aws.utilities.ConfigReader;


public class HomeTest extends TestBase{

	@Test()
	public void searchTest() {
		driver.get(ConfigReader.getProperty("url"));
		HomePage homePage = new HomePage();
		homePage.search.sendKeys("wigs" + Keys.ENTER);
		String title = driver.getTitle();
		Assert.assertEquals("Amazon.com: wigs", title, "title verification: ");		
	}
	
	@Test()
	public void dealsTest() {
		driver.get(ConfigReader.getProperty("url"));
		HomePage homePage = new HomePage();
		homePage.deals.click();
		String title = driver.getTitle();
		Assert.assertEquals("Gold Box Deals | Today's Deals - Amazon.com", title.trim(), "deals verification: ");		
	}
}
