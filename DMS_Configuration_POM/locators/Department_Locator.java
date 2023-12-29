package locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webCommonFunctions.WebElementWait;

public class Department_Locator {
	// Department Locators
	
	WebDriver driver = null;
	
	public Department_Locator(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	// To find 'Settings' dropDown
		@FindBy(xpath = "(//a[@data-toggle='dropdown'])[1]")
		private WebElement settings;
		
		public WebElement getSettings() {
				if(WebElementWait.waitToElementClickable(driver, settings) != null) {
					return settings;
				}else 
					return null;   
		}
	
	// To find 'Department' value in settings dropDown
		@FindBy(partialLinkText = "Department")
		private WebElement department;
		
		public WebElement getDepartment() {
				if(WebElementWait.waitToElementClickable(driver, department) != null) {
					return department;
				}else 
					return null;   
		}
		
	// To find 'Create Department' button
		@FindBy(xpath  = "//button[text()='Create Department']")
		private WebElement buttonCreateDept;
		
		public WebElement getButtonCreateDepartment() {
				if(WebElementWait.waitToElementClickable(driver, buttonCreateDept) != null) {
					return buttonCreateDept;
				}else 
					return null;   
		}	
		
	// 	To find 'Department Name' textBox
		@FindBy(id  = "dept_name")
		private WebElement textboxDeptName;
		
		public WebElement getTextboxDeptName() {
				if(WebElementWait.waitToElementClickable(driver, textboxDeptName) != null) {
					return textboxDeptName;
				}else 
					return null;   
		}
		
	// To find 'Create' button 
		@FindBy(xpath  = "//button[text()='Create']")
		private WebElement buttonCreate;
		
		public WebElement getButtonCreate() {
				if(WebElementWait.waitToElementClickable(driver, buttonCreate) != null) {
					return buttonCreate;
				}else 
					return null;   
		}	
		
	 	// TO find 'Cancel' button
		@FindBy(xpath = "//button[text()='Cancel']")
		private WebElement buttonCancel ;
		
		public WebElement getCancelButton() {
			if(WebElementWait.waitToElementClickable(driver, buttonCancel) != null) {
				return buttonCancel ;
			}else
				return null;
		}
		
				// To find 'pop-up' window
				@FindBy(xpath = "//div[@class='bootbox modal fade in']")
				public List<WebElement> popupWindow ;
				
				
		
		
				// To find 'Close' button on pop-up window
				@FindBy(xpath = "//a[text()='Close']")
				private WebElement close ;
		
				public WebElement getCloseButton() {
					if(WebElementWait.waitToElementClickable(driver, close) != null) {
						return close ;
					}else
						return null;
				}
		
		

		
}
