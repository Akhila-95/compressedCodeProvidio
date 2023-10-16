package com.RegUserWith_MiniCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.BundleProduct;
import com.providio.Scenarios.SimpleProduct;
import com.providio.Scenarios.giftCard;
import com.providio.testcases.baseClass;

public class tc__ShippingAndBillingAddressDiffer_Reg_InMC_Paypal extends baseClass{
	 
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void shippingAndBillingAddressDiffer_Guest() throws InterruptedException {
		
		if(isLoggedIn) {     
			
			BundleProduct  product = new BundleProduct ();
			product.bundleproduct();
			
			 //adding GC into cart
		    giftCard gc = new giftCard();
		    gc.giftCards();
			 		    
		  //simple product
		    SimpleProduct sp = new SimpleProduct();
		    sp.simpleProdcut();
		    
		}else {
		   	 Assert.fail("User not logged in");
		   }
		
	}
}
