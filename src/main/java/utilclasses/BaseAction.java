package utilclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseAction {
	
	static WebDriver driver;
	public void retryMechanism(WebDriver driver, WebElement ele ) {
		
		
		
		 int maxAttempts = 3; // Maximum number of times you want to retry
	 
	     int attempt = 1;
	     boolean elementClickable = false;
	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	     while (attempt <= maxAttempts) {
	         try {
	             WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
	             element.click(); // Click the element once it becomes clickable
	           
	             elementClickable = true; // Set the flag to indicate it was clicked
	 
	             break; // Break the loop since the action was successful
	 
	         } catch (Exception e) {
	             // Not clickable, maybe retry?
	 
	        	 System.out.println("RETRY done " +attempt);
	             attempt++; // Increment the attempt count
	 
	         }
	     }
	     
		}
	
	
	public void retryMechanismWithSendKeys(WebDriver driver, WebElement ele, String Key ) {
		
		
		
		 int maxAttempts = 3; // Maximum number of times you want to retry
	 
	     int attempt = 1;
	     boolean elementClickable = false;
	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	     while (attempt <= maxAttempts) {
	         try {
	             WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
	             element.sendKeys(Key); // Click the element once it becomes clickable
	           
	             elementClickable = true; // Set the flag to indicate it was clicked
	 
	             break; // Break the loop since the action was successful
	 
	         } catch (Exception e) {
	             // Not clickable, maybe retry?
	 
	        	 System.out.println("RETRY done " +attempt);
	             attempt++; // Increment the attempt count
	 
	         }
	     }
	
	
	
	}
}
