package com.RegUserWith_GcAndCC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductsAndBundle_Gc;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.findAStore;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.pageObjects.GiftCertificate;
import com.providio.pageObjects.SimpleProductFromExcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class tc__SimpleProductsAndBundle_Gc_Reg_InGcAndCC extends baseClass {
	 
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void simpleProducts_Bundle_Gc() throws InterruptedException {
		
		if(isLoggedIn) {
			
		// to pick the store
		     findAStore  store = new findAStore();
		     store.findStore();		     
			
		 //adding simple product into cart
	          SimpleProductsAndBundle_Gc spb = new SimpleProductsAndBundle_Gc();
	          spb.simpleProductsAndBundle_Gc();
		
		 //checkoutProcess				        
		     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
		     cp.checkoutprocess();
		     
		  //semi gc and cc 
			 Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
			 gCandCC.paymentProccessByGCandCC(driver);
			
		 } else {
		        Assert.fail("User not logged in");
		    }
}
}
