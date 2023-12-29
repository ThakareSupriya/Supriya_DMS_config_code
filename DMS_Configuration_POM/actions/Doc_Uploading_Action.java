package actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.testng.Reporter;

import dataSourceReader.ExcelFileData;
import locators.DocUpload_Locaors;
import webCommonFunctions.WebButton;

public class Doc_Uploading_Action {
	// Actions for "Documents Uploading" Scenario
	
	WebDriver driver = null; 
	DocUpload_Locaors uploadDocL = null;  

	
	XSSFSheet sheet = null;
	Robot robot = null;
			
	public Doc_Uploading_Action(WebDriver driver) throws IOException, AWTException {
		this.driver = driver ;
		
		robot = new Robot();
		
		uploadDocL = new DocUpload_Locaors(driver);
	}
	
	
	
	public void upload_Documents() throws InterruptedException, IOException, AWTException {
				
		Reporter.log("Single Document uploading Report : with and without indexing" + "</br>");
		Thread.sleep(5000);
		WebButton.clickButton(uploadDocL.getDMS());
		Thread.sleep(3000);
		
		if(uploadDocL.folderList.size()!=0) {  
			WebButton.clickButton(driver.findElement(By.xpath("//li[contains(text(),'"+ExcelFileData.category1Name()+"')]")));  // uploadDocL.getFolder()
		}
		
		
		Thread.sleep(3000);
		WebButton.clickButton(uploadDocL.getUploadWithDocset());
		
		// again To click on cat/folder 
		Thread.sleep(3000);
				try {
					WebButton.clickButton(driver.findElement(By.xpath("//li[contains(text(),'"+ExcelFileData.category1Name()+"')]")));  // uploadDocL.getFolder()
				} catch (Exception e) {
			
				}		
				
				// To select doc set dropDown value (here all) 
				Thread.sleep(6000);
					for(WebElement selectValueOption : uploadDocL.selectValueOptions) {
						Thread.sleep(4000);
						selectValueOption.click();
						Thread.sleep(4000);
					}
				WebButton.clickButton(uploadDocL.getProceedButton())	;
				Thread.sleep(6000);
// -----(Not used)		WebTextBox.sendInput(uploadDocL.uploadFileButton, ExcelFileData.docFirst());   // Here 1ST doc from excel sheet has sent                              //<----- "Send The DOCUMENT'S PATH Here"
			//	WebButton.clickButton(uploadDocL.uploadFileButton);  // new++++++
			//	uploadDocL.uploadFileButton.click();
				try {
				driver.findElement(By.xpath("//div[@class='qq-upload-button']")).click();  //input[@name='qqfile']  // //div[text()='Upload a file']
				Thread.sleep(7000);		
				}catch(ElementClickInterceptedException e){
					System.out.println(e);
				}
				
//--------------------- Code to open a specific folder (where all the documents has kept) and send 
						//    control+A to select all the documents from that folder to upload ---------------------
				
				// To press Control+C
				StringSelection stringselection = new StringSelection(ExcelFileData.documentsFolderPath());  //   F:\\Dmacq-Supriya\\New Workspace\\DMS_Configuration\\Test_Documents
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
				
				Thread.sleep(2000);
				
				// for control+V
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				
				robot.keyRelease(KeyEvent.VK_CONTROL);  // To release keys
				robot.keyRelease(KeyEvent.VK_V);
				
				Thread.sleep(2000);
				
				robot.keyPress(KeyEvent.VK_ENTER);      // To press Key Enter
				robot.keyRelease(KeyEvent.VK_ENTER);    // To release Key Enter
				
				Thread.sleep(2000);
				
				for(int i=0; i<=10; i++) { 
					Thread.sleep(1000);
					robot.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(1000);
					robot.keyRelease(KeyEvent.VK_TAB);
				}
				
				// To press control+A 
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_A);
				
				robot.keyRelease(KeyEvent.VK_CONTROL);  // To release keys
				robot.keyRelease(KeyEvent.VK_A);
				
				Thread.sleep(2000);
				
				robot.keyPress(KeyEvent.VK_ENTER);      // To press Key Enter
				robot.keyRelease(KeyEvent.VK_ENTER);    // To release Key Enter
				
				Thread.sleep(3000);
				robot.keyPress(KeyEvent.VK_ENTER);      // To press Key Enter
				robot.keyRelease(KeyEvent.VK_ENTER);    // To release Key Enter
				
					
				Thread.sleep(8000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window. scrollTo(0, document. body. scrollHeight)");
					Thread.sleep(5000);
				if(uploadDocL.uploadButtons.size() != 0  && driver.findElement(By.xpath("//button[text()='Upload']")).isDisplayed()) {  
					WebButton.clickButton(uploadDocL.getUploadButton());
					Thread.sleep(4000);            												
					if(uploadDocL.windowPopups2.size()!=0 											 
							&& uploadDocL.getWindowPopup2().getText().contains("Upload more files?")) {		
							System.out.println("While Upload Without Indexing:: ");
								Reporter.log("While Upload Without Indexing:: " + "</br>");
																			
							System.out.println(uploadDocL.getWindowPopup2().getText()); 
								Reporter.log(uploadDocL.getWindowPopup2().getText() + "</br>"); 
						Thread.sleep(4000);
						WebButton.clickButton(uploadDocL.getNoButton());  
					} else {} 
					} 
				
		/*		}else if(driver.findElements(By.id("index-next")).size() != 0) {
					Thread.sleep(2000);
					WebButton.clickButton(uploadDocL.getNextButton()); 
						WebButton.clickButton(uploadDocL.getTagFromExistingValue());																// <---- Here used existing master value (last value in the table) to tag
							Actions action = new Actions(driver);
							action.sendKeys(Keys.ENTER).perform();
						WebButton.clickButton(uploadDocL.getIMValueTextbox());
						Thread.sleep(2000);
						WebButton.clickButton(uploadDocL.getIconSearch());
						Thread.sleep(3000);
						
						js.executeScript("window. scrollTo(0, document. body. scrollHeight)");
						Thread.sleep(3000);
						
						List<WebElement> chk = driver.findElements(By.xpath("//input[@name='sel_pop_record_set_id']"));
						int i=chk.size()-1;
						while(chk.size()-1==i) {
							chk.get(i).click();
							Thread.sleep(2000);
							i++;
						}
						WebButton.clickButton(uploadDocL.getSelectButton());
						Thread.sleep(2000);
				} */
				
	}  
	
	
	
	
	 
	
	
	

/*
	// ---------------------------Actions for -->  Scenario: Uploading Multiple Documents  : Without Indexing  and with Multiple Indexing------------------------------------
	public void multipleDocumentUploading() throws InterruptedException, IOException {
		Doc_Uploading_Action DocUploadA = new Doc_Uploading_Action(driver);
		Thread.sleep(7000);
				
				// ------- Selecting 'HR Management' category to upload Documents with multiple indexing
				driver.findElement(By.xpath("//a[@class='a_cat_home icon-home btn-home']")).click();
				Thread.sleep(4000);
				WebButton.clickButton(driver.findElement(By.xpath("//li[contains(text(),'HR Management')]")));
				Thread.sleep(4000);
				WebButton.clickButton(uploadDocL.getUploadWithDocset());

		DocUploadA.multipleDocSending();  
		Thread.sleep(4000);
		
		
		
		WebButton.clickButton(uploadDocL.getMultipleIndexing());
		Thread.sleep(4000);
			
		DocUploadA.multipleDocSending(); 
		Thread.sleep(4000);
		 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window. scrollTo(0, document. body. scrollHeight)");
			
		WebButton.clickButton(driver.findElement(By.xpath("(//button[text()='Upload'])[3]")));
		Thread.sleep(5000);
		if(driver.findElements(By.xpath("(//div[@class='bootbox modal fade in'])[2]")).size()!=0
				&& driver.findElement(By.xpath("(//div[@class='bootbox modal fade in'])[2]")).getText().contains("Upload more files?")) {
			Thread.sleep(3000);
				System.out.println("While Upload With Indexing:: ");
					Reporter.log("While Upload With Indexing:: " + "</br>");
				System.out.println(driver.findElement(By.xpath( "(//div[@class='bootbox modal fade in'])[2]")).getText()); 
					Reporter.log(driver.findElement(By.xpath( "(//div[@class='bootbox modal fade in'])[2]")).getText() + "</br>");
			Thread.sleep(2000);
				System.out.println( driver.findElement(By.xpath("//div[@class='modal-body']")).getText());
					Reporter.log(driver.findElement(By.xpath("//div[@class='modal-body']")).getText()  + "</br>");
			Thread.sleep(9000);
			uploadDocL.getNoButton().click();  
			//WebButton.clickButton(uploadDocL.getNoButton());
			Thread.sleep(4000);
		}
	
	}
 
	
	//------------------------------------------------------------A common method for Multiple  document uploading (in 'HR MAnagement' Category)---------------------------------------------------------------
	public void multipleDocSending() throws InterruptedException, IOException {
		// To select doc set dropDown value (here all) 		
		Thread.sleep(6000);
			for(WebElement selectValueOption : uploadDocL.selectValueOptions) {
				Thread.sleep(4000);
				selectValueOption.click();
				Thread.sleep(4000);
			}
			WebButton.clickButton(uploadDocL.getProceedButton())	;
			Thread.sleep(6000);
			WebTextBox.sendInput(uploadDocL.uploadFileButton, ExcelFileData.docSecond() );    // HERE 2ND DOCUMENT FROM EXCEL HAS SENT TO UPLOAD                             //<----- "Send The DOCUMENT'S PATH Here"
			Thread.sleep(4000);
			WebTextBox.sendInput(uploadDocL.uploadFileButton2, ExcelFileData.docThird() );    // HERE 3RD DOCUMENT FROM EXCEL HAS SENT TO UPLOAD            
			Thread.sleep(2000);
			WebTextBox.sendInput(uploadDocL.uploadFileButton2, ExcelFileData.docFourth() );   // HERE 4TH DOCUMENT FROM EXCEL HAS SENT TO UPLOAD 
			
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");  
			Thread.sleep(4000);				  
			if(uploadDocL.uploadButtons.size()!=0 && driver.findElement(By.xpath("//button[text()='Upload']")).isDisplayed() ) {  
				WebButton.clickButton(uploadDocL.getUploadButton());
				Thread.sleep(4000);
				if(uploadDocL.uploadButtons.size()!=0  
						&& uploadDocL.getWindowPopup2().getText().contains("Upload more files?")) {
						System.out.println("While Upload Without Indexing:: ");
							Reporter.log("While Upload Without Indexing:: " + "</br>");
																				
						System.out.println(uploadDocL.getWindowPopup2().getText()); 
							Reporter.log(uploadDocL.getWindowPopup2().getText() + "</br>"); 
							Thread.sleep(5000);
					WebButton.clickButton(uploadDocL.getYesButton());  
					Thread.sleep(4000); 
				}
			}else if(driver.findElements(By.id("index-next")).size() != 0) {
				WebButton.clickButton(uploadDocL.getNextButton());
				Thread.sleep(2000);
				
				Thread.sleep(2000);
				WebButton.clickButton(uploadDocL.getInsertButton());
				Thread.sleep(2000);					 
					if(uploadDocL.popupWindows.size()!=0) {  
						Thread.sleep(2000);
						WebButton.clickButton(uploadDocL.getPopupCloseButton()); 
						Thread.sleep(3000);
					} 
				Thread.sleep(4000);
				WebButton.clickButton(uploadDocL.getSelectAllCheckbox());
				Thread.sleep(3000);
				WebButton.clickButton(uploadDocL.getIndexButton());
				Thread.sleep(3000);				 
				if(uploadDocL.popupWindows.size()!=0) {   	
					Thread.sleep(3000);
					WebButton.clickButton(uploadDocL.getPopupCloseButton());  
				}
				Thread.sleep(3000);
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				Thread.sleep(4000);
				
			}

	}
	
	*/	
}
