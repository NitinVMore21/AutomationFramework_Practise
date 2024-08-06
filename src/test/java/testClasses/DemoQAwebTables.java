package testClasses;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilclasses.BaseAction;

public class DemoQAwebTables extends BaseTest{
	
	private WebDriverWait wait;
	 JavascriptExecutor js;
	
	  

	
	@Test
	public void Automate() throws InterruptedException  {
		getWebDriver();
		instantiatePOMClasses();
		
		BaseAction ba = new BaseAction();
		
		js = (JavascriptExecutor) driver;
	
		
		driver.get("https://demoqa.com/");
		 driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Enter username
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	      //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='avatar mx-auto white'])[1]"))).click();
		//driver.findElement(By.xpath("(//div[@class='avatar mx-auto white'])[1]"))
	      //*[@id='item-3'])[1]
	  //    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='item-3'])[1]"))).click();
	      
	      
	  	
	  	js = (JavascriptExecutor) driver;
	  	
	  	WebElement element = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]"));
	  		
	      js.executeScript("arguments[0].scrollIntoView();", element);
	  		
	      element.click();
	  		
	      Thread.sleep(2000);
	      
	      WebElement webtable = driver.findElement(By.xpath("//span[normalize-space()='Web Tables']"));
	      
	      js.executeScript("arguments[0].scrollIntoView();", webtable);
	  	
	      webtable.click();
	      
	      
	      
	      
		
	} // end of test method
} // end of class