package com.selenium.samples.istore.test.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoggedInHomePage extends BasePage{
	
	public LoggedInHomePage(WebDriver driver) {
		super(driver);
	}




//	@FindBys({@FindBy(id="meta"), @FindBy(tagName= "a")})
	//@FindBys({@FindBy(id="meta"), @FindBy(xpath= "/ul/li")})
	@FindBys({@FindBy(id="meta"), @FindBy(tagName= "ul"), @FindBy(tagName= "li")})
	public List<WebElement> metaLinks;
	
	@FindBys({
		@FindBy(id="slide_menu"), 
		@FindBy(tagName="a")
		})
	public List<WebElement> slideMenuLinkList;
	
	@FindBy(className= "account_icon")
	public WebElement myAccountLink;
	
	
	public WebElement getMetaLink(String val){
		int numLinks;
		numLinks= metaLinks.size();
		for(WebElement link:metaLinks ){
			if(link.getText().contains(val))
				return link;
		}
		
		return null;
	}
	

}
