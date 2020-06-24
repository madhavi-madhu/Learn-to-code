package udemy.pages;
import udemy.base.*;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightBook extends Base {
	



//	@FindBy(xpath="//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")
//		static Element  from ;
		
		
		
		public FlightBook() throws IOException {
			PageFactory.initElements(driver, this);
		}
		
		public static void selectFrom(String x) {
		 
	//	WebElement from =		
				driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
				//from.click();
		 
//		Select  origin =new Select(from);
//		origin.selectByVisibleText(x);
//		
}
		}