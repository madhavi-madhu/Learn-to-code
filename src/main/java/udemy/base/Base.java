
package udemy.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	FileInputStream objfile;

	public Base() throws IOException {
		try {

			prop = new Properties();
			String read = "M:\\SOFTWARES\\New folder\\Learn-to-code\\src\\main\\java\\udemy\\config\\application.properties";
			objfile = new FileInputStream(read);
			prop.load(objfile);
			System.out.println("file loaded");
			initialization();
		} catch (Exception e) {
			System.out.println("catch exception" + e);
		}
	}

	public void initialization() {

	//	String baseUrl = prop.getProperty("baseUrl");
		String browser = prop.getProperty("browser");
	//	System.out.println(baseUrl);
		System.out.println(browser);
		String chrome = "chrome";
		System.out.println(browser.contentEquals(chrome));
		if (browser.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome loaded");
		} else {
			System.setProperty("webdriver.geckodriver", "C:\\Windows\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Firefox loaded");
		}

		driver.get("https://www.spicejet.com/");
		System.out.println("URL loaded-Initialization");
		driver.manage().window().maximize();
		System.out.println("window maximized");
	}

	public void close() {
		driver.quit();
		System.out.println("driver closed");

	}

	public static void timeouts() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}