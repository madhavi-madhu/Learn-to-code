package udemy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
	 
	public NewTest() {


		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome initiated");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println("Page loaded");
	
	}
  @Test
  public void f() {
	  System.out.println("in function");
  }
}
