package democlasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoGuru {
	
	
public static void main(String[] args) {
	

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.guru99.com/");
		
		List<WebElement> headers = driver.findElements(By.xpath("//*[@id='tutorials-library']//*[contains()='kt-accordion-header']"));
		
	       for (WebElement headerss: headers)
	       {
	    	   System.out.println("The headers are :"+ headerss);
	       }
	}

}
