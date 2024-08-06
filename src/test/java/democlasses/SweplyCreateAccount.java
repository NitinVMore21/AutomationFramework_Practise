package democlasses;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilclasses.ExtentConfiguration;
import utilclasses.ExtentTestManager;

public class SweplyCreateAccount {
	
	
	private WebDriver driver;
	public JavascriptExecutor js;
	
	@Test
	public void signUp() throws Exception
	{
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize(); 

		driver.get("https://dev.mor.link/en");

		Thread.sleep(6000);

		ExtentTestManager.startTest("SweplySignin", "Sign up to Sweply");

		js = (JavascriptExecutor) driver;

		WebElement loginButton = driver.findElement(By.xpath
				("//a[@class='loginBtn px-4 py-2.5 inline-block bg-transparent border border-mor-blue-500 rounded-lg mr-4 rtl:ml-4 rtl:mr-0']"));

		js.executeScript("arguments[0].scrollIntoView();", loginButton);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(loginButton));

		loginButton.click();
		
		WebElement createAccButton = driver.findElement(By.xpath("//*[@id='createAccountText']"));

		js.executeScript("arguments[0].scrollIntoView();", createAccButton);

		wait.until(ExpectedConditions.elementToBeClickable(createAccButton));

		createAccButton.click();
		
		WebElement firstNameBox = driver.findElement(By.xpath("//*[@id='first_name']"));

		js.executeScript("arguments[0].scrollIntoView();", firstNameBox);

		wait.until(ExpectedConditions.elementToBeClickable(firstNameBox));

		firstNameBox.sendKeys("Nitin");
		
		WebElement lastNameBox = driver.findElement(By.xpath("//*[@id='last_name']"));

		js.executeScript("arguments[0].scrollIntoView();", lastNameBox);

		wait.until(ExpectedConditions.elementToBeClickable(lastNameBox));

		lastNameBox.sendKeys("Nitin");
		
		WebElement emailIdBox = driver.findElement(By.xpath("//*[@id='email_id']"));

		js.executeScript("arguments[0].scrollIntoView();", emailIdBox);

		wait.until(ExpectedConditions.elementToBeClickable(emailIdBox));

		emailIdBox.sendKeys("nitinmore931@gmail.com");
		
		WebElement passwordBox = driver.findElement(By.xpath("//*[@id='signup_password']"));

		js.executeScript("arguments[0].scrollIntoView();", passwordBox);

		wait.until(ExpectedConditions.elementToBeClickable(passwordBox));

		passwordBox.sendKeys("Nitin@2020");
		
		WebElement signUpBox = driver.findElement(By.xpath("//*[@id='btn-signup']"));

		js.executeScript("arguments[0].scrollIntoView();", signUpBox);

		wait.until(ExpectedConditions.elementToBeClickable(signUpBox));

		signUpBox.click();
		
		ExtentTestManager.getTest().log(Status.INFO, "clicking on Sign up");

		ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);

	}

}
