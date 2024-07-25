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

public class RadioButtonTest extends BaseClass{
	public JavascriptExecutor js;

		@Test(groups = {"Smoke"})
		
		public void RadioButtonValidation() throws Exception
		{
			// instantiate an object of webdriver
			getWebDriver();
			instantiatePOMClasses();	
			
			// TC step 1
			        //Launch URL
			driver.manage().window().maximize();
	        driver.get(prop.getProperty("testurl"));
	        
	        ExtentTest extentTest = ExtentTestManager.startTest("RadioButton", "Clicking on Button");
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
			     //Click RadioButton Menu
			 js.executeScript("arguments[0].scrollIntoView();", rob.getradioButton());
			 rob.getradioButton().click();
			 
			 //Step 4
			     //Click on Radio button
			 js.executeScript("arguments[0].scrollIntoView();", rob.getyesButton());
		 	    
				ExtentTestManager.getTest().log(Status.INFO, "clicking Yes");
				Thread.sleep(2000);
				
				ExtentConfiguration.addStepWithScreenshotInReport(driver, "test1.png", Status.DEBUG);
		 		
				rob.getyesButton().click();
				Thread.sleep(2000);

		}
		
		 @AfterClass public void tearDown()
		 { 
			 if(driver != null) 
			 { 
				 driver.quit(); 
				 } 
			 }
	}


