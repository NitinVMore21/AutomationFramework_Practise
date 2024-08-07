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



public class NavigationPOSelection extends BaseTest {

	private WebDriverWait wait;
	 JavascriptExecutor js;
	
	  

  
	
	@Test
	public void Automate() throws InterruptedException {
		getWebDriver();
		instantiatePOMClasses();
		
		BaseAction ba = new BaseAction();
		
		js = (JavascriptExecutor) driver;
	
		
		driver.get("https://uat.paragon-epro.com/");
		 driver.manage().window().maximize();
	       wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
             //hover to select finance
       
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
       //click on finance
       retryMechanism(driver.findElement(By.xpath("//span[text()=' Finance ']")));
       //click on PO Management
       retryMechanism(driver.findElement(By.xpath("//a[text()=' PO Management']")));
       //get data from table
       

       // click on the search icon to get the context on the base page
       
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).click();
      //ePO000898-LEADGB_V3.pdf
       
       // click on the required PO 
       
       for (int i = 0; i < 3; i++) {
    	   try {
    		  handleWebTable("//*[@role='table']/tbody/tr", "ePO000898-LEADGB", 1, "clickItem" ); // hard coded value
    		  break;}
    	   catch (StaleElementReferenceException e) {
    		   e.printStackTrace();
    	   }

    	    } // end of for loop
       
       
       // click on update POD button
     //*[@role='table']/tbody/tr[1]/td/button//img[@src='assets/images/attach_user_guide.svg']
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='table']/tbody/tr[1]/td/button//img[@src='assets/images/attach_user_guide.svg']"))).click();
       Thread.sleep(3000);
       // select the file to be uploaded send keys to below weblement
     //*[@id='supportingDocumentFileUpload']
       driver.findElement(By.xpath("//*[@id='supportingDocumentFileUpload']")).sendKeys("C:\\Users\\gaurav.shukla.ESPIRE\\Downloads\\ePO000896-LEADGB_V1.pdf");
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
       handleWebTable("//*[@role='table']/tbody/tr", "UT01118-001", 2, "clickItem");  // hard coded value
       
       // click the receipt action
       handleWebTable("//*[@role='table']/tbody/tr", "UT01118-001", 14, "clickItem");  // hard coded value
       
       // click on Close button on the popup
       retryMechanism(driver.findElement(By.xpath("//button/span[text()='Close']")));
      
       
  }


	
}