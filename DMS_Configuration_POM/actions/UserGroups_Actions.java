package actions;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.*;
import org.testng.Reporter;

import dataSourceReader.ExcelFileReader;
import locators.UserGroups_Locator;
import webCommonFunctions.WebButton;
import webCommonFunctions.WebTextBox;

public class UserGroups_Actions {
	// User Group Creation Actions
	
		WebDriver driver = null;
		UserGroups_Locator userGroupLocator = null; 
		
		static String filePath ; 
		public static XSSFSheet sheet ;
		
		
			public UserGroups_Actions(WebDriver driver) throws IOException {
				this.driver = driver;
				userGroupLocator = new UserGroups_Locator(driver);
				
				filePath = ExcelFileReader.filePath;
				sheet    = ExcelFileReader.sheet;
			}
		
			
			public void creatingUSerGroups() throws InterruptedException {
				WebButton.clickButton(userGroupLocator.getSettings());									// To click on Settings dropDown 
					Reporter.log("Clicked on Settings dropdown" + "<br>");
				WebButton.clickButton(userGroupLocator.getUserGroupsValue());							// To Select User Groups from settings dropDown
					Reporter.log("Clicked on User Groups value in Settings dropdown" + "<br>");
				
					
				for(int row=20; row<=29; row++ ) {	// 19 28
					WebButton.clickButton(userGroupLocator.getCreateUserGroupButton()); 			   // To click on Create User Group button 
					Reporter.log("Clicked on 'Create User Group' button" + "<br>"); 	
					
					String userGroupName    = sheet.getRow(row).getCell(0).toString();
					String groupDescription = sheet.getRow(row).getCell(1).toString();
					
					WebTextBox.sendInput(userGroupLocator.getGroupName(), userGroupName ); 
				    WebTextBox.sendInput(userGroupLocator.getGroupAliasName(), userGroupName );         // coz: Group Alias Name has kept similar to user group name
				    
				    WebButton.clickButton(userGroupLocator.getCopyRightsDropdown());                    // To click on 	'Choose user group' dropDown to copy the rights
				    WebTextBox.sendInput(userGroupLocator.getCopyRightsTextbox(), "Users"); 
				    WebTextBox.sendKeys(userGroupLocator.getCopyRightsTextbox(), Keys.ENTER);
				    
				    WebTextBox.sendInput(userGroupLocator.getUgDescription(), groupDescription );
				    WebButton.clickButton(userGroupLocator.getCreateButton());						    // To click on Create button
					Reporter.log("New User Group:  " + userGroupName + " created" + "<br>");
					
				handlePopup();
				
				}
					
			}
			
			
	/*		
			public void userGroup1Creation() throws InterruptedException, IOException {
				WebButton.clickButton(ugLocator.getSettings());													// To click on Settings dropDown 
					Reporter.log("Clicked on Settings dropdown" + "<br>");
				WebButton.clickButton(ugLocator.getUgValue());													// To Select User Groups from settings dropDown
					Reporter.log("Clicked on User Group value in Settings dropdown" + "<br>");
				WebButton.clickButton(ugLocator.getCreateUgButton()); 											// To click on Create User Group button 
					Reporter.log("Clicked on Create User Group button" + "<br>"); 
				WebTextBox.sendInput(ugLocator.getGroupName(), ExcelFileData.userGroup1Name());     			// To Enter name in Group Name TextBox
					Reporter.log("Entered User group name: " + ExcelFileData.userGroup1Name() + "<br>");
				WebTextBox.sendInput(ugLocator.getGroupAliasName(),ExcelFileData.group1AliasName());   			// To enter Group Alias Name
					Reporter.log("Entered User Group Alias name: " + ExcelFileData.group1AliasName() + "<br>");
				WebTextBox.sendInput(ugLocator.getUgDescription(), ExcelFileData.userGroup1Description());		// To enter Description in Description TextBox 
					Reporter.log("Entered User group description: " + ExcelFileData.userGroup1Description()  + "<br>");
					Thread.sleep(2000);
				WebButton.clickButton(ugLocator.getCreateButton());												// To click on Create button
					Reporter.log("New User Group " + ExcelFileData.userGroup1Name() + " created" + "<br>");
			}
			
			
			
			public void userGroup2Creation() throws InterruptedException, IOException {
			//	WebButton.clickButton(ugLocator.getSettings());													// To click on Settings dropDown 
			//		Reporter.log("Clicked on Settings dropdown" + "<br>");
			//	WebButton.clickButton(ugLocator.getUgValue());													// To Select User Groups from settings dropDown
			//		Reporter.log("Clicked on User Group value in Settings dropdown" + "<br>");
				WebButton.clickButton(ugLocator.getCreateUgButton()); 											// To click on Create User Group button 
					Reporter.log("Clicked on Create User Group button" + "<br>"); 
				WebTextBox.sendInput(ugLocator.getGroupName(), ExcelFileData.userGroup2Name());     			// To Enter name in Group Name TextBox
					Reporter.log("Entered User group name: " + ExcelFileData.userGroup2Name() + "<br>");
				WebTextBox.sendInput(ugLocator.getGroupAliasName(),ExcelFileData.group2AliasName());   			// To enter Group Alias Name
					Reporter.log("Entered User Group Alias name: " + ExcelFileData.group2AliasName() + "<br>");
				WebTextBox.sendInput(ugLocator.getUgDescription(), ExcelFileData.userGroup2Description());		// To enter Description in Description TextBox 
					Reporter.log("Entered User group description: " + ExcelFileData.userGroup2Description()  + "<br>");
					Thread.sleep(2000);
				WebButton.clickButton(ugLocator.getCreateButton());												// To click on Create button
					Reporter.log("New User Group " + ExcelFileData.userGroup2Name() + " created" + "<br>");
			}
	*/		

				
		// To handle pop-up window if appears :-- if "Group Name already exists."	 
			public void handlePopup() throws InterruptedException {
				Thread.sleep(2000);	
				if(userGroupLocator.popupWindows.size() > 0 &&  userGroupLocator.getPopupWindow().getText().contains("Group Name already exists.")) {
					
					Thread.sleep(2000);
					if(driver.findElements(By.xpath("//a[text()='OK']")).size()>0) { 
						Thread.sleep(3000);
						driver.findElement(By.xpath("//a[text()='OK']")).click();
						Thread.sleep(2000);
					}else if(driver.findElements(By.xpath("//a[text()='Close']")).size() > 0) {
						Thread.sleep(2000);
						WebButton.clickButton(userGroupLocator.getCloseButton());
						Thread.sleep(4000);
					}
					WebButton.clickButton(userGroupLocator.getCancelButton());
							System.out.println("User Group Name already exists. ");
									Reporter.log("User Group Name already exists. " + "<br>");
				}else {
						System.out.println("New User Group Created. ");
								Reporter.log("New User-Group Created. " + "<br>");
				}
			}
}
