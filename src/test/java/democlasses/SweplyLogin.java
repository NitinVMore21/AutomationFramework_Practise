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

public class SweplyLogin {

	private WebDriver driver;
	public JavascriptExecutor js;

	@Test

	public void login() throws Exception
	{
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize(); 

		driver.get("https://dev.mor.link/en");

		Thread.sleep(6000);

		ExtentTestManager.startTest("SweplyLogin", "Login to Sweply");

		js = (JavascriptExecutor) driver;

		WebElement loginButton = driver.findElement(By.xpath
				("//a[@class='loginBtn px-4 py-2.5 inline-block bg-transparent border border-mor-blue-500 rounded-lg mr-4 rtl:ml-4 rtl:mr-0']"));

		js.executeScript("arguments[0].scrollIntoView();", loginButton);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(loginButton));

		loginButton.click();

		WebElement emailBox = driver.findElement(By.xpath("//*[@id='email']"));

		js.executeScript("arguments[0].scrollIntoView();", emailBox);

		wait.until(ExpectedConditions.elementToBeClickable(emailBox));

		emailBox.sendKeys("nitinvmore1981@gmail.com");

		WebElement passwordBox = driver.findElement(By.xpath("//*[@id='password']"));

		js.executeScript("arguments[0].scrollIntoView();", passwordBox);

		wait.until(ExpectedConditions.elementToBeClickable(passwordBox));

		passwordBox.sendKeys("Nitin@2024");

		WebElement signinBox = driver.findElement(By.xpath("//*[@id='signInText']"));

		js.executeScript("arguments[0].scrollIntoView();", signinBox);

		wait.until(ExpectedConditions.elementToBeClickable(signinBox));

		signinBox.click();

		ExtentTestManager.getTest().log(Status.INFO, "clicking Sign In");

		ExtentConfiguration.addStepWithScreenshotInReport(driver, "Test.png", Status.DEBUG);

	}

}
