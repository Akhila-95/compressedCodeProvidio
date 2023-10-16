

package com.RegUserWith_CreditCard;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.SearchingProduct;
import com.providio.commonfunctionality.findAStore;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__BySearchingProduct_RegUser_InCC extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
		if(isLoggedIn) {
			
		// to pick the store
		     findAStore  store = new findAStore();
		     store.findStore();
			
		//searching a product 
			SearchingProduct sp = new SearchingProduct();
			sp.searchingProduct();
		        
	      //checkoutProcess	        
            tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();            
            cp.checkoutprocess();
            
           //payment by credit card
		     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();	     
		     cc.paymentByCreditCard();
		} else {
	        Assert.fail("User not logged in");
	    }
	 
    }
}