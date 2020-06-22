package udemy.pages;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import udemy.base.Base;

public class refer extends Base {
	
    @FindBy(xpath="//*[@class=\'menu-item\']")
	static WebElement  headbut1 ;
	
	
	
	public refer() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	 public static  String getTitle() {
		return driver.getTitle();
	 }
	 public static boolean getHeaderButtons() {
		 return headbut1.isDisplayed();
	 }
	 public static String getHeaderButtonstext() {
		 return headbut1.getText();
	 }
	
	
}