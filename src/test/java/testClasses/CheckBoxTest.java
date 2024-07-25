package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilclasses.ExtentConfiguration;
import utilclasses.ExtentTestManager;

public class CheckBoxTest extends BaseClass
{
	public JavascriptExecutor js;
	
	@Test (groups = {"Smoke"})
	
	public void CheckBoxValidation() throws Exception
	{
		// instantiate an object of webdriver
				getWebDriver();
				instantiatePOMClasses();	
				
				// TC step 1
				       //Launch URL
				driver.manage().window().maximize();
		        driver.get(prop.getProperty("testurl"));
		        
		        ExtentTest extentTest = ExtentTestManager.startTest("Checkbox", "Clicking on Button");
		        ExtentTestManager.getTest().log(Status.INFO, " STEP 01 application launched");
				ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);
				
				// Step 2
				     //Click on Element Frame
				 js = (JavascriptExecutor) driver;
			      WebElement element = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]"));
			      js.executeScript("arguments[0].scrollIntoView();", element);
			      element.click();
			      ExtentTestManager.getTest().log(Status.INFO, " STEP 02 Elements icon clicked on main page");
				 ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);
			      
				//Step 3
					// click on the Checkbox menu item
				 driver.findElement(By.id("item-1")).click();
				 
				//Step 4
				     // click on Toggle button
				 js.executeScript("window.scrollBy(0,200)");
				 cob.getbutton().click();
				 
				 ExtentTestManager.getTest().log(Status.INFO, " STEP 02 Elements icon clicked on main page");
				 ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);
				 
				 //Step 5
				      //Select on Checkbox 
				 
				 cob.getselectButton().click();
				 ExtentTestManager.getTest().log(Status.INFO, " STEP 02 Elements icon clicked on main page");
				 ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);
				 
			      	}
	 @AfterClass public void tearDown()
	 { if(driver != null) { driver.quit(); } }


}
