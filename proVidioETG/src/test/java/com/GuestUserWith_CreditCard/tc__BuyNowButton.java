package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.providio.Validations.Checkout_Validation;
import com.providio.commonfunctionality.BuyNowInPDP;
import com.providio.commonfunctionality.findAStore;
import com.providio.commonfunctionality.navigationProccess;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class tc__BuyNowButton extends baseClass{
	@Test
		public void buynow() throws InterruptedException {
				
					//launching the browser and passing the url into it
					launchBrowsering lb = new launchBrowsering();
					lb.chromeBrowser();
					
				 // to pick the store - have to check whether buy now button with pick up store 
				     findAStore  store = new findAStore();
				     store.findStore();
				
				  //selects a random category and product add to cart
			          navigationProccess navProccess = new navigationProccess();
			          navProccess.configuredCategoryForBuyNow();
			       
			      //click on buy now    
			          BuyNowInPDP buyNow= new BuyNowInPDP();
			          buyNow.clickOnBuyNow(driver);
		    	    			          
		          //payment process             
				     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();		     
				     cc.paymentByCreditCard();
				     
			           	
	    	}
}
