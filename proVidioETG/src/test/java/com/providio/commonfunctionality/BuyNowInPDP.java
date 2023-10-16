package com.providio.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.Validations.BuyNowValidation;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.testcases.baseClass;

public class BuyNowInPDP extends baseClass {

public void clickOnBuyNow(WebDriver driver) throws InterruptedException {
		
		//selecting attributes from the  pdp page by checking the condition 		
		allAttributesinOneFile.allAttributes();
			
		//checking the buy now button is enabled and in stock after selecting the attributes 	
	     productDescriptionPage pdp = new productDescriptionPage(driver);
	     List <WebElement> buyNowEnabled =driver.findElements(By.xpath("//button[contains(@class,'buy-now btn btn-primary')]"));
	     List  <WebElement> inStock =driver.findElements(By.xpath("//div[contains(text(), 'In Stock')]"));
	     
	     if((buyNowEnabled.size()>0)&& inStock.size()>0) {
	    	 
	    	 // verifying the buynow button is displayed or not 
	    	 Thread.sleep(3000);	    	 
	    	 WebElement buyNowEnabled1 =driver.findElement(By.xpath("//button[contains(@class,'buy-now btn btn-primary')]"));
		     test.info("Verifying Buy now button in PDP");
		     
			     if(buyNowEnabled1.isDisplayed()) {
			    	 //clicking  on buy now button in pdp page 
			    	 Thread.sleep(2000);
				     pdp.clickOnBuyNowButton(driver);
				     System.out.println("Product added to cart by Buy now button");
			    	 test.pass("Successfully clicked on buy now button");
			     }else {
			    	 test.fail("No  buy now button is clicked");
			     }
			
			     //buy now validation
			     Thread.sleep(1000);			     
			     BuyNowValidation buy = new BuyNowValidation();
			     buy.buynow(driver);
		     
			     //clicking on place order button 
			     WebElement buyNowPlaceOrder =driver.findElement(By.cssSelector(".buynow-placeorder"));
			     JavascriptExecutor js = (JavascriptExecutor)driver;
			     js.executeScript("arguments[0].click();",buyNowPlaceOrder);     
		     
	     }else {
	    	//if the product is out of stock then it will search for new prodcut by selecting random menu and random product
	    	 
	    	 	test.info("Product is out of stock so searching for new product");
	    	 	
	    	 //navigating to pdp page 
	    	 	navigationProccess navProccess = new navigationProccess(); 	 
	    	 	navProccess.configuredCategoryForBuyNow();
	    	 	
	    	 	
	     }
	}
	
		
}
