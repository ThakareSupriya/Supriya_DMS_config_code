package locators;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webCommonFunctions.WebElementWait;

public class IndexMaster_Locator {
	// Index Master locators
	 
	// WebDriver Instance
		WebDriver driver = null;
		
	//  Constructor 
		public IndexMaster_Locator(WebDriver driver ) {
			this.driver = driver;
			PageFactory.initElements(driver , this);
		}
	
		
	// To find Index Master icon
		@FindBy(xpath  = " //span[contains(text(),'I-Master')]")
		private WebElement im;

		public WebElement navigateToIm() {
			if(WebElementWait.waitToElementClickable(driver, im) != null) {
				return im;
			}else 
				return null;   
		}
		
	// To find New Index Master button
		@FindBy(xpath  = "//button[contains(text(),'New Index Master')]")
		private WebElement newIM;

		public WebElement getNewIM() {
			if(WebElementWait.waitToElementClickable(driver, newIM) != null) {
				return newIM;
			}else 
				return null;   
		}
		
	// To find Index Master TextBox 
		@FindBy(id   = "index_master")
		private WebElement imName;

		public WebElement getIMName() {
			if(WebElementWait.waitToElementClickable(driver, imName) != null) {
				return imName;
			}else 
				return null;   
		}
		
	// To find Index Master TextBox 
		@FindBy(xpath  = "//textarea[@id='description']")
		private WebElement imDescription;

			public WebElement getIMDescription() {
				if(WebElementWait.waitToElementClickable(driver, imDescription) != null) {
					return imDescription;
				}else 
					return null;   
		}
	
	// To find Create button to create new IM
		@FindBy(id  = "im_submit")
		private WebElement createButton;

			public WebElement getCreateButton() {
				if(WebElementWait.waitToElementClickable(driver, createButton) != null) {
					return createButton;
				}else 
					return null;   
		}
			
	// If Same index master already exists....... close the pop-up window and hit 'Cancel button on 'New Index Master' window
				// To find pop-up window
				@FindBy(xpath  = "//div[@class='bootbox modal fade in']")
				private WebElement popupWindow;
	
					public WebElement getPopUpWindow() {
						if(WebElementWait.waitToElementClickable(driver, popupWindow) != null) {
							return popupWindow;
						}else 
							return null;   
				}
				
				// To find 'Close' button  
				@FindBy(xpath  = "//a[text()='Close']")
				private WebElement closeButton;
	
					public WebElement getCloseButton() {
						if(WebElementWait.waitToElementClickable(driver, closeButton) != null) {
							return closeButton;
						}else 
							return null;   
				}	
			
			    // To find 'Cancel' button        
			   @FindBy(xpath  = "//button[text()='Cancel']")  
			   private WebElement cancelButton;

				  public WebElement getCancelButton() {
					  if(WebElementWait.waitToElementClickable(driver, cancelButton) != null) {
						  return cancelButton;
					  }else 
						  return null;   
			   }		
			
	// To find add fields icon for 'Procurement Information' Index Master 
		@FindBy(xpath  = "//td[contains(text(),'Procurement')]//following-sibling::td[3]//i[@class='icon-building']")
		private WebElement im1Fields;

			public WebElement getIM1Fields() {
				if(WebElementWait.waitToElementClickable(driver, im1Fields) != null) {
					return im1Fields;
				}else 
					return null;   
		}
			
	// To find add fields icon for 'Employee Information' Index Master
		@FindBy(xpath  = "//td[contains(text(),'Employee')]//following-sibling::td[3]//i[@class='icon-building']")
		private WebElement im2Fields;

			public WebElement getIM2Fields() {
				if(WebElementWait.waitToElementClickable(driver, im2Fields) != null) {
					return im2Fields;
				}else 
					return null;   
		}		

	// To find 'Add Field' button on Fields DashBoard - To add single field
		@FindBy(xpath  = "//button[text()='Add Field']")
		private WebElement addField; 

			public WebElement getIMaddField() {
				if(WebElementWait.waitToElementClickable(driver, addField) != null) {
					return addField;
				}else 
					return null;   
		}
			
	// To find 'Field Name' TextBox on  New Index Field	page 
		@FindBy(id  = "field_name")
		private WebElement fieldName;

			public WebElement getFieldName() {
				if(WebElementWait.waitToElementClickable(driver, fieldName) != null) {
					return fieldName;
				}else 
					return null;   
		}
				
		// To find Field Type - Choose a field type DropDown field
		@FindBy(xpath = "//span[contains(text(),'Choose a Field Type...')]")
		private WebElement chooseFieldType;

			public WebElement getChooseFieldType() {
				if(WebElementWait.waitToElementClickable(driver, chooseFieldType) != null) {
					return chooseFieldType;
				}else 
					return null;   
		}
		
		// To find specific Field Type TextBox - Text/Numeric etc.
			@FindBy(xpath = "(//input[@type='text'])[2]")
			private WebElement fieldTypeTextbox;

				public WebElement getFieldTypeTextbox() {
				if(WebElementWait.waitToElementClickable(driver, fieldTypeTextbox) != null) {
					return fieldTypeTextbox;
				}else 
					return null;   
		}
				
							// To find 'Add Value' button for Field type Select Menu  : in Field Values																			-:- Usable only when field type is Select Menu -:-
								@FindBy(xpath  = "//button[text()='Add Value']")
								private WebElement subAddValue;
									public WebElement getSubAddValue() {
									if(WebElementWait.waitToElementClickable(driver, subAddValue) != null) {
											return subAddValue;
									}else 
											return null;   
							}
							 // To find TextBox to enter sub-value name : in Field Values	: value1																				-:- Usable only when field type is Select Menu -:-
								@FindBy(xpath  = "(//input[@name='fieldsids[]'])[1]")
								private WebElement selectFieldValue1;
									public WebElement getSelectFieldValue1() {
									if(WebElementWait.waitToElementClickable(driver, selectFieldValue1) != null) {
											return selectFieldValue1;
									}else 
											return null;   
							} 
							// To find TextBox to enter sub-value name : in Field Values	: value1																				-:- Usable only when field type is Select Menu -:-
							@FindBy(xpath  = "(//input[@name='fieldsids[]'])[2]")
							private WebElement selectFieldValue2;
								public WebElement getSelectFieldValue2() {
								if(WebElementWait.waitToElementClickable(driver, selectFieldValue2) != null) {
										return selectFieldValue2;
								}else 
										return null;   
						  } 
		
		// To find "Create" button on  New Index Field page
			@FindBy(id  = "imf_add")
			private WebElement create;
				public WebElement getCreate() {
				if(WebElementWait.waitToElementClickable(driver, create) != null) {
						return create;
				}else  
						return null;   
		}
				
	  //  To find 'Values List' icon for 'Procurement Information' Index Master 
		@FindBy(xpath  = "//td[contains(text(),'Procurement')]//following-sibling::td[3]//i[@class='icon-th']")
		private WebElement im1ValuesList;
			public WebElement getIM1ValuesList() {
			if(WebElementWait.waitToElementClickable(driver, im1ValuesList) != null) {
					return im1ValuesList;
			}else 
					return null;   
	   } 	
	
	 //  To find 'Values List' icon for 'Employee Information' Index Master 
	@FindBy(xpath  = "//td[contains(text(),'Employee')]//following-sibling::td[3]//i[@class='icon-th']") 
	private WebElement im2ValuesList;
		public WebElement getIM2ValuesList() {
		if(WebElementWait.waitToElementClickable(driver, im2ValuesList) != null) {
				return im2ValuesList;
		}else 
				return null;   
   } 	
	
	// To find all the Fields in specific Index master - 'Automated Index Master'
		@FindBy(xpath  = "//label/span[@class='labelauty-checked-image']")
		public List <WebElement> allFields;
					
	// To find 'Add Value' button on Values List page
		@FindBy(xpath  = "(//button[@class='btn btn-danger'])[2]")
		private WebElement addValueButton;
			public WebElement getAddValueButton() {
			if(WebElementWait.waitToElementClickable(driver, addValueButton) != null) {
					return addValueButton;
			}else 
					return null;   
	   } 
		
												   
			
		// To find 'Insert' button on 'Values List' page
		@FindBy(id  = "imv_add")
		private WebElement insertButton;
			public WebElement getInsertButton() {
			if(WebElementWait.waitToElementClickable(driver, insertButton) != null) {
					return insertButton;
			}else 
					return null;   
	   }	
			
// TO FIND 'deal room -ANALYTICS' LINK (FOR PAGINATION PURPOSE)	
			@FindBy(xpath  = "//a[contains(text(), 'Analytics')]")
			private WebElement analytics;
				public WebElement getAnalyticsLink() {
				if(WebElementWait.waitToElementClickable(driver, analytics) != null) {
						return analytics;
				}else 
						return null;   
		   }	
		
		/*		
				// --------------- Locators for Master Report ---------------
				@FindBy(xpath  = "//td[contains(text(),'Employee Information')]/following-sibling::td//i[@class='icon-tasks']")
				private WebElement masterReport;
				
				public WebElement getMasterReport(){
					if(WebElementWait.waitToElementClickable(driver, masterReport) != null) {
						return masterReport;
					}else
						return null;   
				}
				
				// 'New Report' button  
				@FindBy(xpath = "//button[text()='New Report']")
				private WebElement buttonNewReport;
				
				public WebElement getButtonNewReport(){
					if(WebElementWait.waitToElementClickable(driver, buttonNewReport) != null) {
						return buttonNewReport;
					}else
						return null;
				}
				
				
				@FindBy(id  = "im_report_name")
				private WebElement imReportName;
				
				public WebElement getIMreportName(){
					if(WebElementWait.waitToElementClickable(driver, imReportName) != null) {
						return imReportName;
					}else
						return null;   
				}
				
				// 'Report Type' DropDown  
				
				@FindBy(xpath  = "//span[text()='Choose a report type...']")
				private WebElement reportType;
				
				public WebElement getReportType(){
					if(WebElementWait.waitToElementClickable(driver, reportType) != null) {
						return reportType;
					}else
						return null;
				}
				
				// 'Report Type SearchBox'  
				@FindBy(xpath  = "//div[@class='chzn-search']//input")
				private WebElement reportTypeSearchbox;
				
				public WebElement getReportTypeSearchbox(){
					if(WebElementWait.waitToElementClickable(driver, reportTypeSearchbox) != null) {
						return reportTypeSearchbox;
					}else
						return null;
				}
				
				

				@FindBy(xpath  = "//div[@id='divIndexMasterFields']//label")  	//Index Master Fields
				public List <WebElement> indexMasterFields;
				
				// 'Period DropDown' -:: Same Locator as for Document Report Locator ::-
				@FindBy(xpath  = "//span[text()='Choose a Period...']")
				private WebElement periodDropdown;
				
				public WebElement getPeriodDropdown(){
					if(WebElementWait.waitToElementClickable(driver, periodDropdown) != null) {
						return periodDropdown;
					}else
						return null;   
				}
				
				 
				// 'Period SearchBox' 
				@FindBy(xpath  = "(//div[@class='chzn-search']//input)[2]") // 
				private WebElement periodSearchbox;
				
				public WebElement getPeriodSearchbox(){
					if(WebElementWait.waitToElementClickable(driver, periodSearchbox) != null) {
						return periodSearchbox;
					}else
						return null;   
				}
				
				
				@FindBy(xpath = "//span[text()='Choose a No. of Year(s)...']")  //   // id  = "yearsDiv"
				private WebElement reportPeriodInNumber;
				
				public WebElement getReportPeriodInNumber(){
					if(WebElementWait.waitToElementClickable(driver, reportPeriodInNumber) != null) {
						return reportPeriodInNumber;
					}else
						return null;   
				}
				
				@FindBy(xpath  = "(//div[@class='chzn-search']//input)[6]")   // [5]
				private WebElement numberOfMonthsSearchbox;
				
				public WebElement getNumberOfMonthsSearchbox(){
					if(WebElementWait.waitToElementClickable(driver, numberOfMonthsSearchbox) != null) {
						return numberOfMonthsSearchbox;
					}else
						return null;    
				}
				
				// 'Add Button'
				@FindBy(xpath  = "//button[@type='submit']")
				private WebElement addButton;
				
				public WebElement getAddButton(){
					if(WebElementWait.waitToElementClickable(driver, addButton) != null) {
						return addButton;
					}else
						return null;   
				}
				
				@FindBy(linkText = "Master Report - Dashboard") // Master Report - DashBoard  Index Master Report
				private WebElement imReportDashboard;
				
				public WebElement getIMreportDashboard(){
					if(WebElementWait.waitToElementClickable(driver, imReportDashboard) != null) {
						return imReportDashboard;
					}else
						return null;   
				}
			*/
}						