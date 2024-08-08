package testClasses;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilclasses.BaseAction;

public class Scenario1_CreateCampaign_LineItem extends BaseTest {

	// public static WebDriver driver;
	private WebDriverWait wait;
	JavascriptExecutor js;

	/*
	 * @AfterClass public void tearDown() { if (driver != null) { driver.quit(); } }
	 */

	@Test
	public void Automate() throws InterruptedException {
		getWebDriver();
		instantiatePOMClasses();

		BaseAction ba = new BaseAction();

		js = (JavascriptExecutor) driver;
		// wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// check ck = new check();
		// ck.uploadFile();

		// driver = new ChromeDriver();

		driver.get("https://uat.paragon-epro.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Enter username
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Staginguser_3");

		Thread.sleep(2000);

		// Enter password
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Paragon@2024");
		// Thread.sleep(4000);

		// Click on checkbox

		// new WebDriverWait(driver,
		// 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(plp.getCaptcha()));
		// reCAPTCHA
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,
		// 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

		// new WebDriverWait(driver,
		// 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='recaptcha-anchor-label']"))).click();

		// driver.switchTo().frame("a-");
		// driver.switchTo().frame(0);
		// Thread.sleep(7000);

		// System.out.println("captcha selected");
		// driver.switchTo().defaultContent();
		// Click on login
		// plp.getSubmitButton().click();
		// driver.findElement(By.xpath("//button[@type='submit' and
		// @class='mat-focus-indicator login100-form-btn mat-raised-button
		// mat-button-base']")).click();
		driver.findElement(By.xpath("//button")).click();
		System.out.println("submit button clicked");

		// step to click on campaign icon
		// *[text()=' Campaigns']
		// action class and move to element
		Actions action = new Actions(driver);
		// webelement for side nav
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideNav']"))).click();
		// WebElement ele = driver.findElement(By.xpath("//*[@id='sideNav']"));
		// action.moveToElement(ele);
		// click on workflow icon
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Workflow ']"))).click();

		// click on campaign icon
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Campaigns']"))).click();

		// click on ManageCampaign button present on
        String UTnumber = "UT01109";
		WebElement manageCampButton = driver.findElement(By.xpath("//*[text()='"+UTnumber+"']"));
		ba.retryMechanism(driver, manageCampButton);

		// Click add item button
		WebElement addItemButton = driver.findElement(By.xpath(
				"//button[@class='mat-focus-indicator mat-tooltip-trigger fab-secondary mat-fab mat-button-base mat-secondary']"));
		ba.retryMechanism(driver, addItemButton);

		
		
		// Click ob prefilled templates
		Thread.sleep(2000);
		WebElement prefilledTemplates = driver.findElement(By.xpath("//span[@class='mat-button-wrapper']"));
		ba.retryMechanism(driver, prefilledTemplates);

		// enter number of item
		WebElement numbOfItem = driver.findElement(By.xpath("//input[@id='txt203']"));
		ba.retryMechanismWithSendKeys(driver, numbOfItem, "1");

		// enter quantity
		WebElement numbOfQuatity = driver.findElement(By.xpath("//input[@id='qua203']"));
		ba.retryMechanismWithSendKeys(driver, numbOfQuatity, "20");

		// clickcheckbox

		WebElement clickcheckbox = driver.findElement(By.xpath(
				"//label[@for='check203-input']//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']"));
		ba.retryMechanism(driver, clickcheckbox);

		// click on Plus sign

		WebElement clickonaddsign = driver.findElement(By.xpath("//tbody/tr[1]/td[11]/button[1]/span[1]/img[1]"));
		ba.retryMechanism(driver, clickonaddsign);

		// Click yes on popup

		// driver.switchTo().alert().accept();

		WebElement clickOnYes = driver.findElement(
				By.xpath("//*[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']"));
		ba.retryMechanism(driver, clickOnYes);

		Thread.sleep(5000);

		
		
		
		// veiwAll100Entries

		//WebElement Clickshow = driver.findElement(By.xpath("//div[contains(@class, 'mat-select-trigger')]//div[contains(@class, 'mat-select-value')]"));
		//WebElement clck100 = driver.findElement(By.xpath("//*[contains(@class, 'mat-option-text') and normalize-space(text())='100']"));
		
		
		
		
	 	/*WebElement lastPage = driver.findElement(By.xpath("//*[@aria-label='Last Page']"));
		js.executeScript("arguments[0].scrollIntoView();", lastPage);
		*/
		//ba.retryMechanism(driver, Clickshow);
		//ba.retryMechanism(driver, clck100);

		
		
		
		
		
		// WebElement clck100 = driver.findElement(By.xpath("
		// //span[normalize-space()='100']"));

		// *[@class='mat-tooltip-trigger btn bg-orange cdk-focused cdk-mouse-focused']
		// Click on manage item button

		List<WebElement> listEle = driver.findElements(By.xpath("//*[@role='table']//tbody/tr"));

		System.out.println(listEle.size());

		int i = 6;

		WebElement manageItemButton = driver.findElement(
				By.xpath("//*[@role='table']//tbody/tr["+i+"]//*[@class='mat-cell cdk-cell cdk-column-CampaignItemReference mat-column-CampaignItemReference ng-star-inserted']"));
		js.executeScript("arguments[0].scrollIntoView();", manageItemButton);
		// ba.retryMechanism(driver,submitCosting);
		// WebElement manageItemButton = driver.findElement(By.xpath("//*[text()='
		// UT01109-001 ']"));
		ba.retryMechanism(driver, manageItemButton);

		// Edit delivery =

		WebElement EditDelivery = driver.findElement(By.xpath("//*[@id='mat-expansion-panel-header-2']"));
		js.executeScript("arguments[0].scrollIntoView();", EditDelivery);

		ba.retryMechanism(driver, EditDelivery);

		//

		// Click checkbox nonApplicable

		WebElement ChckBoxNonApplicable = driver
				.findElement(By.xpath("//label[@for='mat-radio-8-input']//span[@class='mat-radio-container']"));
		ba.retryMechanism(driver, ChckBoxNonApplicable);

		//

		// Save & close
		WebElement saveAndClose = driver.findElement(By.xpath("//span[normalize-space()='Save & Close']"));
		ba.retryMechanism(driver, saveAndClose);

		/*
		 * //veiwAll100Entries WebElement pageEntry =
		 * driver.findElement(By.xpath("//div[@id='mat-select-value-29']")); WebElement
		 * clck100 = driver.findElement(By.xpath(" //span[normalize-space()='100']"));
		 * ba.retryMechanism(driver,pageEntry); ba.retryMechanism(driver,clck100);
		 */
		Thread.sleep(2000);

		// Submit for costing

		// List<WebElement> listEle =
		// driver.findElements(By.xpath("//*[@role='table']//tbody/tr"));

		// System.out.println(listEle.size());
		
		
      // click on submit costing  Remove this 
	 	WebElement submitCosting = driver.findElement(By.xpath("//*[@role='table']//tbody/tr[" + i
				+ "]//img[@src='assets/images/submit-for-costing-pound.svg']"));
		js.executeScript("arguments[0].scrollIntoView();", submitCosting);
		ba.retryMechanism(driver, submitCosting);
		//// tbody/tr[9]/td[11]/button[2]/span[1]/div[1]/img[1]
		// *[@role='table']//tbody/tr
		Thread.sleep(2000);
     
		// Submit supplier price
		WebElement SupplierPrice = driver
				.findElement(By.xpath("//*[@role='table']//tbody/tr["+i+"]//img[@src='assets/images/view-supplier-price.svg']"));
		js.executeScript("arguments[0].scrollIntoView();", SupplierPrice);
		ba.retryMechanism(driver, SupplierPrice);

		// Select Paragon Dagenham from searchbox
        
		WebElement ClickSearchBox = driver.findElement(By.xpath("//*[@id='SsupplierId']"));
		//js.executeScript("arguments[0].scrollIntoView();", ClickSearchBox);
		ba.retryMechanism(driver, ClickSearchBox);
		WebElement Search = driver.findElement(By.xpath("//input[@class='mat-input-element mat-form-field-autofill-control mat-select-search-input cdk-text-field-autofill-monitored']"));
		
		ba.retryMechanismWithSendKeys(driver, Search, "Paragon");
		
		WebElement selectDagenham = driver.findElement(By.xpath("//span[contains(text(),'Paragon CC (Dagenham)')]"));
		//js.executeScript("arguments[0].scrollIntoView();", selectDagenham);
		//ba.retryMechanismWithSendKeys(driver, ClickSearchBox, "paragon CC (Dagenham)");
		ba.retryMechanism(driver, selectDagenham);

		// //enter estimate ref no
        Thread.sleep(2000);
		WebElement enterEstimateRefNo = driver
				.findElement(By.xpath("//input[@id='f']"));
		ba.retryMechanismWithSendKeys(driver, enterEstimateRefNo, "ERN09876");

		 Thread.sleep(2000);
		 
		WebElement deliveryCost = driver.findElement(By.xpath("(//input[@id='qt'])[1]"));
		ba.retryMechanismWithSendKeys(driver, deliveryCost, "123");

		Thread.sleep(2000);
		WebElement PaperCost = driver.findElement(By.xpath("(//input[@id='qt'])[2]"));
		//js.executeScript("arguments[0].scrollIntoView();", PaperCost);
		ba.retryMechanismWithSendKeys(driver, PaperCost, "1234");
     
		Thread.sleep(2000);
		WebElement production = driver.findElement(By.xpath("(//input[@id='qt'])[3]"));
		//js.executeScript("arguments[0].scrollIntoView();", production);
		ba.retryMechanismWithSendKeys(driver, production, "12");
 
		Thread.sleep(2000);
		WebElement submitcostPrice = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].scrollIntoView();", submitcostPrice);
		ba.retryMechanism(driver, submitcostPrice);
		
		System.out.println("Submit button is clicked after supplier submit");
		
		
		
		//click on manage prices
		WebElement ClckManagePrice = driver.findElement(By.xpath("//*[@role='table']//tbody/tr["+i+"]//img[@src='assets/images/submit-supplier-price.svg']"));
		js.executeScript("arguments[0].scrollIntoView();", ClckManagePrice);
		ba.retryMechanism(driver, ClckManagePrice);
		
		WebElement checkBox = driver.findElement(By.xpath("//span[@class='mat-checkbox-frame']"));
		checkBox.click();
		
		
		
WebElement manageQuoteButton = driver.findElement(By.xpath("//i[@class='fas fa-chevron-circle-right fa-3x']"));
		ba.retryMechanism(driver, manageQuoteButton);
		
WebElement markup = driver.findElement(By.xpath("//input[@name='markUp']"));
		ba.retryMechanismWithSendKeys(driver, markup,"10");
		
		
		WebElement generateQuote = driver.findElement(By.xpath("//i[@class='fas fa-chevron-circle-right fa-3x']"));
		ba.retryMechanism(driver, generateQuote);
		
		
		
		//Click on Quote Management
		WebElement quoteManagement = driver.findElement(By.xpath("//div[contains(text(),'Quote Management')]"));
		ba.retryMechanism(driver, quoteManagement);
		
		//click on 1st quote
		WebElement quote1 = driver.findElement(By.xpath("//a[normalize-space()='"+UTnumber+"-Q-008']"));
		ba.retryMechanism(driver, quote1);
		
		
		//click on radio button to select the quote and accept
		Thread.sleep(2000);
		WebElement ClickRadioB = driver.findElement(By.xpath("//span[@class='mat-radio-outer-circle']"));
		js.executeScript("arguments[0].scrollIntoView();", ClickRadioB);
		ClickRadioB.click();
		
		
		WebElement acceptQuote = driver.findElement(By.xpath("//button[normalize-space()='Accept Selected']"));
		ba.retryMechanism(driver, acceptQuote);
		

		
		//click on final accept
		WebElement finalAccept = driver.findElement(By.xpath("//*[text()='Accept Quote']"));
		ba.retryMechanism(driver, finalAccept);
	}

}
