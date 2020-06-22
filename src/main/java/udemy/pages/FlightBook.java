package udemy.pages;
import udemy.base.*;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightBook extends Base {
	



	@FindBy(xpath="//*[@id=\"ctl00_mainContent_ddl_originStation1\"]")
		static WebElement  from ;
		
		
		
		public FlightBook() throws IOException {
			PageFactory.initElements(driver, this);
		}
		
		public void selectFrom(String x) {
		from.click();
		Select  origin =new Select(from);
		origin.selectByVisibleText(x);
		
}
		}