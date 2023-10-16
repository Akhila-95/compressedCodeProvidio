package com.GuestUserWith_Minicart_Paypal;

import org.testng.annotations.Test;

import com.providio.commonfunctionality.findAStore;
import com.providio.commonfunctionality.navigationProccess;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__PaypalCheckout_MiniCart_GuestUser extends baseClass {
	int  minicartCountValue=0;
@Test
	public void paypalCheckout_MiniCart() throws InterruptedException {
		
			//launching the browser and passing the url into it
				launchBrowsering lb = new launchBrowsering();
				lb.chromeBrowser();
		       
		      // to pick the store
			     findAStore  store = new findAStore();
			     store.findStore();
			     
		     //selects a random catgory and product add to cart
		         navigationProccess navProccess = new navigationProccess();
		         navProccess.commonNavigationProccess();
		    
	         //checkout from mini cart by paypal	        
		        tc__CheckOutProcessByPayPal checkOutProcessByPayPal= new tc__CheckOutProcessByPayPal();
		        checkOutProcessByPayPal. checkoutprocessFromMiniCart();
	}

}
