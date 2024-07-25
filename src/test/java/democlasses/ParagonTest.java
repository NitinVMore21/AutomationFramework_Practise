package democlasses;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParagonTest {

	public WebDriver driver;
	
	@Test
	public void m1() throws Exception
	{
        WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		options.addArguments("--headless");
		
		driver = new ChromeDriver(options); 
		
		options.setHeadless(true);
		
		driver.manage().window().maximize(); 
		
		driver.get("https://uat.paragon-epro.com/login?returnUrl=%2F");
		
		Thread.sleep(10000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		
		WebElement username = driver.findElement(By.xpath("//input[@id='userName']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(username));
		
		username.sendKeys("test123");
		
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("test1");
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
				By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
		
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']"))).click();
	}
}
