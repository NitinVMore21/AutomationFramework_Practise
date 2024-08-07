package testClasses;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.ButtonsPage;
import pageClasses.CheckBoxPage;
import pageClasses.CheckoutPage;
import pageClasses.ParagonLoginPage;
import pageClasses.RadioButtonPage;
import pageClasses.TextBoxPage;
import pageClasses.WebTablePage;
import utilclasses.EmailUtil;

public class BaseTest {
	

	public static String WORKING_DIR = System.getProperty("user.dir");
	public static String TIME_STAMP = new SimpleDateFormat("dd.MM.yyyy.HH.mm").format(new Date());
	public static String EXTENT_REPORTS_FOLDER = WORKING_DIR + "/AutomationReports";
	public static String REPORT_NAME = "ExtentReport_" + TIME_STAMP + ".html";
	public static String EXTENT_REPORTS_PATH = EXTENT_REPORTS_FOLDER + File.separator + REPORT_NAME;
	public WebDriver driver;
	public CheckoutPage cop;
	public JavascriptExecutor js;
	public CheckBoxPage cob;
	public RadioButtonPage rob;
	public TextBoxPage tbp;
	public ButtonsPage bp;
	public WebTablePage wtb;
	public Properties prop;
	public ParagonLoginPage plp;
	

	
	public WebDriver getWebDriver() {
		
		 try {
			loadProperties();
			initBrowser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
		return driver;
		
	}
	
	
	public void instantiatePOMClasses() {
		// instantiate the pom classes
		cob = new CheckBoxPage(driver);
		
		rob = new RadioButtonPage(driver);
		
	    tbp = new TextBoxPage(driver);
	    
	    bp = new ButtonsPage(driver);
	    
	    wtb = new WebTablePage(driver);
	    plp = new ParagonLoginPage(driver);
	}

	public void retryMechanism(WebElement ele ) {
		
		
	
	 int maxAttempts = 3; // Maximum number of times you want to retry

     int attempt = 1;
     boolean elementClickable = false;
     WebDriverWait wait = new WebDriverWait(driver, 20);
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
     
	} // end of method for retry
	
	
	// method for table navigations amd text extraction
	// input to this method is the xpath of the table till the tbody part
	public String getTextFrmTableBody(String baseXpath, String searchItem, int colIndex) throws InterruptedException {
		String finalText = null;
		
		// two loops.. first one iterates the total number of rows and second iterates the cols within a specific row
		List<WebElement> listEle =  driver.findElements(By.xpath(baseXpath));
		
		// get the number of cols
		Thread.sleep(3000);
			List<WebElement> listCols = driver.findElements(By.xpath("//*[@role='table']/thead/tr/th"));
		
		// iterate the rows of the table
		
		  for (int i=0; i< listEle.size() ; i++) { // iterate the cols of the table
		  for (int j =1; j<=listCols.size(); j++) {
			  int k = i+1;
			 WebElement test = listEle.get(i).findElement(By.xpath(baseXpath+"["+k+"]"+"/td["+j+"]"));
		  
		  if (searchItem.equalsIgnoreCase(test.getText())) {
			  WebElement targeEle =
					     listEle.get(i).findElement(By.xpath(baseXpath+"["+k+"]"+"/td["+colIndex+"]"));
			  finalText = targeEle.getText();
			  } // end of if
		  
		  
		  } // end of j loop
		 	
		} // end of for loop
		
		
		
		
		return finalText;
	}
	
	
	public String handleWebTable(String baseXpath, String searchItem, int colIndex, String actionRequired) throws InterruptedException {
		String finalText = null;
		 WebElement test;
		// two loops.. first one iterates the total number of rows and second iterates the cols within a specific row
		List<WebElement> listEle =  driver.findElements(By.xpath(baseXpath));
		// get the number of cols
		Thread.sleep(3000);
		List<WebElement> listCols = driver.findElements(By.xpath("//*[@role='table']/thead/tr/th"));
		// iterate the rows of the table
		  for (int i=0; i< listEle.size() ; i++) { // iterate the cols of the table
			  for (int j =1; j<=listCols.size(); j++) {
				  int k = i+1;
				  try {
					   test = listEle.get(i).findElement(By.xpath(baseXpath+"["+k+"]"+"/td["+j+"]"));}
					  catch(org.openqa.selenium.NoSuchElementException e) {
						  e.printStackTrace();
						  break;
					  }
				 // WebElement test = listEle.get(i).findElement(By.xpath(baseXpath+"["+k+"]"+"/td["+j+"]"));
		  
				  if (searchItem.equalsIgnoreCase(test.getText())) {
					  WebElement targeEle =
					     listEle.get(i).findElement(By.xpath(baseXpath+"["+k+"]"+"/td["+colIndex+"]"));
					    
					    if (actionRequired.equalsIgnoreCase("getText")) {
					    	finalText = targeEle.getText();
					    	return finalText;
					    	
					    }
					    if (actionRequired.equalsIgnoreCase("clickItem")) {
					    	targeEle.click();
					    	finalText= "dummy";
					    	return finalText;
					    }
					    
					    
				  } // end of if
		    } // end of j loop
		 	
		} // end of for loop
				
		return finalText;
	}
	
	public int getMatchRowNum(String baseXpath, String searchItem, int colIndex, String actionRequired) throws InterruptedException {
		int rowNum = 0;
		 WebElement test;
		List<WebElement> listEle =  driver.findElements(By.xpath(baseXpath));
		// get the number of cols
		Thread.sleep(3000);
		List<WebElement> listCols = driver.findElements(By.xpath("//*[@role='table']/thead/tr/th"));
		// iterate the rows of the table
		  for (int i=0; i< listEle.size() ; i++) { // iterate the cols of the table
			  for (int j =1; j<=listCols.size(); j++) {
				  int k = i+1;
				  try {
				   test = listEle.get(i).findElement(By.xpath(baseXpath+"["+k+"]"+"/td["+j+"]"));}
				  catch(org.openqa.selenium.NoSuchElementException e) {
					  e.printStackTrace();
					  break;
				  }
		  
				  if (searchItem.equalsIgnoreCase(test.getText().trim())) {
					  WebElement targeEle =
					     listEle.get(i).findElement(By.xpath(baseXpath+"["+k+"]"+"/td["+colIndex+"]"));
					    
					    if (actionRequired.equalsIgnoreCase("getRowNum")) {
					    	rowNum = k;
					    	return rowNum;
					    }
					    
					    
					    
				  } // end of if
		    } // end of j loop
		 	
		} // end of for loop
				
		
		
		return rowNum;
		
	}
	
	
	 @BeforeClass(alwaysRun = true)
     public void setup() throws Exception {
			/*
			 * loadProperties(); initBrowser(); driver.manage().window().maximize();
			 * driver.get(prop.getProperty("testurl")); performInitialActions();
			 */
    }

    public void loadProperties() throws IOException {
        prop = new Properties();
        String propFilePath = WORKING_DIR + System.getProperty("file.separator") + "/conf.properties";
        prop.load(new FileReader(propFilePath));
    }

    public WebDriver initBrowser() throws Exception {
    	
        String browser = prop.getProperty("browser").toLowerCase();
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
              //  chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                //chromeOptions.setHeadless(true);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                firefoxOptions.setHeadless(true);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                edgeOptions.setHeadless(true);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        return driver;
    }

    private void performInitialActions() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        Thread.sleep(2000);
    }
	
	@BeforeMethod (alwaysRun = true)
	
	public void createObject()
	{ 
		//cop = new CheckTextoutPage(driver);
		
		
		  cob = new CheckBoxPage(driver);
		  
		  rob = new RadioButtonPage(driver);
		  
		  tbp = new TextBoxPage(driver);
		  
		  bp = new ButtonsPage(driver);
		  
		  wtb = new WebTablePage(driver);
		 
	}
	/*
	 * @AfterClass public void tearDown() { if(driver != null) { driver.quit(); } }
	 */
	
    @AfterSuite
    public void sendReport() {
    	
		/*
		 * String reportPath = EXTENT_REPORTS_PATH; String toEmail =
		 * "gaurav.shukla@espireinfo.co.uk"; String fromEmail = "nitin.more@espire.com";
		 * String host = "smtp-mail.outlook.com"; String subject = "TestNG Report";
		 * String body = "Please find the attached Extent Report.";
		 * 
		 * EmailUtil.sendEmailWithReport(reportPath, toEmail, fromEmail, host, subject,
		 * body);
		 */
    }

}
