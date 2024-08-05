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
			
			driver.get("https://uat.paragon-epro.com/login");//https://uat.paragon-epro.com/login
			
			Thread.sleep(2000);
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
			WebElement username = driver.findElement(By.xpath("//*[@id='userName']"));
			
	//		String print = username.getAttribute("data-placeholder");
	//		
	//		System.out.println(print);
			
			wait.until(ExpectedConditions.elementToBeClickable(username));
			
			username.sendKeys("Staginguser_1");
			
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Paragon@2024");
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
					By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
			
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
	        
			driver.switchTo().frame("a-");
			driver.switchTo().frame(0);
	        
	        driver.switchTo().defaultContent();
	        
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//button[@type='submit']"))).click(); // fail
		}
//	@Test
//	public void validateParagonWebsite() throws InterruptedException
//	{
//		WebDriverManager.chromedriver().setup();
//
//		ChromeOptions options = new ChromeOptions();
//
//		options.addArguments("--remote-allow-origins=*");
//
//		options.addArguments("--headless");
//
//		driver = new ChromeDriver(options); 
//
//		options.setHeadless(true);
//
//		driver.manage().window().maximize(); 
//		driver.get("https://uat.paragon-epro.com/login");
//		driver.manage().window().maximize();
//		System.out.println("URL Launched");
//		//Enter username
//		plp.getUserName().sendKeys("test");
//		Thread.sleep(2000);
//		/*driver.findElement(By.name("userName")).sendKeys("test");
//		System.out.println("Username- test");
//		Thread.sleep(2000);*/
//		//Enter password
//		plp.getPassword().sendKeys("test1");
//		Thread.sleep(2000);
//		/*driver.findElement(By.name("password")).sendKeys("test1");
//		System.out.println("Password- test1");*/
//		Thread.sleep(2000);
//		//Click on checkbox
//
//		//new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(plp.getCaptcha()));
//		// reCAPTCHA
//		new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
//
//		//	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
//		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='recaptcha-anchor-label']"))).click();
//		//driver.switchTo().frame("a-");
//		//driver.switchTo().frame(0);
//		Thread.sleep(7000);
//
//		System.out.println("captcha selected");
//		driver.switchTo().defaultContent();
//		//Click on login
//		//	plp.getSubmitButton().click();
//		//driver.findElement(By.xpath("//button[@type='submit' and @class='mat-focus-indicator login100-form-btn mat-raised-button mat-button-base']")).click();
//		driver.findElement(By.xpath("//button")).click();
//		System.out.println("submit button clicked");
//
//	}

}
