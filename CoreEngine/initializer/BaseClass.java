package initializer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	// main method -  to check if browser is opening (launchBrowserWith method is working ) --> yes working
		public static void main(String[] args) {
			launchBrowserWith("");
		}
		
		public static WebDriver launchBrowserWith(String browserName) {
			WebDriver driver;
			
			switch (browserName.toLowerCase()) {
			
			case "chrome" : {
				ChromeOptions chromeOpt = new ChromeOptions();
				WebDriverManager.chromiumdriver().setup();
				driver = new ChromeDriver(chromeOpt);
				break;
				
				
			/*	String chromepath = ".//Drivers/chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromepath);
				driver = new ChromeDriver();
				break;
				*/
			}
			
			case "edge" : {
				EdgeOptions edgeOpt = new EdgeOptions();
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(edgeOpt);
				break;
				
			/*	String egdePath = ".//Drivers/msedgedriver.exe";
				System.setProperty("webdriver.edge.driver", egdePath);
				driver = new EdgeDriver();
				break;
		    */
			}
			
			case "firefox" : {
			/*	String firefoxPath = ".//Drivers/geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", firefoxPath);
				driver = new FirefoxDriver();
				break;
			*/
				
				FirefoxOptions firefoxOpt = new FirefoxOptions();
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(firefoxOpt);
				break;
			}
			
			default:
				ChromeOptions chromeOpt = new ChromeOptions();
				WebDriverManager.chromiumdriver().setup();
				driver = new ChromeDriver(chromeOpt);
				break;
			
			/*	
				String defaultPath = ".//Drivers/chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", defaultPath);
				driver = new ChromeDriver();
				break;
			*/
			}
			return driver;
		}
}
