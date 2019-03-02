package com.aws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aws.utilities.Driver;

public class LoginPage {

	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id="nav-tools")
	public WebElement AccountAndLists;
	
	@FindBy(id="ap_email")
	public WebElement Email;
	
	@FindBy(id="ap_password")
	public WebElement password;
	
	@FindBy(id="signInSubmit")
	public WebElement signInBtn;
	
}
