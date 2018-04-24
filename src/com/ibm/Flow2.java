package com.ibm;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Flow2 {
	WebDriver driver;	

	@Test()
	public void homePage() throws Exception{
		
		System.setProperty("webdriver.gecko.driver","C:\\test12\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); //This is the location where you have installed Firefox on your machine
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
		
		driver.get("https://w3-01.ibm.com/tools/wse/runtime/hspx/dev/protect/X0038/xDNSO/page/home?x_role=Noticer");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//for providing username
		driver.findElement(By.xpath(".//*[@id='desktop']")).sendKeys("xxxxxxx");
		Thread.sleep(5000);
		//for providing password
		driver.findElement(By.xpath(".//*[@id='body']/div[1]/div[2]/div/div/form/input[4]")).sendKeys("xxxxxxx");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='btn_signin']")).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Screenshot.CapturexDNSOScreenshot(driver, "User logged in successfully");	
	}
	
	@Test(dependsOnMethods= "homePage")
	public void new_LeadNoticer() throws Exception
	{
		    //clicking new lead tab
			driver.findElement(By.xpath(".//*[@id='ibm-content-wrapper']/header/div[1]/div/ul/li[2]/a")).click();
		    Thread.sleep(8000);
		   
		    //select country
		    Select country = new Select(driver.findElement(By.id("country")));
		    country.selectByVisibleText("France");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	    
	
	        //Select offering family
		    Select offerfamily = new Select(driver.findElement(By.id("Offeringfamily")));
		    offerfamily.selectByVisibleText("IS2");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		    //Select offering name
		    Select offername = new Select(driver.findElement(By.id("Offeringname")));
		    offername.selectByVisibleText("IS2");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		    //estimated value
		    driver.findElement(By.xpath(".//*[@id='Estimatedvalue']")).sendKeys("70");
		    
		    //Values
		    Select values = new Select(driver.findElement(By.id("Value")));
		    values.selectByVisibleText("100-150");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		    //Lead description
		    driver.findElement(By.xpath(".//*[@id='LeadDescription']")).sendKeys("new lead creation");
			Screenshot.CapturexDNSOScreenshot(driver, "Lead details added successfully");
	
	//-----------------------------------Maintenance details----------------------------------------------------
		    
		    //machine type
		     driver.findElement(By.xpath(".//*[@id='machinetype']")).sendKeys("New12345");
		    //model
		     driver.findElement(By.xpath(".//*[@id='model']")).sendKeys("xyz1234");
		    
		    //serial number
		     driver.findElement(By.xpath(".//*[@id='serialnumber']")).sendKeys("987654321");
		    
		    //coverage
		     Select coverage = new Select(driver.findElement(By.id("coverage")));
			 coverage.selectByVisibleText("5x11h");
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		    //address
		     driver.findElement(By.xpath(".//*[@id='installationaddress']")).sendKeys("qwerty 123.456");
	       
	         //click on add
		     driver.findElement(By.name("addmachine")).click();
		     
		     //alert accept
		     driver.switchTo().alert().accept();
		     Thread.sleep(6000);
		       
	//--------------------------------Customer Data----------------------------------------------------- 
		       
		     //click on customer data tab
			 driver.findElement(By.partialLinkText("Customer Data")).click();
			 Thread.sleep(6000);
			   
		     //customer code
			 driver.findElement(By.xpath(".//*[@id='CustomerCode']")).sendKeys("P01690");
			 driver.findElement(By.xpath(".//*[@id='getCustomerDetailsByNumber']")).click();
			 Thread.sleep(10000);
			    
	//----------------------Customer Info---------------------------------------------------------------
			    
			 //Click on Customer Info tab
			 driver.findElement(By.partialLinkText("Customer info")).click();
			 Thread.sleep(6000);
			    
			    //first name
			    driver.findElement(By.xpath(".//*[@id='Firstname']")).sendKeys("Bharathi");
			    
			    //last name
			    driver.findElement(By.xpath(".//*[@id='Lastname']")).sendKeys("Konduru");
			    
			    //Telephone 
			    driver.findElement(By.xpath(".//*[@id='Telephone']")).sendKeys("98765432");
			    
			    //Email
			    driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys("bharathi@gmail.com");
			    Thread.sleep(6000);
			    
   //-----------------------Additional Details---------------------------------------------------
			    
			  //Click on Additional details tab
			    driver.findElement(By.partialLinkText("Additional details")).click();
			    Thread.sleep(6000);
			    
			  //choose focal point
			    Select focalPoint = new Select(driver.findElement(By.id("Choosefocalpoint")));
			    focalPoint.selectByVisibleText("Bharathi-bhakondu@in.ibm.com");
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 
			    //Click on Submit Lead to FP
			     driver.findElement(By.name("evt_submit")).click();
			     Thread.sleep(8000);
			     
			   //alert accept
			     driver.switchTo().alert().accept();
			     Thread.sleep(10000);	
			     Screenshot.CapturexDNSOScreenshot(driver,"lead submitted to FP successfully");
	}
	
	@Test(dependsOnMethods= "new_LeadNoticer")
	public void login_FpRole() throws Exception
	{
		
		//clicking on login for other roles
		driver.findElement(By.xpath(".//*[@id='ibm-content-wrapper']/button")).click();
		Thread.sleep(6000);
		
		//clicking on focal point role
		driver.findElement(By.xpath(".//*[@id='ibm-contact-module']/ul/li[5]/a")).click();
		Thread.sleep(8000);
		
		 //clicking on search lead tab.
		driver.findElement(By.xpath(".//*[@id='ibm-content-wrapper']/header/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(8000);
		
		//clicking on lead id based on country and status:
		//country
		 Select country = new Select(driver.findElement(By.id("Country")));
		  country.selectByVisibleText("France");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//status
		    Select status = new Select(driver.findElement(By.id("status")));
		    status.selectByVisibleText("Assigned to FP");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		  //click on search lead button
		  driver.findElement(By.name("searchLead")).click();
		  Thread.sleep(10000);
		    	    
		//clicking on Lead id
	    driver.findElement(By.xpath(".//*[@id='searchLeadTable']/tbody/tr[1]/td[2]")).click();
		Thread.sleep(8000);
		
		//Click on Additional details tab
	    driver.findElement(By.partialLinkText("Additional details")).click();
	    Thread.sleep(6000);
	    
	    //Choose Opportunity owner
	    Select opportunityRole = new Select(driver.findElement(By.id("ChooseOpportunityOwner")));
	    opportunityRole.selectByVisibleText("Bharathi-bhakondu@in.ibm.com");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    //Click on Approve Lead button
	    driver.findElement(By.name("evt_approvelead")).click();
	    Thread.sleep(8000);
	    
	    //alert accept
	     driver.switchTo().alert().accept();
	     Thread.sleep(10000);		
	     
	     Screenshot.CapturexDNSOScreenshot(driver, "lead submitted to OO successfully");
}
	
    @Test(dependsOnMethods= "login_FpRole")
	public void login_OoRole() throws Exception
	{
		
		//clicking on login for other roles
		driver.findElement(By.xpath(".//*[@id='ibm-content-wrapper']/button")).click();
	    Thread.sleep(6000);
				
		//clicking on  Opportunity owner role
		driver.findElement(By.xpath(".//*[@id='ibm-contact-module']/ul/li[6]/a")).click();
		Thread.sleep(10000);
	   
		 //clicking on search lead tab.
		driver.findElement(By.xpath(".//*[@id='ibm-content-wrapper']/header/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(8000);
		
		
		//clicking on lead id based on country and status:
		//country
		Select country = new Select(driver.findElement(By.id("Country")));
		country.selectByVisibleText("France");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//status
		Select status = new Select(driver.findElement(By.id("status")));
		status.selectByVisibleText("Assigned to OO");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				    	  
		//click on search lead button
		driver.findElement(By.name("searchLead")).click();
		Thread.sleep(10000);
				    
	    //clicking on Lead id
	    driver.findElement(By.xpath(".//*[@id='searchLeadTable']/tbody/tr[1]/td[2]/a")).click();
		Thread.sleep(8000);
		
		//Opportunity number
	     driver.findElement(By.xpath(".//*[@id='Opportunitynumber']")).sendKeys("FX-F4RUALI");
	     
	     //Click on Contract elements tab
	     driver.findElement(By.partialLinkText("Contract Elements")).click();
	     Thread.sleep(6000);
	     
	     //Contract Value
	     driver.findElement(By.xpath(".//*[@id='Contractvalue']")).sendKeys("123456");
		    
		 //Contract Number
		 driver.findElement(By.xpath(".//*[@id='Contractnumber']")).sendKeys("1234abc");
		 
		//Currency
		Select currency = new Select(driver.findElement(By.id("contractCurrency")));
		currency.selectByVisibleText("USD");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
	   //Click on Additional details tab
		driver.findElement(By.partialLinkText("Additional details")).click();
		Thread.sleep(6000);
	
	   //Click on Send to customer button
	    driver.findElement(By.name("evt_approveleadOO")).click();
	    Thread.sleep(8000);
	    
	    //alert accept
	     driver.switchTo().alert().accept();
	     Thread.sleep(10000);
	    
	     Screenshot.CapturexDNSOScreenshot(driver, "lead submitted to Sent to customer successfully");
	    
	     //clicking on search lead tab.
			driver.findElement(By.xpath(".//*[@id='ibm-content-wrapper']/header/div[1]/div/ul/li[2]/a")).click();
			Thread.sleep(8000);
					
			//clicking on lead id based on country and status:
			//country
			Select country1 = new Select(driver.findElement(By.id("Country")));
			country1.selectByVisibleText("France");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//status
			Select status1 = new Select(driver.findElement(By.id("status")));
			status1.selectByVisibleText("Sent to Customer");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					    	  
			//click on search lead button
			driver.findElement(By.name("searchLead")).click();
			Thread.sleep(10000);
		
			 //clicking on Lead id
		    driver.findElement(By.xpath(".//*[@id='searchLeadTable']/tbody/tr[1]/td[2]/a")).click();
			Thread.sleep(8000);
			
			 //Click on Additional details tab
			driver.findElement(By.partialLinkText("Additional details")).click();
			Thread.sleep(6000);
			
			 //Choose Customer fulfillment
		    Select customerFulfillment = new Select(driver.findElement(By.id("ChooseCF")));
		    customerFulfillment.selectByVisibleText("Bharathi-bhakondu@in.ibm.com");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		    //Click on customer signed the contract button
		    driver.findElement(By.name("evt_approveleadOO2")).click();
		    Thread.sleep(8000);
		    
		    //alert accept
		     driver.switchTo().alert().accept();
		     Thread.sleep(10000);
		     
		     Screenshot.CapturexDNSOScreenshot(driver, "lead submitted to CF successfully");
		}
    
    @Test(dependsOnMethods= "login_OoRole")
	public void login_CfRole() throws Exception{
    	
    	//clicking on login for other roles
    	driver.findElement(By.xpath(".//*[@id='ibm-content-wrapper']/button")).click();
    	Thread.sleep(6000);
    					
    	//clicking on  Opportunity owner role
    	driver.findElement(By.xpath(".//*[@id='ibm-contact-module']/ul/li[3]/a")).click();
    	Thread.sleep(10000);
    		   
    	//clicking on search lead tab.
    	driver.findElement(By.xpath(".//*[@id='ibm-content-wrapper']/header/div[1]/div/ul/li[2]/a")).click();
    	Thread.sleep(8000);
    			
    			
    	//clicking on lead id based on country and status:
    	//country
    	Select country = new Select(driver.findElement(By.id("Country")));
    	country.selectByVisibleText("France");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	//status
    	Select status = new Select(driver.findElement(By.id("status")));
    	status.selectByVisibleText("Contract Sent To CF");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    					    	  
    	//click on search lead button
    	driver.findElement(By.name("searchLead")).click();
    	Thread.sleep(10000);
    					    
    	//clicking on Lead id
    	driver.findElement(By.xpath(".//*[@id='searchLeadTable']/tbody/tr[1]/td[2]/a")).click();
    	Thread.sleep(8000);
    			
	  //Click on Additional details tab
		driver.findElement(By.partialLinkText("Additional details")).click();
		Thread.sleep(6000); 
	    
	  //Click on Close Lead as won button
	    driver.findElement(By.name("evt_approveleadCF")).click();
	    Thread.sleep(8000);
	    
	    //alert accept
	     driver.switchTo().alert().accept();
	     Thread.sleep(10000);   
	     
	     Screenshot.CapturexDNSOScreenshot(driver, "lead submitted to Won successfully");
    }
}
