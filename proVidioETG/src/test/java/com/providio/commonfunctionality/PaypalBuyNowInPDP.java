package com.providio.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.Validations.navigationProcessWithValidation;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.testcases.baseClass;

public class PaypalBuyNowInPDP extends baseClass {

	public void paypalBuyNowFromPDP(WebDriver driver) throws InterruptedException {
		
		//checking if the buy now button is in avaible in pdp page if it is avaialble then executes the if condition 
		List<WebElement> paypalbuyNowPdp =driver.findElements(By.xpath("//div[contains(@class,'salesforce-buynow-element ')]"));
		if(paypalbuyNowPdp.size()>0) {
		
		  //selecting attributes from the  pdp page by checking the condition 		
			  allAttributesinOneFile.allAttributes();
		  	  Thread.sleep(2000);
		  	
		  //checking the paypal buy now button is enabled and in stock after seelecting the attributes 
		  	 WebElement paypalbuyNowEnabled =driver.findElement(By.xpath("//div[contains(@class,'salesforce-buynow-element ')]"));
		     List<WebElement> inStock =driver.findElements(By.xpath("//div[contains(text(), 'In Stock')]"));
		     
			     if(paypalbuyNowEnabled.isEnabled()&& inStock.size()>0) {
			    	 productDescriptionPage pdp = new productDescriptionPage(driver);			    	 
			    	 pdp.clickOnPaypalBuyNow(driver);
			    	 
			     //verifying whether the paypalbuy now is displayed  after selecting attributes
			    	 test.info("Verifying the paypal buy now button");
			    	  if (paypalbuyNowEnabled.isDisplayed()) {
			    		  test.pass("Succesffuly clicked on paypal buy now button in pdp");
			    	  }
			    	  else {
			    		  test.fail("No  paypal buy now button in pdp");
			    	  }
			    	  
			     }else {
			    	//if the prodcut is outof stock then it will search for new prodcut by selecting random menu and random product
			    	 	System.out.println("Product is out of stock so searching for new product");			    	 
			    	 
			    	 //navigates to random menu by validating the  PLP page
			    	 	navigationProcessWithValidation navProccess= new navigationProcessWithValidation(driver);
			    	 	navProccess.selectRandomMenu(driver);
				 
				     //recursion -when a method calls itself it is called as recusrion, repeats the same processs untill product is instock and added to cart		    		
						allAttributesinOneFile.allAttributes();
			    	
			     }
		  
		}else {
			System.out.println("No paypal buy now button for brain tree");
		}
	}	
}
