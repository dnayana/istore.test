package com.selenium.samples.istore.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.samples.istore.test.page.LoggedInHomePage;
import com.selenium.samples.istore.test.page.LoginPage;
import com.selenium.samples.istore.utils.IConstants;

public class StoreLoginTest {

	static WebDriver driver;
	
	@BeforeClass
	public void init(){
		driver= new FirefoxDriver();
	}
	
	@Test(enabled=true, groups={"sanity","functional"})
	public void testLoginOnlineStore() throws InterruptedException{
		
		driver.get(IConstants.URLConstants.ONLINESTORE_LOGIN_URL);
		
		Assert.assertTrue(driver.getPageSource().contains("Your Account"));
		
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.username.sendKeys(IConstants.UserCreds.USER);
		loginPage.password.sendKeys(IConstants.UserCreds.PASSWORD);
		loginPage.loginButton.click();
		
	}
	
	
	@Test(enabled=true, groups={"functional"})
	public void testMetaLinkSiteAdmin() throws InterruptedException{
		
		driver.get(IConstants.URLConstants.ONLINESTORE_LOGIN_URL);
		
		Assert.assertTrue(driver.getPageSource().contains("Your Account"));
		
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		LoggedInHomePage loggedInHomePage= PageFactory.initElements(driver, LoggedInHomePage.class);
		
		loginPage.loginToStore(IConstants.UserCreds.USER,IConstants.UserCreds.PASSWORD);
		
		loggedInHomePage.waitForPageLoadUntilURLContains("login=1");
		
		String myAccountText= loggedInHomePage.myAccountLink.getAttribute("title");
		
		loggedInHomePage.getMetaLink("Site Admin").click();
		
		loggedInHomePage.waitForPageLoadUntilURLContains("wp-admin/");
		
		
	}
	
	@Test(enabled=false, groups={"functional"})
	public void testHomeSlideMenuLinks() throws InterruptedException{
		
		driver.get(IConstants.URLConstants.ONLINESTORE_LOGIN_URL);
		
		Assert.assertTrue(driver.getPageSource().contains("Your Account"));
		
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		
		LoggedInHomePage loggedInHomePage= loginPage.loginToStore(IConstants.UserCreds.USER,IConstants.UserCreds.PASSWORD);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 
	}
	@AfterClass
	public void teardown(){
		driver.quit();;
	}
}
