package com.providio.Scenarios;

import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.allAttributesinOneFile;
import com.providio.pageObjects.VariationProductFromExcel;
import com.providio.testcases.baseClass;

public class VariationProduct extends baseClass{

	public void variationProduct() throws InterruptedException {
		  
		 //searched for variation product
		 VariationProductFromExcel fromExcel = new VariationProductFromExcel();
		 fromExcel.performRandomOperations(driver);
		 logger.info("searched for Variation product");

		//Selecting the attributes
		    allAttributesinOneFile.selectTheAttributesInPdp(driver);
		    
	 		//validating the product is add to the cart
	  	    addtoCartValidation.validatingProductisAddtoCart(driver);

	}

}
