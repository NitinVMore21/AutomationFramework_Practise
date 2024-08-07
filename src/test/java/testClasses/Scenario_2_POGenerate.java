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
     
       
       // click on the search icon to get the context on the base page
       
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).click();
       
       // click on the specific campaign -- //*[text()='UT01108']
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='UT01118']"))).click();
       // create xpath for the campaign based on the date created + status + user/account manager
       //aria-describedby="cdk-describedby-message-46"
       // click on send po button
       retryMechanism(driver.findElement(By.xpath("//table[@role=\"table\"]//tbody/tr[1]/td/button[not(@hidden)]//img[@src='assets/images/send-for-approval.svg']")));
       Thread.sleep(3000);
       //click on Yes in the pop up
       retryMechanism(driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),' Yes')]")));
		/*
		 * retryMechanism(driver.findElement(By.xpath(
		 * "//button[@aria-describedby='cdk-describedby-message-29']")));
		 * 
		 * // add assertion for status update-- PO approved
		 * 
		 * //click on create po retryMechanism(driver.findElement(By.xpath(
		 * "//button[@aria-describedby='cdk-describedby-message-23']"))); // click on
		 * close button wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//button[@class='mat-focus-indicator mat-stroked-button mat-button-base']"
		 * ))).click(); //retryMechanism(driver.find)
		 * 
		 * // click on Supporting document section retryMechanism(driver.findElement(By.
		 * xpath("//*[text()='Supporting Documents']"))); // extract the PO number
		 * 
		 * // click on sdie nav then click on finance and then click on po
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//*[@id='sideNav']"))).click(); // click on workflow icon
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//*[text()=' Finance ']"))).click();
		 * 
		 * // click on campaign icon
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//a[normalize-space()='PO Management']"))).click();
		 */ 
       

      
       
  }


	
}
