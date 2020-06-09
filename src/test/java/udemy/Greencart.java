package udemy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Greencart {

 WebDriver driver;
	public static WebElement box;

	public Greencart() {

		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Chrome initiated");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		// driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println("Page loaded");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void products() {
		System.out.println("All products");
		List<WebElement> products = driver.findElements(By.xpath("//*[@class=\'product-name\']"));
		for (int i = 0; i < products.size(); i++)
			System.out.println(i + 1 + ". " + products.get(i).getText());

	}

	@Test(priority = 3)
	public void addToCart() {
		List<WebElement> products = driver.findElements(By.xpath("//*[@class=\'product-name\']"));
		for (int i = 0; i <= products.size(); i++) {
			if (products.get(i).getText().contains("Cucumber")) {
				driver.findElement(By.cssSelector("text()='ADD TO CART'")).click();
				System.out.println("cart");
			} else {
				System.out.println("not matched" + products.get(i).getText() + products.size());
				//driver.close();
			}

		}
	}
	
	
	@Test(priority=2)
	public void add3Kg() {
		List<WebElement> products = driver.findElements(By.xpath("//*[@class=\'product-name\']"));
		for (int i = 0; i <= products.size(); i++) {
			if (products.get(i).getText().contains("Cucumber")) {
				driver.findElement(By.xpath("//a[@class=\'increment\']")).click();
				System.out.println("cart");
			} else {
				System.out.println("not matched" + products.get(i).getText() + products.size());
				//driver.close();
			}

		}
	}
	
	
	
	
	
	
	
	

}
