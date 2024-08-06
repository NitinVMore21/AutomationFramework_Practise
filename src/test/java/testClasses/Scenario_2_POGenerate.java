package testClasses;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
     
       
       // click on the specific campaign -- //*[text()='UT01108']
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='UT01108']"))).click();
       // create xpath for the campaign based on the date created + status + user/account manager
       
       // click on send po button
       retryMechanism(driver.findElement(By.xpath("//button[@aria-describedby='cdk-describedby-message-22']")));
       Thread.sleep(3000);
       String parent=driver.getWindowHandle();
       Set<String>s=driver.getWindowHandles();
       // Now iterate using Iterator
       Iterator<String> I1= s.iterator();
       while(I1.hasNext()) {
    	   System.out.println("this is parent child -- " +parent);
    	   String child_window=I1.next();
    	   System.out.println("this is first child -- " +child_window);
       }
       retryMechanism(driver.findElement(By.xpath("//button[@aria-describedby='cdk-describedby-message-29']")));
      
       // add assertion for status update-- PO approved
       
       //click on create po
       retryMechanism(driver.findElement(By.xpath("//button[@aria-describedby='cdk-describedby-message-23']")));
       // click on close button
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='mat-focus-indicator mat-stroked-button mat-button-base']"))).click();
       //retryMechanism(driver.find)
       
       // click on Supporting document section
       retryMechanism(driver.findElement(By.xpath("//*[text()='Supporting Documents']")));
       // extract the PO number
       
       // click on sdie nav then click on finance and then click on po
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
       // click on workflow icon
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Finance ']"))).click();
       
       // click on campaign icon
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='PO Management']"))).click();
       
       

       
	/*
	 * //Click on Back to Campaign WebElement BckToCampaign =
	 * driver.findElement(By.xpath("//i[@class='fas fa-chevron-circle-left fa-3x']")
	 * ); // js.executeScript("arguments[0].scrollIntoView();", BckToCampaign);
	 * js.executeScript("window.scrollTo(0, 0);"); //
	 * js.executeScript("arguments[0].scrollIntoView();", BckToCampaign);
	 * ba.retryMechanism(driver,BckToCampaign); //
	 * retryMechanism(driver,BckToCampaign); Thread.sleep(2000);
	 */
        
			/*
			 * //Click on Edit button on campaign page WebElement editBtn =
			 * driver.findElement(By.
			 * xpath("//button[@class='mat-focus-indicator mat-tooltip-trigger buttonSize mat-button mat-button-base cdk-focus']"
			 * )); js.executeScript("arguments[0].scrollIntoView();", editBtn);
			 * ba.retryMechanism(driver,editBtn);
			 */    
        
       //retryMechanism(RESET);
       
  //   new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='BusinessUnitId']"))).click();
       
       // click on select value within the box
  //    WebElement element1 = driver.findElement(By.xpath("//span[normalize-space()='PCC UK Lead Supply']"));
       //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='PCC UK Lead Supply']"))).click();
       
       
  }


	
}
