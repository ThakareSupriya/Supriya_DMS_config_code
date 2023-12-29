package actions;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.*;

import dataSourceReader.ExcelFileData;
import locators.GroupRights_Locator;
import webCommonFunctions.WebButton;
import webCommonFunctions.WebTextBox;

public class ThumbRights_Action {
	
	WebDriver driver  = null;
	GroupRights_Locator groupRightsLocator = null;
	
	
	public ThumbRights_Action(WebDriver driver) {
		this.driver = driver ;
		
		groupRightsLocator = new GroupRights_Locator(driver);;
	}
	
	 
	
	// Function To assign IM Fields and IG Rights
	public void assign_IMfieldsRights_IGRights() throws InterruptedException, IOException {
		WebButton.clickButton(groupRightsLocator.getDmacq_logo());
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[@class='widget-head  blue']//following::h3[text()='Workspace']")).size() >0) {
			Thread.sleep(2000);
			WebButton.clickButton(driver.findElement(By.xpath("//a[normalize-space()='"+ExcelFileData.dealRoomName()+"']")));
		}
		WebButton.clickButton(groupRightsLocator.getDms());
		Thread.sleep(2000);
			Set<String> parent_Windows = driver.getWindowHandles();
			 Object[] s = parent_Windows.toArray();
			
		WebButton.clickButton(groupRightsLocator.getAssignRights());
		Thread.sleep(2000);
	
	Set <String> winIds = driver.getWindowHandles();
			for(String winId : winIds) {
				driver.switchTo().window(winId);
			}

				
		// To assign  IM Fields Rights	: FOR IM 1
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class='icon-list']")).click();
		Thread.sleep(2000);
		WebButton.clickButton(groupRightsLocator.get_AlreadySelected_userGroup());
		Thread.sleep(2000);
		WebTextBox.sendInput(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), "Users");
		Thread.sleep(2000);
		WebTextBox.sendKeys(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), Keys.ARROW_DOWN);
		Thread.sleep(2000);
		WebTextBox.sendKeys(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), Keys.ENTER);
		Thread.sleep(2000);
		WebButton.clickButton(groupRightsLocator.get_selectIM());
		Thread.sleep(2000);
		WebTextBox.sendInput(groupRightsLocator.get_textbox_IMSelect(), ExcelFileData.im1Name());
		Thread.sleep(2000);
		WebTextBox.sendKeys(groupRightsLocator.get_textbox_IMSelect(), Keys.ENTER);
		Thread.sleep(2000);
		WebButton.clickButton(groupRightsLocator.getvisible_Rights());
		Thread.sleep(2000);
		WebButton.clickButton(groupRightsLocator.getToSearch_Rights());
		Thread.sleep(2000);  
		
		// To assign  IG  Rights: FOR IG 1
		WebButton.clickButton(groupRightsLocator.getIG_Rights());
		Thread.sleep(2000);
		WebButton.clickButton(groupRightsLocator.get_AlreadySelected_userGroup());
		Thread.sleep(2000);
		WebTextBox.sendInput(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), "Users");
		Thread.sleep(2000);
		WebTextBox.sendKeys(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), Keys.ARROW_DOWN);
		Thread.sleep(2000);
		WebTextBox.sendKeys(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), Keys.ENTER);
		Thread.sleep(2000);
		WebButton.clickButton(groupRightsLocator.get_selectIG());
		Thread.sleep(2000);
		WebTextBox.sendInput(groupRightsLocator.get_textbox_IGSelect(), ExcelFileData.ig1Name());
		Thread.sleep(2000);
		WebTextBox.sendKeys(groupRightsLocator.get_textbox_IGSelect(), Keys.ENTER);
		Thread.sleep(2000);
		WebButton.clickButton(groupRightsLocator.getvisible_Rights());
		Thread.sleep(2000);
		WebButton.clickButton(groupRightsLocator.getToSearch_Rights());
		Thread.sleep(2000);

				//  To assign  IM Fields Rights	: FOR IM 2
				driver.findElement(By.xpath("//i[@class='icon-list']")).click();
				Thread.sleep(2000);
				WebButton.clickButton(groupRightsLocator.get_AlreadySelected_userGroup());
				Thread.sleep(2000);
				WebTextBox.sendInput(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), "Users");
				Thread.sleep(2000);
				WebTextBox.sendKeys(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), Keys.ARROW_DOWN);
				Thread.sleep(2000);
				WebTextBox.sendKeys(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), Keys.ENTER);
				Thread.sleep(2000);
				WebButton.clickButton(groupRightsLocator.get_selectIM());
				Thread.sleep(2000);
				WebTextBox.sendInput(groupRightsLocator.get_textbox_IMSelect(), ExcelFileData.im2Name());
				Thread.sleep(2000);
				WebTextBox.sendKeys(groupRightsLocator.get_textbox_IMSelect(), Keys.ENTER);
				Thread.sleep(2000);
				WebButton.clickButton(groupRightsLocator.getvisible_Rights());
				Thread.sleep(2000);
				WebButton.clickButton(groupRightsLocator.getToSearch_Rights());
				Thread.sleep(2000);
				
				// To assign  IG  Rights: FOR IG 2
				WebButton.clickButton(groupRightsLocator.getIG_Rights());
				Thread.sleep(2000);
				WebButton.clickButton(groupRightsLocator.get_AlreadySelected_userGroup());
				Thread.sleep(2000);
				WebTextBox.sendInput(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), "Users");
				Thread.sleep(2000);
				WebTextBox.sendKeys(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), Keys.ARROW_DOWN);
				Thread.sleep(2000);
				WebTextBox.sendKeys(groupRightsLocator.getTextbox_Select_userGroup_ForRights(), Keys.ENTER);
				Thread.sleep(2000);
				WebButton.clickButton(groupRightsLocator.get_selectIG());
				Thread.sleep(2000);
				WebTextBox.sendInput(groupRightsLocator.get_textbox_IGSelect(), ExcelFileData.ig2Name());
				Thread.sleep(2000);
				WebTextBox.sendKeys(groupRightsLocator.get_textbox_IGSelect(), Keys.ENTER);
				Thread.sleep(2000);
				WebButton.clickButton(groupRightsLocator.getvisible_Rights());
				Thread.sleep(2000);
				WebButton.clickButton(groupRightsLocator.getToSearch_Rights());
				Thread.sleep(2000);	
			//	break;
				}             
		//	}	                
			
	//}
	
	
	// Function To assign IM rights and Category Rights
	public void assign_IM_Rights() throws InterruptedException {
		Thread.sleep(3000);
		WebButton.clickButton(groupRightsLocator.getIM_Rights_Tab());
		Thread.sleep(12000);
			for(int i=16; i<groupRightsLocator.IM_Rights_Checkboxes.size(); i++) { 
			try {
				if(groupRightsLocator.IM_Rights_Checkboxes.get(i).isSelected() == false) {
				WebButton.clickButton(groupRightsLocator.IM_Rights_Checkboxes.get(i));
				Thread.sleep(5000);
				}
			}catch (Exception e) {
				System.out.println(e);
			}
			}
	}
	
	
	// Function To Assign Category Rights
	public void assign_Category_Rights() throws InterruptedException {
		Thread.sleep(3000);
		WebButton.clickButton(groupRightsLocator.getCategory_Rights_Tab());
		Thread.sleep(3000);
		for( WebElement Access_Purge_Checkbox : groupRightsLocator.categoryRights_Checkboxes) {
			 if(Access_Purge_Checkbox.isSelected() == false) {
				 WebButton.clickButton(Access_Purge_Checkbox);
				 Thread.sleep(4000);
			 }
		}
		
	}
	
}
