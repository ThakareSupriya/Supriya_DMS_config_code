package locators;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webCommonFunctions.WebElementWait;

public class GroupRights_Locator {
	
		WebDriver driver = null; 
		
		public GroupRights_Locator(WebDriver driver) {
			this.driver = driver ;
			PageFactory.initElements(driver, this);
		}

//---------------- To Create USer Account ----------------- 	
		// To find User Accounts value from settings dropDown	
		@FindBy (xpath = "//i[@class='icon-user']")
		private WebElement userAccount ;
		
		public WebElement getUserAccountValue() {
			if(WebElementWait.waitToElementClickable(driver, userAccount) != null) {
				return userAccount;	
			}else 
				return null;
		}
		
		// To find New User button
		@FindBy(xpath = "//button[text()='New User']")
		private WebElement newUser;
		
		public WebElement getbutton_NewUser() {
			if(WebElementWait.waitToElementClickable(driver, newUser) != null) {
				return newUser;
			}else 
				return null;
		}
		
		// To find User Name textBox
		@FindBy(id = "fname")
		private WebElement firstName ;
		
		public  WebElement getFirstName() {
			if(WebElementWait.waitToElementClickable(driver, firstName) != null) {
				return firstName;	
			}else 
				return null;
		}
		
		// TO find Last Name TextBox
		@FindBy(id = "lname")
		private WebElement lastName ;
		
		public  WebElement getLastName() {
			if(WebElementWait.waitToElementClickable(driver, lastName) != null) {
				return lastName;	
			}else 
				return null;
		}
		
		// To find Login Type DropDown :: If selected as DMS USER
		@FindBy(xpath = "//div[@id='ad_domain_name_chzn']")
		private WebElement loginDomain;
		
		public WebElement getLoginDomain() {
			if(WebElementWait.waitToElementClickable(driver, loginDomain) != null) {
				return loginDomain;
			}else 
				return null;
		}
				
		
		// To find Login Type DropDown :: if not selected as 'DMS User'
		@FindBy(xpath = "//span[text()='Choose DMS/AD Login']")
		private WebElement loginType;
		
		public WebElement getLoginType() {
			if(WebElementWait.waitToElementClickable(driver, loginType) != null) {
				return loginType;
			}else 
				return null;
		}
			// To find Login Type searchBox 
			@FindBy(xpath = "//div[@class='chzn-search']//input") //  //span[text()='Choose DMS/AD Login']
			private WebElement loginTypeSearchbox;
			
			public WebElement getLoginTypeSearchbox() {
				if(WebElementWait.waitToElementClickable(driver, loginTypeSearchbox) != null) {
					return loginTypeSearchbox;
				}else 
					return null;
			}
		
	//  To find password TextBox
		@FindBy(id  = "password")
		private WebElement password;
			
		public WebElement getPassword() {
			if(WebElementWait.waitToElementClickable(driver, password) != null) {
				return password;
			}else 
				return null;
		}
	
	// To find confirm password TextBox
		@FindBy(id = "re_password")
		private WebElement confPassword;
			
		public WebElement getConfPassword() {
			if(WebElementWait.waitToElementClickable(driver, confPassword) != null) {
				return confPassword;
			}else 
				return null;   
		}
	
	// To find UserName TextBox
		@FindBy(id = "username")
		private WebElement username;
			
		public WebElement getUsername() {
			if(WebElementWait.waitToElementClickable(driver, username) != null) {
				return username;
			}else 
				return null;   
		}
		
	//  To find Email TextBox
		@FindBy(id = "email")
		private WebElement email;
			
		public WebElement getEmail() {
			if(WebElementWait.waitToElementClickable(driver, email) != null) {
				return email;
			}else 
				return null;   
		} 
			
	// To find User Group DropDown
		@FindBy(xpath  = "//span[text()='Select User Group']")
		private WebElement ug; 
			
		public WebElement getUserGroup() {
			if(WebElementWait.waitToElementClickable(driver, ug) != null) {
				return ug;
			}else 
				return null;   
		}  
				// To find user group SearchBox in user group dropDown
					@FindBy(xpath  = "//div[@id='user_group_by_user_type']//input") //    (//li[text()='Human Resources'])[1]
					private WebElement ugValueSearchbox;
			
					public WebElement getUgValueSearchbox() {
						if(WebElementWait.waitToElementClickable(driver, ugValueSearchbox) != null) {
							return ugValueSearchbox;
						}else 
							return null;   
					} 
			
					
	// To find Select Deal Room dropDown
		@FindBy(xpath  = "//input[@value='Select Deal Room']")
		private WebElement selectDR;
			
		public WebElement getSelectDR() {
			if(WebElementWait.waitToElementClickable(driver, selectDR) != null) {
				return selectDR;
			}else 
				return null;   
		}  

   // To find Create button
		@FindBy(id  = "btn-create")
		private WebElement createButton;
						 
		public WebElement getCreatebutton() {
			if(WebElementWait.waitToElementClickable(driver, createButton) != null) {
				return createButton;
			}else 
				return null;   
		}  
	
	// To find pop-up window  
		@FindBy(xpath  = "//div[@class='bootbox modal fade in']")
		private WebElement popupWindow;
						 
		public WebElement getPopupWindow() {
			if(WebElementWait.waitToElementClickable(driver, popupWindow) != null) {
				return popupWindow;
			}else 
				return null;   
		} 	
		
//---------------- To Assign Group Rights -----------------

	// To find 'Group Rights' in settings dropDown 
		@FindBy(xpath  = "//a[contains(text(),'Group Rights')]")
		private WebElement groupRights;
							 
		public WebElement getGroupRights() {
			if(WebElementWait.waitToElementClickable(driver, groupRights) != null) {
				return groupRights;
			}else 
				return null;   
		}
		
	// TO delete/find already selected user group i.e. 'super admin'
		@FindBy(xpath  = "//span[@class='token-input-delete-token-facebook']")
		private WebElement delete_alreadySelectedGroup;
									 
		public WebElement get_AlreadySelected_userGroup() {
			if(WebElementWait.waitToElementClickable(driver, delete_alreadySelectedGroup) != null) {
				return delete_alreadySelectedGroup;
			}else 
				return null;   
		}
		
	// To find textBox for 'Select user group for rights'
		@FindBy(xpath  = "//input[@placeholder='Enter User Group']")
		private WebElement select_userGroup_ForRights;
									 
		public WebElement getTextbox_Select_userGroup_ForRights() {
			if(WebElementWait.waitToElementClickable(driver, select_userGroup_ForRights) != null) {
				return select_userGroup_ForRights;
			}else 
				return null;   
		}
		
	// To find textBox for 'Select user group for rights'
		@FindBy(xpath  = "//input[@name='chbox']")
		public List<WebElement> checkboxes ;
		
	// To find logo
		@FindBy(xpath  = "//img[@alt='Recall']")
		private WebElement dmacq_logo;
									 
		public WebElement getDmacq_logo() {
			if(WebElementWait.waitToElementClickable(driver, dmacq_logo) != null) {
				return dmacq_logo;
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
		
	// To find Assign Rights tab
		@FindBy(id = "assign_rights_icon")
		private WebElement assignRights;
				
		public WebElement getAssignRights() {
			if(WebElementWait.waitToElementClickable(driver, assignRights) != null) {
				return assignRights;
			}else 
				return null;   
		}	
		
	// To find 'IM Field Rights' tab
		@FindBy(id = "index_master_fields_tab")
		private WebElement IM_filds_Rights;
						
		public WebElement getIM_filds_Rights() {
			if(WebElementWait.waitToElementClickable(driver, IM_filds_Rights) != null) {
				return IM_filds_Rights;
			}else 
				return null;   
		}	
		
		
	// To find Choose index master 
		@FindBy(xpath = "//span[text()='Choose a Index Master...']")
		private WebElement selectIM;
								
		public WebElement get_selectIM() {
			if(WebElementWait.waitToElementClickable(driver, selectIM) != null) {
				return selectIM;
			}else 
				return null;   
		}
		
	// To find textbox to send IM name
		@FindBy(xpath = "//span[text()='Choose a Index Master...']//following::div//input")
		private WebElement textbox_IMSelect;
										
		public WebElement get_textbox_IMSelect() {
			if(WebElementWait.waitToElementClickable(driver, textbox_IMSelect) != null) {
				return textbox_IMSelect;
			}else 
				return null;   
		}		
		
	// To find 'IM Field Rights' tab
		@FindBy(id = "index_group_tab")
		private WebElement IG_Rights;
								
		public WebElement getIG_Rights() {
			if(WebElementWait.waitToElementClickable(driver, IG_Rights) != null) {
				return IG_Rights;
			}else 
				return null;   
		}	
		
	// To find Choose index Group 
		@FindBy(xpath = "//span[text()='Choose a Index Group...']")
		private WebElement selectIG;
										
		public WebElement get_selectIG() {
			if(WebElementWait.waitToElementClickable(driver, selectIG) != null) {
				return selectIG;
			}else 
				return null;   
		}
	// To find textbox to send IM name
		@FindBy(xpath = "//span[text()='Choose a Index Group...']//following::div//input")
		private WebElement textbox_IGSelect;
												
		public WebElement get_textbox_IGSelect() {
			if(WebElementWait.waitToElementClickable(driver, textbox_IGSelect) != null) {
				return textbox_IGSelect;
			}else 
				return null;   
		}
		
	// To find 'checkBox' to tick for visible rights
		@FindBy(id = "visible_checkAll")
		private WebElement visible_Rights;
												
		public WebElement getvisible_Rights() {
			if(WebElementWait.waitToElementClickable(driver, visible_Rights) != null) {
				return visible_Rights;
			}else 
				return null;   
		}
	// To find 'checkBox' to tick for To search rights
		@FindBy(id = "search_checkAll")
		private WebElement toSearch_Rights;
												
		public WebElement getToSearch_Rights() {
			if(WebElementWait.waitToElementClickable(driver, toSearch_Rights) != null) {
				return toSearch_Rights;
			}else 
				return null;   
		}
		
		
// ---------------------- For IM RIGHTS Tab -----------------------------------------
		
		// To find 'IM Field Rights' tab
			@FindBy(id = "index_master_tab")
			private WebElement IM_Rights_Tab;
								
			public WebElement getIM_Rights_Tab() {
				if(WebElementWait.waitToElementClickable(driver, IM_Rights_Tab) != null) {
					return IM_Rights_Tab;
				}else 
					return null;   
			}
			
		// To find All checkBoxes for all  IM Rights row ::- Master View, Master Edit, Master Delete --&-- All
			@FindBy(xpath = "//input[@type='checkbox']") //   //thead[@class='header']//input[@type='checkbox']
			public List <WebElement>  IM_Rights_Checkboxes;
			
			
			
// ---------------------- For Category Rights RIGHTS Tab -----------------------------------------
			
		// To find 'IM Field Rights' tab
			@FindBy(id = "category_rights_tab")
			private WebElement category_Rights_Tab;
								
			public WebElement getCategory_Rights_Tab() {
				if(WebElementWait.waitToElementClickable(driver, category_Rights_Tab) != null) {
					return category_Rights_Tab;
				}else 
					return null;   
			}
			
		// To find 'IM Field Rights' tab
			@FindBy(xpath = "//input[@type='checkbox']")
			public List <WebElement> categoryRights_Checkboxes;
								
			
			
			
	}
 

