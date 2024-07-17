package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilclasses.ExtentConfiguration;
import utilclasses.ExtentTestManager;

public class CheckBoxPage {
	
	public WebDriver driver;
	public JavascriptExecutor js;

	@FindBy(xpath="//button[@title='Toggle']//*[name()='svg']")
	 WebElement button;
	
	@FindBy(xpath="//label[@for='tree-node-desktop']//span[@class='rct-checkbox']//*[name()='svg']")
	 WebElement selectButton;
	
	public CheckBoxPage(WebDriver driver) {
		
		this.driver = driver;
		
		this.js = (JavascriptExecutor) driver;
		
		PageFactory.initElements(driver, this);
	}


	public void CheckboxElement() throws InterruptedException {
		
		ExtentTest extentTest = ExtentTestManager.startTest("CheckBox", "Clicking on Button");
		
		driver.findElement(By.id("item-1")).click();
		
		js.executeScript("window.scrollBy(0,200)");
		
		button.click();
		
		ExtentTestManager.getTest().log(Status.INFO, "option chossing");
		
		ExtentConfiguration.addStepWithScreenshotInReport(driver, "test1.png", Status.DEBUG);
		
		selectButton.click();
	}
}
