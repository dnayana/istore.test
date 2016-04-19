package com.selenium.samples.istore.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.annotations.Test;

public class ThingsToDoTest {

	public static WebDriver driver = new FirefoxDriver();

	@FindBys({ @FindBy(className = "display-group-results"),
			@FindBy(tagName = "a") })
	public static List<WebElement> resultList;

	@Test
	public void testThingsToDo(){
		
		driver.get("https://www.travelocity.com");
		
		// click on header Things To do
		WebElement thingsToDoLink= driver.findElement(By.id("primary-header-activity"));
		thingsToDoLink.click();
		
		//Look for city San jose
		WebElement city= driver.findElement(By.id("activity-destination"));
		city.sendKeys("San");
		
		//class display-group-results
		resultList.get(3).click();
		
		
		driver.close();
		
	}
}
