package com.GuestUserWith_ViewCart_Paypal;

import org.testng.annotations.Test;

import com.providio.commonfunctionality.findAStore;
import com.providio.commonfunctionality.navigationProccess;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__PaypalFromViewCartPage_GuestUser extends baseClass {
	 
	@Test
	public void paypalFromViewCartPage() throws InterruptedException {
			//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
		
			
		// to pick the store
		     findAStore  store = new findAStore();
		     store.findStore();
	     
		  // selects a random catgory and product add to cart
	          navigationProccess navProccess = new navigationProccess();
	          navProccess.commonNavigationProccess();
	          
	     
    	 //paypal checkout form view cart page
 	          tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();	         
 	          paypal.checkoutprocessFromViewCart();
   
		        }

}
