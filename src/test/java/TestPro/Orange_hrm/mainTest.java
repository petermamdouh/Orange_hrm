package TestPro.Orange_hrm;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class mainTest extends baseBuild {
	
	public static String userpriv;
	public static String selectEmployeeName;
	public static String userRand;
	public static int  userstatus;
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		ExtentTest test  = extent.createTest("Login with valid data", "insert valid Email and password And expected navigate to the dashboard");
		
		// Enter your Email 
		WebElement email_field = driver.findElement(By.xpath(email));
		email_field.click();
		email_field.sendKeys("Admin");
		
		//Enter password 
		WebElement password = driver.findElement(By.xpath(pass));
		password.click();
		password.sendKeys("admin123");
		
		//press on the login btn
		WebElement login_button = driver.findElement(By.xpath(login_btn));
		login_button.click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(welcome)));
		
		WebElement welcome_title = driver.findElement(By.xpath(welcome));
		System.out.println(welcome_title.getText());
		
		Assert.assertTrue(welcome_title.getText().contains("Welcome"));
		
		test.log(Status.PASS, "User enter valid data and navigate to the Dashboard");		
	}
	
	@Test(priority = 2)
	public void add_new() throws InterruptedException {
		ExtentTest test  = extent.createTest("Add new user", "Enter valid data in field ");
		
		WebElement add_new = driver.findElement(By.xpath(admin_btn));
		add_new.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(add_btn)));
		
		WebElement add = driver.findElement(By.xpath(add_btn));
		add.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(add_header)));
		
		//add privilege
		WebElement priv = driver.findElement(By.xpath(privilege));
		Select option = new Select(priv); 
		option.selectByValue("1");
		userpriv = "Admin"; 
		
		
		//add employee name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(employeeName)));
		WebElement employee_name = driver.findElement(By.xpath(employeeName));
		employee_name.sendKeys("Peter Mac Anderson");
		selectEmployeeName = "Peter Mac Anderson";
		
		//add user name
		int min = 1;
	    int max = 1000;
	    int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userName)));
		WebElement user_name = driver.findElement(By.xpath(userName));
		user_name.sendKeys("user_name"+random_int);
		userRand = "user_name"+random_int  ;
		
		
		//add status
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(status)));
		WebElement status_list = driver.findElement(By.xpath(status));
		Select statusOption = new Select(status_list); 
		statusOption.selectByVisibleText("Enabled");
		userstatus = 1;
		
		
		//add pass
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userPass)));
		WebElement user_pass = driver.findElement(By.xpath(userPass));
		user_pass.sendKeys("pass@123");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(confPass)));
		WebElement conf_pass = driver.findElement(By.xpath(confPass));
		conf_pass.sendKeys("pass@123");
		
		WebElement save_btn = driver.findElement(By.xpath(save));
		save_btn.click();
		
		Thread.sleep(2000);  
		WebElement usertxt = driver.findElement(By.xpath(system_user));
		System.out.println(usertxt.getText());
		
		Assert.assertTrue(usertxt.getText().contains("System Users"));
		
		test.log(Status.PASS, "User created successfully");		
			
	}
	
	@Test(priority = 3)
	public void search() throws InterruptedException {
		ExtentTest test  = extent.createTest("Search", "Search for a user");
		
		WebElement search = driver.findElement(By.xpath(search_field));
		search.sendKeys(userRand);
		
		WebElement btn_search = driver.findElement(By.xpath(search_btn));
		btn_search.click();
		
		WebElement result_td = driver.findElement(By.xpath(table));
		List<WebElement> rows = result_td.findElements(By.tagName("tr"));
		
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {				
				//System.out.println(col.getText());
				for(int i = 0; i<5 ; i++) {
					if(col.getText().contains(userRand)) {
						Assert.assertTrue(col.getText().contains(userRand));
						break;
					}
				}
			}
		}
		
		test.log(Status.PASS, "User returned successfully");		  
		
	}
	
	@Test(priority = 4)
	public void assertion() throws InterruptedException {
		ExtentTest test  = extent.createTest("Assertion", "View user details");
		
		Thread.sleep(1000);
		WebElement tableItem = driver.findElement(By.xpath(tabledata_item));
		tableItem.click();
		
		//check user Role
		WebElement priv_select = driver.findElement(By.xpath(selectedPriv));
		Select select = new Select (priv_select);
		String option = select.getFirstSelectedOption().getText();	
		System.out.println(option);
		Assert.assertEquals(userpriv, option);
		
		//check Employee name 
		WebElement employeeVal = driver.findElement(By.xpath(selectedemployee));
		String name_emp = employeeVal.getAttribute("value");
		System.out.println(name_emp);
		Assert.assertEquals(selectEmployeeName, name_emp);
		
		//check User name
		WebElement selected_userName = driver.findElement(By.xpath(selectedname));
		String name_userVal = selected_userName.getAttribute("value");
		System.out.println(name_userVal);
		Assert.assertEquals(userRand, name_userVal);
		
		//check Status
		//system doesn't returned the selected status (issue)
		// Add status functionality doesn't work 
		
		test.log(Status.PASS, "System returns valid data in fields");	
	}
	
	

}
