package actions;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import dataSourceReader.ExcelFileData;
import locators.GroupRights_Locator;
import locators.UserGroups_Locator;
import webCommonFunctions.*;

public class GroupRights_Action {
	
	WebDriver driver  = null;
	UserGroups_Locator userGroupLocator    = null;
	GroupRights_Locator groupRightsLocator = null;
	
	
	public GroupRights_Action(WebDriver driver) {
		this.driver = driver ;
		
		userGroupLocator   = new UserGroups_Locator(driver);
		groupRightsLocator = new GroupRights_Locator(driver);
	}
	

	
	public void create_UserGroup() throws InterruptedException {
		WebButton.clickButton(userGroupLocator.getSettings());									// To click on Settings dropDown 
			Reporter.log("Clicked on Settings dropdown" + "</br>");
		WebButton.clickButton(userGroupLocator.getUserGroupsValue());							// To Select User Groups from settings dropDown
			Reporter.log("Clicked on User Groups value in Settings dropdown" + "</br>");
			
		WebButton.clickButton(userGroupLocator.getCreateUserGroupButton()); 					// To click on Create User Group button 
			Reporter.log("Clicked on 'Create User Group' button" + "</br>"); 	
			
		WebTextBox.sendInput(userGroupLocator.getGroupName(), "Users" );  				
		WebTextBox.sendInput(userGroupLocator.getGroupAliasName(), "Users" );         			// coz: Group Alias Name has kept similar to user group name
		

	    WebTextBox.sendInput(userGroupLocator.getUgDescription(), "Application Users: Can view, add and edit their own documents. "
	    									  + "Can view documents uploaded by other users, if category access and other rights are provided." );
	    Thread.sleep(3000);
	    WebButton.clickButton(userGroupLocator.getCreateButton());								// To click on Create button
		Reporter.log("Created New User Group:  Users" + "</br>");
		
	Thread.sleep(4000);
	handlePopup();
	}
	
	
	// While Creating Group - 'Users' & User Account with UserName - 'Dmacq_User' 
    //:: All required data is HardCoded here
	public void create_UserAccount() throws InterruptedException, IOException {
		WebButton.clickButton(userGroupLocator.getSettings());	
		WebButton.clickButton(groupRightsLocator.getUserAccountValue());	
		
		WebButton.clickButton(groupRightsLocator.getbutton_NewUser());
		
		WebTextBox.sendInput(groupRightsLocator.getFirstName(), "Dmacq"); 
		WebTextBox.sendInput(groupRightsLocator.getLastName(), "DMS User"); 
		//WebButton.clickButton(groupRightsLocator.getLoginType());
		//WebTextBox.sendInput(groupRightsLocator.getLoginTypeSearchbox(), "DMS USER");
		Thread.sleep(3000);
		//WebTextBox.sendKeys(groupRightsLocator.getLoginTypeSearchbox(), Keys.ENTER);
		WebTextBox.sendInput(groupRightsLocator.getPassword(), "Ab!123456");
		WebTextBox.sendInput(groupRightsLocator.getConfPassword(), "Ab!123456");
		WebTextBox.sendInput(groupRightsLocator.getUsername(), "Dmacq_User");
		WebTextBox.sendInput(groupRightsLocator.getEmail(), "dmacquser@d.com");
		WebButton.clickButton(groupRightsLocator.getUserGroup());
		WebTextBox.sendInput(groupRightsLocator.getUgValueSearchbox(), "Users");
		WebTextBox.sendKeys(groupRightsLocator.getUgValueSearchbox(), Keys.ENTER);
		Thread.sleep(3000);
		WebButton.clickButton(groupRightsLocator.getSelectDR());
		WebTextBox.sendInput(groupRightsLocator.getSelectDR(), ExcelFileData.dealRoomName());
		Thread.sleep(2000);
		WebTextBox.sendKeys(groupRightsLocator.getSelectDR(), Keys.ENTER);
		WebButton.clickButton(groupRightsLocator.getCreatebutton());
		Thread.sleep(7000);
		if(driver.findElements(By.xpath("//div[@class='bootbox modal fade in']")).size() > 0 
				&&	driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).getText().contains("Try another")  ){
			Thread.sleep(3000);	
			if(driver.findElements(By.xpath("//a[text()='Close']")).size() > 0) {
				WebButton.clickButton(userGroupLocator.getCloseButton());	
			}else if(driver.findElements(By.xpath("//a[text()='OK']")).size() > 0) {
				Thread.sleep(2000);
				WebButton.clickButton(userGroupLocator.getOkButton());
			}
			Thread.sleep(3000);
			WebButton.clickButton(userGroupLocator.getCancelButton());
		}
	}
	
	
	public void assign_GroupRights() throws InterruptedException {
		WebButton.clickButton(userGroupLocator.getSettings());
		Thread.sleep(2000);
		WebButton.clickButton(groupRightsLocator.getGroupRights());
		Thread.sleep(2000);
			groupRightsLocator.get_AlreadySelected_userGroup().click();        					   // To clear 'Select user group for rights' field.
		Thread.sleep(2000);
		WebTextBox.sendInput(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), "Users"); // To send 'Users' group to assign rights
		Thread.sleep(4000);
		WebTextBox.sendKeys(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), Keys.ENTER);
		Thread.sleep(2000);
		
		// To assign rights till Discussion row..... Excluding Discussion rights
		for(int i=0; i<240; i++) {
			if(groupRightsLocator.checkboxes.get(i).isSelected() == false) {
			Thread.sleep(2000);
			WebButton.clickButton(groupRightsLocator.checkboxes.get(i));
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			}else {
				System.out.println(i + " is already selected");
			}
		}
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);
	}

	

	
		// To handle pop-up window if appears :-- if "Group Name already exists."	 
		public void handlePopup() throws InterruptedException {
			Thread.sleep(2000);	
			if(userGroupLocator.popupWindows.size() > 0 &&  userGroupLocator.getPopupWindow().getText().contains("Group Name already exists.")) {
				Thread.sleep(3000);	
				if(driver.findElements(By.xpath("//a[text()='Close']")).size() > 0) {
					WebButton.clickButton(userGroupLocator.getCloseButton());	
				}else if(driver.findElements(By.xpath("//a[text()='OK']")).size() > 0) {
					Thread.sleep(2000);
					WebButton.clickButton(userGroupLocator.getOkButton());
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
