package actions;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import dataSourceReader.ExcelFileData;
import dataSourceReader.ExcelFileReader;
import locators.DocSet_Locator;
import webCommonFunctions.WebButton;
import webCommonFunctions.WebTextBox;

public class DocSet_Action {
	//Doc set feature Actions
	
	// WebDriver instance
			WebDriver driver = null; 
			DocSet_Locator docSetLocator= null;
			
			ExcelFileReader excelRead;
			
	// Constructor
			public DocSet_Action(WebDriver driver) throws IOException {
				this.driver = driver;
				docSetLocator = new DocSet_Locator(driver);
				
				excelRead = new ExcelFileReader();
			}
			
			// To enter into deal room (i. e. Test Room) 
			public void clickDealRoom() throws InterruptedException, IOException {
				
				
				
				if(driver.findElements(By.xpath("//a[normalize-space()='"+ExcelFileData.dealRoomName()+"']")).size() != 0) {
					WebButton.clickButton(docSetLocator.getDealRoom());
					Thread.sleep(2000);
				}
				
			}
			
			
			
			// Doc-set 1 creation
			public void docSet1Creation() throws IOException {
				WebButton.clickButton(docSetLocator.getDocSetIcon());			  					 // To click on Doc-Set icon
					Reporter.log("Selected Doc-Set " + "<br>");
				WebButton.clickButton(docSetLocator.getCreateDocSetButton()); 	 		    		 // To click Create Doc Set button
					Reporter.log("Clicked create doc set button " + "<br>");
				WebTextBox.sendInput(docSetLocator.getDocSetName(), ExcelFileData.docset1Name());    // To enter Doc Set Name
					Reporter.log("Doc-Set name entered " + "<br>");
				WebTextBox.sendInput(docSetLocator.dropdownValue, ExcelFileData.dropdownValue1());   // To click 'Add values' button
			}
			
			
			public void addDset1Values() throws InterruptedException, IOException  { 
				
				WebButton.clickButton(docSetLocator.getAddValuesButton());
				WebTextBox.sendInput(docSetLocator.dropdownValue2, ExcelFileData.dropdownValue2());
				Thread.sleep(2000);
				WebButton.clickButton(docSetLocator.getAddValuesButton());
				WebTextBox.sendInput(docSetLocator.dropdownValue3, ExcelFileData.dropdownValue3());
				Thread.sleep(2000);
				WebButton.clickButton(docSetLocator.getAddValuesButton());
				WebTextBox.sendInput(docSetLocator.dropdownValue4, ExcelFileData.dropdownValue4());
					Reporter.log("Doc-Set dropdown values entered " + "<br>");
				Thread.sleep(4000);
				
				docSetLocator.dropdownValue.sendKeys(Keys.ENTER); 
				Thread.sleep(2000);
				
				if(driver.findElements(By.xpath("//div[@class='bootbox modal fade in']")).size() > 0) {  // driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).isDisplayed()
					
							System.out.println(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).getText()); //docSetLocator // "Same DocSet already exist"
								Reporter.log(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).getText());  //  "Same DocSet already exist" + "<br>"
								Thread.sleep(2000);
								if(driver.findElements(By.xpath("//a[@class='btn btn-success']")).size()>0) {
									Thread.sleep(2000);
									driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
								}else if(driver.findElements(By.xpath("//a[text()='OK']")).size()>0){
									Thread.sleep(2000);
									driver.findElement(By.xpath("//a[text()='OK']")).click();
									Thread.sleep(2000);
								}
								Thread.sleep(4000);
								if(driver.findElements(By.xpath("//button[text()='Cancel']")).size() != 0) {
									Thread.sleep(2000);
									WebButton.clickButton(driver.findElement(By.xpath("//button[text()='Cancel']")));
									Thread.sleep(2000);
								}
				}
			}

			
			
			
			// Doc-set 2 creation
			public void docSet2Creation() throws IOException, InterruptedException {
				Thread.sleep(5000);
				WebButton.clickButton(docSetLocator.getCreateDocSetButton()); 	 		    		 // To click Create Doc Set button
					Reporter.log("Clicked create doc set button " + "<br>");
				WebTextBox.sendInput(docSetLocator.getDocSetName(), ExcelFileData.docset2Name());    // To enter Doc Set Name
					Reporter.log("Doc-Set name entered " + "<br>");
				WebTextBox.sendInput(docSetLocator.dropdownValue, ExcelFileData.dropdownValue5());   // To click 'Add values' button
			}

						
			public void addDset2Values() throws InterruptedException, IOException  { 
				
				WebButton.clickButton(docSetLocator.getAddValuesButton());
				WebTextBox.sendInput(docSetLocator.dropdownValue2, ExcelFileData.dropdownValue6());
				Thread.sleep(2000);
				WebButton.clickButton(docSetLocator.getAddValuesButton());
				WebTextBox.sendInput(docSetLocator.dropdownValue3, ExcelFileData.dropdownValue7());
					Reporter.log("Doc-Set dropdown values entered " + "<br>");
				Thread.sleep(4000);
				
				//docSetLocator.dropdownValue.sendKeys(Keys.ENTER); 
				Actions action = new Actions(driver);
				action.sendKeys(Keys.ENTER).perform();
				Thread.sleep(4000);
				
				if(driver.findElements(By.xpath("//div[@class='bootbox modal fade in']")).size() > 0) {  // driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).isDisplayed()
					
							System.out.println(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).getText()); //docSetLocator // "Same DocSet already exist"
								Reporter.log(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).getText());  //  "Same DocSet already exist" + "<br>"
						Thread.sleep(2000);
						if(driver.findElements(By.xpath("//a[@class='btn btn-success']")).size()>0) {
						Thread.sleep(2000);
						driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
						}else if(driver.findElements(By.xpath("//a[text()='OK']")).size()>0){
						Thread.sleep(2000);
						driver.findElement(By.xpath("//a[text()='OK']")).click();
						Thread.sleep(2000);
						}	
						Thread.sleep(4000);			
								if(driver.findElements(By.xpath("//button[text()='Cancel']")).size() != 0) {
									Thread.sleep(2000);
									WebButton.clickButton(driver.findElement(By.xpath("//button[text()='Cancel']")));
									Thread.sleep(2000);
								}
				}
			}
			
			
			
			
			// Doc-set 3 creation
			public void docSet3Creation() throws IOException, InterruptedException {
				Thread.sleep(5000);
				WebButton.clickButton(docSetLocator.getCreateDocSetButton()); 	 		    		 // To click Create Doc Set button
					Reporter.log("Clicked create doc set button " + "<br>");
				WebTextBox.sendInput(docSetLocator.getDocSetName(), ExcelFileData.docset3Name());    // To enter Doc Set Name
					Reporter.log("Doc-Set name entered " + "<br>");
				WebTextBox.sendInput(docSetLocator.dropdownValue, ExcelFileData.dropdownValue8());   // To click 'Add values' button
			}
			
			
			public void addDset3Values() throws InterruptedException, IOException  { 
				
				WebButton.clickButton(docSetLocator.getAddValuesButton());
				WebTextBox.sendInput(docSetLocator.dropdownValue2, ExcelFileData.dropdownValue9());
					Reporter.log("Doc-Set dropdown values entered " + "<br>");
				Thread.sleep(4000);
				
				//docSetLocator.dropdownValue.sendKeys(Keys.ENTER); 
				Actions action = new Actions(driver);
				action.sendKeys(Keys.ENTER).perform();
				Thread.sleep(4000);
				
				if(driver.findElements(By.xpath("//div[@class='bootbox modal fade in']")).size() > 0) {  // driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).isDisplayed()
					
							System.out.println(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).getText()); //docSetLocator // "Same DocSet already exist"
								Reporter.log(driver.findElement(By.xpath("//div[@class='bootbox modal fade in']")).getText());  //  "Same DocSet already exist" + "<br>"
								Thread.sleep(2000);
								if(driver.findElements(By.xpath("//a[@class='btn btn-success']")).size()>0) {
									Thread.sleep(2000);
									driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
								}else if(driver.findElements(By.xpath("//a[text()='OK']")).size()>0){
									Thread.sleep(2000);
									driver.findElement(By.xpath("//a[text()='OK']")).click();
									Thread.sleep(2000);
								}
								Thread.sleep(4000);
								if(driver.findElements(By.xpath("//button[text()='Cancel']")).size() != 0) {
									Thread.sleep(2000);
									WebButton.clickButton(driver.findElement(By.xpath("//button[text()='Cancel']")));
									Thread.sleep(2000);
								}
				}
			}
			
		
				
			
			
			// To Assign 'Doc Set Permissions' for all the available doc-set
			public void assignDocsetPermissions() throws InterruptedException {
				
				Thread.sleep(4000);
				for(int i=0; i<=docSetLocator.permissionsIcon.size()-1; i++) {  
					WebButton.clickButton(docSetLocator.permissionsIcon.get(i));  
					Thread.sleep(2000);
					for(WebElement checkbox : docSetLocator.checkboxAllPermission) {
						WebButton.clickButton(checkbox);                              // As checkBox is not selected be default
						Thread.sleep(2000);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,1000)");
						Thread.sleep(1000);
					}
					Thread.sleep(8000);
					driver.findElement(By.linkText("Doc Set Dashboard")).click();
				}
			}
			


		
  
}
