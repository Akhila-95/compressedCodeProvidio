package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.VariationProduct;
import com.providio.commonfunctionality.findAStore;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;


public class tc__VariationProductForGuestUser_InCheckoutPaypal extends baseClass{
	
	 
	 @Test
	public void variationProduct() throws InterruptedException {
		 

			//launching browser
				launchBrowsering lb = new launchBrowsering();
				lb.chromeBrowser();
		 	
			// to pick the store
			     findAStore  store = new findAStore();
			     store.findStore();
				
			//variation product	 
				 VariationProduct product = new VariationProduct();
				 product.variationProduct();
		
        //checkoutProcess	        
				tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();         
				cp.checkoutprocess();

		//paypal process from checkout page
				tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
				cpp.checkoutprocessFromCheckout();
	 }
}

