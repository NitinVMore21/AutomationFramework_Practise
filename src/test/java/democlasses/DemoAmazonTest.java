package democlasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAmazonTest {
	
	
	@Test
	
	public void amazonTest() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
			
		WebDriver driver = new ChromeDriver(options);
				
		driver.get("https://www.amazon.in/");
		
		System.out.println("We are on the URL");
		
		Thread.sleep(10);
		
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Laptops");
		
		driver.findElement(By.xpath("//*[text()=' under 20000 price']")).click();
		
		System.out.println("We are selecting the 2nd Options from dropdown");
 	}

}
