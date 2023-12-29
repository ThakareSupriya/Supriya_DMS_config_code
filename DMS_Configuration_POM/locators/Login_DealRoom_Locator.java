package locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webCommonFunctions.WebElementWait;

public class Login_DealRoom_Locator {
	//  Locators for Login and Deal Room functionality 
	
	WebDriver driver = null; 				
	
	public Login_DealRoom_Locator (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver , this);                                           
	}
	
//  Login page Locators	
		//  for UserName
		@FindBy (name = "username")
		private  WebElement username;
		
		public WebElement getUsername () {
				if(WebElementWait.waitToElementClickable(driver, username) != null) {
					return username;
				}else 
					return null;
		}
		
		// for password 
		@FindBy(name = "password")
		private WebElement password;
		
		public WebElement getPassword() {
			if(WebElementWait.waitToElementClickable(driver, password) != null) {
				return password;
			}else 
				return null;
		}
		
		// click on login button
		@FindBy(id = "btn-create")
		private WebElement loginButton; 
		
		public WebElement getLoginButton() {
			if(WebElementWait.waitToElementClickable(driver, loginButton) != null) {
				return loginButton;
			}else
				return  null;                                                                    
		}
		
				// Deal Room locators	
				//  for Create Deal Room button
						@FindBy (xpath = "(//a[@class='icon-home'])[2]")
						private  WebElement homeIcon;
						
						public WebElement getHomeIcon() {
								if(WebElementWait.waitToElementClickable(driver, homeIcon) != null) {
									return homeIcon;
								}else 
									return null;
						}
					
					
					//  for Create Deal Room button
						@FindBy (xpath = "//button[text()=\"Create Deal Room\"]")  // //button[text()=\"Create Deal Room\"]
						public  List<WebElement> createDRButtonAvailable;
						
						@FindBy (xpath = "//button[text()=\"Create Deal Room\"]")  // //button[text()=\"Create Deal Room\"]
						private  WebElement createDRButton;
						
						public WebElement getCreateDRButton () {
								if(WebElementWait.waitToElementClickable(driver, createDRButton) != null) {
									return createDRButton;
								}else 
									return null;
						}
						
					// To enter Deal Room name
						@FindBy(id = "project_name")
						private WebElement  projectName;
						
						public WebElement getProjectName () {
							if(WebElementWait.waitToElementClickable(driver, projectName) != null) {
								return projectName;
							}else 
								return null;
					}
						
					//  To find Create button
						@FindBy(id = "btn-create")
						private WebElement  createButton;
						
						public WebElement getCreateButton () {
							if(WebElementWait.waitToElementClickable(driver, createButton) != null) {
								return createButton;
							}else 
								return null;
					}
					
					// If deal room with same name is  already exist, Locators to find  :-  pop-up window, close pop-up window and 'Cancel' button
						// To find pop-up window
						@FindBy(xpath = "//div[@class='bootbox modal fade in']/div[1]")
						public List<WebElement>  popupWindowDisplayed;
						
						@FindBy(xpath = "//div[@class='bootbox modal fade in']/div[1]")
						private WebElement  popupWindow;
						
						public WebElement getPopupWindow () {
							if(WebElementWait.waitToElementClickable(driver, popupWindow) != null) {
								return popupWindow;
							}else 
								return null;
					}
						
						// To find 'Close' button on pop-up window
						@FindBy(xpath = "//a[normalize-space()='Close']")
						private WebElement  closeButton;
						
						public WebElement getCloseButton () {
							if(WebElementWait.waitToElementClickable(driver, closeButton) != null) {
								return closeButton;
							}else 
								return null;
					   }
						
						// To find 'Cancel' button on 'New Deal Room' page
						@FindBy(xpath = "//button[text()='Cancel']")
						private WebElement  cancelButton;
						
						public WebElement getCancelButton () {
							if(WebElementWait.waitToElementClickable(driver, cancelButton) != null) {
								return cancelButton;
							}else 
								return null;
					}
						// To find Deal Room  to enter  into existing Deal Room          //a[normalize-space()='Test Room']
						@FindBy(xpath = "//a[normalize-space()='Test Room']")
						private WebElement  dealRoom;
						
						public WebElement getDealRoom () {
							if(WebElementWait.waitToElementClickable(driver, dealRoom) != null) {
								return dealRoom;
							}else 
								return null;
					}

}
