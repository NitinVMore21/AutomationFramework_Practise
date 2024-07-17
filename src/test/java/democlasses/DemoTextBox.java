package democlasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTextBox {
	
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
	    
	    WebElement textbox = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']"));
		
	    js.executeScript("arguments[0].scrollIntoView();", textbox);
			
	    textbox.click();
			
	    Thread.sleep(2000);
	    
	    WebElement username = driver.findElement(By.xpath("//input[@id='userName']"));
		
	    js.executeScript("arguments[0].scrollIntoView();", username);
			
	    username.sendKeys("Marsh");
			
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("xyz@xyz.com");
	    
	    driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Nashik Pune Highway");
	    
	    driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Nashik Pune Highway");
	    
//	    Actions act = new Actions(driver);
//	    
//	    act.sendKeys(Keys.ENTER).build().perform();
	    
	    driver.findElement(By.xpath("//button[@id='submit']")).click();
	    
	}

}
