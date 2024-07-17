package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		
		this.driver = driver;
		
	//	PageFactory.initElements(driver, this);
	}

	public void verifyingLogin() throws Exception
	{
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@class='login']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='login_id']")).sendKeys("nitinvmore1981@gmail.com");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='nextbtn']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Nitin@2020");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='nextbtn']")).click();	
		
	}
	
	
}
