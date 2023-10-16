package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProduct;
import com.providio.commonfunctionality.findAStore;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__SimpleProductAndGc_InCheckout_Paypal extends baseClass {
	
	  
	@Test
	public void simpleProduct_Gc() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();

		// to pick the store
	     findAStore  store = new findAStore();
	     store.findStore();
		
		//simple product
	    SimpleProduct sp = new SimpleProduct();
	    sp.simpleProdcut();
		

		 //checkoutProcess				        
	     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
	     cp.checkoutprocess();
	     
	    //paypal process from checkout page
		 tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
		 cpp.checkoutprocessFromCheckout();
	}
	
}
