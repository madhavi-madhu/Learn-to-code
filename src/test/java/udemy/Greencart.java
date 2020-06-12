package udemy;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Greencart {

	WebDriver driver;
	public static WebElement box;
	String vegies[] = { "Cucumber", "Beans", "Carrot","Capsicum" };
int j=0;
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

	@Test(priority = 2)
	public void addItemsToCart() throws InterruptedException {
		List<WebElement> products = driver.findElements(By.xpath("//*[@class=\'product-name\']"));
		for (int i = 0; i < products.size(); i++) {
			// how to split an array
			String names[] = products.get(i).getText().split(" ");
			String formatnames = names[0].trim();
			// converting a normal array( which occupies less space when compared to list
			// arry ) to list array
			List items = Arrays.asList(vegies);
			//comparing the given vegies with the list of items in the browser
			if (items.contains(formatnames)) {
				j++;
				//System.out.println(products.get(i).getText());
									
				driver.findElements(By.xpath("//a[@class=\'increment\']")).get(i).click();
				Thread.sleep(1000);
				driver.findElements(By.xpath("//button[(text()='ADD TO CART')]")).get(i).click();
				Thread.sleep(1500);
				System.out.println(formatnames+ " item is added to cart");
				if(j==vegies.length) {break;}
			} else {
				System.out.println("not matched" + products.get(i).getText() + products.size());

			}

		}
		driver.findElement(By.xpath("//*[@class=\"cart-icon\"]")).click();
	TakesScreenshot src= ((TakesScreenshot)driver);
	File s = src.getScreenshotAs(OutputType.FILE);}
	
	
	
	
	
	
	
	
	
	
	

}