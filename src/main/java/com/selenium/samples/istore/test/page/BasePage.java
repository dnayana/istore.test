package com.selenium.samples.istore.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.google.common.base.Predicate;


public class BasePage {
	
	public WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver= driver;
	}

	public void waitForPageLoadUntilURLContains(final String containsUrl) {
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(new Predicate<WebDriver>() {
            public boolean apply(WebDriver driver) {
                return driver.getCurrentUrl().contains(containsUrl);
            }
        });
    }
}
