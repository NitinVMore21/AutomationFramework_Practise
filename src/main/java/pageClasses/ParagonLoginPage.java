package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParagonLoginPage {

		private WebDriver driver;
		
		@FindBy(xpath="//*[@id='userName']")
		WebElement UserName;
		
		@FindBy(xpath="//*[@id='password']")
		WebElement Password;
		
		@FindBy(xpath="//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")
		WebElement Captcha;
		
		@FindBy(xpath="//span[@class='mat-button-wrapper']")
		
		WebElement SubmitButton;
				

	public ParagonLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserName()
	{
		return UserName;
	}

	public WebElement getPassword()
	{
		return Password;
	}

	public WebElement getCaptcha()
	{
		return Captcha;
	}

	public WebElement getSubmitButton()
	{
		return SubmitButton;
	}
		

}
