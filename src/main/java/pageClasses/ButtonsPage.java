package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilclasses.ExtentConfiguration;
import utilclasses.ExtentTestManager;


public class ButtonsPage {

	public WebDriver driver;
	public JavascriptExecutor js;
	
	@FindBy(xpath="//span[normalize-space()='Buttons']")
	 WebElement Buttons;
	
	@FindBy(xpath="//button[@id='doubleClickBtn']")
	 WebElement DoubleClick;
	
	public ButtonsPage(WebDriver driver) {

		this.driver = driver;
		
		this.js = (JavascriptExecutor) driver;
		
		PageFactory.initElements(driver, this);
	}

	public void buttonsElement() throws Exception
	{
		ExtentTest extentTest = ExtentTestManager.startTest("ButtonTest", "Clicking on Button");
		
	    js.executeScript("arguments[0].scrollIntoView();", Buttons);
			
	    Buttons.click();
			
	    Thread.sleep(2000);
		
		ExtentTestManager.getTest().log(Status.INFO, "DoubleClick");
		
		ExtentConfiguration.addStepWithScreenshotInReport(driver, "test1.png", Status.DEBUG);
		
	    js.executeScript("arguments[0].scrollIntoView();", DoubleClick);
			
        Actions act = new Actions(driver);
        
        act.doubleClick(DoubleClick);
			
	    Thread.sleep(2000);
	}
}
