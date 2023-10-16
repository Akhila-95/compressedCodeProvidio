package com.providio.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.Validations.navigationProcessWithValidation;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;

public class navigationProccess extends baseClass {
	
	 
	
	public void commonNavigationProccess() throws InterruptedException {
		
		for(int i=1;i<=1; i++) {
			
			 // to pick the store
			     findAStore  store = new findAStore();
			     store.findStore();
			
			//navigating to random menu by validating the plp page  
				 navigationProcessWithValidation  navPage =new navigationProcessWithValidation (driver);
		    	 navPage.selectRandomMenu(driver);
	    	
		    //apply filters to products		    	
		    	 selectingFilterFromPlp. selectingFilterisFormplp();
		    	 
	    	//selecting Random product
				productListingPage plp = new productListingPage(driver);
				plp.selectProductRandom(driver);
	   	
			//selecting attributes from the  pdp page by checking the condition 
		   		 List<WebElement> pdpPage = driver.findElements(By.xpath("//button[contains(@class,'add-to-cart btn btn-primary')]"));
		   		 if( pdpPage.size()>0) {
		   			allAttributesinOneFile.selectTheAttributesInPdp(driver);
			    		 }
	   	  //validating the product is add to the cart
	  	         addtoCartValidation.validatingProductisAddtoCart(driver);
	    }			
	}
	
	
	public void configuredCategoryForBuyNow() throws InterruptedException {
			
			navigationPage navPage= new navigationPage(driver);
			
			//hover on electronics
				navPage.clickelectronicsMenu(driver);
				
			//click on GPS navigation 
				navPage.ClickelectronicsofGpsUnits();
				test.info("Entered into Gps unit  menu");
				
			//selecting Random product
				productListingPage plp = new productListingPage(driver);
				plp.selectProductRandom(driver);	
	    	 
			//selecting attributes from the  pdp page by checking the condition 
				List<WebElement> pdpPage = driver.findElements(By.xpath("//button[contains(@class,'add-to-cart btn btn-primary')]"));
		   		 if( pdpPage.size()>0) {
		   			allAttributesinOneFile.selectTheAttributesInPdp(driver);
			    		 }  	 
			
			// no Product add to cart validation for buy now 
	}
}
