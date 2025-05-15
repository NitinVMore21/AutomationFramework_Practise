package tdstpageclasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AgentRegistrationOrg {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	
	@FindBy(xpath="//*[@id='ccc-close']") 
	 WebElement CloseButton;
	
	@FindBy(xpath="//*[text()='Sign up']") 
	 WebElement SignUpButton;
	
	@FindBy(xpath="//*[@id='selectItem-11']")
	 WebElement SelectItem;
	
	@FindBy(xpath="//*[@id='gridCheck1-11']")
	 WebElement SelectGrid;
	
	@FindBy(xpath="//*[@id='selTitle-11']")
	 WebElement SelectTitle;
	
	@FindBy(xpath="//*[@id='inputFName-11']")
	 WebElement FirstName;
	
	@FindBy(xpath="//*[@id='inputSName-11']")
	 WebElement SurName;
	
	@FindBy(xpath="//*[@id='inputEmailVal-11']")
	 WebElement Email;
	
	@FindBy(xpath="//*[text()='Submit']")
	 WebElement SubmitButton;
	
	@FindBy(xpath="//*[text()='I agree']")
	 WebElement AgreeButton;
	
	@FindBy(xpath="//*[@id='landLineValue-11']")
	 WebElement LandlineNumber;
	
	@FindBy(xpath="//*[@id='mobileValue-11']")
	 WebElement MobileNumber;
	
	@FindBy(xpath="//*[@id='whyTDSMS-11']")
	 WebElement ChooseTDS;
	
	@FindBy(xpath="//*[@id='whereTDSMS-11']")
	 WebElement WhereTDS;
	
	@FindBy(xpath="//*[@id='whyDAS-11']")
	 WebElement AnotherScheme;
	
	@FindBy(xpath="//*[@id='checkSubscription12-11']")
	 WebElement CheckBox;
	
	@FindBy(xpath="//*[text()='Join now']")
	 WebElement JoinNow;
	
	public AgentRegistrationOrg(WebDriver driver) {

		this.driver = driver;
		
		this.js = (JavascriptExecutor) driver;
		
		PageFactory.initElements(driver, this);
	}

	public void agentRegistrationsorg() throws Exception
	{
		Thread.sleep(5000);
		
		CloseButton.click();
		
		SignUpButton.click();
		
		Thread.sleep(5000);
		
		Select selectitem = new Select(SelectItem);
		
		selectitem.selectByVisibleText("Agent");
		
		SelectGrid.click();
		
		Select selecttitle = new Select(SelectTitle);
		
		selecttitle.selectByVisibleText("Mr.");
		
		FirstName.sendKeys("Nitin");
		
		SurName.sendKeys("More");
		
		Email.sendKeys("nitinmore13245@yopmail.com");
		
		SubmitButton.click();
		
		Thread.sleep(5000);
		
		AgreeButton.click();
		
		LandlineNumber.sendKeys("123456");
		
		MobileNumber.sendKeys("07123456789");
		
		Select selecttds = new Select(ChooseTDS);
		
		selecttds.selectByVisibleText("Bad experience from another scheme");
		
//		Select selectwheretds = new Select(WhereTDS);
//		
//		selectwheretds.selectByVisibleText("From a TDS  colleague");
//		
//		Select selectwhydas = new Select(AnotherScheme);
//		
//		selectwheretds.selectByVisibleText("No");
//		
//		CheckBox.click();
//		
//		JoinNow.click();
	}

}
