package com.providio.Scenarios;

import com.providio.Validations.preValidationCheck;
import com.providio.testcases.baseClass;

public class Bundle_GcAndAllPromotions extends baseClass{

	public void bundleGcandallpromotions() throws InterruptedException {
		
		
	    //validation Home page
	    preValidationCheck.prevalidationHome(driver);
	 
		 //searching the bundle product from excel sheet
	    BundleProduct bp = new BundleProduct();
	    bp.bundleproduct();

		 //adding GC into cart
	    giftCard gc = new giftCard();
	    gc.giftCards();
		 
		//simple product
	    SimpleProduct sp = new SimpleProduct();
	    sp.simpleProdcut();
	}
}
