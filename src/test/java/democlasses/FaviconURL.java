package democlasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaviconURL {
	
	public WebDriver driver;
	@Test
	public void m1()
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize(); 
		
		driver.get("https://ess.espire.com/dashboard");
		
        // Locate the favicon element
        WebElement faviconElement = driver.findElement(By.xpath("//link[@rel='icon' or @rel='shortcut icon']"));
        
        // Get the favicon URL
        String faviconUrl = faviconElement.getAttribute("href");
        
        System.out.println(faviconUrl);
	}
	


}
