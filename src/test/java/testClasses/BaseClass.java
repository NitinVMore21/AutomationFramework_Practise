package testClasses;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.ButtonsPage;
import pageClasses.CheckBoxPage;
import pageClasses.CheckoutPage;
import pageClasses.RadioButtonPage;
import pageClasses.TextBoxPage;
import pageClasses.WebTablePage;
import utilclasses.EmailUtil;

public class BaseClass {
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
	


	 @BeforeClass(alwaysRun = true)
     public void setup() throws Exception {
        loadProperties();
        initBrowser();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("testurl"));
        performInitialActions();
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
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                chromeOptions.setHeadless(true);
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
	
	@BeforeMethod
	
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
    	
        String reportPath =  EXTENT_REPORTS_PATH;
        String toEmail = "gaurav.shukla@espireinfo.co.uk";
        String fromEmail = "nitin.more@espire.com";
        String host = "smtp-mail.outlook.com";
        String subject = "TestNG Report";
        String body = "Please find the attached Extent Report.";

        EmailUtil.sendEmailWithReport(reportPath, toEmail, fromEmail, host, subject, body);
    }
}
