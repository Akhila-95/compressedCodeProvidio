package com.providio.paymentProccess;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.providio.Validations.CartPageValidation;
import com.providio.Validations.QuantityValidation;
import com.providio.Validations.miniCartAndCartValidation;
import com.providio.commonfunctionality.CommonProccessFromMiniCartForViewCartAndCheckout;
import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.guestUserLoginPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.testcases.baseClass;
import com.providio.testcases.tc__TaxCalculationCheckoutPage;

public class tc__MinicartViewCartProcess extends baseClass {
	
	
	
    public void checkoutprocess() throws InterruptedException {

       List <WebElement> minicartcount = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));
     
       //CommonProccessFromMiniCartForViewCartAndCheckout 
       CommonProccessFromMiniCartForViewCartAndCheckout  commonProccess= new CommonProccessFromMiniCartForViewCartAndCheckout ();
       
       // minicart and check out validation
       miniCartAndCartValidation validation= new miniCartAndCartValidation();
	       if(minicartcount.size()>0) {
	    	   WebElement miniCartDisplay = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
	    	   if(miniCartDisplay.isDisplayed()) {
		    	   WebElement minicartcount1 = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
		    	   String countOfMinicart = minicartcount1.getText();
		    	   int minicartCountValue = Integer.parseInt(countOfMinicart);
		
		        if (minicartCountValue > 0) {		
		            miniCartPage mc = new miniCartPage(driver);		            
		            Thread.sleep(5000);		               
		            //click on the cart button
		            mc.clickcartbutton(driver);
		            Thread.sleep(1000);
		            
		            List <WebElement> minicartPopUp = driver.findElements(By.xpath("(//h1)[1]"));
		            if(minicartPopUp.size()>0) {
		            	
			            //validate the button click 			          
			            validation.validateMiniCartClick();
	         
			            Thread.sleep(1000);
			            //clicks on view cart button 
			            mc.clickviewCartButton(driver);
						logger.info("clicked the view cart button in the minicart");
						
						//validate the view cart button click
						validation.validateViewCartClick();
						Thread.sleep(1000);
						
						CartPageValidation cartPage =new CartPageValidation();
						cartPage.cartPage(driver);
		            }
		
		            viewCartPage vcp = new viewCartPage(driver);
		            
		            //click the checkout button
		           // validation.validateCheckoutafterClick();
		            vcp.clickCheckout(driver);
		            Thread.sleep(1000);
		
		            //Taxcalculation
		            
		           // tc__TaxCalculationCheckoutPage tc = new tc__TaxCalculationCheckoutPage();           
		           // tc.taxCalculation();
		            
		           //if any guest user means guest checkout
		            commonProccess.clickContinueAsGuest();
		            Thread.sleep(2000);
		            
		            //verifying the availability of shipping or pick store size
		            
		            List<WebElement> shippingLabel= driver.findElements(By.xpath("(//h2[contains(text(),'Shipping')])[2]"));
		            
		            List<WebElement> pickUpStoreLabel= driver.findElements(By.xpath("(//span[contains(text(),'Store Pickup')])[1]")); 
		            
		            List<WebElement> enterAddressList= driver.findElements(By.xpath("(//button[contains(text(),'Enter Address')])[2]")); 
		            
		            List<WebElement> storePickUpList= driver.findElements(By.xpath("(//span[contains(text(),'Store Pickup')])[2]")); 
		            
		            if(shippingLabel.size()>0)  {
		            	
		            	WebElement shippingLabelDisplay= driver.findElement(By.xpath("(//h2[contains(text(),'Shipping')])[2]"));
			            	
			            	if(shippingLabelDisplay.isDisplayed() && !(enterAddressList.size()>0)) {
			            		
				            	checkOutPage cp = new checkOutPage(driver);
				            	
				            	//selecting shipping address
				            	commonProccess.selectShippingAddress(cp);
	
					            commonProccess.selectPaymentMethod(cp);
					            
			            	}else if(pickUpStoreLabel.size()>0) {
				            	
			            	    // enter the name and address details
			            	    checkOutPage cp = new checkOutPage(driver);
				            	
				            	//when bipois are enabled,store pickup works, and this code executes				            				            	
				            	commonProccess.selectPaymentMethod(cp);
				            		
				            	//entering billing address details			            		
				            	commonProccess.selectBillingAddress(cp);
				            }		   
		            
		            } if(enterAddressList.size()>0 && storePickUpList.size()>0) {
		            	
		            	test.info("The  products are from store pick up and delivery to address");
		            	
		                WebElement enterAddressDisplay= driver.findElement(By.xpath("(//button[contains(text(),'Enter Address')])[2]"));
		               
			               if(enterAddressDisplay.isDisplayed()) {
			            	   
				            	test.info("In cart some  products are from store so , we have to enter the address to deliver normal products");
				            	
				            	//total div of multi shipping
				            	 WebElement parentmultiShipping= driver.findElement(By.xpath("(//div[contains(@class,'multi-shipping')])[1] "));
				            	 
				            	 //click on enter address
				            	 WebElement enterAddress= parentmultiShipping.findElement(By.xpath("((//div[contains(@class,'multi-shipping')])[1]//form[@id='dwfrm_shipping'])[1]"));
				            	
				            	 enterAddress.click();
				            	 
				            	 // enter the name and address details
				            	 checkOutPage cp = new checkOutPage(driver); 		            	 
				            	 
				            	 Thread.sleep(1000);
				            	 commonProccess.selectShippingAddress(cp);
				            	 
				            	 //save the address
				            	 WebElement saveTheAddressButton= driver.findElement(By.xpath("(//button[contains(@class,'save-shipment')])[2]"));
				            	 JavascriptExecutor js = (JavascriptExecutor)driver;
			                     js.executeScript("arguments[0].click();",saveTheAddressButton);
				            	
			                     Thread.sleep(2000);
			                     commonProccess.selectPaymentMethod(cp);
				            	 //click on enter address
			               }
		             
		        	}else {
		            	//if Only Gc added to cart then this snippet executes 
		        		 test.info("As only Gift cart is in cart ");
		        		
	            		 List<WebElement> billingAddress= driver.findElements(By.xpath("//label[contains(text(),'Billing Address')]"));		            	
		            	 checkOutPage cp = new checkOutPage(driver);
		            	 
			            	 if(billingAddress.size()>0) {
			            		 
			            		 commonProccess.selectBillingAddress(cp);
			            		 	
			            		 commonProccess.selectPaymentMethod(cp);
		            	 }		          
		        } 
		        
		       }/*else {
		            logger.info("The cart value is empty");
		            test.fail("The cart value is empty");
		       }*/
	       }
	     } 
	  }
    } 
   
	  

