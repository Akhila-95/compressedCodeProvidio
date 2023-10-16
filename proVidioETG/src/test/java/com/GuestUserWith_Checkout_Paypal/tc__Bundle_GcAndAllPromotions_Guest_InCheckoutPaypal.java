package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.commonfunctionality.findAStore;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.paymentProccess.tc__MiniCartCheckoutButton;
import com.providio.testcases.baseClass;

public class tc__Bundle_GcAndAllPromotions_Guest_InCheckoutPaypal extends baseClass{
	 
	@Test
	public void bundle_GcAndAllPromotions() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
		//pick up store
		findAStore  store = new findAStore();
	    store.findStore();
		
		//promotions
		Bundle_GcAndAllPromotions bgs = new Bundle_GcAndAllPromotions();
		bgs.bundleGcandallpromotions();
		 
		 //checkoutProcess
        tc__MiniCartCheckoutButton cp = new tc__MiniCartCheckoutButton();         
		cp.checkoutprocess();
	     
	    //paypal process from checkout page
		 tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
		 cpp.checkoutprocessFromCheckout();
	
		 
	}
}
