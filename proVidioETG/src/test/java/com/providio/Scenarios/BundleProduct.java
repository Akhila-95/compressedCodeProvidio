package com.providio.Scenarios;

import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.allAttributesinOneFile;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.testcases.baseClass;

public class BundleProduct extends baseClass{
	
	public void bundleproduct() throws InterruptedException {
		 
		 //searching the bundle product from excel sheet
		 BundleProductFromEXcel bundleProduct = new  BundleProductFromEXcel();
		 bundleProduct.performRandomOperations(driver);
		 logger.info("Searched a product");

			//Selecting the attributes
		    allAttributesinOneFile.selectTheAttributesInPdp(driver);
    	
    	//validating the product is add to the cart
    	addtoCartValidation.validatingProductisAddtoCart(driver);
	
	}

}
