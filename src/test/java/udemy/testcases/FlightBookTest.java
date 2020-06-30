package udemy.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.testng.annotations.Test;
import udemy.base.*;
import udemy.pages.FlightBook;

public class FlightBookTest extends Base {
	FlightBook fp;

	public FlightBookTest() throws IOException {
		super();
	}

	@Test(priority = 1, testName = "StaticOrigin ")
	public void selectOrigin() {

		WebElement from = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]"));
		System.out.println("origin is : " + from.getText());

		from.click();

		WebElement fromcity = driver.findElement(By.xpath("//*[@id='dropdownGroup1']/div/ul[1]/li[6]/a"));
		fromcity.click();
		System.out.println("Selected origin is : " + from.getText());

	}

	@Test(priority = 2, testName = "DynamicDestination ", dependsOnMethods = "selectOrigin")
	public void selectDestination() throws InterruptedException {
		WebElement to = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"]"));
		System.out.println("Destination is : " + to.getText());
		to.click();
		Thread.sleep(300);
		System.out.println(" Selected Destination is : " + to.getText());
		// print list of cities shown
		FlightBook.CityList();
		FlightBook.selectDest("JAI");
		System.out.println("destination");

	}

	@Test
	public void selectDepDate() {
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]")).sendKeys("");

		
//date logic 
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String date1 = dateFormat.format(date); // Now format the date
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]")).sendKeys(date1);

		// Print the Date
		System.out.println("Current date and time is " + date1);

		System.out.println(dateFormat.format(new Date()));

	}
}
