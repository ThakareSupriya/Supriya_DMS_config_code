package webCommonFunctions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebWait {
	static int seconds = 30;
	
	 // following methods will apply explicite wait on the elements 
		
	public static WebElement elementPresent(WebDriver driver,  WebElement element ) {
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
		return visibleElement ;
	} 
	
	public static boolean elementSelection(WebDriver driver, WebElement element) {
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		boolean elementSelected = wait.until(ExpectedConditions.elementToBeSelected(element));
		return elementSelected ;
	}
	
	public static WebElement elementSelected(WebDriver driver,  WebElement element ) {
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		WebElement elementSelected = wait.until(ExpectedConditions.visibilityOf(element));
		return elementSelected ;
	}
}
