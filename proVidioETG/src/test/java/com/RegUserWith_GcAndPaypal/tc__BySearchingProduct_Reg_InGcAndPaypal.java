

package com.RegUserWith_GcAndPaypal;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.SearchingProduct;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.findAStore;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__BySearchingProduct_Reg_InGcAndPaypal extends baseClass {
	 
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
    	    
			    
		       	
				
		     //gc and paypal
				Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
				gcAndPaypal.paymentProccessByGCandPaypal();
				
		 }else {
		   	 Assert.fail("User not logged in");
		   }
    }
}