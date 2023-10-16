package com.providio.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.providio.Validations.navigationProcessWithValidation;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;

public class allAttributesinOneFile extends baseClass{
	
	
	public static  void selectTheAttributesInPdp(WebDriver driver) throws InterruptedException {
		
		//selecting attributes from the  pdp page by checking the condition 
		allAttributes();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
     
		//to pick the store in pdp page 
	 List  <WebElement> pickUpStore =driver.findElements(By.id("delivery-options-store"));
	 if(pickUpStore.size()>0) {
		 test.info("Pick up store is available for cybersource and stripe");
		 WebElement pickUpStoreenabled =driver.findElement(By.id("delivery-options-store"));
		 if(pickUpStoreenabled.isEnabled()) {
			 js.executeScript("arguments[0].click();",pickUpStoreenabled);
			 test.info("Selected the pickUp in Store");
		 }else {
			 test.info("Pick up store is not available for this product");
		 }
	 }else{
	/*	test.info("Order groove is in Brain tree payment ");
		WebElement subscriptionButton =driver.findElement(By.id("main-optin-button"));
		subscriptionButton.click();
	
		Thread.sleep(1000);
		// Locate the select element
        WebElement selectElement = driver.findElement(By.tagName("og-select-frequency"));
        
        // Get a list of all available options
        List<WebElement> options = selectElement.findElements(By.tagName("option"));
        
        // Generate a random index within the range of available options
        int randomIndex = (int) (Math.random() * options.size());
        
        // Click the randomly selected option
        options.get(randomIndex).click();
        Thread.sleep(1000);*/
	 }
	 
	//checking the  add to cart enabled and  in stock
    		List<WebElement> Stocksize = driver.findElements(By.xpath("//div[contains(text(), 'This item is currently not available')]"));
     		test.info("Verify that the product is avaliable");
     	    // Check if the element is present
     	    if (Stocksize.size() <= 0) {
     	    	test.pass("The product is avaliable");
     	    	
     	    	List<WebElement> addtoCartButton = driver.findElements(By.xpath("//button[contains(@class, 'add-to-cart')]"));
     	    	List<WebElement> addAlltoCartButton = driver.findElements(By.xpath("//button[contains(@class, 'add-to-cart-global')]"));
     	    	
     	    	//addtocartbutton is enabled
     	    	test.info("Verify that the product is avaliable");
     	    	if(addAlltoCartButton.size()>0) {
     	    		test.info("Verify that the add all to cart button");
     	    		logger.info("addallto button enabled");
     	    		WebElement addalltoCartButtonClick = driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart-global')]"));  	   		   
     	    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addalltoCartButtonClick);
     	    	 	js.executeScript("arguments[0].click();", addalltoCartButtonClick);
    	            test.pass("Successfully clicked on the add all to cart button");
     	    		//addalltoCartButtonClick.click();
     	    		
     	    	}else if(addtoCartButton.size()>0) {
     	    		test.info("Verify that the add to cart button");
     	    		logger.info("add to cart  button enabled");
     	    		WebElement addtoCartButtonClick = driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart')]"));
     	    		
     	            js.executeScript("arguments[0].click();", addtoCartButtonClick);
     	           test.pass("Successfully clicked on the add to cart button");
     	    		//addtoCartButtonClick.click();
     	    	}
      
     	    }else {
    	 
    	 	//if the prodcut is outof stock then it will search for new prodcut by selecting random menu and random product
     	    	System.out.println("Product is out of stock so searching for new product");	    	
    	 	
	    	 	navigationProccess  navProccess  = new navigationProccess ();	
	    	 	navProccess.commonNavigationProccess();
     }	    
	     
	}

	public static void allAttributes() throws InterruptedException {
		
		//fetching the to collect the total number of div contains attributes  
		List <WebElement> mainDiv= driver.findElements(By.xpath("//div[@class='attributes px-0']"));
		System.out.println("The total number of size division are " +mainDiv.size());
		
		//fetching  all the attributes in pdp page 
		//fetching the color element in drop down
		List<WebElement> colorElement = driver.findElements(By.xpath("//span[contains(@class,' non-input-label')]"));
		System.out.println("The colordrop down count is " + colorElement.size());
		
		//fetching dropdown element in size
		List<WebElement> sizeElement = driver.findElements(By.xpath("//select[contains(@class,'select-size')]"));
		System.out.println("The size drop down count  is " +  sizeElement.size());
		
		//fecthing memeorysize element in dropdown
		List<WebElement> memoryElement = driver.findElements(By.id("memorySize-null"));
		
		//fetching width elements in drop down 
	    List<WebElement> widthElements = driver.findElements(By.cssSelector("select.select-width"));
        System.out.println(widthElements.size());
     
        //fetching showname element in drop down
        List<WebElement> showName = driver.findElements(By.xpath("//select[contains(@class,'select-showName')]"));
        System.out.println(showName.size());
	     
	     //another way of attributes :- selecting the attributes from box type
	     
        //fetching size elements from boxtype 
	     List<WebElement> sizeBox= driver.findElements(By.cssSelector("div.select-size"));
	     
	     //fetching color element from box type
	     List<WebElement> colorBox= driver.findElements(By.xpath("//button[contains(@class,'color-attribute')]"));
	     
	     //fetching thememory element from box type
	     List<WebElement> memoryBox = driver.findElements(By.xpath("//div[contains(@class, 'select-memorySize')]"));
	     
	     //fetching the wiodth elements from box type 
		 List<WebElement> widthBox = driver.findElements(By.xpath("//div[contains(@class, 'select-width')]"));
		
		 // fetching show name from box type 
		 List<WebElement> showNameBox= driver.findElements(By.cssSelector(".showName"));
		 
		 // fetching the extended warranty eleent from box type
		 List<WebElement> extendedWarranty = driver.findElements(By.className("options-select"));
	     
	     for(int i=1; i<=mainDiv.size();i++) {
	    	 
			if(colorElement.size()>0|| colorBox.size()>0) {
				attributesSelection.colorSelection();
				System.out.println("selected color");
				Thread.sleep(1000);
			}if(sizeElement.size()>0|| sizeBox.size()>0 ) {
				attributesSelection.sizeSelction();
				System.out.println("selected size");
				Thread.sleep(1000);					
			} if(memoryElement.size()>0||  memoryBox.size()>0) {
				attributesSelection.memorySelection();
				System.out.println("selected memory size");
				//Thread.sleep(1000);
			} if(widthElements.size()>0 || widthBox.size()>0) {	
				attributesSelection.widthSelection();
				System.out.println("selected width");
				//Thread.sleep(1000);
			}if(showName.size()>0 || showNameBox.size()>0) {
				//Thread.sleep(1000);
				attributesSelection.selectShowName();
				System.out.println("Selected show name ");
			}if(extendedWarranty.size()>0) {
				attributesSelection.selectExtendedWarranty();
				System.out.println("Selected extended warranty ");
			}
	     }
	     
		//validating the product is instock and adding to the cart
		  //validatingInstock.inStockValidation();
	     
	}
	
	public static void quickshopallAttributes() throws InterruptedException {
		//finding the how many size elements are there in the page and after that itterating the how many size elements need to select the each one 
        List<WebElement> countofSizeElement = driver.findElements(By.xpath("//select[contains(@class, 'select-size')]"));
        logger.info("countofSizeElement: "+countofSizeElement.size());
        //if incase size element is not there means need to find the what other element is there on the page and select that one 
        List<WebElement> countofmemorysize = driver.findElements(By.xpath("//select[contains(@class, 'select-memorySize')]"));
        logger.info("countofmemorysize: "+countofmemorysize.size());
        
        //size should be greater than one 
        if(countofSizeElement.size()>0) {
        
        //iterating the size elements more than one
	     for(int p = 1; p <= countofSizeElement.size(); p++) {
	    	 
           //Find the parent div element that contains size and width elements
              WebElement parentDiv = driver.findElement(By.xpath("(//div[@class ='attributes px-0'])["+p+"]"));

          //Verify the presence of size element within the parent div
   	       List<WebElement> sizeElements = driver.findElements(By.xpath("//select[contains(@class, 'select-size')]"));
   	       System.out.println("sizeElements:"+sizeElements.size());
   	       //Verify the presence of width element within the parent div
   	       List<WebElement> widthElements = driver.findElements(By.xpath("//select[contains(@class, 'select-width')]"));
   	       System.out.println("widthElements: "+widthElements.size());
  	       //Verify the presence of color element within the parent div
   	       List<WebElement> colorElement = driver.findElements(By.xpath("//select[contains(@class, 'select-color')]"));
   	       System.out.println("colorElement: "+colorElement.size());
   	       
   	       //validating the all the attributes are present in any pdp
   	       if(sizeElements.size()>0&&widthElements.size()>0&&colorElement.size()>0) {

   	    	//selcting the color   
   	    	attributesSelection.colorSelection();
   	    	Thread.sleep(3000);
   	    	//select the size
   	    	attributesSelection.sizeSelction();
   	    	Thread.sleep(3000);
   	    	//select the width
   	    	attributesSelection.widthSelection();
   	    	Thread.sleep(5000);
   	    	//validate the product is instock or not
   	    	//validatingInstock.inStockValidation();

   	       }else if(sizeElements.size()>0&&colorElement.size()>0) {
   	    	   
   	    	//selecting the color   
   	    	attributesSelection.colorSelection();
   	    	Thread.sleep(3000);
   	    	//select the size
   	    	attributesSelection.sizeSelction();
   	    	Thread.sleep(3000);
   	    	Thread.sleep(5000);
   	    	//validate the product is instock or not
   	    	//validatingInstock.inStockValidation();
   	    	   
   	       }
   	       
	     }
	     //selecting the memory size of the product
        }else if(countofmemorysize.size()>0) {
        	
   	    	attributesSelection.memorySelection();
   	    	Thread.sleep(3000);
   	    	Thread.sleep(5000);
   	    	//validate the product is instock or not
   	    	//validatingInstock.inStockValidation();
        	logger.info("memory size");

        }else {
        	
   	    	//validate the product is instock or not
   	    	//validatingInstock.inStockValidation();
        }
        Thread.sleep(3000);

	}

}
