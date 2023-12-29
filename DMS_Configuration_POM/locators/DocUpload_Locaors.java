package locators;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webCommonFunctions.WebElementWait;

public class DocUpload_Locaors {
	
		WebDriver driver = null ;
		
		public DocUpload_Locaors(WebDriver driver) {
				this.driver = driver ;
				PageFactory.initElements(driver, this);
		}
		
		// ------------------------------------ Login Page Locators ------------------------------------
		// For UserName
		@FindBy (name = "username")
		private  WebElement username;
		
		public WebElement getUsername () {
				if(WebElementWait.waitToElementClickable(driver, username) != null) {
					return username;
				}else 
					return null;
		}
		// For password 
		@FindBy(name = "password")
		private WebElement password;
		
		public WebElement getPassword() {
			if(WebElementWait.waitToElementClickable(driver, password) != null) {
				return password;
			}else 
				return null;
		}
		
		// For 'login' button
		@FindBy(id = "btn-create")
		private WebElement loginButton; 
		
		public WebElement getLoginButton() {
			if(WebElementWait.waitToElementClickable(driver, loginButton) != null) {
				return loginButton;
			}else
				return  null;                                                                    
		}
		
		// For Login Error Message on Login page	  
		@FindBy(xpath = "//div[@class='alert-error']")
		private WebElement loginError; 
		
		public WebElement getLoginError() {
			if(WebElementWait.waitToElementClickable(driver, loginError) != null) {
				return loginError;
			}else
				return  null;                                                                    
		}
		
		// ------------------------------------ Password Reset Locators ------------------------------------
		// To find 'Forgot password? "Click here" to reset '
		@FindBy(linkText  = "Click here")
		private WebElement clickHere; 
		
		public WebElement getClickHereLink() {
			if(WebElementWait.waitToElementClickable(driver, clickHere) != null) {
				return clickHere;
			}else
				return  null;                                                                    
		}
		
		// "Email" textbox :   Enter your registered email address to reset your password.   
		@FindBy(xpath  = "//input[@type='email']")
		private WebElement emailTextbox; 
		
		public WebElement getEmailTextbox() {
			if(WebElementWait.waitToElementClickable(driver, emailTextbox) != null) {
				return emailTextbox;
			}else
				return  null;                                                                    
		}
		// "Send" button :   on Reset Password page [Telegram Icon]
		@FindBy(xpath  = "//img[@class='loginicon']")
		private WebElement telegramIcon; 
		
		public WebElement getTelegramIcon() {
			if(WebElementWait.waitToElementClickable(driver, telegramIcon) != null) {
				return telegramIcon;
			}else
				return  null;                                                                    
		}
		// "Notification" :   Password Reset Notification    
		@FindBy(xpath  = "//div[@class='alert alert-success alert-dismissible forgottost']")
		private WebElement passwordResetNotification; 
		
		public WebElement getPasswordResetNotification() {
			if(WebElementWait.waitToElementClickable(driver, passwordResetNotification) != null) {
				return passwordResetNotification;
			}else
				return  null;                                                                    
		}
		// -----For Change password---
		// "User profile" icon
		@FindBy(xpath  = "//img[@class='round']")
		private WebElement userProfileIcon; 
		
		public WebElement getUserProfileIcon() {
			if(WebElementWait.waitToElementClickable(driver, userProfileIcon) != null) {
				return userProfileIcon;
			}else
				return  null;                                                                    
		}
		// "Edit profile" icon
		@FindBy(xpath  = "//i[@class='icon-edit']")
		private WebElement editProfileIcon; 
		
		public WebElement getEditProfileIcon() {
			if(WebElementWait.waitToElementClickable(driver, editProfileIcon) != null) {
				return editProfileIcon;
			}else
				return  null;                                                                    
		}
		//  "Edit profile" button
		@FindBy(xpath  = "//button[text()='Edit Profile']")
		private WebElement editProfileButton; 
		
		public WebElement getEditProfileButton() {
			if(WebElementWait.waitToElementClickable(driver, editProfileButton) != null) {
				return editProfileButton;
			}else
				return  null;                                                                    
		}
		// "Change password" Tab
		@FindBy(linkText  = "Change Password")
		private WebElement changePasswordTab; 
		
		public WebElement getChangePasswordTab() {
			if(WebElementWait.waitToElementClickable(driver, changePasswordTab) != null) {
				return changePasswordTab;
			}else
				return  null;                                                                    
		}
		// Finding 'Password' textbox on :  'Edit User Profile' page          
		@FindBy(id   = "password1")
		private WebElement passwordTxtbox; 
		
		public WebElement getPasswordTxtbox() {
			if(WebElementWait.waitToElementClickable(driver, passwordTxtbox) != null) {
				return passwordTxtbox;
			}else
				return  null;                                                                    
		}
		// Finding 'Repeat Password' textBox on :  'Edit User Profile' page          
		@FindBy(id   = "re_password")
		private WebElement rePasswordTxtbox; 
		
		public WebElement getRePasswordBtn() {
			if(WebElementWait.waitToElementClickable(driver, rePasswordTxtbox) != null) {
				return rePasswordTxtbox;
			}else
				return  null;                                                                    
		}
		// Finding 'Update Password' button on :  'Edit User Profile' page  
		@FindBy(id   = "btn-create3")
		private WebElement updatePasswordBtn; 
		
		public WebElement getUpdatePasswordBtn() {
			if(WebElementWait.waitToElementClickable(driver, updatePasswordBtn) != null) {
				return updatePasswordBtn;
			}else
				return  null;                                                                    
		}
		// Finding "Logo" to exit  Edit User Profile page
		@FindBy(xpath   = "//a[@class='brand']")
		private WebElement logo; 
		
		public WebElement getLogo() {
			if(WebElementWait.waitToElementClickable(driver, logo) != null) {
				return logo;
			}else
				return  null;                                                                    
		}
		//  ----- Logout Test Case locators ----
		// To find "Logout" icon from user profile
		@FindBy(xpath   = "//i[@class=' icon-lock']")
		private WebElement logoutIcon; 
		
		public WebElement getLogoutIcon() {
			if(WebElementWait.waitToElementClickable(driver, logoutIcon) != null) {
				return logoutIcon;
			}else
				return  null;                                                                    
		}
		
		// ------------------------------------ Scenario: Uploading of Documents ------------------------------------
		// To find deal room (i. e. ::	Test Room)
				@FindBy(xpath  = "//a[contains(text(),'Test Room')]") //   //a[normalize-space()='DMS DATA']  
				private WebElement dRoom;
				
				public WebElement getDealRoom() {
						if(WebElementWait.waitToElementClickable(driver, dRoom) != null){
							return dRoom;
						}else 
							return null;   
				}
				
		// To find "DMS" icon 
		@FindBy(  linkText  = "DMS") // xpath   //span[text()='DMS']
		private WebElement dms; 
		
		public WebElement getDMS() {
			if(WebElementWait.waitToElementClickable(driver, dms) != null) {
				return dms;
			}else
				return  null;                                                                    
		}
		
		// To find specific category (for size [List])                    :: Accounts Docs ::
		@FindBy(xpath   = "//li[contains(text(),'Accounts')]")
		public List <WebElement> folderList; 
		
	/*	public WebElement getFolderList() {
			if(WebElementWait.waitToListElementClickable(driver, folderList) != null) {
				return folderList;
			}else
				return  null;                                                                    
		}
	*/	
		// To find specific category
		@FindBy(xpath   = "//li[contains(text(),'Accounts')]")
		private WebElement folder; 
		
		public WebElement getFolder() {
			if(WebElementWait.waitToElementClickable(driver, folder) != null) {
				return folder;
			}else
				return  null;                                                                    
		}
		
		// To find "Upload With DocSet"
		@FindBy(xpath   = "(//i[@class='icon-upload-alt'])[1]")
		private WebElement uploadWithDocset; 
		
		public WebElement getUploadWithDocset() {
			if(WebElementWait.waitToElementClickable(driver, uploadWithDocset) != null) {
				return uploadWithDocset;
			}else
				return  null;                                                                    
		}
		
		// To find Doc-Set values (all) : To select doc set dropDown value
		@FindBy(xpath  = "//ins[@class='iCheck-helper']")           
		public List<WebElement> selectValueOptions;    
		
		// To find  'Proceed' button 
		 @FindBy(xpath  = "//span[@class='blink_me']")  
		 private WebElement proceedButton;

		 public WebElement getProceedButton() {
			 if(WebElementWait.waitToElementClickable(driver, proceedButton) != null) {
				 return proceedButton;
			 }else 
				 return null;   
		 }
		// To find  'Upload file' button 1 (for 1st value)
		 @FindBy(xpath  = "(//input[@name='qqfile'])[1]")   
		 public WebElement uploadFileButton;

		 public WebElement getUploadFileButton() {
			 if(WebElementWait.waitToElementClickable(driver, uploadFileButton) != null) {
				 return uploadFileButton;
			 }else 
				 return null;   
		 }
		// To find  'Upload file' button 2 (for 2st value)
				 @FindBy(xpath  = "(//input[@name='qqfile'])[2]")   
				 public WebElement uploadFileButton2;

				 public WebElement getUploadFileButton2() {
					 if(WebElementWait.waitToElementClickable(driver, uploadFileButton2) != null) {
						 return uploadFileButton2;
					 }else 
						 return null;   
				 }
		// To click on 'Upload' button   
		 @FindBy(xpath  = "//button[text()='Upload']")   
		 public List <WebElement> uploadButtons;

		 public List <WebElement> getUploadButtons() {
			 if(WebElementWait.waitToListElementClickable(driver, uploadButtons) != null) {
				 return uploadButtons;
			 }else 
				 return null;   
		 }
		 
		 // To click on 'Upload' button   
		 @FindBy(xpath  = "//button[text()='Upload']")   
		 private WebElement uploadButton;

		 public WebElement getUploadButton() {
			 if(WebElementWait.waitToElementClickable(driver, uploadButton) != null) {
				 return uploadButton;
			 }else 
				 return null;   
		 }
		 // To find 'Next' button  
		 @FindBy(id  = "index-next")  
		 private WebElement nextButton;

		 public WebElement getNextButton() {
			 if(WebElementWait.waitToElementClickable(driver, nextButton) != null) {
				 return nextButton;
			 }else 
				 return null;   
		 } 
		 // To find Indexing 'Multiple' radio button  
		 @FindBy(id  = "multiple")  
		 private WebElement multipleIndexing;

		 public WebElement getMultipleIndexing() {
			 if(WebElementWait.waitToElementClickable(driver, multipleIndexing) != null) {
				 return multipleIndexing;
			 }else 
				 return null;   
		 } 
		 
		 // -----For IM indexing: -------
			 	// To find "Tag from existing value" 
			 	@FindBy(xpath   = "//span[text()='Tag from existing value']")
				private WebElement tagFromExistingValue; 
				
				public WebElement getTagFromExistingValue() {
					if(WebElementWait.waitToElementClickable(driver, tagFromExistingValue) != null) {
						return tagFromExistingValue;
					}else
						return  null;                                                                    
				}
				// To find "Choose a master field..." 
			 	@FindBy(xpath   = "//span[text()='Choose a master field...']")
				private WebElement chooseMasterField; 
				
				public WebElement getchooseMasterField() {
					if(WebElementWait.waitToElementClickable(driver, chooseMasterField) != null) {
						return chooseMasterField;
					}else
						return  null;                                                                    
				}
				// To find IM value Search textBox [Enter - field name......]
				@FindBy(xpath   = "//textarea[@class='class_index_master_field_val span8']") //   // //input[@class='class_index_master_field_val span8']
				private WebElement imValueTextbox; 
				
				public WebElement getIMValueTextbox() {
					if(WebElementWait.waitToElementClickable(driver, imValueTextbox) != null) {
						return imValueTextbox;
					}else
						return  null;                                                                    
				}
				// To find 'Search icon' to search IM field value
				@FindBy(xpath = "//i[@class='icon-search']")
				private WebElement iconSearch;
			
				public WebElement getIconSearch() {
					if(WebElementWait.waitToElementClickable(driver, iconSearch) != null) {
						return iconSearch;
					}else 
						return null;  
			}
				// To find 'Select' button                                                 
				@FindBy(xpath = "//button[text()='Select']")
				private WebElement selectButton;
			
				public WebElement getSelectButton() {
					if(WebElementWait.waitToElementClickable(driver, selectButton) != null) {
						return selectButton;
					}else 
						return null;  
			}
				// To find "Add New Value" button ---- for indexing
				@FindBy(xpath = "//button[text()=' Add New Value']")
				private WebElement addNewValue;
			
				public WebElement getAddNewValue() {
					if(WebElementWait.waitToElementClickable(driver, addNewValue) != null) {
						return addNewValue;
					}else 
						return null;  
			}
		
							//--------------- Add New Value ----------------
							// To find 'all input fields' on "Add New Index Master Value" form    // used for multiIndexing
							@FindBy(xpath = "//form[@id='AddForm']//div//textarea")
							private WebElement textArea;
							
							public WebElement getFormFirstTextbox() {
								if(WebElementWait.waitToElementClickable(driver, textArea) != null) {
									return textArea;
								}else 
									return null;  
							}
							// To find 'all input fields' on "Add New Index Master Value" form    // used for multiIndexing
							@FindBy(xpath = "//form[@id='AddForm']//div//input")
							public List<WebElement> inputImFields;
			
				
				
				// To find "Insert" button on "Add New Index Master Value" form
				@FindBy(xpath = "//button[text()='Insert']")
				private WebElement insertButton;
			
				public WebElement getInsertButton() {
					if(WebElementWait.waitToElementClickable(driver, insertButton) != null) {
						return insertButton;
					}else 
						return null;  
			}
				// To find select All checkBox  to select all the uploaded files for indexing
				@FindBy(id = "selectall")
				private WebElement selectAllcheckboxes;
			
				public WebElement getSelectAllCheckbox() {
					if(WebElementWait.waitToElementClickable(driver, selectAllcheckboxes) != null) {
						return selectAllcheckboxes;
					}else 
						return null;  
			}
				// To find "Index" button for files indexing
				@FindBy(id = "index-btn")
				private WebElement indexButton;
			
				public WebElement getIndexButton() {
					if(WebElementWait.waitToElementClickable(driver, indexButton) != null) {
						return indexButton;
					}else 
						return null;  
			}
				// To find "NO" button for indexed, Upload more files?
				@FindBy(xpath = "//a[@class='btn null']")  // xpath = //a[text()='NO']    
				private WebElement NoButton;
			
				public WebElement getNoButton() {
					if(WebElementWait.waitToElementClickable(driver, NoButton) != null) {
						return NoButton;
					}else 
						return null;  
			}
				// To find "NO" button for indexed, Upload more files?
				@FindBy(xpath = "//a[text()='YES']")
				private WebElement yesButton;
			
				public WebElement getYesButton() {
					if(WebElementWait.waitToElementClickable(driver, yesButton) != null) {
						return yesButton;
					}else 
						return null;  
			}
				
				//----Bulk Indexing Locators------------
				// -----------------------------------------Locators for -  Scenario: Indexing of Uploaded documents without Indexing (In Dmacq_v9_new, unindexed documents has not marked differently, hence selexcting few for indexing (which may be indexed or unindexed))----------------------------------------------------
				// To find checkBox to select documents for indexing
				@FindBy(xpath = "//input[@type='checkbox' and @name='id[]']")
				public List<WebElement> docsCheckboxes;
			
				// To find 'Action' droprDown
				@FindBy(xpath  = "(//button[@data-toggle='dropdown'])[1]") 
				private WebElement actionDropdown;
			
				public WebElement getActionDropdown() {
					if(WebElementWait.waitToElementClickable(driver, actionDropdown) != null) {
						return actionDropdown;
					}else 
						return null;   		
			}
				// To find 'Indexing' dropDown value
				@FindBy(id = "multiple_indexing1")
				private WebElement valueIndexing;
			
				public WebElement getValueIndexing() {
					if(WebElementWait.waitToElementClickable(driver, valueIndexing) != null) {
						return valueIndexing;
					}else 
						return null;   
			}
				// To find 'Select all' icon on  Bulk Indexing page to select All documents in list
				@FindBy(xpath = "//input[@id='selectall']")
				private WebElement selectAllDocsCheckbox;
			
				public WebElement getSelectAllDocsCheckbox() {
					if(WebElementWait.waitToElementClickable(driver, selectAllDocsCheckbox) != null) {
						return selectAllDocsCheckbox;
					}else 
						return null;   
			}
				
				
										// -----------------------------------------Locators to create new category and for category indexing i.e. Set indexes to category----------------------------------------------------
										// To find "Create-Category" icon 
										@FindBy(id   = "category_add")
										private WebElement createCategory; 
										
										public WebElement getCreateCategoryIcon() {
											if(WebElementWait.waitToElementClickable(driver, createCategory) != null) {
												return createCategory;
											}else
												return  null;                                                                    
										}
										
										// To find "New Category Name:" textBox
										@FindBy(id   = "category")
										private WebElement newCategoryName; 
										
										public WebElement getNewCatNameTextbox() {
											if(WebElementWait.waitToElementClickable(driver, newCategoryName) != null) {
												return newCategoryName;
											}else
												return  null;                                                                    
										}
										//  To find "Add" button on New Category Form page
										@FindBy(id   = "btn-create")
										private WebElement addBtn; 
										
										public WebElement getAddButton() {
											if(WebElementWait.waitToElementClickable(driver, addBtn) != null) {
												return addBtn;
											}else
												return  null;                                                                    
										}
										
										// To find 'Set Indexes to category' icon for indexing with newly  created category  
										@FindBy(xpath   = "//td[contains(text(),'Accounts')]/following-sibling::td//i[@class='icon-retweet']")
										private WebElement setIndexesToCat; 
										
										public WebElement getSetIndexesToCategory() {
											if(WebElementWait.waitToElementClickable(driver, setIndexesToCat) != null) {
												return setIndexesToCat;
											}else
												return  null;                                                                    
										}
										// To find Select Index Master(s) textBox
										@FindBy(xpath = "//input[@value='Select Index Master']")
										public WebElement selectIM;
										
										public WebElement getSelectIM() {
												if(WebElementWait.waitToElementClickable(driver, selectIM) != null) {
													return selectIM;
												}else 
													return null;   
										}
										
										// To find Select Doc Set dropDown arrow
										@FindBy(xpath = "//div[@id='doc_set_chzn']")                 
										private WebElement selectDocSetropdown;
										
										public WebElement getSelectDocSet() {
												if(WebElementWait.waitToElementClickable(driver, selectDocSetropdown) != null) {
													return selectDocSetropdown;
												}else 
													return null;   
										}
										// To find Select Doc Set dropDown textBox	
										
										@FindBy(xpath = "//div[@id='doc_set_chzn']//input")                                   
										private WebElement docSetDropdownTextbox;
										
										public WebElement getDocSetDropdownTextbox() {
												if(WebElementWait.waitToElementClickable(driver, docSetDropdownTextbox) != null) {
													return docSetDropdownTextbox;
												}else 
													return null;   
										}
										
										// To find all Doc Set DropDown Values at once
										@FindBy(xpath = " //span[@class='labelauty-unchecked']")                                     
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
								@FindBy(xpath  = "//div[@class='bootbox modal fade in']") //div[@class='bootbox modal fade in']                                   
								public List <WebElement> popupWindows;					  
								
								public List <WebElement> getPopUpwindows() {
										if(WebElementWait.waitToListElementClickable(driver, popupWindows) != null) {
											return popupWindows;
										}else 
											return null;   
								}
								
								// To find pop-up window on success of  'Set Indexes to category' 
								@FindBy(xpath  = "//div[@class='bootbox modal fade in']") //div[@class='bootbox modal fade in']                                   
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
								
								
						
		
		// To find Close button on pop-up windows
		@FindBy(xpath = "//a[text()='Close']")
		private WebElement popUpCloseButton;
						
		public WebElement getPopupCloseButton() {
			if(WebElementWait.waitToElementClickable(driver, popUpCloseButton)!=null) {
					return popUpCloseButton;
			}else
					return null;
		}
		
		// To find another pop up windows
		@FindBy(xpath = "(//div[@class='bootbox modal fade in'])[2]")
		public List<WebElement> windowPopups2;
						
		public List<WebElement> getWindowsPopups2() {
			if(WebElementWait.waitToListElementClickable(driver, windowPopups2)!=null) {
					return windowPopups2;
			}else
					return null;
		}
		// To find another pop up window  
		@FindBy(xpath = "(//div[@class='bootbox modal fade in'])[2]")
		private WebElement windowPopup2;
						
		public WebElement getWindowPopup2() {
			if(WebElementWait.waitToElementClickable(driver, windowPopup2)!=null) {
					return windowPopup2;
			}else
					return null;
		}
}
