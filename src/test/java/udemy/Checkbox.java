package udemy;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sun.tools.javac.util.Assert;

public class Checkbox<webElement> {
	public static WebDriver driver;
	public static WebElement box;

	public Checkbox() {

		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Chrome initiated");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println("Page loaded");
	}

	@Test(priority = 1)
	public void selectCheckBox() throws InterruptedException {

		box = driver.findElement(By.id("checkBoxOption1"));
		// boolean s= box.isDisplayed();
		Assert.check(true, box.isDisplayed());
		box.click();
		Assert.check(true, box.isSelected());
		System.out.println("checked");
		Thread.sleep(1000);

	}

	@Test(priority = 2)
	public void unselectCheckBox() throws InterruptedException {
		driver.navigate().refresh();
		box = driver.findElement(By.id("checkBoxOption1"));

		boolean g = box.isSelected();
		if (g == false) {
			System.out.println("box is unchecked and returned " + g);
			box.click();
			box.click();
			Thread.sleep(500);
			g = box.isSelected();
			// Assert.check(false,box.isSelected());
			System.out.println("clicked 2 times : box is checked and unchecked");
			// boolean s= box.isDisplayed();
		} else {
			System.out.println("box is selected after refresh");
		}
		// driver.close();

	}

	@SuppressWarnings("unchecked")
	@Test(priority = 3)
	public void Checkbox() {
		driver.navigate().refresh();
		List<WebElement> link = driver.findElements(By.xpath("//*[@type=\"checkbox\"]"));
		int count = 0;

		// List<webElement> link = (List<webElement>) box;

		System.out.println("In class checkbox: no of checkboxes in the page are " + link.size());

	}
}
