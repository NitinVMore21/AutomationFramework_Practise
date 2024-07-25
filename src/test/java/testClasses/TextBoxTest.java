package testClasses;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilclasses.ExcelReader;
import utilclasses.ExtentConfiguration;
import utilclasses.ExtentTestManager;

public class TextBoxTest extends BaseClass
{
	public JavascriptExecutor js;
	
	@DataProvider(name = "data")

	public Object[][] readExcelData()

	{
		return ExcelReader.readData(WORKING_DIR + "\\testdataDemoqa_v01.xlsx", "TextboxSheet");
		//return new ExcelReader(getClass()).readData("C:\\Users\\nitin.more\\Desktop\\TestDataForMapping.xlsx","Sheet1");
	}
	
	@Test (dataProvider = "data")
	public void TextboxValidation(Map<String, String> input) throws Exception
	{
		// instantiate an object of webdriver
		getWebDriver();
		instantiatePOMClasses();
		
		// TC step 1
		     //Launch URL
		driver.manage().window().maximize();
        driver.get(prop.getProperty("testurl"));
		
        ExtentTest extentTest = ExtentTestManager.startTest("TextBox", "Clicking on Button");
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
			// click on the textBox menu item
			tbp.getTextBox().click();
			ExtentTestManager.getTest().log(Status.INFO, " STEP 03 Text Box element has been clicked");
			ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);
		
			// step 4
			// enter the details of the users
			tbp.getUserName().sendKeys(input.get("Full Name"));
			tbp.getUserEmail().sendKeys(input.get("Email"));
			
			tbp.getCurrentAddress().sendKeys(input.get("Current Address"));
			
			tbp.getPermanentAddress().sendKeys(input.get("Permanent Address"));
			
			ExtentTestManager.getTest().log(Status.INFO, " STEP 04/5/6/7 user details entered");
			ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);
		
	      
	  // step 8 click on submit
			Actions act = new Actions(driver);
		    
		    act.sendKeys(Keys.ENTER).build().perform();
		    js.executeScript("arguments[0].scrollIntoView();", tbp.getSubmit());
		    tbp.getSubmit().click();
			ExtentTestManager.getTest().log(Status.INFO, " STEP 08 sUBMIT BUTTON CLICKED");
			ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);
		
	      
		//wtb.webTablesElement(input);
		//Assert.assertEquals(EXTENT_REPORTS_PATH, WORKING_DIR);
		// to introduce the failure
		
	}
	
	
	 @AfterClass public void tearDown()
	 { if(driver != null) { driver.quit(); } }
	 
	}
