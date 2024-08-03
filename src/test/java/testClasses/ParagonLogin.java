package testClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
public class ParagonLogin extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test
	public void validateParagonWebsite() throws InterruptedException
	{
		
		getWebDriver();
		instantiatePOMClasses();
		driver.get("https://uat.paragon-epro.com/login");
		driver.manage().window().maximize();
		System.out.println("URL Launched");
		
		WebDriverWait wt2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		
		//Enter username
		plp.getUserName().sendKeys("Staginguser_1");
		Thread.sleep(2000);
	
		//Enter password
		plp.getPassword().sendKeys("Paragon@2024");
		Thread.sleep(2000);
		
	
		//Click on checkbox
		
		
		//new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(plp.getCaptcha()));
		// reCAPTCHA
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

	//	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='recaptcha-anchor-label']"))).click();
		
		//driver.switchTo().frame("a-");
		//driver.switchTo().frame(0);
		Thread.sleep(7000);
	
		
		System.out.println("captcha selected");
		driver.switchTo().defaultContent();
		//Click on login
	//	plp.getSubmitButton().click();
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
//		action.moveToElement(ele);
		// click on workflow icon
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();
		
		// click on campaign icon
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Campaigns']"))).click();
	//	driver.findElement(By.xpath("//*[text()=' Campaigns']")).click();
		// click on add icon
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='assets/images/assign-suppliers.svg']"))).click();
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
		retryMechanism(element);
		WebElement element1 = driver.findElement(By.xpath("//span[normalize-space()='PCC UK Lead Supply']"));
		retryMechanism(element1);
		
		
		WebElement customertxtBox = driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c91-28 ng-star-inserted']"));
		retryMechanism(customertxtBox);
		//Select dropdown = (Select) driver.findElement(By.xpath("//*[@id='customer-panel'"));
		//dropdown.selectByVisibleText(" Staging Client 3 - CRUK");
		
		// enter text in search
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Search']"))).click();
		driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys("CRUK");
		
		
		WebElement stagingClient_3_cruk = driver.findElement(By.xpath("//*[@id='mat-option-54']"));
		retryMechanism(stagingClient_3_cruk);

		WebElement customer_entities = driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c91-30 ng-star-inserted']"));
		retryMechanism(customer_entities);
		WebElement CRUK_UK = driver.findElement(By.xpath("//span[normalize-space()='CRUK UK']"));
		retryMechanism(CRUK_UK);

		WebElement Account_Manager = driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c91-34 ng-star-inserted']"));
		retryMechanism(Account_Manager);
		
		WebElement Staging_user = driver.findElement(By.xpath("//span[normalize-space()='Staging User3']"));
		retryMechanism(Staging_user);


		WebElement Campaign_title = driver.findElement(By.xpath("//input[@id='title']"));
		retryMechanism(Campaign_title);

		WebElement customer_camping_ref = driver.findElement(By.xpath("//input[@id='title']"));
		retryMechanism(customer_camping_ref);


		WebElement date = driver.findElement(By.xpath("//input[@id='mat-input-12']"));
		retryMechanism(date);
		WebElement Value_6 = driver.findElement(By.xpath("//div[normalize-space()='6']"));
		retryMechanism(Value_6);



		WebElement sales_representative = driver.findElement(By.xpath("//div[@id='mat-select-value-23']"));
		retryMechanism(sales_representative);
		WebElement David_Reynolds = driver.findElement(By.xpath("//span[normalize-space()='David Reynolds']"));
		retryMechanism(David_Reynolds);


		WebElement VAT = driver.findElement(By.xpath("//div[@id='mat-select-value-27']"));
		retryMechanism(VAT);
		WebElement vat20 = driver.findElement(By.xpath("//span[normalize-space()='VAT20']"));
		retryMechanism(vat20);

		WebElement purchase_order_number = driver.findElement(By.xpath("//input[@id='ponumber']"));
		retryMechanism(purchase_order_number);

		WebElement purchase_order_value = driver.findElement(By.xpath("//input[@id='povalue']"));
		retryMechanism(purchase_order_value);


		WebElement cost_centre = driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c91-51 ng-star-inserted']"));
		retryMechanism(cost_centre);
		WebElement regionalmarketing = driver.findElement(By.xpath("//span[contains(text(),'MFE - DM – Regional Marketing')]"));
		retryMechanism(regionalmarketing);


		WebElement RESET = driver.findElement(By.xpath("//span[normalize-space()='Reset']"));

		//retryMechanism(RESET);
		
	//	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='BusinessUnitId']"))).click();
		
		// click on select value within the box
	//    WebElement element1 = driver.findElement(By.xpath("//span[normalize-space()='PCC UK Lead Supply']"));
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='PCC UK Lead Supply']"))).click();
		
		
	}
	
	
}
