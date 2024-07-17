package democlasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoRadio {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	
	@Test
	
	public void m1() throws Exception
	{
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize(); 
		
		driver.get("https://demoqa.com/");
		
		js = (JavascriptExecutor) driver;
		
		WebElement element = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]"));
			
	    js.executeScript("arguments[0].scrollIntoView();", element);
			
	    element.click();
			
	    Thread.sleep(2000);
	    
	    WebElement radiobutton = driver.findElement(By.xpath("//span[normalize-space()='Radio Button']"));
	    
	    js.executeScript("arguments[0].scrollIntoView();", radiobutton);
		
	    radiobutton.click();
			
	    Thread.sleep(2000);
	    
	  WebElement yesbutton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
	  
	  js.executeScript("arguments[0].scrollIntoView();", yesbutton);
		
	  yesbutton.click();
			
	    Thread.sleep(2000);
	    
	}

}
