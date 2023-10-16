// Import necessary packages and classes
package com.providio.paymentProccess;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.Validations.Checkout_Validation;
import com.providio.Validations.preValidationCheck;
import com.providio.commonfunctionality.paymentMethods;
import com.providio.creditCardPaymentMethods.allPaymentMethods;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.testcases.baseClass;

// Define a test class named "tc__CreditCardPaymentProcess"
public class tc__CreditCardPaymentProcess extends baseClass{
	
	// Define a method named "paymentByCreditCard"
	public void paymentByCreditCard() throws InterruptedException {
		
		List<WebElement> billingPage = driver.findElements(By.xpath("//label[contains(text(),'Billing Address')]"));		
		
		if(billingPage.size()>0) {
			
			WebElement billingAddressDisplay = driver.findElement(By.xpath("//label[contains(text(),'Billing Address')]"));	
			
				if(billingAddressDisplay.isDisplayed()) {
					
					// Validate the payment page
					preValidationCheck.validatePaymentButtonClk();
			       
					// Detect payment methods
					// Brain Tree
					List<WebElement> brainTree = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
				    // Credit Card Salesforce
					List<WebElement> creditcardsSalesForce = driver.findElements(By.xpath("//div[@class='sfpp-payment-method-header sfpp-payment-method-header-card']"));
				    // Stripe
				    List<WebElement> stripePayment = driver.findElements(By.xpath("(//div[contains(@class,'StripeElement')])[1]"));
				    // CyberSource
				    List<WebElement> cyberSourcePayment = driver.findElements(By.xpath("//li[@data-method-id='CREDIT_CARD']"));
				   
				    // Create an instance of the "allPaymentMethods" class
				    allPaymentMethods bpm = new allPaymentMethods();
				    
				    JavascriptExecutor js = (JavascriptExecutor) driver;	    		  
		    		js.executeScript("window.scrollBy(0,900)", "");
				    
				    // Determine the payment method and proceed accordingly
				    if(brainTree.size()>0) {
				    	
				    	bpm.BrainTreeMethod();
				    	//bpm.addNewCardThoughExistingCards();
				    	
				    } else if(creditcardsSalesForce.size()>0) {
				    	
				    	bpm.salesForce();
				    	
				    } else if(stripePayment.size()>0) {
				    	
				    	bpm.stripe();	
				    	
				    	//wantedly calling 
				    		 //bpm.addNewCardThoughExistingCards();
				    	
				    } else if(cyberSourcePayment.size()>0){
				    	
				    	//guest and reg user
				    		bpm.cyberSource();
				    	
				    	//adding new paymnet
				    		//bpm.addNewCardThoughExistingCards();
				    	
				    	//backToSavedCards
				    		//paymentMethods  pp = new  paymentMethods ();
				    		//pp.backToSavedCards();
				    	
				    }		
		
				    // Salesforce payment integration: place the order
				    if(creditcardsSalesForce.size()>0) {
				    	logger.info("Clicking the Salesforce place the order");
				    	paymentpPage pp = new paymentpPage(driver);
				    	// Click the place order button
				    	pp.placetheOrder(driver);
				    	
				    } else {
				    	// Review order page
			    		reviewOrderPage rop = new reviewOrderPage(driver);
			    		Thread.sleep(4000);			    		
			    		// Locate the review order button
			    		WebElement reviewOrder= driver.findElement(By.xpath("//button[contains(text(), 'Next: Review Order')]"));	
			    		
			    		if(reviewOrder.isDisplayed()) {
				    		rop.clickonReviewOrder(driver);
				    		logger.info("Clicked on review order button");
				    		Thread.sleep(4000);		    		
			    		}
			    		//locate the placeorder
			    		 WebElement placeOrderButton= driver.findElement(By.cssSelector("button.place-order"));	    	
			    		
			    		if (placeOrderButton.isDisplayed()) { 		    			
			    			 js.executeScript("window.scrollBy(0,350)", "");	    			
			    			 Thread.sleep(2000);
				    		
				    		 rop.clickonplaceorderwithJsExuter(driver);
				    		 logger.info("successfully click on the place order button by normal click");
				    		}
			    		
			    		}
				    
				    Thread.sleep(7000);
					 // Checkout validation
		    		if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
		    			
		    			 Checkout_Validation checkout= new Checkout_Validation();
		    			 
		    		 // Validate the final place the order page
		    			 checkout.validatePlacetheOrderPage();
		    		
		    	     // Order number and order date
		    			 checkout.ordernumberandOrderdate();
		    			 Thread.sleep(5000);
		    		}	 
				}
		  }
	}
 }//method
//class
	
