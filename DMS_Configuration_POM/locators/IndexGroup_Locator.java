package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webCommonFunctions.WebElementWait;

public class IndexGroup_Locator {
	// Index Group locators
	
	// WebDriver Instance
			WebDriver driver = null;
			
	//  Constructor to initialize driver
			public IndexGroup_Locator(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver , this);
			}
	
	// To find deal room (i. e. Test Room)
			@FindBy(xpath  = "//a[normalize-space()='Test Room']")
			private WebElement dr;
	
				public WebElement getDr() {
					if(WebElementWait.waitToElementClickable(driver, dr) != null) {
						return dr;
					}else 
						return null;   
			}
	
	// To find Index Group icon
			@FindBy(xpath  = "//span[contains(text(),'I-Group')]")
			private WebElement ig;

			public WebElement getIG() {
				if(WebElementWait.waitToElementClickable(driver, ig) != null) {
					return ig;
				}else 
					return null;   
		 }
			
	// To find 'New Index Group' button
			@FindBy(xpath  = "//button[text()='New Index Group']")
			private WebElement newIGbutton;

			public WebElement getNewIGbutton() {
				if(WebElementWait.waitToElementClickable(driver, newIGbutton) != null) {
					return newIGbutton;
				}else 
					return null;   
		 }
		
	// To find 'Index Group Name' DroDdown value
			@FindBy(xpath  = "//span[contains(text(),'Choose a Index Group...')]")
			private WebElement igNameDropdown;

			public WebElement getIGnameDropdown() {
				if(WebElementWait.waitToElementClickable(driver, igNameDropdown) != null) {
					return igNameDropdown;
				}else 
					return null;   
		 }
					// To find Index group name SearchBox 
						@FindBy(xpath  = "//input[@type='text']")
						private WebElement igNameSearchbox;
			
						public WebElement getIGnameSearchbox() {
							if(WebElementWait.waitToElementClickable(driver, igNameSearchbox) != null) {
								return igNameSearchbox;
							}else 
								return null;   
					 }
						
					// To find TextBox for OTHERS TextBox
						@FindBy(name  = "index_group_other")
						private WebElement igOther;
			
						public WebElement getIGother() {
							if(WebElementWait.waitToElementClickable(driver, igOther) != null) {
								return igOther;
							}else 
								return null;   
					 }
		
	// To find add fields icon for 'Invoice Information' Index Group
			@FindBy(xpath   = "//td[contains(text(),'Invoice Information')]//following-sibling::td[2]//i[@class='icon-building']")
			private WebElement ig1Fields;
	
			public WebElement getIG1Fields() {
				if(WebElementWait.waitToElementClickable(driver, ig1Fields) != null) {
					return ig1Fields;
				}else 
					return null;   
		 }
			
	// To find add fields icon for 'HR Documents' Index Group
			@FindBy(xpath   = "//td[contains(text(),'HR Documents')]//following-sibling::td[2]//i[@class='icon-building']")
			private WebElement ig2Fields;
	
			public WebElement getIG2Fields() {
				if(WebElementWait.waitToElementClickable(driver, ig2Fields) != null) {
					return ig2Fields;
				}else 
					return null;   
		 }
		
	// To find 'Add Field' button on Automated Index Group - Fields page
			@FindBy(xpath  = "//button[text()='Add Field']")
			private WebElement addFieldButton;
	
			public WebElement getAddFieldButton() {
				if(WebElementWait.waitToElementClickable(driver, addFieldButton) != null) {
					return addFieldButton;
				}else 
					return null;   
		 }
	
	// To find Index Group Name DropDown   //span[contains(text(),'Choose a Index Group...')]
			@FindBy(xpath  = "//span[contains(text(),'Choose a Field Type...')]")
			private WebElement igFieldTypeDropdown;
	
			public WebElement getIGFieldTypeDropdown() {
				if(WebElementWait.waitToElementClickable(driver, igFieldTypeDropdown) != null) {
					return igFieldTypeDropdown;
				}else 
					return null;   
		 }
	
	//  To find specific Field Type TextBox - to send Text/DropDown/Date/Numeric/Multi-Select                                                                              
			@FindBy(xpath  = "(//input[@type='text'])[1]")
			private WebElement igFieldTypeTextbox;
	
			public WebElement getIGFieldTypeTextbox() {
				if(WebElementWait.waitToElementClickable(driver, igFieldTypeTextbox) != null) {
					return igFieldTypeTextbox;
				}else 
					return null;   
		 }
										//   
										@FindBy(xpath  = "//a[@class='chzn-single']")
										private WebElement igFieldType;
								
										public WebElement getIGFieldType() {
											if(WebElementWait.waitToElementClickable(driver, igFieldType) != null) {
												return igFieldType;
											}else 
												return null;   
									 }
	//  To  find 'Field Name' TextBox  on  New Index Field page of IG
			@FindBy(id  = "field_name")
			private WebElement igFieldName;
	
			public WebElement getIGFieldName() {
				if(WebElementWait.waitToElementClickable(driver, igFieldName) != null) {
					return igFieldName;
				}else 
					return null;   
		 }
						
							// To find 'Add Fields' button in Field Values for Field Type :- DropDown & Multi Select
								@FindBy(xpath  = "//button[@id='addfieldEmp']")
								private WebElement igAddFieldsButton;
						
								public WebElement getIgAddFieldsButton() {
									if(WebElementWait.waitToElementClickable(driver, igAddFieldsButton) != null) {
										return igAddFieldsButton;
									}else 
										return null;   
							 }
						
							// To find first TextBox to add sub field in Field Values section
								@FindBy(xpath = "(//input[@id='fieldsids[]'])[1]")
								private WebElement igValueTextbox1;
						
								public WebElement getIgigValueTextbox1() {
									if(WebElementWait.waitToElementClickable(driver, igValueTextbox1) != null) {
										return igValueTextbox1;
									}else 
										return null;   
							 }
							// To find second TextBox to add sub field in Field Values section
							@FindBy(xpath = "(//input[@id='fieldsids[]'])[2]")
							private WebElement igValueTextbox2;
						
							public WebElement getIgigValueTextbox2() {
								if(WebElementWait.waitToElementClickable(driver, igValueTextbox2) != null) {
									return igValueTextbox2;
								}else 
									return null;   
							}
							// To find third TextBox to add sub field in Field Values section
							@FindBy(xpath = "(//input[@id='fieldsids[]'])[3]")
							private WebElement igValueTextbox3;
						
							public WebElement getIgigValueTextbox3() {
								if(WebElementWait.waitToElementClickable(driver, igValueTextbox3) != null) {
									return igValueTextbox3;
								}else 
									return null;   
							}
}
