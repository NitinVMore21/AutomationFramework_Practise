package democlasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilclasses.ExtentConfiguration;
import utilclasses.ExtentTestManager;

public class DemoButtons {
	
	public WebDriver driver;
	public JavascriptExecutor js;

	@Test
	public void m1 () throws Exception
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize(); 
		
		driver.get("https://demoqa.com/");
		
		ExtentTest extentTest = ExtentTestManager.startTest("ButtonTest", "Clicking on Button");
		
		js = (JavascriptExecutor) driver;
		
		WebElement element = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]"));
			
	    js.executeScript("arguments[0].scrollIntoView();", element);
			
	    element.click();
			
	    Thread.sleep(2000);
	    
		WebElement buttons = driver.findElement(By.xpath("//span[normalize-space()='Buttons']"));
		
	    js.executeScript("arguments[0].scrollIntoView();", buttons);
			
	    buttons.click();
			
	    Thread.sleep(2000);
	    
		WebElement doubleclick = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		
	    js.executeScript("arguments[0].scrollIntoView();", doubleclick);
	    
        ExtentTestManager.getTest().log(Status.INFO, "doubleclick");
		
		ExtentConfiguration.addStepWithScreenshotInReport(driver, "test1.png", Status.DEBUG);
			
        Actions act = new Actions(driver);
      
        act.doubleClick(doubleclick);
			
	    Thread.sleep(2000);
	    
	}
}
