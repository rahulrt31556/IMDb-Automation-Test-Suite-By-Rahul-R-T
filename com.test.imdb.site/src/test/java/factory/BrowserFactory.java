package factory;

/*
 *Browser factory class is mainly used to create the instance 
 *of selenium webdriver with respect to the specified browsers.
 *  
 * Currently i have selected only IE, firefox and chrome.
 * 
 * This class has static get browser method with browser name as input parameter, 
 * which returns the specifed browser driver. 
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import DataProvider.configDataProvider;

public class BrowserFactory {

	static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName){
		
		if (browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome"))
		{
			configDataProvider config = new configDataProvider();
			System.setProperty("webdriver.chrome.driver", config.getChromePath());
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("IE"))
		{
			configDataProvider config = new configDataProvider();
			System.setProperty("webdriver.ie.driver", config.getIEPath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;		
		
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
}
