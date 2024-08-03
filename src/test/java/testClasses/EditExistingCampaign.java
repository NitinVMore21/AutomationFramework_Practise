package testClasses;



import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilclasses.BaseAction;



public class EditExistingCampaign extends BaseTest {
	//public static WebDriver driver;
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
		//wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//check ck = new check();
		//ck.uploadFile();
	
		//driver = new ChromeDriver();
		
		driver.get("https://uat.paragon-epro.com/");
		 driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Enter username
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Staginguser_1");
		
        Thread.sleep(2000);
   
        //Enter password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Paragon@2024");
       Thread.sleep(4000);
        
   
        //Click on checkbox
        
        
        //new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(plp.getCaptcha()));
        // reCAPTCHA
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

   //   new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='recaptcha-anchor-label']"))).click();
        
        //driver.switchTo().frame("a-");
        //driver.switchTo().frame(0);
        Thread.sleep(7000);
   
        
        System.out.println("captcha selected");
        driver.switchTo().defaultContent();
        //Click on login
   //   plp.getSubmitButton().click();
        //driver.findElement(By.xpath("//button[@type='submit' and @class='mat-focus-indicator login100-form-btn mat-raised-button mat-button-base']")).click();
        driver.findElement(By.xpath("//button")).click();
        System.out.println("submit button clicked");
        
       
        // webelement for side nav
        Thread.sleep(3000);
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
        //WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));

        // click on workflow icon
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
        
        // click on campaign icon
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Campaigns']"))).click();
   //   driver.findElement(By.xpath("//*[text()=' Campaigns']")).click();
       
        
   } // end of testng test method

	
} // end of class

		
		