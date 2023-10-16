package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.Scenarios.SearchingProduct;
import com.providio.Scenarios.SimpleProduct;
import com.providio.commonfunctionality.findAStore;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__Bundle_GcAndAllPromotions_Guest_InCC extends baseClass{
	 
	@Test
	public void bundle_GcAndAllPromotions() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
		// to pick the store
	     findAStore  store = new findAStore();
	     store.findStore();
	     
		//pramotions
		 Bundle_GcAndAllPromotions bgs = new Bundle_GcAndAllPromotions();
		 bgs.bundleGcandallpromotions();
		  
	  //searching a product 		
		 SearchingProduct sp = new SearchingProduct();
		 sp.searchingProduct();
		 
		//checkoutProcess				        
	     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
	     cp.checkoutprocess();
	     
	     //payment process
         tc__CreditCardPaymentProcess tc = new tc__CreditCardPaymentProcess();			              
         tc.paymentByCreditCard();
	
		 
	}
}
