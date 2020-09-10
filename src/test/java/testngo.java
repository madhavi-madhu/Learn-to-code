import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testngo {
	WebDriver driver;
	public testngo() {
	System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
	driver = new ChromeDriver();
	System.out.println("Chrome initiated");
	driver.get("https://ngodarpan.gov.in/index.php/home");
	// driver.findElement(By.id("checkBoxOption1")).click();
	System.out.println("Page loaded");
	driver.manage().window().maximize();
	WebElement dr= driver.findElement(By.xpath("/html/body/div[11]/div/div[3]/div[1]/div/h2/a[2]"));
	dr.click();
}

	
	
	
	
	
}
