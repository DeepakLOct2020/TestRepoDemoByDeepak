package Commerce.MyAmazon.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PreDefinedActions {
	
	protected static WebDriver driver;
	
	public static WebDriver start() {
		
		String filePath = "G:\\Technocredits\\Selenium\\ChromeDriver\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		System.out.println("Native to Application");
		return driver;
		
	}
	
	public static void close() {
		driver.close();
	}
	
}
