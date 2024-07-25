package pageClasses;

import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilclasses.ExtentConfiguration;
import utilclasses.ExtentTestManager;

public class WebTablePage {
	
	private WebDriver driver;
	public JavascriptExecutor js;
	
	@FindBy(xpath="//span[normalize-space()='Web Tables']")
	 WebElement webtTable;
	
	@FindBy(xpath="//button[@id='addNewRecordButton']")
	 WebElement addButton;
	
	@FindBy(xpath="//input[@id='firstName']")
	 WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	 WebElement lastName;
	
	@FindBy(xpath="//input[@id='userEmail']")
	 WebElement userEmail;
	
	@FindBy(xpath="//input[@id='age']")
	 WebElement Age;
	
	@FindBy(xpath="//input[@id='salary']")
	 WebElement Salary;
	
	@FindBy(xpath="//input[@id='department']")
	 WebElement Department;
	
	
	
	public WebTablePage(WebDriver driver) {
		
		this.driver = driver;
		
		this.js = (JavascriptExecutor) driver;
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getwebtTable()
	{
		return webtTable;
	}
	
	public WebElement getaddButton()
	{
		return addButton;
	}
	
	public WebElement getfirstName()
	{
		return firstName;
	}
	
	public WebElement getlastName()
	{
	  return lastName;
	}
	
	public WebElement getuserEmail()
	{
		return userEmail;
	}
	
	public WebElement getAge()
	{
		return Age;
	}
	
	public WebElement getSalary()
	{
		return Salary;
	}
	
	public WebElement getDepartment()
	{
		return Department;
	}


}
