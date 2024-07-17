package democlasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAlerts {
	
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
		
		WebElement element = driver.findElement(By.xpath("//div[3]//div[1]//div[2]//*[name()='svg']"));
			
	    js.executeScript("arguments[0].scrollIntoView();", element);
			
	    element.click();
	    
		WebElement alertelement = driver.findElement(By.xpath("//span[normalize-space()='Alerts']"));
		
	    js.executeScript("arguments[0].scrollIntoView();", alertelement);
			
	    alertelement.click();
	    
		WebElement alertelement1 = driver.findElement(By.xpath("//*[@id='alertButton']"));
		
	    js.executeScript("arguments[0].scrollIntoView();", alertelement1);
			
	    alertelement1.click();
	    
	    driver.switchTo().alert().accept();
	    
		WebElement alertelement2 = driver.findElement(By.xpath("//*[@id='alertButton']"));
		
	    js.executeScript("arguments[0].scrollIntoView();", alertelement2);
			
	    alertelement2.click();
	    
	    Thread.sleep(6000);
	    
	    driver.switchTo().alert().accept();
	    
		WebElement alertelement3 = driver.findElement(By.xpath("//*[@id='alertButton']"));
		
	    js.executeScript("arguments[0].scrollIntoView();", alertelement3);
			
	    alertelement3.click();
	    
	    driver.switchTo().alert().accept();
	    
		WebElement alertelement4 = driver.findElement(By.xpath("//*[@id='promtButton']"));
		
	    js.executeScript("arguments[0].scrollIntoView();", alertelement4);
			
	    alertelement4.click();
	    
	    driver.switchTo().alert().dismiss();
	    
	}

}
