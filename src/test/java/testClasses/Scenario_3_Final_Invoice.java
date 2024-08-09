package testClasses;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilclasses.BaseAction;

public class Scenario_3_Final_Invoice extends BaseTest{

	private WebDriverWait wait;
	 JavascriptExecutor js;
	
	  

/* @AfterClass
 public void tearDown() {
     if (driver != null) {
         driver.quit();
     }
 }*/
	
	@Test
	public void Automate() throws InterruptedException {
		getWebDriver();
		instantiatePOMClasses();
		
		BaseAction ba = new BaseAction();
		
		js = (JavascriptExecutor) driver;
	
		
		driver.get("https://uat.paragon-epro.com/");
		 driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Enter username
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Staginguser_2");
		
     Thread.sleep(2000);

     //Enter password
     driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Password@123456");
    Thread.sleep(4000);
     

     driver.findElement(By.xpath("//button")).click();
     System.out.println("submit button clicked");
     
     
     // webelement for side nav
     Thread.sleep(3000);
     wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
     //WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
//   action.moveToElement(ele);
     // click on workflow icon
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
     
     // click on campaign icon
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Campaigns']"))).click();
    // retryMechanism(driver.findElement(By.xpath("//a[normalize-space()='Campaigns']")));
//   driver.findElement(By.xpath("//*[text()=' Campaigns']")).click();
   
     
     // click on the search icon to get the context on the base page
     
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).clear();
     
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).sendKeys("UT01118");
     
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).click();
     
     // click on the specific campaign -- //*[text()='UT01108']
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='UT01118']"))).click(); // hard coded value
     
     //validating status as PO receipted
         
     String campaign_ID = handleWebTable("//*[@role='table']/tbody/tr", "Draft Invoiced", 2, "getText");
     System.out.println("campaign_ID = "+campaign_ID);
     
     // click on supporting docs link
     retryMechanism(driver.findElement(By.xpath("//*[@id='mat-tab-label-2-2']")));
     
		/*
		 * //search the required Draft invoiced row
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@placeholder='Search..']"))).clear();
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@placeholder='Search..']"))).sendKeys("Draft Invoice");
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@placeholder='Search..']"))).click();
		 */
   //  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
     // get the pdf PO name from table
     Thread.sleep(3000);
     String pdfName = null;
     for (int i = 0; i < 3; i++) {
    	 try {
    		  pdfName = handleWebTable("//*[@role='table']/tbody/tr","Draft Invoice" , 2,"getText");
    		 break;
    	 }
    	  catch (StaleElementReferenceException e) {
      		   e.printStackTrace();
      	   }
     }// end of for loop
    // String pdfName = handleWebTable("//*[@role='table']/tbody/tr","Draft Invoice" , 2,"getText");
     //ePO000898-LEADGB_V3.pdf extract : ePO000898-LEADGB
     String[] act = pdfName.split("_");
     System.out.println("split pdf name = "+act[0]);
     
     //navigating to Finance
     wait = new WebDriverWait(driver, Duration.ofSeconds(30));
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
      //WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
//    action.moveToElement(ele);
      // click on workflow icon
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Finance ']"))).click();
      
      // click on sales invoices
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Sales Invoices']"))).click();
 
      //click on invoice number
      for (int i = 0; i < 3; i++) {
   	   try {
   		  handleWebTable("//*[@role='table']/tbody/tr", act[0], 2, "clickItem" ); // hard coded value
   		  break;}
   	   catch (StaleElementReferenceException e) {
   		   e.printStackTrace();
   	   }

   	} // end of for loop
      
      // click on check box next to campaig id 
      
      for (int i = 0; i < 3; i++) {
   	   try {
   		   handleWebTable("//*[@role='table']/tbody/tr", campaign_ID.trim(), 2, "clickItem");  // hard coded value
   		  break;}
   	   catch (StaleElementReferenceException e) {
   		   e.printStackTrace();
   	   }

   	    } //
      
      // click on the check list check boxes
      //first check box //*[@id='mat-checkbox-23-input'] second check box: //*[@id='mat-checkbox-24-input'] //*[@id='buttonIsPost']
      
      retryMechanism(driver.findElement(By.xpath("//*[text()='Check Client PO or Acceptance of Quote ']")));
      retryMechanism(driver.findElement(By.xpath("//*[text()='Check Proof of Delivery or Postal Docket ']")));
      
      
}
}
