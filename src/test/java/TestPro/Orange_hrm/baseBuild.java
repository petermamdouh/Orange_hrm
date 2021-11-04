package TestPro.Orange_hrm;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class baseBuild extends variables {
	ExtentReports extent;
	ChromeDriver driver ;
	
	
	@BeforeSuite
	public void globalSetup () throws IOException {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Navigate to the URL", "Navigate to orangehrmlive.com");
		
		String chrome = System.getProperty("user.dir")+"\\recourse\\chromedriver95.exe";
		System.setProperty("webdriver.chrome.driver", chrome);
		driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login_txt)));
		
		test.log(Status.PASS, "Navigated Successfully");
	
	}
	
	@AfterSuite
	public void globalTearDown () {
		extent.flush();
		driver.close();
	}
	
}


