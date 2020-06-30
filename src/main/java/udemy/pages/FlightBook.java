package udemy.pages;
import udemy.base.*;
import java.io.IOException;
import java.util.List;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightBook extends Base {
	



	@FindBy(xpath="//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")
		static Element  from ;
		
		
		
		public FlightBook() throws IOException {
			PageFactory.initElements(driver, this);
		}
		
		public static void selectDest(String x) {
			String name = x;
			name.toUpperCase();
			if (name.length() > 3) {
				// click on city by linktext
				driver.findElement(By.linkText(name)).click();
			} else {
				System.out.println("//a[contains(@value," + "'" + name + "'" + ")]");
				WebElement bycode = driver.findElement(By.xpath("(//a[contains(@value," + "'" + name + "'" + ")])[2]"));
				bycode.click();
				System.out.println("In else my length is > 3");
			}
	
}
		public static void CityList() {
			List<WebElement> tocitydrop = driver.findElements(By.xpath("//*[@id=\'citydropdown\']/tbody/tr[2]/td[2]"));

			System.out.println("cities are \n " + tocitydrop.get(1).getText());
			
		}
		}