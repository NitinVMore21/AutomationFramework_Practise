package democlasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DemoBaseClass {
    protected WebDriver driver;
    protected Properties prop;
    protected JavascriptExecutor js;
    public static String WORKING_DIR = System.getProperty("user.dir");

    @Test(alwaysRun = true)
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
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(edgeOptions);
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

    @BeforeMethod(alwaysRun = true)
    public void createPageObjects() {
       
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Teardown Successfully");
    }
}
