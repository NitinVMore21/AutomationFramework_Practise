package pageClasses;

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

public class TextBoxPage {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	
	@FindBy(xpath="//div[@class='element-list collapse show']//li[@id='item-0']")
	 WebElement textBox;
	
	@FindBy(xpath="//input[@id='userName']")
	 WebElement userName;
	
	@FindBy(xpath="//input[@id='userEmail']")
	 WebElement userEmail;
	
	@FindBy(xpath="//textarea[@id='currentAddress']")
	 WebElement currentAddress;
	
	@FindBy(xpath="//textarea[@id='permanentAddress']")
	 WebElement permanentAddress;
	
	@FindBy(xpath="//button[@id='submit']")
	 WebElement Submit;
	
	public TextBoxPage(WebDriver driver) {
		
		this.driver = driver;
		
		this.js = (JavascriptExecutor) driver;
		
		PageFactory.initElements(driver, this);
	}

	public void textBoxElement() throws Exception
	{
		ExtentTest extentTest = ExtentTestManager.startTest("TextBox", "Clicking on Button");
		
	    js.executeScript("arguments[0].scrollIntoView();", textBox);
			
	    textBox.click();
			
	    Thread.sleep(2000);
		
	    js.executeScript("arguments[0].scrollIntoView();", userName);
			
	    userName.sendKeys("Marsh");
			
	    Thread.sleep(2000);
	    
	    userEmail.sendKeys("xyz@xyz.com");
	    
	    currentAddress.sendKeys("Nashik Pune Highway");
	    
	    permanentAddress.sendKeys("Nashik Pune Highway");
	    
		ExtentTestManager.getTest().log(Status.INFO, "clicking Submit");
		
		ExtentConfiguration.addStepWithScreenshotInReport(driver, "test1.png", Status.DEBUG);
	    
	    Actions act = new Actions(driver);
	    
	    act.sendKeys(Keys.ENTER).build().perform();
	    
	    Submit.click();
	}

}
