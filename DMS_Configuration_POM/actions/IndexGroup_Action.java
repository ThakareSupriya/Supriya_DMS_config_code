package actions;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.testng.Reporter;

import dataSourceReader.ExcelFileData;
import dataSourceReader.ExcelFileReader;
import locators.IndexGroup_Locator;
import webCommonFunctions.WebButton;
import webCommonFunctions.WebTextBox;

public class IndexGroup_Action {
	// Index Group Actions
	

		WebDriver driver = null;
		IndexGroup_Locator igLocator = null;
	
		ExcelFileReader excelRead; 
	
		public IndexGroup_Action(WebDriver driver) throws IOException {
			this.driver = driver;
			  igLocator = new IndexGroup_Locator(driver);
			
			  excelRead = new ExcelFileReader();
		}
	
		public void clickDealRoom() { 
			WebButton.clickButton(igLocator.getDr());
		}
		
		
		public void indexGroup1Creation() throws IOException, InterruptedException {         // To click 'Index Group Name' DropDown value and to enter Index group name in searchbox 
			WebButton.clickButton(igLocator.getIG());						             	 // To click on Index Group icon
				Reporter.log("Entered into Index Group " + "<br>");
			WebButton.clickButton(igLocator.getNewIGbutton());                               // To click 'New Index Group' button
				Reporter.log("Clicked on 'New Index Group' button to create new index group " + "<br>");
			
			Thread.sleep(3000);
			WebButton.clickButton(igLocator.getIGnameDropdown());
			WebTextBox.sendInput(igLocator.getIGnameSearchbox(), "OTHER" );
			igLocator.getIGnameSearchbox().sendKeys(Keys.ENTER);
			WebTextBox.sendInput(igLocator.getIGother(), ExcelFileData.ig1Name());
			igLocator.getIGother().sendKeys(Keys.ENTER); 
			
			// If same IG name is already exists : handle pop-up window 
			try {
				Thread.sleep(3000);
				if(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).isDisplayed()) {
						System.out.println(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).getText());
						Reporter.log(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).getText()+ "<br>");
						
				//	WebButton.clickButton(driver.findElement(By.xpath("//a[@class='btn btn-success']")));
						Thread.sleep(2000);
						if(driver.findElements(By.xpath("//a[text()='OK']")).size()>0) { 
							Thread.sleep(3000);
							driver.findElement(By.xpath("//a[text()='OK']")).click();
							Thread.sleep(2000);
						}else if(driver.findElements(By.xpath("//button[text()='Cancel']")).size() > 0) {
							Thread.sleep(2000);
							WebButton.clickButton(driver.findElement(By.xpath("//button[text()='Cancel']")));
							Thread.sleep(4000);
						}
						
						
					WebButton.clickButton(driver.findElement(By.xpath("//button[@class='btn btn-cancel']")));
				}
			} catch (Exception e) {
				// TODO: handle exception  : when we create New IG, which not already exists, it throws an exception, hence handleled that here
					System.out.println("Created New Index Group: " +  ExcelFileData.ig1Name());
							Reporter.log("Created New Index Group: " +  ExcelFileData.ig1Name() + "<br>");
			}
			Thread.sleep(4000);
		}
	
	
		
				// To click 'add fields' icon for '1st Index group in sheet' Index Group
				public void addIG1Fields() throws IOException, InterruptedException { 
					Thread.sleep(2000);
					WebButton.clickButton(driver.findElement(By.xpath("//td[contains(text(),'"+ExcelFileData.ig1Name()+"')]//following-sibling::td[2]//i[@class='icon-building']")));  // igLocator.getIG1Fields()
					Thread.sleep(2000);
					
					XSSFSheet sheet = ExcelFileReader.sheet;
					
					for(int row=58; row<=59; row++) { // 59  63  // 69  70  // 57 58
					WebButton.clickButton(igLocator.getAddFieldButton());
					Thread.sleep(2000);
					
					String fieldName ;
					String fieldType ;
					
					XSSFRow r = sheet.getRow(row);
					XSSFCell cell = r.getCell(0);
					
					if(r==null || cell==null) {  
						Thread.sleep(2000);
						driver.findElement(By.xpath("//button[text()='Cancel']")).click();
						continue;
					}else {
						 fieldName = sheet.getRow(row).getCell(1).toString();
						 fieldType = sheet.getRow(row).getCell(0).toString();
					}
					
					WebButton.clickButton(igLocator.getIGFieldTypeDropdown());
					WebTextBox.sendInput(igLocator.getIGFieldTypeTextbox(), fieldType);
					igLocator.getIGFieldTypeTextbox().sendKeys(Keys.ENTER);
					WebTextBox.sendInput(igLocator.getIGFieldName(), fieldName);
								
									Thread.sleep(2000);		
									// -:- Usable only for field type is Multi-Select  -:-
									String ftype = igLocator.getIGFieldType().getText();                                                                                         // -:- Usable only for field type is DropDown/Multi Select  -:-
									System.out.println(fieldType);
									if(ftype.equals("DropDown")) {
										WebButton.clickButton(igLocator.getIgAddFieldsButton());
										
										WebTextBox.sendInput(igLocator.getIgigValueTextbox1(), ExcelFileData.field_1());                                   // -:- Usable only for field type is DropDown  -:-
										Thread.sleep(1000);
										WebTextBox.sendInput(igLocator.getIgigValueTextbox2(), ExcelFileData.field_2());									 // -:- Usable only for field type is DropDown  -:-
							
									}//else if (fieldType.equals("Multi Select")) {
									//	WebButton.clickButton(igLocator.getIgAddFieldsButton());
									//	WebTextBox.sendInput(igLocator.getIgigValueTextbox1(), ExcelFileData.multiSelectField1Ig2()); 
									//	Thread.sleep(1000);
									//	WebTextBox.sendInput(igLocator.getIgigValueTextbox2(), ExcelFileData.multiSelectField1Ig2());
									// }    
						
					Thread.sleep(3000);				
					igLocator.getIGFieldName().sendKeys(Keys.ENTER);
					
					try {
						Thread.sleep(3000);
						if(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).isDisplayed()){
							//WebButton.clickButton(driver.findElement(By.xpath("//a[@class='btn btn-success']")));
							Thread.sleep(2000);
							if(driver.findElements(By.xpath("//a[text()='OK']")).size()>0) { 
								Thread.sleep(3000);
								driver.findElement(By.xpath("//a[text()='OK']")).click();
								Thread.sleep(2000);
							}else if(driver.findElements(By.xpath("//button[text()='Cancel']")).size() > 0) {
								Thread.sleep(2000);
								WebButton.clickButton(driver.findElement(By.xpath("//button[text()='Cancel']")));
								Thread.sleep(4000);
							}
							
							Reporter.log("Same index Field already exists....!!"+ "<br>");
							WebButton.clickButton(driver.findElement(By.xpath("//button[@class='btn btn-history']")));
						}
					} catch (Exception e) {
						System.out.println("New Index Group Field Created" + fieldName);
							Reporter.log("New Group Fields Created"+ fieldName +  "<br>");
						// TODO: handle exception : when we create new field, which not already exists, it throws an exception, hence handled that here
					}
				  }
				}
 
				
		public void indexGroup2Creation() throws IOException, InterruptedException {         // To click 'Index Group Name' DropDown value and to enter Index group name in searchbox 
		//	WebButton.clickButton(igLocator.getIG());						             	 // To click on Index Group icon
		//		Reporter.log("Entered into Index Group " + "<br>");
			WebButton.clickButton(igLocator.getNewIGbutton());                               // To click 'New Index Group' button
				Reporter.log("Clicked on 'New Index Group' button to create new index group " + "<br>");
			
			Thread.sleep(3000);
			WebButton.clickButton(igLocator.getIGnameDropdown());
			WebTextBox.sendInput(igLocator.getIGnameSearchbox(), "OTHER" );
			igLocator.getIGnameSearchbox().sendKeys(Keys.ENTER);
			WebTextBox.sendInput(igLocator.getIGother(), ExcelFileData.ig2Name());
			igLocator.getIGother().sendKeys(Keys.ENTER); 
			
			// If same IG name is already exists : handle pop-up window
			try {
				Thread.sleep(3000);
				if(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).isDisplayed()) {
						System.out.println(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).getText());
						Reporter.log(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).getText()+ "<br>");
						
					//WebButton.clickButton(driver.findElement(By.xpath("//a[@class='btn btn-success']")));
						Thread.sleep(2000);
						if(driver.findElements(By.xpath("//a[text()='OK']")).size()>0) { 
							Thread.sleep(3000);
							driver.findElement(By.xpath("//a[text()='OK']")).click();
							Thread.sleep(2000);
						}else if(driver.findElements(By.xpath("//button[text()='Cancel']")).size() > 0) {
							Thread.sleep(2000);
							WebButton.clickButton(driver.findElement(By.xpath("//button[text()='Cancel']")));
							Thread.sleep(4000);
						}
						
					
					WebButton.clickButton(driver.findElement(By.xpath("//button[@class='btn btn-cancel']")));
				}
			} catch (Exception e) {
				// TODO: handle exception  : when we create New IG, which not already exists, it throws an exception, hence handleled that here
					System.out.println("Created New  Index Group: " + ExcelFileData.ig2Name());
							Reporter.log("Created New  Index Group: " + ExcelFileData.ig2Name() + "<br>");
			}
			Thread.sleep(4000);
		}		
				
				
				
				// To click 'add fields' icon for 'Second index group in sheet' Index Group
				public void addIG2Fields() throws IOException, InterruptedException { 
					Thread.sleep(2000);
					WebButton.clickButton(driver.findElement(By.xpath("//td[contains(text(),'"+ExcelFileData.ig2Name()+"')]//following-sibling::td[2]//i[@class='icon-building']")));  // igLocator.getIG2Fields()
					Thread.sleep(2000);
					
					XSSFSheet sheet = excelRead.sheet;
					
					for(int row=58; row<=59; row++) {  // 59  62  // 69 70  // 57 58
					WebButton.clickButton(igLocator.getAddFieldButton());
					Thread.sleep(2000);
					
					String fieldName ;
					String fieldType ;
					
					XSSFRow r = sheet.getRow(row);
					XSSFCell cell = r.getCell(0);
					
					if(r==null || cell==null) {  
						Thread.sleep(2000);
						driver.findElement(By.xpath("//button[text()='Cancel']")).click();
						continue;
					}else {
						 fieldType = sheet.getRow(row).getCell(3).toString();  // 4
						 fieldName = sheet.getRow(row).getCell(4).toString();  // 5
					}
					
					WebButton.clickButton(igLocator.getIGFieldTypeDropdown());
					WebTextBox.sendInput(igLocator.getIGFieldTypeTextbox(), fieldType);
					igLocator.getIGFieldTypeTextbox().sendKeys(Keys.ENTER);
					WebTextBox.sendInput(igLocator.getIGFieldName(), fieldName);
								
									Thread.sleep(2000);		
									// -:- Usable only for field type is Multi-Select / DrodpDown  -:-
									String ftype = igLocator.getIGFieldType().getText();                                                                   
									System.out.println(fieldType);
									if(ftype.equals("DropDown")) {
										WebButton.clickButton(igLocator.getIgAddFieldsButton());
										WebButton.clickButton(igLocator.getIgAddFieldsButton());
										
										WebTextBox.sendInput(igLocator.getIgigValueTextbox1(), ExcelFileData.field_1());                                   
										Thread.sleep(1000);
										WebTextBox.sendInput(igLocator.getIgigValueTextbox2(), ExcelFileData.field_2());		
										Thread.sleep(1000);
										WebTextBox.sendInput(igLocator.getIgigValueTextbox3(), ExcelFileData.field_3());	
							
									}else if (fieldType.equals("Multi Select")) {
										WebButton.clickButton(igLocator.getIgAddFieldsButton());
										WebTextBox.sendInput(igLocator.getIgigValueTextbox1(), ExcelFileData.field_1()); 
										Thread.sleep(1000);
										WebTextBox.sendInput(igLocator.getIgigValueTextbox2(), ExcelFileData.field_2());
									}     
						
					Thread.sleep(3000);				
					igLocator.getIGFieldName().sendKeys(Keys.ENTER);
					
					try {
						Thread.sleep(3000);
						if(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).isDisplayed()){
							//WebButton.clickButton(driver.findElement(By.xpath("//a[@class='btn btn-success']")));
							
							Thread.sleep(2000);
							if(driver.findElements(By.xpath("//a[text()='OK']")).size()>0) { 
								Thread.sleep(3000);
								driver.findElement(By.xpath("//a[text()='OK']")).click();
								Thread.sleep(2000);
							}else if(driver.findElements(By.xpath("//button[text()='Cancel']")).size() > 0) {
								Thread.sleep(2000);
								WebButton.clickButton(driver.findElement(By.xpath("//button[text()='Cancel']")));
								Thread.sleep(4000);
							}
							
							Reporter.log("Same index Field already exists....!!"+ "<br>");
							WebButton.clickButton(driver.findElement(By.xpath("//button[@class='btn btn-history']")));
						}
					} catch (Exception e) {
						System.out.println("New Index Group Field Created" + fieldName);
							Reporter.log("New Group Fields Created"+ fieldName +  "<br>");
						// TODO: handle exception : when we create new field, which not already exists, it throws an exception, hence handled that here
					}
				  }
				}

				
}
