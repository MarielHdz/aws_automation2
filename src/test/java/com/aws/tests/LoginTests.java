package com.aws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aws.pages.HomePage;
import com.aws.pages.LoginPage;
import com.aws.utilities.ConfigReader;


public class LoginTests extends TestBase {

	@Test()
	public void signIn() {
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
	}
	
	@Test()
	public void test() {
		System.out.println("ran test");
	}

}
