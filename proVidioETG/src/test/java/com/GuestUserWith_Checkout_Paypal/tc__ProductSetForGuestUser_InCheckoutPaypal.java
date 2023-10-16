package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.ProductSet;
import com.providio.commonfunctionality.findAStore;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;
public class tc__ProductSetForGuestUser_InCheckoutPaypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	@Test 
	public void productSet() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
		
		// to pick the store
	     findAStore  store = new findAStore();
	     store.findStore();
	     
		//product set
		ProductSet ps = new ProductSet();
		ps.productSet();
		 	
	    //checkoutProcess		        
		tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	         
        cp.checkoutprocess();
	        
		//paypal process from checkout page
		 tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
		 cpp.checkoutprocessFromCheckout();
	    } 
}

