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



public class Create_CampaignClass extends BaseTest {
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
        
        
        // step to click on campaign icon
        //*[text()=' Campaigns']
        // action class and move to element
        Actions action = new Actions(driver);
        // webelement for side nav
        Thread.sleep(3000);
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
        //WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
//      action.moveToElement(ele);
        // click on workflow icon
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
        
        // click on campaign icon
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Campaigns']"))).click();
   //   driver.findElement(By.xpath("//*[text()=' Campaigns']")).click();
        // click on add icon
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='assets/images/assign-suppliers.svg']"))).click();
        // click on business unit box //div[@id='mat-select-value-13']
        /*
        * new WebDriverWait(driver, 20).until(ExpectedConditions.
        * elementToBeClickable(By.xpath("//*[@id='BusinessUnitId']"))).click();
        */
        
        /*
        * js = (JavascriptExecutor) driver;
        * 
         * 
         * 
         * WebElement element =
        * driver.findElement(By.xpath("//*[@id='BusinessUnitId']"));
        * 
         * js.executeScript("arguments[0].scrollIntoView();", element);
        * 
         * element.click();
        */
        
        
        // retry mechanism implementation
        WebElement element = driver.findElement(By.xpath("//*[@id='BusinessUnitId']"));
        ba.retryMechanism(driver,element);
        WebElement element1 = driver.findElement(By.xpath("//span[normalize-space()='PCC UK Lead Supply']"));
        ba.retryMechanism(driver,element1);
        
        
        WebElement customertxtBox = driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c91-28 ng-star-inserted']"));
        ba.retryMechanism(driver,customertxtBox);
        WebElement stagingClient_3_cruk = driver.findElement(By.xpath("//span[normalize-space()='Staging Client 3 - CRUK']"));
        ba.retryMechanism(driver, stagingClient_3_cruk);

        WebElement customer_entities = driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c91-30 ng-star-inserted']"));
        ba.retryMechanism(driver,customer_entities);
        WebElement CRUK_UK = driver.findElement(By.xpath("//span[normalize-space()='CRUK UK']"));
        ba.retryMechanism(driver,CRUK_UK);

		/*
		 * WebElement Account_Manager =
		 * driver.findElement(By.xpath("//*[@id='title']"));
		 * ba.retryMechanism(driver,Account_Manager);
		 */        
		/*
		 * WebElement Staging_user =
		 * driver.findElement(By.xpath("//span[normalize-space()='Staging User3']"));
		 * ba.retryMechanism(driver,Staging_user);
		 */


        WebElement Campaign_title = driver.findElement(By.xpath("//input[@id='title']"));
        ba.retryMechanismWithSendKeys(driver, Campaign_title, "Test_3");

        WebElement customer_camping_ref = driver.findElement(By.xpath("//input[@id='reference']"));
        ba.retryMechanismWithSendKeys(driver, customer_camping_ref, "CR124324332");

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement date = driver.findElement(By.xpath("//button[@aria-label='Open calendar']//span[@class='mat-button-wrapper']//*[name()='svg']"));
        ba.retryMechanism(driver,date);
        WebElement Value_6 = driver.findElement(By.xpath("//div[normalize-space()='6']"));
        ba.retryMechanism(driver,Value_6);



     /*   WebElement sales_representative = driver.findElement(By.xpath("//div[@id='mat-select-value-23']"));
        retryMechanism(driver,sales_representative);
        WebElement David_Reynolds = driver.findElement(By.xpath("//span[normalize-space()='David Reynolds']"));
        retryMechanism(driver,David_Reynolds);
     */
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement VAT = driver.findElement(By.xpath("//div[@id='mat-select-value-27']"));
        ba.retryMechanism(driver,VAT);
        WebElement vat20 = driver.findElement(By.xpath("//span[normalize-space()='VAT20']"));
        ba.retryMechanism(driver,vat20);

        js.executeScript("window.scrollBy(0,350)", "");
        WebElement purchase_order_number = driver.findElement(By.xpath("//input[@id='ponumber']"));
        ba.retryMechanismWithSendKeys(driver, purchase_order_number, "PO12421331");

        WebElement purchase_order_value = driver.findElement(By.xpath("//input[@id='povalue']"));
        ba.retryMechanismWithSendKeys(driver, purchase_order_value, "2");

       
        WebElement cost_centre = driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c91-51 ng-star-inserted']"));
        ba.retryMechanism(driver,cost_centre);
        WebElement regionalmarketing = driver.findElement(By.xpath("//span[contains(text(),'MFE - DM – Regional Marketing')]"));
        ba.retryMechanism(driver,regionalmarketing);


        WebElement RESET = driver.findElement(By.xpath("//span[normalize-space()='Reset']"));
        ba.retryMechanism(driver,RESET);
        
        //Click on Back to Campaign
        WebElement BckToCampaign = driver.findElement(By.xpath("//i[@class='fas fa-chevron-circle-left fa-3x']"));
       // js.executeScript("arguments[0].scrollIntoView();", BckToCampaign);
        js.executeScript("window.scrollTo(0, 0);");
      //  js.executeScript("arguments[0].scrollIntoView();", BckToCampaign);
        ba.retryMechanism(driver,BckToCampaign);
       // retryMechanism(driver,BckToCampaign);
         Thread.sleep(2000);
         
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

	     
	
    /*  public static void main (String []args) throws InterruptedException {
    	  check ck = new check();
    	  ck.Automate();
    	  
    	  
      }*/
	    }

		
		