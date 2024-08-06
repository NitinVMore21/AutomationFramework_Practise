package democlasses;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoParagonLogin {
	public WebDriver driver;
	public JavascriptExecutor js;
	@Test
	public void validateParagonWebsite() throws InterruptedException
    {
         
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options); 
         driver.get("https://uat.paragon-epro.com/login");
         driver.manage().window().maximize();
         System.out.println("URL Launched");
         Thread.sleep(5000);
         
         //Enter username
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
			WebElement username = driver.findElement(By.xpath("//*[@id='userName']"));
//         plp.getUserName().sendKeys("Staginguser_1");
			username.sendKeys("Staginguser_1");
         Thread.sleep(2000);
         /*driver.findElement(By.name("userName")).sendKeys("test");
         System.out.println("Username- test");
         Thread.sleep(2000);*/
         
         //Enter password
//         plp.getPassword().sendKeys("Paragon@2024");
         driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Paragon@2024");
         Thread.sleep(2000);
         /*driver.findElement(By.name("password")).sendKeys("test1");
         System.out.println("Password- test1");*/
         Thread.sleep(2000);
         
         //Click on checkbox
         
         
         //new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(plp.getCaptcha()));
         // reCAPTCHA
         
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

    //   new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
         new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='recaptcha-anchor-label']"))).click();
         
         //driver.switchTo().frame("a-");
         //driver.switchTo().frame(0);
         Thread.sleep(7000);
  
         System.out.println("captcha selected");
         
         Thread.sleep(20000);
         driver.switchTo().defaultContent();
         //Click on login
    //   plp.getSubmitButton().click();
         //driver.findElement(By.xpath("//button[@type='submit' and @class='mat-focus-indicator login100-form-btn mat-raised-button mat-button-base']")).click();
         driver.findElement(By.xpath("//button")).click();
         System.out.println("submit button clicked");
         
         
         // step to click on campaign icon
         //*[text()=' Campaigns']
         // action class and move to element
         Actions action = new Actions(driver);
         // webelement for side nav
         Thread.sleep(3000);
         new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
         //WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
//       action.moveToElement(ele);
         Thread.sleep(3000);
         // click on workflow icon
         js = (JavascriptExecutor) driver;
         
 		WebElement element3 = driver.findElement(By.xpath("//*[text()=' Workflow ']"));
		
 	    js.executeScript("arguments[0].scrollIntoView();", element3);
 	    
 	   wait.until(ExpectedConditions.elementToBeClickable(element3)).click();
 			
//         new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
         Thread.sleep(3000);
         // click on campaign icon
 		WebElement element4 = driver.findElement
 				(By.xpath("//*[@class='sideNavDropDown ng-star-inserted']//a[normalize-space()='Campaigns'][1]"));
		
 	    js.executeScript("arguments[0].scrollIntoView();", element4);
 	    
 	    wait.until(ExpectedConditions.elementToBeClickable(element4)).click();
 			
//         new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='sideNavDropDown ng-star-inserted']//a[normalize-space()='Campaigns'][1]")))
//         .click();
    //   driver.findElement(By.xpath("//*[text()=' Campaigns']")).click();
         // click on add icon
		WebElement element5 = driver.findElement
 				(By.xpath("//img[@src='assets/images/assign-suppliers.svg']"));
		
 	    js.executeScript("arguments[0].scrollIntoView();", element5);
 	    
 	   wait.until(ExpectedConditions.elementToBeClickable(element5)).click();
 			
//         new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='assets/images/assign-suppliers.svg']"))).click();
         // click on business unit box //div[@id='mat-select-value-13']
       
 		
 		WebElement element = driver.findElement(By.xpath("//div[@id='mat-select-value-13']"));
 			
 	    js.executeScript("arguments[0].scrollIntoView();", element);
 	    
 	   wait.until(ExpectedConditions.elementToBeClickable(element)).click();
 			
//         new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='mat-select-value-13']"))).click();
         
         // click on select value within the box
 		WebElement element1 = driver.findElement(By.xpath("//span[normalize-space()='PCC UK Lead Supply']"));
			
 	    js.executeScript("arguments[0].scrollIntoView();", element1);
 	    
 	   wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
 			
 	 
//         new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='PCC UK Lead Supply']"))).click();
         
 		WebElement element2 = driver.findElement(By.xpath("//*[@id='mat-select-value-15']"));
		
 	    js.executeScript("arguments[0].scrollIntoView();", element2);
 	    
 	   wait.until(ExpectedConditions.elementToBeClickable(element2)).sendKeys(" Royal Bank of Scotland");
 			
 	   
//         new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mat-select-value-15']"))).sendKeys(" Royal Bank of Scotland");
         
    }


}
