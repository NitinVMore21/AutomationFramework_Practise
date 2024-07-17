package pageClasses;

import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilclasses.ExtentConfiguration;
import utilclasses.ExtentTestManager;

public class WebTablePage {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	
	@FindBy(xpath="//span[normalize-space()='Web Tables']")
	 WebElement webtTable;
	
	@FindBy(xpath="//button[@id='addNewRecordButton']")
	 WebElement addButton;
	
	@FindBy(xpath="//input[@id='firstName']")
	 WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	 WebElement lastName;
	
	@FindBy(xpath="//input[@id='userEmail']")
	 WebElement userEmail;
	
	@FindBy(xpath="//input[@id='age']")
	 WebElement Age;
	
	@FindBy(xpath="//input[@id='salary']")
	 WebElement Salary;
	
	@FindBy(xpath="//input[@id='department']")
	 WebElement Department;
	
	public WebTablePage(WebDriver driver) {
		
		this.driver = driver;
		
		this.js = (JavascriptExecutor) driver;
		
		PageFactory.initElements(driver, this);
	}

	public void webTablesElement(Map<String, String> input) throws Exception
	{
		ExtentTest extentTest = ExtentTestManager.startTest("WebTable", "Clicking on Button");
	    
	    js.executeScript("arguments[0].scrollIntoView();", webtTable);
		
	    webtTable.click();
			
	    Thread.sleep(2000);
	    
	    js.executeScript("arguments[0].scrollIntoView();", addButton);
		
	    addButton.click();
			
	    Thread.sleep(2000);
	    
	    js.executeScript("arguments[0].scrollIntoView();", firstName);
		
	    firstName.sendKeys(input.get("firstName"));
			
	    Thread.sleep(2000);
	    
	    lastName.sendKeys(input.get("lastName"));
	    
	    userEmail.sendKeys(input.get("userEmail"));
	    
	    Age.sendKeys(input.get("age"));
	    
	    Salary.sendKeys(input.get("salary"));
	    
	    Department.sendKeys(input.get("department"));
	    
		ExtentTestManager.getTest().log(Status.INFO, "clicking Submit");
		
		ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);
	    
	    Actions act = new Actions(driver);
	    
	    act.sendKeys(Keys.ENTER).build().perform();
	}

}
