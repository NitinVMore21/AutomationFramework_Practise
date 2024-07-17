package democlasses;

import java.util.Map;

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
import utilclasses.TestDataProvider;



public class DemoWebtables extends TestDataProvider {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	
	@Test(dataProvider = "data")
	public void m1 (Map<String, String> input) throws Exception {
	
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
    
    WebElement webtable = driver.findElement(By.xpath("//span[normalize-space()='Web Tables']"));
    
    js.executeScript("arguments[0].scrollIntoView();", webtable);
	
    webtable.click();
		
    Thread.sleep(2000);
    
    WebElement addbutton = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
    
    js.executeScript("arguments[0].scrollIntoView();", addbutton);
	
    addbutton.click();
		
    Thread.sleep(2000);
    
    WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
    
    js.executeScript("arguments[0].scrollIntoView();", firstname);
	
    firstname.sendKeys(input.get("firstName"));
		
    Thread.sleep(2000);
    
    driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(input.get("lastName"));
    
    driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(input.get("userEmail"));
    
    driver.findElement(By.xpath("//input[@id='age']")).sendKeys(input.get("age"));
    
    driver.findElement(By.xpath("//input[@id='salary']")).sendKeys(input.get("salary"));
    
    driver.findElement(By.xpath("//input[@id='department']")).sendKeys(input.get("department"));
    
    Actions act = new Actions(driver);
    
    act.sendKeys(Keys.ENTER).build().perform();

}
}
