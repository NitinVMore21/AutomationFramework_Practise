package utilclasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentConfiguration {


	    public static WebDriver driver;
	    public static ExtentReports extent;
		public static final String WORKING_DIR = System.getProperty("user.dir");
		public static final String TIME_STAMP = new SimpleDateFormat("dd.MM.yyyy.HH.mm").format(new Date());
		public static final String EXTENT_REPORTS_FOLDER = WORKING_DIR + "/AutomationReports";
		public static final String REPORT_NAME = "ExtentReport_" + TIME_STAMP + ".html";
		public static final String EXTENT_REPORTS_PATH = EXTENT_REPORTS_FOLDER + File.separator + REPORT_NAME;
		public static Logger logger = LogManager.getLogger(ExtentConfiguration.class.getName());

	

		public static ExtentReports getInstance() {
		if (extent == null) {
		createReportsFolder();
		attachReporters();
		addStepWithScreenshotInReport(driver, "Test", Status.INFO);
		}
		return extent;
		}

		
		public static void createReportsFolder() {
			File file = new File(EXTENT_REPORTS_FOLDER);
			if (!file.exists() && !file.mkdir()) {
			logger.warn("Failed to create directory!");
			}
			}

		
		private static ExtentHtmlReporter initHtmlReporter() {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(EXTENT_REPORTS_PATH);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle(REPORT_NAME);
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setReportName("Execution-Status");
			htmlReporter.config().setCSS("css-string");
			htmlReporter.config().setJS("js-string");
			htmlReporter.config().setProtocol(Protocol.HTTPS);
			htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
			return htmlReporter;
			}


		public static ExtentReports attachReporters() {
			String klovReporterRequired = null;
			extent = new ExtentReports();
			extent.attachReporter(initHtmlReporter());
			return extent;
		}
		
		public static String captureScreenshot(WebDriver driver, String screenshotName) 
		{
	        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	        String screenshotName1 = "test_" + timestamp + ".png";
			String destinationPath =
					"C:\\Users\\nitin.more\\eclipse-workspace\\Automation_Practise\\"
					+ screenshotName1 + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(srcFile, new File(destinationPath));
		} catch (IOException e) 
		{
		logger.warn("Failed to capture screenshot...");
		}
		return destinationPath;
		}

		public static void addStepWithScreenshotInReport(WebDriver driver,String message, Status status) {
		ExtentTest extentTest = ExtentTestManager.getTest();
		if (extentTest != null) {
		if (driver != null) {
		String path = captureScreenshot(driver, "screenshot");
		try {
		extentTest.log(status, message,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
		logger.warn(e.getMessage());
		}
		} else {
		extentTest.log(status, message);
		}
		}
		}
		}

