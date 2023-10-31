package com.providio.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.providio.Validations.BuyNowValidation;
import com.providio.Validations.Checkout_Validation;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class BuyNowInPDP extends baseClass {

public void clickOnBuyNow(WebDriver driver) throws InterruptedException {

			
		//checking the buy now button is enabled and in stock after selecting the attributes 	
	     productDescriptionPage pdp = new productDescriptionPage(driver);
	     List<WebElement> buyNowList =driver.findElements(By.xpath("//button[contains(@class,'buy-now btn btn-primary')]"));
	     List<WebElement> inStock =driver.findElements(By.xpath("//div[contains(text(), 'In Stock')]"));
	     
	    	 if((buyNowList.size()>0)&& inStock.size()>0) {
	    		 WebElement buyNowEnabled =driver.findElement(By.xpath("//button[contains(@class,'buy-now btn btn-primary')]"));
	    		 if(buyNowEnabled.isEnabled()) {
	    			 
		    	 // verifying the buynow button is displayed or not 
		    	 Thread.sleep(3000);	    	 
		    	// WebElement buyNowDisplayed =driver.findElement(By.xpath("//button[contains(@class,'buy-now btn btn-primary')]"));
			     test.info("Verifying Buy now button in PDP");
			     
				    // if(buyNowDisplayed .isDisplayed()) {
				    	 //clicking  on buy now button in pdp page 
				    	 Thread.sleep(3000);
					     pdp.clickOnBuyNowButton(driver);
					     Thread.sleep(6000);	
				    	 test.pass("Successfully clicked on buy now button");
				    	 List<WebElement> shippingLabel =driver.findElements(By.xpath("(//h2[contains(text(),'Shipping')])[2]"));
				    	 List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));
				    	 List<WebElement> buyNowPopUp = driver.findElements(By.xpath("(//div[@class='modal fade buy-now show'])[1]"));// (//div[@class='modal fade buy-now show'])[1]//div[@class='modal-content']
				    	

				    	 if(continueasAGuest.size()>0) {
						    		test.info("User is guest");
						    		
						    		Thread.sleep(5000);
						    		//if user guest means guest checkout is same fo brain tree and cybersource			    		
						    	       CommonProccessFromMiniCartForViewCartAndCheckout  commonProccess= new CommonProccessFromMiniCartForViewCartAndCheckout ();					    	       
						               commonProccess.clickContinueAsGuest();
							    	 if(shippingLabel.size()>0) {
							    		// address details
							    		 Thread.sleep(2000);
								            AddressDetails address = new AddressDetails();
								            address.address();
							    	 }			   								    	 
					    	 }else if(buyNowPopUp.size()>0) {
					    		
						    		 test.info("User is registered and will get buy now pop up only for stripe and brain tree payments Not in Salesforce and Cybersource");
							    		 //buy now validation
									     Thread.sleep(5000);			     
									     BuyNowValidation buy = new BuyNowValidation();
									     buy.buynow(driver);
								     
									     //clicking on place order button 
									     List<WebElement> buyNowPlaceOrderList =driver.findElements(By.xpath("(//a[contains(@class,'buynow-placeorder')])[1]"));
									     if(buyNowPlaceOrderList.size()>0) {
									    	 
											     WebElement buyNowPlaceOrder =driver.findElement(By.xpath("(//a[contains(@class,'buynow-placeorder')])[1]"));
											   if(buyNowPlaceOrder.isDisplayed()) {
												     buyNowPlaceOrder.click();
												     test.info("Clicked on  place order button");
												     Thread.sleep(7000);
													 // Checkout validation
										    		if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
										    			
										    			 Checkout_Validation checkout= new Checkout_Validation();
										    			 
										    		 // Validate the final place the order page
										    			 checkout.validatePlacetheOrderPage();
										    		
										    	     // Order number and order date
										    			 checkout.ordernumberandOrderdate();
										    			 //Thread.sleep(5000);
										    		}	 
											     
											   }else if(shippingLabel.size()>0) {
									    		// address details
										            AddressDetails address = new AddressDetails();
										            address.address();
				      
										        
									    	 }
					    		   
					    		 }
				    	 }
					    	 
		    		else if(shippingLabel.size()>0) {
						    		 test.info("User is registered ,now Cybersource or salesforce actiated and buynow pop up will be only in brain tree and stripe not in cybersource and salesforce So,it will redirect to shipping page");
						    		// address details
							            AddressDetails address = new AddressDetails();
							            address.address();
							            
							            Thread.sleep(3000);
							            
							            //payment by credit card
							 		     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();	     
							 		     cc.paymentByCreditCard();
						    	 }
				    		
					     //}else {
				    	 //test.fail("No  buy now button is clicked");
				   //  }
				
	    		 }else {
	    			 test.pass("Buy now button is not enabled");
	    		 }
		     
	     }else {
	    	//if the product is out of stock then it will search for new prodcut by selecting random menu and random product
	    	 
	    	 	test.info("Product is out of stock so searching for new product");
	    	 	
	    	 //navigating to pdp page 
	    	 	navigationProccess navProccess = new navigationProccess(); 	 
	    	 	navProccess.configuredCategoryForBuyNow();
	    	 	//calling  the same method
	    	 	clickOnBuyNow(driver);	
	     }
	}
	
		
}
