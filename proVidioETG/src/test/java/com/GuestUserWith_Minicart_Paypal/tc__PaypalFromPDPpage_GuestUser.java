package com.GuestUserWith_Minicart_Paypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.PaypalBuyNowInPDP;
import com.providio.commonfunctionality.navigationProccess;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__PaypalFromPDPpage_GuestUser  extends baseClass{
	 
	@Test
	public void paypalFromPDPpage() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
       
		 //navigates to pdp page randomly
	     navigationProccess nav = new navigationProccess();
	     nav.commonNavigationProccess();
			
		
	  //paypal buy now button
	        
	    		 List<WebElement> paypalbuyNowPdp =driver.findElements(By.xpath("//div[contains(@class,'salesforce-buynow-element ')]"));
	    		 if( paypalbuyNowPdp.size()>0) {
	    			 
	    			 PaypalBuyNowInPDP s = new PaypalBuyNowInPDP();	    			    
	    			 s.paypalBuyNowFromPDP(driver);
	    				

    				//paypal checkout procces
    					tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();
    			        Thread.sleep(5000);
    			        paypal.paypalCheckoutFromPDP();
		    		 }
	    		 else {
	    			 test.pass("Paypal buy now is only in salsforce payment not in cybersource and brain tree");
	    		 }
	       
		
	      

		
	}
}
