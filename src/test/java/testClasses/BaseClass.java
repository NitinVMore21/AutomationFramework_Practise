package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.ButtonsPage;
import pageClasses.CheckBoxPage;
import pageClasses.CheckoutPage;
import pageClasses.RadioButtonPage;
import pageClasses.TextBoxPage;
import pageClasses.WebTablePage;

public class BaseClass {
	
	public WebDriver driver;
	public CheckoutPage cop;
	public JavascriptExecutor js;
	public CheckBoxPage cob;
	public RadioButtonPage rob;
	public TextBoxPage tbp;
	public ButtonsPage bp;
	public WebTablePage wtb;
	
	@BeforeClass

	public WebDriver initBrowser() throws Exception
	{
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		options.addArguments("--headless");
		
		driver = new ChromeDriver(options);
		
		options.setHeadless(true);
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/");
		
		js = (JavascriptExecutor) driver;
		
	    WebElement element = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]"));
		
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		element.click();
		
		Thread.sleep(2000);
		
		return driver;
		
	}
	
	@BeforeMethod
	
	public void createObject()
	{ 
		//cop = new CheckTextoutPage(driver);
		
		cob = new CheckBoxPage(driver);
		
		rob = new RadioButtonPage(driver);
		
	    tbp = new TextBoxPage(driver);
	    
	    bp = new ButtonsPage(driver);
	    
	    wtb = new WebTablePage(driver);
	}
	
	@AfterClass
	public void tearDown()
{
	if(driver != null)
		{
	driver.quit();
		}
	}
}
