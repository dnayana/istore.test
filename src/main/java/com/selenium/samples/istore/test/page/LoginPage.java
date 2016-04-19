package com.selenium.samples.istore.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.samples.istore.utils.IConstants;
import com.selenium.samples.istore.utils.IConstants.UserCreds;

public class LoginPage extends BasePage{
	
	public WebDriver driver;
	
	@FindBy(id="log")
	public WebElement username;
	
	@FindBy(xpath="//input[@id='pwd']")
//	@FindBy(css="input#pwd")
//	@FindBy(id="pwd")
	public WebElement password;
	
	@FindBy(id="login")
	public WebElement loginButton;
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	public LoggedInHomePage loginToStore(String user, String pass){
		LoggedInHomePage loggedInHomePage = PageFactory.initElements(driver,LoggedInHomePage.class );
		username.sendKeys(IConstants.UserCreds.USER);
		password.sendKeys(IConstants.UserCreds.PASSWORD);
		loginButton.click();
		return  loggedInHomePage ;
	}
	

}
