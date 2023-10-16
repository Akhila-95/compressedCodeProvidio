package com.GuestUserWith_Minicart_Paypal;

import org.testng.annotations.Test;
import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.commonfunctionality.findAStore;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__Bundle_GcAndAllPromotions_Guest_InMC_Paypal extends baseClass{
	 
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
		
	  //checkout from mini cart by paypal	        
	      tc__CheckOutProcessByPayPal checkOutProcessByPayPal= new tc__CheckOutProcessByPayPal();
	      checkOutProcessByPayPal. checkoutprocessFromMiniCart();
	
		 
	}
}
