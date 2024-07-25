package testClasses;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilclasses.ExcelReader;
import utilclasses.ExtentConfiguration;
import utilclasses.ExtentTestManager;

public class WebTablesTest extends BaseClass
{

	public JavascriptExecutor js;
	
	@DataProvider(name = "data")

	public Object[][] readExcelData()
	 
	{
		String FilePath="\\testdataDemoqa_v01.xlsx";
		String testDataFile=WORKING_DIR+System.getProperty("file.separator")+FilePath;
		return ExcelReader.readData(testDataFile,"WebtablesElement");
			}
	
	@Test (dataProvider = "data", groups = "Regression")
	public void WebTableValidation(Map<String, String> input) throws Exception
	{
		// instantiate an object of webdriver
				getWebDriver();
				instantiatePOMClasses();
				
				// TC step 1
				     //Launch URL
				driver.manage().window().maximize();
		        driver.get(prop.getProperty("testurl"));
				
		        ExtentTest extentTest = ExtentTestManager.startTest("WebTable", "Clicking on Button");
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
				     //Click WebTable Menu
				  js.executeScript("arguments[0].scrollIntoView();", wtb.getwebtTable());
				  wtb.getwebtTable().click();
				  
				  //Step 4
				     //Click on Add button
				  js.executeScript("arguments[0].scrollIntoView();", wtb.getaddButton());
					
				    wtb.getaddButton().click();
				    
				    //Step 5-Step 10
				       //Add User details 
				    wtb.getfirstName().sendKeys(input.get("firstName"));
				    wtb.getlastName().sendKeys(input.get("lastName"));
				    wtb.getuserEmail().sendKeys(input.get("userEmail"));
				    wtb.getAge().sendKeys(input.get("age"));
				    wtb.getSalary().sendKeys(input.get("salary"));
				    wtb.getDepartment().sendKeys(input.get("department"));
				    
				 //step 11
				    //click on Submit Button
				    ExtentTestManager.getTest().log(Status.INFO, "clicking Submit");
					
					ExtentConfiguration.addStepWithScreenshotInReport(driver, "test1.png", Status.DEBUG);
				    
				    Actions act = new Actions(driver);
				    
				    act.sendKeys(Keys.ENTER).build().perform();
			    
	}
	 @AfterMethod 
	 public void tearDown()
	 { 
		 if(driver != null) 
		 {
			 driver.quit(); 
			 }
		 }
}

	
	/*public Object[][] readExcelData()

	{
		return ExcelReader.readData(WORKING_DIR + "\\testdataDemoqa_v01.xlsx", "WebtablesElement");
		//return new ExcelReader(getClass()).readData("C:\\Users\\nitin.more\\Desktop\\TestDataForMapping.xlsx","Sheet1");
	}
	
	@Test (dataProvider = "data")
	public void validatingWebTables(Map<String, String> input) throws Exception
	{
		wtb.webTablesElement(input);
		Assert.assertEquals(EXTENT_REPORTS_PATH, WORKING_DIR);
		// to introduce the failure
		
	}*/


