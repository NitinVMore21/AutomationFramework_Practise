package paragondemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTable {

    public WebDriver driver;
    public JavascriptExecutor js;

    @Test
    public void m1() throws Exception {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/");

        js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        Thread.sleep(2000);

        WebElement webtable = driver.findElement(By.xpath("//span[normalize-space()='Web Tables']"));
        js.executeScript("arguments[0].scrollIntoView();", webtable);
        webtable.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='rt-table']")));

        // Get headers
        List<WebElement> headers = table.findElements(By.xpath(".//div[@class='rt-thead -header']//div[@role='columnheader']"));
        System.out.println("Table Headers:");
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

        int headerCount = headers.size();
        System.out.println("Header's count: " + headerCount);

        // Get rows
        List<WebElement> rows = table.findElements(By.xpath(".//div[@class='rt-tbody']//div[@role='row']"));
        if (rows.isEmpty()) {
            System.out.println("No data found");
        } else {
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.xpath(".//div[@role='gridcell']"));
                // Ensure the cells list has the expected number of columns
                if (cells.size() >= 4) {  // Assuming email is in the fourth column
                    String firstName = cells.get(0).getText();  // Assuming the first column is the first name
                    if (firstName.equals("Kierra")) {
                        String email = cells.get(3).getText();  // Assuming the email is in the fourth column
                        System.out.println("Email for " + firstName + ": " + email);
                    }
                } else {
                    System.out.println("Row does not have enough columns: " + cells.size());
                }
            }
        }

      
    }
}
