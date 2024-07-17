package democlasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoFrames {
	
	public WebDriver driver;
	
	@Test
	
	public void m1() throws Exception
	{
        WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize(); 
		
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(iframe);
		
		WebElement draggable = driver.findElement(By.xpath("//*[@id='draggable']"));
		
		WebElement droppable = driver.findElement(By.xpath("//*[@id='droppable']"));
		
		Actions act = new Actions(driver);
		
		act.clickAndHold(draggable).moveToElement(droppable).release(draggable).build().perform();
		
		driver.switchTo().parentFrame();
	}
}
