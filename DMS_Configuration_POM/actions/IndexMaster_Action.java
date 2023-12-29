package actions;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.*;
import org.testng.Reporter;

import dataSourceReader.ExcelFileData;
import dataSourceReader.ExcelFileReader;
import locators.IndexMaster_Locator;
import webCommonFunctions.WebButton;
import webCommonFunctions.WebTextBox;

public class IndexMaster_Action {
	 // Index Master Actions
	
	WebDriver driver = null;
	IndexMaster_Locator imLocator = null;
	
	ExcelFileReader excelRead;  
	

	public IndexMaster_Action(WebDriver driver) throws IOException {
		this.driver = driver;
		imLocator = new IndexMaster_Locator(driver);
	//	dynamicLocators = new Dynamic_Locators(driver);
		
		excelRead = new ExcelFileReader(); 
	
	}
	
		
	// To navigate to IM
		public void imNavigate() throws InterruptedException {
			Thread.sleep(2000);
			WebButton.clickButton(imLocator.navigateToIm());  	
		}
		
		// TO create a new IM - IM 1
		public void creatingIndexMaster1() throws IOException {
			WebButton.clickButton(imLocator.getNewIM());    	  								    // To click on New Index Master button
				Reporter.log("Clicked on New Index Master button" + "<br>");
			WebTextBox.sendInput(imLocator.getIMName(), ExcelFileData.im1Name());  					// To enter IM name in Index Master TextBox
				Reporter.log("Entered new Index Master Name: "+ ExcelFileData.im1Name()+"<br>");
			WebTextBox.sendInput(imLocator.getIMDescription(), ExcelFileData.im1Description());		// To enter IM Description
				Reporter.log("Index Master Description Entered" + "<br>");
			WebButton.clickButton(imLocator.getCreateButton());    								    // To hit on Create button
				Reporter.log("Hit the 'Create' button and created new Index Master" + "<br>");				
		}
		
		
		
		// TO create Index Master-1 Fields
		public void creatingIM1fields() throws InterruptedException, IOException {
			//WebButton.clickButton(imLocator.getIM1Fields());  					 		// To click on fields icon for specific Index Master
				WebButton.clickButton(driver.findElement(By.xpath("//td[contains(text(),'"
								+ExcelFileData.im1Name()+"')]//following-sibling::td[3]//i[@class='icon-building']")));
				Reporter.log("Clicked on 'Fields' icon of " + ExcelFileData.im1Name() + " Master"+ "<br>");
				
			XSSFSheet sheet = ExcelFileReader.sheet;
			
			for(int row=45; row<=48; row++) { // 44 47
				Thread.sleep(2000);
				if(driver.findElements(By.linkText("Fields")).size() >0) {
					driver.findElement(By.linkText("Fields")).click();
				}
				Thread.sleep(2000);
				WebButton.clickButton(imLocator.getIMaddField()); 						// To click 'Add Field' button on Fields dashBoard - To add single field
					Reporter.log("Clicked on 'Add Field' button on Fields dashboard - To add single field" + "<br>");
				
				String fieldName = sheet.getRow(row).getCell(1).toString();
				String fieldType = sheet.getRow(row).getCell(0).toString();
				
				WebTextBox.sendInput(imLocator.getFieldName(),fieldName ); 				// To enter 'Field Name' TextBox in  New Index Field page
					Reporter.log("Field Name entered: " + fieldName + "<br>");
				
				WebButton.clickButton(imLocator.getChooseFieldType()); 					// To click 'field type' on  New Index Field page 
					WebTextBox.sendInput(imLocator.getFieldTypeTextbox(), fieldType);
					imLocator.getFieldTypeTextbox().sendKeys(Keys.ARROW_DOWN); 
					imLocator.getFieldTypeTextbox().sendKeys(Keys.ENTER); 
						Reporter.log("Selected the Field Type: " + fieldType + "<br>");
					Thread.sleep(2000);
	
				WebButton.clickButton(imLocator.getCreate());            				// To hit Create button on  New Index Field page
				
				Thread.sleep(2000);
					if(driver.findElements(By.xpath("//div[@class='modal-body']")).size()!=0) {
						System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']")).getText() + fieldName);
						Reporter.log(driver.findElement(By.xpath("//div[@class='modal-body']")).getText() + fieldName + "</br>");
						Thread.sleep(3000);	
						
						if(driver.findElement(By.xpath("//div[@class='modal-body']")).getText().contains("Successfully")) {
							Thread.sleep(2000);	
							driver.navigate().refresh();
							//JavascriptExecutor js = (JavascriptExecutor)driver;
							//js.executeScript("location.reload()");
							Thread.sleep(4000);
							
							driver.findElement(By.xpath("//button[text()='Cancel']")).click();
							Thread.sleep(2000);
						}
							
							
					}
					Thread.sleep(2000);
					if(driver.findElements(By.xpath("//a[text()='OK']")).size()>0) { 
						Thread.sleep(3000);
						driver.findElement(By.xpath("//a[text()='OK']")).click();
						Thread.sleep(2000);
					}else if(driver.findElements(By.xpath("//button[text()='Cancel']")).size() > 0) {
						WebButton.clickButton(imLocator.getCancelButton());
						Thread.sleep(4000);
					}
					
					
					
			 }
					 
		} 
 
		 
				
			// If Same index master already exists....... close the pop-up window and hit 'Cancel button on ' New Index Master' window
			public void popUpHandle() throws InterruptedException {
				Thread.sleep(5000);
				if(driver.findElements(By.xpath("//div[@class='bootbox modal fade in']")).size() > 0) {  // imLocator.getPopUpWindow().isDisplayed() && imLocator.getPopUpWindow().getText().contains("already exists")
					System.out.println(imLocator.getPopUpWindow().getText());
						Reporter.log(imLocator.getPopUpWindow().getText() + "<br>");
					if(driver.findElements(By.xpath("//a[text()='Close']")).size()>0) {
						Thread.sleep(2000);
						WebButton.clickButton(imLocator.getCloseButton());
					}else if(driver.findElements(By.xpath("//a[text()='OK']")).size()>0){
						Thread.sleep(2000);
						WebButton.clickButton(driver.findElement(By.xpath("//a[text()='OK']")));
						Thread.sleep(2000);
					}
								
				}
				Thread.sleep(4000);
				if(driver.findElements(By.xpath("//button[text()='Cancel']")).size()>0) {
					WebButton.clickButton(imLocator.getCancelButton());	
					Thread.sleep(2000);
				}
				
				
			}    
		
			
		// TO create a new IM - IM 2
		public void creatingIndexMaster2() throws IOException, InterruptedException {
			//WebButton.clickButton(imLocator.getIm());  			  								// To click on Index Master icon
			Thread.sleep(2000);
			WebButton.clickButton(imLocator.getNewIM());    	  								    // To click on New Index Master button
				Reporter.log("Clicked on New Index Master button" + "<br>");
			WebTextBox.sendInput(imLocator.getIMName(), ExcelFileData.im2Name());  					// To enter IM name in Index Master TextBox
				Reporter.log("Entered new Index Master Name: "+ ExcelFileData.im2Name()+"<br>");
			WebTextBox.sendInput(imLocator.getIMDescription(), ExcelFileData.im2Description());		// To enter IM Description
				Reporter.log("Index Master Description Entered" + "<br>");
			WebButton.clickButton(imLocator.getCreateButton());    								    // To hit on Create button
				Reporter.log("Hit the 'Create' button and created new Index Master" + "<br>");				
		}		

		
		// TO create Index Master-2 Fields
		public void creatingIM2fields() throws InterruptedException, IOException {
			
			WebButton.clickButton(driver.findElement(By.xpath("//td[contains(text(),'"
					+ExcelFileData.im2Name()+"')]//following-sibling::td[3]//i[@class='icon-building']")));
				Reporter.log("Clicked on 'Fields' icon of " + ExcelFileData.im2Name() + " Master"+ "<br>");
	
			XSSFSheet sheet = ExcelFileReader.sheet;
			
			for(int row=45; row<=48; row++) { // 44  47
				Thread.sleep(2000);
				if(driver.findElements(By.linkText("Fields")).size() >0) {
					driver.findElement(By.linkText("Fields")).click();
				}
				Thread.sleep(2000);
				WebButton.clickButton(imLocator.getIMaddField()); 						// To click 'Add Field' button on Fields dashBoard - To add single field
					Reporter.log("Clicked on 'Add Field' button on Fields dashboard - To add single field" + "<br>");
				
				String fieldType = sheet.getRow(row).getCell(3).toString();
				String fieldName = sheet.getRow(row).getCell(4).toString();
				
				WebTextBox.sendInput(imLocator.getFieldName(),fieldName ); 				// To enter 'Field Name' TextBox in  New Index Field page
					Reporter.log("Field Name entered: " + fieldName + "<br>");
				
				WebButton.clickButton(imLocator.getChooseFieldType()); 					// To click 'field type' on  New Index Field page 
					WebTextBox.sendInput(imLocator.getFieldTypeTextbox(), fieldType);
					imLocator.getFieldTypeTextbox().sendKeys(Keys.ARROW_DOWN); 
					imLocator.getFieldTypeTextbox().sendKeys(Keys.ENTER); 
						Reporter.log("Selected the Field Type: " + fieldType + "<br>");
					Thread.sleep(2000);
						
							// To click on 'Add Value' button and to enter value name in TextBox : in Field Values
							if(driver.findElement(By.xpath("//input[@id='colorval[]']")).isDisplayed()) {  	//-:- Usable only when field type is Select Menu -:-
								Thread.sleep(2000);
								WebTextBox.sendInput(imLocator.getSelectFieldValue1(),ExcelFileData.dropValue1());
								Thread.sleep(1000);
								WebButton.clickButton(imLocator.getSubAddValue());
								Thread.sleep(1000);
								WebTextBox.sendInput(imLocator.getSelectFieldValue2(), ExcelFileData.dropValue2());
								Reporter.log(" Field Values Added as a consequence, Field Type is 'Select Menu' " + "<br>");
							}
					
				Thread.sleep(2000);
				WebButton.clickButton(imLocator.getCreate());            				// To hit Create button on  New Index Field page
				
				Thread.sleep(2000);
					if(driver.findElements(By.xpath("//div[@class='modal-body']")).size()!=0) {
						System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']")).getText() + fieldName);
						Reporter.log(driver.findElement(By.xpath("//div[@class='modal-body']")).getText() + fieldName + "</br>");
						Thread.sleep(3000);	
							
							JavascriptExecutor js = (JavascriptExecutor)driver;
							js.executeScript("location.reload()");
							Thread.sleep(4000);

							//WebButton.clickButton(imLocator.getCancelButton());
							//Thread.sleep(2000);
					}
					Thread.sleep(2000);
					if(driver.findElements(By.xpath("//a[text()='OK']")).size()>0) { 
						Thread.sleep(3000);
						driver.findElement(By.xpath("//a[text()='OK']")).click();
						Thread.sleep(2000);
					}else if(driver.findElements(By.xpath("//button[text()='Cancel']")).size() > 0) {
						WebButton.clickButton(imLocator.getCancelButton());
						Thread.sleep(4000);
					}
					
				
			}
					
		} 
				
				
		
	/*	// Master Reports Actions
		public void masterReports() throws InterruptedException, IOException {
			Thread.sleep(8000); 
		//	WebButton.clickButton(imLocator.getLinkDMS());     
		//	Thread.sleep(2000);
		//	WebButton.clickButton(imLocator.getIconIM());      		// : opens in new tab, switch to newly opened tab
		//	Thread.sleep(2000);
		//		Set<String> handles = driver.getWindowHandles();
		//		for(String handle:handles) {
		//			driver.switchTo().window(handle); 
		//		Thread.sleep(2000);
		//		}
			WebButton.clickButton(driver.findElement(By.xpath("//td[contains(text(),'"
									+ExcelFileData.im1Name()+"')]/following-sibling::td//i[@class='icon-tasks']")));
			Thread.sleep(2000);
			
				XSSFSheet sheet = ExcelFileReader.sheet;
			
			for(int row=54; row<=59; row++) { // 93  97
				
				String reportName = sheet.getRow(row).getCell(0).toString();
				String reportType = sheet.getRow(row).getCell(1).toString();
				 
			WebButton.clickButton(imLocator.getButtonNewReport());
			Thread.sleep(2000);
			WebTextBox.sendInput(imLocator.getIMreportName(), reportName);        // ------------ 
			Thread.sleep(2000);
			WebButton.clickButton(imLocator.getReportType());
			Thread.sleep(2000);
			WebTextBox.sendInput(imLocator.getReportTypeSearchbox(), reportType); // ------------
			Thread.sleep(1000);
			WebTextBox.sendKeys(imLocator.getReportTypeSearchbox(), Keys.ENTER);
			Thread.sleep(2000);
			for(WebElement indexMasterField : imLocator.indexMasterFields) {
				WebButton.clickButton(indexMasterField);
				Thread.sleep(2000);
			} 
			WebButton.clickButton(imLocator.getPeriodDropdown()); 
			Thread.sleep(3000); 
			WebTextBox.sendInput(imLocator.getPeriodSearchbox(), ExcelFileData.masterReportSpan());      
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			//action.sendKeys(Keys.ENTER).perform();
			//WebTextBox.sendKeys(imLocator.getPeriodSearchbox(), Keys.ENTER); // neww
			Thread.sleep(3000);
				action.sendKeys(Keys.ALT).perform(); // new 
				Thread.sleep(2000);
			//WebButton.clickButton(imLocator.getReportPeriodInNumber());
			imLocator.getReportPeriodInNumber().click();
			Thread.sleep(2000);
			WebTextBox.sendInput(imLocator.getNumberOfMonthsSearchbox(), ExcelFileData.masterReportPeriod());  
			Thread.sleep(2000);
			//WebTextBox.sendKeys(imLocator.getNumberOfMonthsSearchbox(), Keys.ENTER); // neww
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			action.sendKeys(Keys.ALT).perform(); // new 
			
			Thread.sleep(4000);
				
				if(driver.findElements(By.xpath("//span[text()='Choose...']")).size() >0){
					Thread.sleep(2000);
					WebButton.clickButton(driver.findElement(By.xpath("//span[text()='Choose...']")));
					Thread.sleep(2000);
					WebTextBox.sendKeys(driver.findElement(By.xpath("(//div[@class='chzn-search']//input)[8]")), Keys.ENTER);
					
					Thread.sleep(2000);
					WebButton.clickButton(driver.findElement(By.xpath("//input[@value='Choose a  category']")));
					Thread.sleep(2000);
					WebTextBox.sendKeys(driver.findElement(By.xpath("//input[@value='Choose a  category']")), Keys.ENTER);
					
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@id='chk_field_2']")).click();
				}
			Thread.sleep(2000);
			WebButton.clickButton(imLocator.getAddButton());  	// Add button
			Thread.sleep(5000);
			
				Reporter.log(reportType + " : Generated" + "<br>");  
				 
		}  
			 
	}*/
		
}
