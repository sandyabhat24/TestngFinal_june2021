package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	static String url="https://techfios.com/test/101/";
	
	public static WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
