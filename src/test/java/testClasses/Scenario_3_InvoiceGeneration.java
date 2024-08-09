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

public class Scenario_3_InvoiceGeneration extends BaseTest {
	
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
//    action.moveToElement(ele);
      // click on workflow icon
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
      
      // click on campaign icon
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Campaigns']"))).click();
 //   driver.findElement(By.xpath("//*[text()=' Campaigns']")).click();
    
      
      // click on the search icon to get the context on the base page
      
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).clear();
      
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).sendKeys("UT01118");
      
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).click();
      
      // click on the specific campaign -- //*[text()='UT01108']
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='UT01118']"))).click(); // hard coded value
      
      //validating status as PO receipted
          
      String campaign_ID = handleWebTable("//*[@role='table']/tbody/tr", "PO Receipted", 2, "getText");
      System.out.println("campaign_ID = "+campaign_ID);
      
      //navigating to Finance
      wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
       //WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
//     action.moveToElement(ele);
       // click on workflow icon
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Finance ']"))).click();
       
       // click on Sales order
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Sales Orders']"))).click();
       
       //click on Campid 
       
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).clear();
       
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).sendKeys("UT01118");
       
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).click();
       
       // click on the specific campaign -- //*[text()='UT01108']
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='UT01118']"))).click(); // hard coded value
       
       // click on check box 
       
          
   //    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='table']/tbody/tr[7]/td[2]")));// hard coded value
     //  retryMechanism(driver.findElement(By.xpath("//*[@role='table']/tbody/tr[7]/td[2]")));
       for (int i = 0; i < 3; i++) {
    	   try {
    		   handleWebTable("//*[@role='table']/tbody/tr", campaign_ID.trim(), 2, "clickItem");  // hard coded value
    		  break;}
    	   catch (StaleElementReferenceException e) {
    		   e.printStackTrace();
    	   }

    	    } // end of for loop
       
      
       // click on create draft invoice
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Create Draft Invoice']"))); // hard coded value
     
      retryMechanism(driver.findElement(By.xpath("//*[text()=' Create Draft Invoice']")));
      
      // click on ok in pop-up
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' OK ']")));
      retryMechanism(driver.findElement(By.xpath("//*[text()=' OK ']")));
    
      // click on close in pop-up
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Close']")));
      retryMechanism(driver.findElement(By.xpath("//*[text()='Close']")));
}
}
