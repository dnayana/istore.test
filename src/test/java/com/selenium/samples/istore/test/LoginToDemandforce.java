package com.selenium.samples.istore.test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginToDemandforce extends PageFactory{
	
	WebDriver driver;
	
	
	WebElement loginLink;
	
	
	WebElement signInButton;
	
	
	public LoginToDemandforce(){
		driver = new FirefoxDriver();
		driver.get("http://www.demandforce.com/");
		
			
	}
	
	//This does not work! NPE
	@Test
	public void login(){
		loginLink.click();
		Assert.assertTrue(signInButton.isDisplayed());
	}

}
