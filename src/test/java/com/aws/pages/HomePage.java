package com.aws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aws.utilities.Driver;


public class HomePage {
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement search;
	
	@FindBy(linkText="Today's Deals")
	public WebElement deals;
	
	@FindBy(xpath="//*[.='Hello, paola']")
	public WebElement helloMsg;
}
