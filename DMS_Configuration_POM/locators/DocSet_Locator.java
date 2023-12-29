package locators;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webCommonFunctions.WebElementWait;

public class DocSet_Locator {
	// Doc Set Locator
	
		WebDriver driver = null;
		
	
		public DocSet_Locator(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		// To find deal room (i. e.	Test Room)
				@FindBy(xpath  = "//a[normalize-space()='Test Room']")
				private WebElement dealRoom;

				public WebElement getDealRoom() {
					if(WebElementWait.waitToElementClickable(driver, dealRoom) != null) {
						return dealRoom;
					}else 
						return null;   
				}
				
		// To find doc set icon on DashBoard
			@FindBy(xpath  = "//i[@class='icon-copy']")
			private WebElement docSetIcon;
			
			public WebElement getDocSetIcon() {
					if(WebElementWait.waitToElementClickable(driver, docSetIcon) != null) {
						return docSetIcon;
					}else 
						return null;   
			}
			
		// To find Create Doc Set button
			@FindBy(xpath  = "//button[text()='Create Doc Set']")
			private WebElement createDocSetButton;
			
			public WebElement getCreateDocSetButton() {
					if(WebElementWait.waitToElementClickable(driver, createDocSetButton) != null) {
						return createDocSetButton;
					}else 
						return null;   
			}
		
		// To find Doc Set Name textBox
				@FindBy(id  = "field_name")
				private WebElement docSetName;
					
				public WebElement getDocSetName() {
						if(WebElementWait.waitToElementClickable(driver, docSetName) != null) {
							return docSetName;
						}else 
							return null;   
			}
		
		// To find 'Add Values'	button
				@FindBy(id  = "addfieldEmp")
				private WebElement addValues;
					
				public WebElement getAddValuesButton() {
						if(WebElementWait.waitToElementClickable(driver, addValues) != null) {
							return addValues;
						}else 
							return null;   
			}
				//  To find DropDown value textBox on Document Set page
						@FindBy(id  = "fieldsids[]")
					//public List<WebElement> dropdownValue;
					public WebElement dropdownValue;
							
					public WebElement getDropdownValue() {
					//		List<WebElement> elements = (List<WebElement>) driver.findElement(By.id("fieldsids[]"));
							
							/*	if(WebElementWait.waitToElementClickable(driver, dropdownValue) != null) {
									return dropdownValue;
								}else     */
									return null;       
					}                               
					
					@FindBy(xpath =  "(//input[@name='fieldsids[]'])[2]")
					public WebElement dropdownValue2;
					
					@FindBy(xpath =  "(//input[@name='fieldsids[]'])[3]")
					public WebElement dropdownValue3;
					
					@FindBy(xpath =  "(//input[@name='fieldsids[]'])[4]")
					public WebElement dropdownValue4;
						// for multiple doc set value -to use for each loop
						@FindBy(id  = "fieldsids[]")
						public List<WebElement> dropdown;
						
						
	// _____________________ Locators to Assign Doc Set Permissions _____________________			
		// To find 'Permissions' icon	
		@FindBy(xpath  = "//i[@class='icon-ok']")
		public List<WebElement> permissionsIcon;		
						
		// To find list of checkBox for 'All' Permissions
		@FindBy(xpath  = "//input[@class='check_all_rights']")
		public List<WebElement> checkboxAllPermission;
		
		
}
