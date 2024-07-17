package democlasses;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoWindow {
	
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
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String parentId = driver.getWindowHandle();
		
		Thread.sleep(5000);
		
        js = (JavascriptExecutor) driver;
		
		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']"));
			
	    js.executeScript("arguments[0].scrollIntoView();", element);
			
	    element.click();
		
		Set<String> allwindowid = driver.getWindowHandles();
		
		for(String winid:allwindowid)
		{
			System.out.println(winid);
			
			if(!(parentId.equals(winid)))
			{
				driver.switchTo().window(winid);
			}
		}
		
		driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/a[1]/button[1]")).click();
		
	}
}
