package com.RegUserWith_GcAndCC;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.findAStore;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__Bundle_GcAndAllPromotions_Reg_InGcAndCC extends baseClass{
	 
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void bundle_GcAndAllPromotions() throws InterruptedException {
		
		if(isLoggedIn) {   
		 
		// to pick the store
		     findAStore  store = new findAStore();
		     store.findStore();
		     
		//promotions
			 Bundle_GcAndAllPromotions bgs = new Bundle_GcAndAllPromotions();
			 bgs.bundleGcandallpromotions();
		 
		//checkoutProcess				        
		     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
		     cp.checkoutprocess();
		     
		 //semi gc and cc 
			 Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
			 gCandCC.paymentProccessByGCandCC(driver);
		
		}else {
		   	 Assert.fail("User not logged in");
		   }
		 
	}
}
