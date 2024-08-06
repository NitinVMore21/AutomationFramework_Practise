package paragondemo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;




public class ManageCampaign extends BaseTest {





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
		//	      action.moveToElement(ele);
		// click on workflow icon
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();

		// click on campaign icon
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Campaigns']"))).click();


		//Click manage campiang

		WebElement manageCampButton = driver.findElement(By.xpath("//a[text()='UT01101']"));
		ba.retryMechanism(driver,manageCampButton);

		//Click add item button
		WebElement addItemButton = driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-tooltip-trigger fab-secondary mat-fab mat-button-base mat-secondary']"));
		ba.retryMechanism(driver,addItemButton);

		//   Click ob prefilled templates

		WebElement prefilledTemplates = driver.findElement(By.xpath("//button[@type='submit']"));
		ba.retryMechanism(driver,addItemButton);


		//enter number of item
		WebElement numbOfItem = driver.findElement(By.xpath("//input[@id='txt203']"));
		ba.retryMechanismWithSendKeys(driver, numbOfItem, "1");

		//enter quantity
		WebElement numbOfQuatity = driver.findElement(By.xpath("//input[@id='qua203']"));
		ba.retryMechanismWithSendKeys(driver, numbOfQuatity, "20");



		//clickcheckbox

		WebElement clickcheckbox = driver.findElement(By.xpath
				("//label[@for='check203-input']//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']"));
		ba.retryMechanism(driver,clickcheckbox);


		//click on Plus sign

		WebElement clickonaddsign = driver.findElement(By.xpath
				("//button[@class='mat-focus-indicator mat-tooltip-trigger buttonSize mat-button mat-button-base cdk-focused cdk-mouse-focused']//img[@class='iconSize']"));
		ba.retryMechanism(driver,clickonaddsign);


		//Click yes on alert popup

		driver.switchTo().alert().accept();


		//*[@class='mat-tooltip-trigger btn bg-orange cdk-focused cdk-mouse-focused']
		//Click on manage item button
		WebElement manageItemButton = driver.findElement(By.xpath("//*[@class='mat-tooltip-trigger btn bg-orange cdk-focused cdk-mouse-focused']"));
		ba.retryMechanism(driver,manageItemButton);


		//Edit delivery = 

		WebElement EditDelivery = driver.findElement(By.xpath("//h6[@id='Delivery']"));
		js.executeScript("arguments[0].scrollIntoView();", EditDelivery);

		ba.retryMechanism(driver,EditDelivery);


		//  

		//Click checkbox nonApplicable


		WebElement ChckBoxNonApplicable = driver.findElement(By.xpath("//*[@for='mat-radio-8-input']"));
        ba.retryMechanism(driver,ChckBoxNonApplicable);

		//  

		//Save & close
		WebElement saveAndClose = driver.findElement(By.xpath("//span[normalize-space()='Save & Close']"));
        ba.retryMechanism(driver,saveAndClose);
		
		

        // Submit for costing  
    	WebElement submitCosting = driver.findElement(By.xpath("//img[@src='assets/images/submit-for-costing-pound.svg']"));
        ba.retryMechanism(driver,submitCosting);
        
        
        
        //Submit supplier price   
        WebElement SupplierPrice = driver.findElement(By.xpath("//img[@src='assets/images/view-supplier-price.svg']"));
        ba.retryMechanism(driver,SupplierPrice);
        
        
        // Select Paragon Dagenham from searchbox      
        
        WebElement ClickSearchBox = driver.findElement(By.xpath("//div[@id='mat-select-value-57']"));
        WebElement selectDagenham = driver.findElement(By.xpath("//*[text()=' Paragon CC (Dagenham)']"));
        ba.retryMechanismWithSendKeys(driver, ClickSearchBox, "paragon CC (Dagenham)");
        
        ba.retryMechanism(driver,selectDagenham);
        
        
        //  //enter estimate ref no
        
        WebElement enterEstimateRefNo = driver.findElement(By.xpath("//input[@id='f']")); 
        WebElement deliveryCost = driver.findElement(By.xpath("//div[@class='mat-form-field-infix ng-tns-c48-211']//input[@id='qt']")); 
        WebElement PaperCost = driver.findElement(By.xpath("//div[@class='mat-form-field-infix ng-tns-c48-212']")); 


	}

}
