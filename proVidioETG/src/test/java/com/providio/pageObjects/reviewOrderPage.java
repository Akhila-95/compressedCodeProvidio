package com.providio.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class reviewOrderPage {
	
WebDriver lDriver;
	
	public reviewOrderPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath ="//button[contains(text(), 'Next: Review Order')]")
	WebElement reviewOrderPage;
    public void clickonReviewOrder(WebDriver driver) throws InterruptedException {	 
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;     
    	// Brain Tree
		List<WebElement> creditcardscheck = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
	    if(creditcardscheck.size()>0) {
	    		Thread.sleep(3000);
		    	if(reviewOrderPage.isDisplayed()) {
		    		// js.executeScript("window.scrollBy(0,100)", "");
		    		 js.executeScript("arguments[0].click();",reviewOrderPage);
		    		 Thread.sleep(1000);
		    		 reviewOrderPage.click();
		    	}
	    	}
	  if(reviewOrderPage.isDisplayed()) {
	    	js.executeScript("arguments[0].click();",reviewOrderPage);
	    	Thread.sleep(3000);
	  }
    }
    
    
    //In checkout page if the it will check the button of revieworder and place order buttons
	@FindBy(xpath ="//button[contains(@class,' place-order')]")
	WebElement placetheorderwithJsExuter;
	
	@FindBy(xpath ="//button[contains(@class,' place-order')]")
	List<WebElement> placetheorderList;
	
    public void clickonplaceorderwithJsExuter(WebDriver driver) throws InterruptedException {
    	Thread.sleep(2000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;    
    	js.executeScript("window.scrollBy(0,100)", "");
    	
    	if(placetheorderList.size()>0) {
	    	 if(placetheorderwithJsExuter.isDisplayed() && placetheorderwithJsExuter.isEnabled() ) {  	    		 		
	    		 js.executeScript("arguments[0].click();", placetheorderwithJsExuter);
		    		Thread.sleep(4000);	    			    		
	    	 }
    	}
    } 
 
}
