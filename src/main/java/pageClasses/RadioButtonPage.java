package pageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilclasses.ExtentConfiguration;
import utilclasses.ExtentTestManager;

public class RadioButtonPage {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	
	@FindBy(xpath="//span[normalize-space()='Radio Button']")
	 WebElement radioButton;
	
	@FindBy(xpath="//label[@for='yesRadio']")
	 WebElement yesButton;

  public RadioButtonPage(WebDriver driver) {
	
	this.driver = driver;
	
	this.js = (JavascriptExecutor) driver;
	
	PageFactory.initElements(driver, this);
	
	}

     public void RadiobuttonElement() throws InterruptedException {
		
    	 ExtentTest extentTest = ExtentTestManager.startTest("RadioButton", "Clicking on Button");
 	    
 	    js.executeScript("arguments[0].scrollIntoView();", radioButton);
 		
 	    radioButton.click();
 			
 	    Thread.sleep(2000);
 	  
 	    js.executeScript("arguments[0].scrollIntoView();", yesButton);
 	    
		ExtentTestManager.getTest().log(Status.INFO, "clicking Yes");
		
		ExtentConfiguration.addStepWithScreenshotInReport(driver, "test1.png", Status.DEBUG);
 		
		yesButton.click();
 			
 	    Thread.sleep(2000);
	}
}
