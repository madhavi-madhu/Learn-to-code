import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NgoTest {

	WebDriver driver;
	WebDriverWait wait;

	public NgoTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Chrome initiated");
		driver.get("https://ngodarpan.gov.in/index.php/home");
		// driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println("Page loaded");
		driver.manage().window().maximize();

	}

	@Test
	public void f() throws IOException, InterruptedException {
		WebElement dr = driver.findElement(By.xpath("/html/body/div[11]/div/div[3]/div[1]/div/h2/a[2]"));
		dr.click();
		WebElement state = driver.findElement(
				By.xpath("//*[@id=\"frm_griev\"]/table[2]/tbody/tr[2]/td/table/tbody/tr[5]/td/ol/li[22]/a\n" + " "));
		state.click();

		List<WebElement> d = driver.findElements(By.xpath("/html/body/div[9]/div[1]/div[3]/div/div/div[2]/table"));

		int sno = 1;
		for (int m = 1; m <= 3; m++) {
			for (int i = 1; i <= 10; i++) {
				Thread.sleep(1000);
				System.out.println("\n for is " + i);

				String g = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println(g);

				WebElement r = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]/a"));
				System.out.println("clicking");
				Thread.sleep(1000);

				Actions action = new Actions(driver);
				action.moveToElement(r).click().build().perform();
				Thread.sleep(1000);
					// writing to excel 
				String filepath = ("C:\\Users\\hp\\Desktop\\Book.xlsx");
				File file = new File(filepath);
				FileInputStream fis = new FileInputStream(file);
				XSSFWorkbook wb = new XSSFWorkbook(fis);

				int so = wb.getActiveSheetIndex();
				Sheet sh = wb.getSheetAt(so);

				Row row = sh.getRow(sno);
				row.createCell(0).setCellValue(sno);
				row.createCell(1).setCellValue(g);

				int k = 2;

				for (int p = 1; p <= 7; p++) {
					String f = driver
							.findElement(By.xpath("//*[@id=\"printThis\"]/div/div/table[8]/tbody/tr[" + p + "]/td[2]"))
							.getText();
					System.out.println(f);
					row.createCell(k).setCellValue(f);

					k++;
				}

				FileOutputStream fos1 = new FileOutputStream("C:\\Users\\hp\\Desktop\\Book.xlsx");
				wb.write(fos1);
				fos1.close();
				fis.close();
				wb.close();
				Thread.sleep(500);
				WebElement button = driver.findElement(By.xpath("/html/body/div[9]/div[3]/div[2]/div/div[1]/button/span"));

				Thread.sleep(500);
				Actions action2 = new Actions(driver);
				action2.moveToElement(button).click().build().perform();
				System.out.println(i + "clicked");

				// wait = new WebDriverWait(driver, 100);
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"form-group
				// pull-left\"]")));
				Thread.sleep(1000);
				driver.navigate().refresh();
				sno++;
			}
			
			pagination();
			// main loop closing area

		}
		System.out.println("data written to excel " + (sno-1) + " rows inserted ");
		driver.close();
	}
	
public void pagination() {
	List<WebElement> page=driver.findElements(By.xpath("//*[@class=\"pagination\"]/li/a"));
	 
	System.out.println(page.size());
	for(int i=0; i<page .size(); i++){ 
		if(i==((page.size()-2))) {
			page.get(i).click();
		}
			Actions pagination=new Actions(driver);
		pagination.sendKeys(Keys.ENTER);
		 } 
	
}
}
