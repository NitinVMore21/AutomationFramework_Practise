package pageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilclasses.ExtentConfiguration;
import utilclasses.ExtentTestManager;

public class RadioButtonPage {
	
	private WebDriver driver;
	public JavascriptExecutor js;
	
	@FindBy(xpath="//span[normalize-space()='Radio Button']")
	 WebElement radioButton;
	
	@FindBy(xpath="//label[@for='yesRadio']")
	 WebElement yesButton;

  public RadioButtonPage(WebDriver driver) {
	
	this.driver = driver;
	
	this.js = (JavascriptExecutor) driver;
	
	PageFactory.initElements(driver, this);
	
	}

  public void setradioButton(WebElement radioButton)
  {
	  this.radioButton=radioButton;
  }
  
  public WebElement getradioButton()
  {
	  return radioButton;
  }
  
  public WebElement getyesButton()
  {
	  return yesButton;
  }
    
}

	