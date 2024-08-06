package testClasses;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilclasses.BaseAction;

public class NavigationTest extends BaseTest {
	

	private WebDriverWait wait;
	 JavascriptExecutor js;
	
	  

  /* @AfterClass
   public void tearDown() {
       if (driver != null) {
           driver.quit();
       }
   }*/
	
	@Test
	public void Automate() throws InterruptedException  {
		getWebDriver();
		instantiatePOMClasses();
		
		BaseAction ba = new BaseAction();
		
		js = (JavascriptExecutor) driver;
	
		
		driver.get("https://uat.paragon-epro.com/");
		 driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Enter username
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Staginguser_4");
		
       Thread.sleep(2000);
  
       //Enter password
       driver.findElement(By.xpath("//input[@type='password']")).sendKeys("August@202426");
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
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='UT01108']"))).click();
       // create xpath for the campaign based on the date created + status + user/account manager
       
       // click on send po button
              
       // click on Supporting document section
       retryMechanism(driver.findElement(By.xpath("//*[@id='mat-tab-label-2-2']")));
       // extract the PO number
       Thread.sleep(5000);
       String poNumber = getTextFrmTableBody("//*[@role='table']/tbody/tr","Purchase Order" , 2);
       System.out.println(poNumber);
       
       // click logout 
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='navbarDropdownMenuLink']"))).click();
       
       
       // click on sdie nav then click on finance and then click on po
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//*[@id='sideNav']"))).click(); // click on workflow icon
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//*[text()=' Finance ']"))).click();
		 * 
		 * // click on campaign icon
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//a[normalize-space()='PO Management']"))).click();
		 */
       
       
       ////button[@aria-describedby='cdk-describedby-message-21']

       
  }

	

}
