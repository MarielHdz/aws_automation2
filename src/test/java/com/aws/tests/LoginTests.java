package com.aws.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aws.pages.HomePage;
import com.aws.pages.LoginPage;
import com.aws.utilities.ConfigReader;

public class LoginTests extends TestBase {

	@Test(priority = 1)
	public void signIn() {
		extentLogger = report.createTest("signIn test");
		driver.get(ConfigReader.getProperty("url"));
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.AccountAndLists.click();
		String sigInPageTitle = driver.getTitle();
		Assert.assertEquals("Amazon Sign In", sigInPageTitle.trim(), "sigIn page verification: ");
		loginPage.Email.sendKeys("paoh4@hotmail.com");
		loginPage.password.sendKeys("Pmgh1987@");
		loginPage.signInBtn.click();
		String helloUser = homePage.helloMsg.getText();
		Assert.assertEquals("Hello, paola", helloUser.trim(), "User logedIn verification: ");
		extentLogger.pass("verified the title after signIn");
	}

	@Test(priority = 2)
	public void invalidUserName() {
		extentLogger = report.createTest("signIn test2");
		driver.get(ConfigReader.getProperty("url"));
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.AccountAndLists.click();
		String sigInPageTitle = driver.getTitle();
		Assert.assertEquals("Amazon Sign In", sigInPageTitle.trim(), "sigIn page verification: ");
		loginPage.Email.sendKeys("paoh4@");
		loginPage.password.sendKeys("Pmgh1987@");
		loginPage.signInBtn.click();
		String helloUser = homePage.helloMsg.getText();
		Assert.assertEquals("Hello, paola", helloUser.trim(), "User logedIn verification: ");
		extentLogger.pass("verified user name in logged module");
		System.out.println("PAola");
	}

}
