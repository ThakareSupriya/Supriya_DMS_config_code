package webCommonFunctions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class WebTextBox {
	public static void main(String[] args)  {
		// To test if below methods are working
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//driver.get("http://192.168.0.35/dmacq_v9_new/login.php");
		
	//	WebElement usr = driver.findElement(By.name("username"));
	//	WebTextBox.sendInput(usr, "supriya");
	}
	
	// To send text input as String
	public static void sendInput(WebElement textBox , String inputText) {
		textBox.sendKeys(inputText);
	}
	
	// To send keys
	public static void sendKeys(WebElement textBox , Keys keys) {
		textBox.sendKeys(keys);
	}
	
	public static void clearText(WebElement textBox) {
			textBox.clear();
	}
	
	

		
		
}
