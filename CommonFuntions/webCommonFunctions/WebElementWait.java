package webCommonFunctions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementWait {
	/* Method for to  wait for  webElement to be clickable 
	 * Parameters - WebDriver, WebElement				Return Type - WebElement
	 */
	public static WebElement waitToElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/* Method for to  wait for  webElement to be clickable 
	 * Parameters - WebDriver, List<WebElement>				Return Type - List<WebElement>
	 */
	public static WebElement waitToListElementClickable(WebDriver driver, List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return (WebElement) wait.until(ExpectedConditions.elementToBeClickable((By) elements));
		//return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		
	}
	
	/* Method for to  wait for  webElement to be clickable using by (locator)
	 * Parameters - WebDriver, By								Return Type - WebElement
	 */
	public static WebElement waitToElementClickableBy(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	} 
	
	/* Method for to  wait for  webElement to be visible inside DOM
	 * Parameters - WebDriver, WebElement				Return Type - WebElement
	 */
	public static WebElement visibilityOfWebElement (WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 return wait.until(ExpectedConditions.visibilityOf(element));
		}
	
	/* Method for to  wait for  webElement to be visible inside DOM using by (locator)
	 * Parameters - WebDriver, By				Return Type - WebElement
	 */
	public static WebElement visibilityOfWebElementBy (WebDriver driver,  By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
	

}
