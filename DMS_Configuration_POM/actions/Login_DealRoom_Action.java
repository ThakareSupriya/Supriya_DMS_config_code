package actions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dataSourceReader.ExcelFileData;
import locators.Login_DealRoom_Locator;
import webCommonFunctions.WebButton;
import webCommonFunctions.WebTextBox;

public class Login_DealRoom_Action {

		WebDriver driver = null;
		Login_DealRoom_Locator loginDealRoomLocator = null;
		
		public Login_DealRoom_Action(WebDriver driver) {
			this.driver = driver ;
			loginDealRoomLocator = new Login_DealRoom_Locator(driver);
		}
		
	//  Login page Actions
		// To enter username in login page username textbox
		public void enterUsername(String username) {
			WebTextBox.sendInput(loginDealRoomLocator.getUsername(), username);
		}
		
		// To enter password in login page password textbox
		public void enterPassword(String password) {
			WebTextBox.sendInput(loginDealRoomLocator.getPassword(), password);
		}
		
		// To click on login button
		public void clickLoginButton() {
			WebButton.clickButton(loginDealRoomLocator.getLoginButton());
		}
	
	
	
	// Condition: if there is only 1 deal room, entered directly into the default one,but if there is another deal room available, use 'DMS DATA' deal room
		public void enterIntoDealRoom() throws InterruptedException, IOException {
			Thread.sleep(5000);
			if(driver.findElements(By.xpath("//h3[text()='Workspace']")).size() >=2){
				driver.findElement(By.xpath("//a[normalize-space()='"+ExcelFileData.dealRoomName()+"']")).click();
			}
	  }	

}
/*
 * 		if(loginDealRoomLocator.popupWindowDisplayed.size()!=0) {
			if(loginDealRoomLocator.getPopupWindow().isDisplayed()) {
				if(loginDealRoomLocator.getPopupWindow().getText().contains("already exists!")) {
					Thread.sleep(2000);
					WebButton.clickButton(loginDealRoomLocator.getCloseButton());
					WebButton.clickButton(loginDealRoomLocator.getCancelButton());
					
					Thread.sleep(5000);
					driver.findElement(By.xpath("(//a[@class='icon-home'])[2]")).click();
					
					WebButton.clickButton(loginDealRoomLocator.getDealRoom());
				}
			}	
			System.out.println(" but as Deal Room already exists, so entered into same"); 
		}
 */
