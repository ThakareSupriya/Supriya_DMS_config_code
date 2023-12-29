package locators;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webCommonFunctions.WebElementWait;

public class Category_Loactor {
	// Category and sub category creation locators
	
	WebDriver driver = null;
	
	//  Constructor to initialize driver
	public Category_Loactor(WebDriver driver) {
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
	
	// To find DMS tab
	@FindBy(xpath = "//span[normalize-space()='DMS']")
	private WebElement dms;
	
	public WebElement getDms() {
			if(WebElementWait.waitToElementClickable(driver, dms) != null) {
				return dms;
			}else 
				return null;   
	}
	
	// To find create category icon    
	@FindBy(id  = "category_add")
	private WebElement addCat;
	 
	public WebElement getAddCat() {
			if(WebElementWait.waitToElementClickable(driver, addCat) != null) {
				return addCat;
			}else 
				return null;   
	}
	
	// To find 'Create Category' button [While creating new category second/third time]
	@FindBy(xpath  = "//button[contains(text(),'Create')]")
	private WebElement createCat;
	 
	public WebElement getCreateCat() {
			if(WebElementWait.waitToElementClickable(driver, createCat) != null) {
				return createCat;
			}else 
				return null;   
	}
	
	// To find New Category Name TextBox  
		@FindBy(xpath  = "//input[@id='category']")
		private WebElement newCatName;
		
		public WebElement getNewCatName() {
				if(WebElementWait.waitToElementClickable(driver, newCatName) != null) {
					return newCatName;
				}else 
					return null;   
		}        
		
			// TO find 'Turn-off QC Approval? ' checkBox
			@FindBy(id = "pre_approval_status") 
			private WebElement turnoffQCApproval;
			
			public WebElement getTurnOffQCApproval() {
					if(WebElementWait.waitToElementClickable(driver, turnoffQCApproval) != null) {
						return turnoffQCApproval;
					}else 
						return null;   
			}
			// To find ' Clone from this Category: ' DropDown
			@FindBy(xpath = "//span[text()='Please select a category or a sub category']") 
			private WebElement cloneCategory;
			
			public WebElement getCloneCategory() {
					if(WebElementWait.waitToElementClickable(driver, cloneCategory) != null) {
						return cloneCategory;
					}else 
						return null;   
			}
			
			// To find ' Replicate Category ' SearchBox
			@FindBy(xpath = "//div[@class='chzn-drop']//input") 
			private WebElement ReplicateCategory;
			
			public WebElement getReplicateCategory() {
					if(WebElementWait.waitToElementClickable(driver, ReplicateCategory) != null) {
						return ReplicateCategory;
					}else 
						return null;    
			}
			
			
							// Set Indexes to category
							
							// To find 'Set indexes to category' button against specific category  i. e. - Article Category
							@FindBy(xpath = "//td[contains(text(),'Article Category')]/following-sibling::td//i[@class='icon-retweet']") 
							private WebElement setIndexesToSecondCat;
							
							public WebElement getSetIndexesToSecondCat() {
									if(WebElementWait.waitToElementClickable(driver, setIndexesToSecondCat) != null) {
										return setIndexesToSecondCat;
									}else 
										return null;   
							}
							
							// To find 'Set indexes to category' button against specific category  i. e. - Loan Category
							@FindBy(xpath = "//td[contains(text(),'Loan Category')]/following-sibling::td//i[@class='icon-retweet']") 
							private WebElement setIndexesToThirdCat;
							
							public WebElement getSetIndexesToThirdCat() {
									if(WebElementWait.waitToElementClickable(driver, setIndexesToThirdCat) != null) {
										return setIndexesToThirdCat;
									}else 
										return null;   
							}
		
		// To find Select Index Master(s) TextBox
		@FindBy(xpath = "//input[@value='Select Index Master']")
		public WebElement selectIM;
		
		public WebElement getSelectIM() {
				if(WebElementWait.waitToElementClickable(driver, selectIM) != null) {
					return selectIM;
				}else 
					return null;   
		}
		
		// To find Select Index Master(s) Mandatory: TextBox
		@FindBy(xpath = "//input[@value='Select Index Master Mandatory']")
		public WebElement mandatoryIM;
		
		public WebElement getMandatoryIM() {
				if(WebElementWait.waitToElementClickable(driver, mandatoryIM) != null) {
					return mandatoryIM;
				}else 
					return null;   
		}
		
		// To find Select Index group(s): TextBox
		@FindBy(xpath = "//input[@value='Select Index Category']")             //<--Need to change locator as changed in DOM
		public WebElement selectIG;
		
		public WebElement getSelectIG() {
				if(WebElementWait.waitToElementClickable(driver, selectIG) != null) {
					return selectIG;
				}else 
					return null;   
		}
		
		// To find Select Doc Set DropDown arrow
		@FindBy(xpath = "//div[@id='doc_set_chzn']")             //  (//b)[7]                 
		private WebElement selectDocSetropdown;
		
		public WebElement getSelectDocSet() {
				if(WebElementWait.waitToElementClickable(driver, selectDocSetropdown) != null) {
					return selectDocSetropdown;
				}else 
					return null;   
		}
					// To find Select Doc Set DropDown TextBox	
					@FindBy(xpath = "//div[@id='doc_set_chzn']//input")                                   
					private WebElement docSetDropdownTextbox;
					
					public WebElement getDocSetDropdownTextbox() {
							if(WebElementWait.waitToElementClickable(driver, docSetDropdownTextbox) != null) {
								return docSetDropdownTextbox;
							}else 
								return null;   
					}
					
					// To find all Doc Set DropDown Values at once
					@FindBy(xpath = " //span[@class='labelauty-unchecked']")                                     //span[@class='labelauty-unchecked']  |  //span[@class='labelauty-checked']
					public List<WebElement> docSetValues;
					
		// To find 'Save' button on Set Indexes to Category page
		@FindBy(name = "btn_set_indexes")                                   
		private WebElement saveButton;
		
		public WebElement getSaveButton() {
				if(WebElementWait.waitToElementClickable(driver, saveButton) != null) {
					return saveButton;
				}else 
					return null;   
		}
		
		// To find pop-up window on success of  'Set Indexes to category' 
		@FindBy(xpath  = "//div[@class='bootbox modal fade in']")                                   
		private WebElement popupWindow;
		
		public WebElement getPopUpwindow() {
				if(WebElementWait.waitToElementClickable(driver, popupWindow) != null) {
					return popupWindow;
				}else 
					return null;   
		}
	
		// To find 'Successfully Updated' div in pop-up window
		@FindBy(xpath  = "//div[text()='Successfully Updated.']")                                   
		private WebElement textSuccessful;
		
		public WebElement getTextSuccessful() {
				if(WebElementWait.waitToElementClickable(driver, textSuccessful) != null) {
					return textSuccessful;
				}else 
					return null;   
		}
		
		//  To find 'Close' button on pop-up window
		@FindBy(xpath  = "//a[@class='btn btn-success']")                                   
		private WebElement closeButton;
		
		public WebElement getCloseButton() {
				if(WebElementWait.waitToElementClickable(driver, closeButton) != null) {
					return closeButton;
				}else 
					return null;   
		}
		
		// To find 'Back' button on  pop-up window
		@FindBy(xpath  = "//button[@class='btn history_back']")                                   
		private WebElement backButton;
		
		public WebElement getBackButton() {
				if(WebElementWait.waitToElementClickable(driver, backButton) != null) {
					return backButton;
				}else 
					return null;   
		}	
		
		
		// to find 'Home' icon to navigate to 'Category Details' page (i.e. parent category)
		@FindBy(xpath  = "//a[@class='icon-home a_cat_home' or @class='a_cat_home icon-home']")  // //a[@class='icon-home a_cat_home' or @class='a_cat_home icon-home']     // //a[@class='icon-home a_cat_home']                            
		private WebElement homeIcon;
		
		public WebElement getHomeIcon() {
				if(WebElementWait.waitToElementClickable(driver, homeIcon) != null) {
					return homeIcon;
				}else 
					return null;   
		}
		
}

