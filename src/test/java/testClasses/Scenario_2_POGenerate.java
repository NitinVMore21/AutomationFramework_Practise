package testClasses;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilclasses.BaseAction;

public class Scenario_2_POGenerate extends BaseTest {

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
//     action.moveToElement(ele);
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
       // create xpath for the campaign based on the date created + status + user/account manager
       //aria-describedby="cdk-describedby-message-46"
       // click on send po button
     
       String campaign_ID = handleWebTable("//*[@role='table']/tbody/tr", "Quote Accepted", 2, "getText");
       System.out.println("campaign_ID = "+campaign_ID);
       int rowNum = getMatchRowNum("//*[@role='table']/tbody/tr", "Quote Accepted", 2, "getRowNum");
       System.out.println("rowNum  = "+rowNum);
      //*[@role='table']/tbody/tr[5]/td[11]/button[not(@hidden)]//img[@src='assets/images/send-for-approval.svg']
       retryMechanism(driver.findElement(By.xpath("//table[@role=\"table\"]//tbody/tr["+rowNum+"]/td/button[not(@hidden)]//img[@src='assets/images/send-for-approval.svg']"))); 
		

       retryMechanism(driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),' Yes')]")));
       
       /////////////////////////////////////
       // click on create PO
       retryMechanism(driver.findElement(By.xpath("//table[@role='table']//tbody/tr["+rowNum+"]/td/button[not(@hidden)]//img[@src='assets/images/generate_doc_create_po.svg']"))); // hard coded value
       //click on close (popup)
       retryMechanism(driver.findElement(By.xpath("//*[text()='Close']")));
       
       // click on supporting docs link
       retryMechanism(driver.findElement(By.xpath("//*[@id='mat-tab-label-2-2']")));
       
       // get the pdf PO name from table
       String pdfName = handleWebTable("//*[@role='table']/tbody/tr","Purchase Order" , 2,"getText");
       //ePO000898-LEADGB_V3.pdf extract : ePO000898-LEADGB
       String[] act = pdfName.split("_");
       System.out.println("split pdf name = "+act[0]);
       
 //hover to select finance
       
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
       //click on finance
       retryMechanism(driver.findElement(By.xpath("//span[text()=' Finance ']")));
       //click on PO Management
       retryMechanism(driver.findElement(By.xpath("//a[text()=' PO Management']")));

       
       for (int i = 0; i < 3; i++) {
    	   try {
    		  handleWebTable("//*[@role='table']/tbody/tr", act[0], 1, "clickItem" ); // hard coded value
    		  break;}
    	   catch (StaleElementReferenceException e) {
    		   e.printStackTrace();
    	   }

    	    } // end of for loop
       
       // code to be analysed ///////////////////////////////////////////////////////////////////////////////
       
       int rowNum1 = getMatchRowNum("//*[@role='table']/tbody/tr", campaign_ID, 2, "getRowNum");
       System.out.println("rownum 2 in PO section ="+rowNum1);
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='table']/tbody/tr["+rowNum1+"]/td/button//img[@src='assets/images/attach_user_guide.svg']"))).click();
       Thread.sleep(3000);
       // select the file to be uploaded send keys to below weblement
     //*[@id='supportingDocumentFileUpload']
       driver.findElement(By.xpath("//*[@id='supportingDocumentFileUpload']")).sendKeys("C:\\Users\\rahul\\Downloads\\ePO000895-LEADGB_V1.pdf");
       // enter comments inthe text area
     //*[@id='supportingDocumentDescription']
       driver.findElement(By.xpath("//*[@id='supportingDocumentDescription']")).sendKeys("Coments");
       retryMechanism(driver.findElement(By.xpath("(//*[@role='combobox'])[2]")));
       // select pod option
       retryMechanism(driver.findElement(By.xpath("//span[text()=' Proof Of Delivery']")));
       
       // click the save button
       retryMechanism(driver.findElement(By.xpath("//button[@type='submit']")));
       
       // click on Receipt tab
       retryMechanism(driver.findElement(By.xpath("//*[@class='mat-tab-header']//div[text()='Receipt']")));
       
       // select the checkbox on receipt tab
       handleWebTable("//*[@role='table']/tbody/tr", "UT01118-006", 2, "clickItem");  // hard coded value
       
       // click the receipt action
       handleWebTable("//*[@role='table']/tbody/tr", "UT01118-006", 14, "clickItem");  // hard coded value
       
       // click on Close button on the popup
       retryMechanism(driver.findElement(By.xpath("//button/span[text()='Close']")));
      
       
             //get data from table

       //Scenario -2 completed
       
  }


	
}
