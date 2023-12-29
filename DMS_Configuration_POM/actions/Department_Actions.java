package actions;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import dataSourceReader.ExcelFileReader;
import locators.Department_Locator;
import webCommonFunctions.WebButton;
import webCommonFunctions.WebTextBox;

public class Department_Actions {
	// Department Creation Actions
	
		WebDriver driver = null;	
		Department_Locator deptLocator = null;
		
		public Department_Actions(WebDriver driver) {
			this.driver = driver ;
			deptLocator = new Department_Locator(driver);
			
		}
		
		public void departmentCreation() throws InterruptedException {
			Thread.sleep(5000);
			WebButton.clickButton(deptLocator.getSettings());
				Reporter.log("Clicked on 'Settings' dropdown" + "<br>");
				Thread.sleep(2000);	
			WebButton.clickButton(deptLocator.getDepartment());
				Reporter.log("Clicked on 'Department' dropdown value" + "<br>");
				Thread.sleep(2000);	
				
				
			XSSFSheet sheet = ExcelFileReader.sheet;	
			
			for(int row=8; row<=17; row++) { // 7 16
				
				String departmentName = sheet.getRow(row).getCell(0).toString();
				
			WebButton.clickButton(deptLocator.getButtonCreateDepartment());
				Reporter.log("Clicked on 'Create Department button'" + "<br>");
				Thread.sleep(2000);	
			WebTextBox.sendInput(deptLocator.getTextboxDeptName(), departmentName );
				Reporter.log(" 'Department Name' enetered: " + departmentName + "<br>");
				Thread.sleep(2000);	
			WebButton.clickButton(deptLocator.getButtonCreate());
				Reporter.log("Hit the 'Create' button" + "<br>");
				Thread.sleep(4000);		
				
				if(deptLocator.popupWindow.size() != 0) {
					Reporter.log(driver.findElement(By.xpath("//div[@class='modal-body']")).getText() + "<br>");
					Thread.sleep(2000);
					if(driver.findElements(By.xpath("//a[text()='OK']")).size()>0) { 
						Thread.sleep(3000);
						driver.findElement(By.xpath("//a[text()='OK']")).click();
						Thread.sleep(2000);
					}else if(driver.findElements(By.xpath("//a[text()='Close']")).size() > 0) {
						Thread.sleep(2000);
						WebButton.clickButton(deptLocator.getCloseButton());
						Thread.sleep(4000);
					}
					
					Thread.sleep(2000);	
					WebButton.clickButton(deptLocator.getCancelButton());
				}
			} 
			
			
		}

}
