package udemy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentreportPractise {
	static ExtentTest test ;
	static ExtentReports report ;
	WebDriver driver ;
	 
	@BeforeClass
	public static void startTest()
	{
	report = new ExtentReports();

	test = report.createTest("ExtentreportPractise");
	}
	public ExtentreportPractise() {


		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
		  driver = new ChromeDriver();
		System.out.println("Chrome initiated");
		driver.get("https://google.com");
		// driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println("Page loaded madgavi");
	
		
	}
		
		
		
		@Test
		public void extentReportsDemo()
		{
			if(driver.getTitle().equals("Google"))
		{
		test.log(null, "Navigated to the specified URL");
		test.log(  null, "Navigated to the specified URL");
		}
		else
		{
		//test.log(LogStatus.FAIL, "Test Failed");
		}
		}
		@AfterClass
		public static void endTest()
		{
		report.close();
		report.flush();
		}
		
		
		
		
		
		
		
		
		
		
	
}
