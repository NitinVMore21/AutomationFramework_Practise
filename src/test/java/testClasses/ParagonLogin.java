package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilclasses.ExtentConfiguration;
import utilclasses.ExtentTestManager;

public class ParagonLogin extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test
	public void validateParagonWebsite() throws InterruptedException {

		// instantiate an object of webdriver
		getWebDriver();
		instantiatePOMClasses();

		// Step 1--Launch URL
		driver.manage().window().maximize();
		driver.get(prop.getProperty("testurl"));

		ExtentTest extentTest = ExtentTestManager.startTest("Login", "URL Launched");
		ExtentTestManager.getTest().log(Status.INFO, " STEP 01 application launched");
		ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);

		System.out.println("URL Launched");

		// Step 2--Enter username
		plp.getUserName().sendKeys("test");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, " STEP 02 Enter Username");
		ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);

		// Step 3--Enter password
		plp.getPassword().sendKeys("test1");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, " STEP 03 Enter Password");
		ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);

		// Step 4--Click on Captcha checkbox

		new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(
				"//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='recaptcha-anchor-label']"))).click();

		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, " STEP 04 Captcha checkbox selected");
		ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);

		System.out.println("captcha selected");

		// Step 5--Click on login button

		driver.switchTo().defaultContent();
		plp.getSubmitButton().click();
		ExtentTestManager.getTest().log(Status.INFO, " STEP 05 Click on Login button");
		ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);

		System.out.println("Login button clicked");
	}

}
