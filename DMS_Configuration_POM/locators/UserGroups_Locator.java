package locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webCommonFunctions.WebElementWait;

public class UserGroups_Locator {
	
	// User group creation locators
	
	WebDriver driver = null;
	
	// Constructor 
	public UserGroups_Locator(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver , this);
	}
	
	//  To find Settings dropDown
		@FindBy (xpath  = "(//a[@data-toggle='dropdown'])[1]")
		private  WebElement settings;
		
		public WebElement getSettings () {
				if(WebElementWait.waitToElementClickable(driver, settings) != null) {
					return settings;
				}else 
					return null;
		}
		
	// To find User Groups from settings dropDown	
		@FindBy (xpath  = "(//i[@class='icon-group'])[1]")
		private  WebElement userGroup;
		
		public WebElement getUserGroupsValue() {
				if(WebElementWait.waitToElementClickable(driver, userGroup) != null) {
					return userGroup;
				}else 
					return null;
		}
	
	// To find Create User Group button 
		@FindBy (xpath  = "//button[text()='Create User Group']")
		private  WebElement createUGButton;
		
		public WebElement getCreateUserGroupButton () {
				if(WebElementWait.waitToElementClickable(driver, createUGButton) != null) {
					return createUGButton;
				}else 
					return null;
		}
		
	// To find Group Name TextBox
		@FindBy (id  = "name")
		private  WebElement groupName;
		
		public WebElement getGroupName () {
				if(WebElementWait.waitToElementClickable(driver, groupName) != null) {
					return groupName;
				}else 
					return null;
		}
		
	// To find Group Alias name TextBox
		@FindBy (id  = "groupalias")
		private  WebElement groupAliasName;
		
		public WebElement getGroupAliasName () {
				if(WebElementWait.waitToElementClickable(driver, groupAliasName) != null) {
					return groupAliasName;
				}else 
					return null;
		}
		
	//  To find 'Choose User group' dropDown to Copy Rights 	
		@FindBy (xpath  = "//span[text()='Choose User Group']")
		private  WebElement copyRightsDropdown;

		public WebElement getCopyRightsDropdown () {
			if(WebElementWait.waitToElementClickable(driver, copyRightsDropdown) != null) {
				return copyRightsDropdown;
			}else 
				return null;
		}
		
		
		// To find 'Copy Rights' textBox to send user group name to copy rights ::- HARDCOADED TO 'USERS' group
		@FindBy (xpath  = "//div[@class='chzn-search']//input")
		private  WebElement copyRightsTextbox;
		
		public WebElement getCopyRightsTextbox() {
			if(WebElementWait.waitToElementClickable(driver, copyRightsTextbox) != null) {
				return copyRightsTextbox;
			}else 
				return null;
		}
		
	// To find Description  TextBox	
		@FindBy (id  = "description")
		private  WebElement ugDescription;

		public WebElement getUgDescription () {
			if(WebElementWait.waitToElementClickable(driver, ugDescription) != null) {
				return ugDescription;
			}else 
				return null;
		}
		
		
	// To find 'Create' button
		@FindBy (id  = "btn-create")
		private  WebElement createButton;

		public WebElement getCreateButton () {
			if(WebElementWait.waitToElementClickable(driver, createButton) != null) {
				return createButton;
			}else 
				return null;
		}
		
	// To find pop-up window if exists : if  Group Name already exists.
		@FindBy (xpath = "//div[@class='bootbox modal fade in']")
		public List <WebElement> popupWindows;
		
		
		@FindBy (xpath = "//div[@class='bootbox modal fade in']")
		private  WebElement popupWindow;

		public WebElement getPopupWindow() {
			if(WebElementWait.waitToElementClickable(driver, popupWindow) != null) {
				return popupWindow;
			}else 
				return null;
		}
		
	// To find 'Close' button on pop-up window
		@FindBy (xpath = "//a[text()='Close']")
		private WebElement closeButton;

		public WebElement getCloseButton () {
			if(WebElementWait.waitToElementClickable(driver, closeButton) != null) {
				return closeButton;
			}else 
				return null;
		}
	
	// To find  'Cancel' button
		@FindBy (xpath = "//button[text()='Cancel']")
		private  WebElement cancelButton;

		public WebElement getCancelButton () {
			if(WebElementWait.waitToElementClickable(driver, cancelButton) != null) {
				return cancelButton;
			}else 
				return null;
		}
		
	// To find  'OK' button 
		@FindBy (xpath = "//a[text()='OK']")
		private  WebElement okButton;

		public WebElement getOkButton () {
			if(WebElementWait.waitToElementClickable(driver, okButton) != null) {
				return okButton;
			}else 
				return null;
		}
		
		
}	
