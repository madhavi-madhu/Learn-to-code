package udemy.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;
import udemy.base.*;
import udemy.pages.FlightBook;

public class FlightBookTest extends Base {
	FlightBook fp;

	public FlightBookTest() throws IOException {
		super();
	}

	@Test(priority = 1, testName = "origin ")
	public void selectOrigin() {

		WebElement from = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]"));
		System.out.println("origin is : "+ from.getText());

		from.click();

		WebElement fromcity = driver.findElement(By.xpath("//*[@id='dropdownGroup1']/div/ul[1]/li[6]/a"));
		fromcity.click();
		System.out.println("Selected origin is : "+ from.getText());

	}

	@Test(priority = 2, testName = "destination ", dependsOnMethods = "selectOrigin")
	public void selectDestination() throws InterruptedException {
		WebElement to = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"]"));
		System.out.println("Destination is : "+ to.getText());

		to.click();
		//to.sendKeys("hyd");
		to.sendKeys("Guja");
		Thread.sleep(300);
		System.out.println(" Selected Destination is : "+ to.getText());
		String tocitydrop = driver.findElements(By.xpath("//*[@id=\'citydropdown\']/tbody/tr[2]/td[2]")).get(1).getText();
		System.out.println(tocitydrop);
		//WebElement tocity = driver.findElement(By.xpath("//*[@id='dropdownGroup1']/div/ul[2]/li[6]/a"));
		System.out.println("destination");
		//tocity.click();
	}
}
