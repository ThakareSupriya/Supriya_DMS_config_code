package actions;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import dataSourceReader.ExcelFileData;
import dataSourceReader.ExcelFileReader;
import locators.Reports_Locator;
import webCommonFunctions.WebButton;
import webCommonFunctions.WebTextBox;

public class Reports_Action {
	
	WebDriver  driver = null;
	Reports_Locator reportsL = null;
	
	 
	public Reports_Action(WebDriver driver) throws IOException {
		this.driver = driver;
		
		reportsL  = new Reports_Locator(driver);
		
	}
	
	
	public void generateDocumentReports() throws InterruptedException, IOException {
		Reports_Action reportsAct  = new Reports_Action(driver);
		
		Thread.sleep(5000);
		WebButton.clickButton(reportsL.getDMSicon());
		Thread.sleep(3000);
		WebButton.clickButton(reportsL.getViewCategoryIcon());
		Thread.sleep(3000);
		
		Set<String> handles = driver.getWindowHandles();
		for(String handle:handles) {
			driver.switchTo().window(handle);
			
			if(reportsL.categoryList.size() != 0){ 
				Thread.sleep(3000);
				
				WebButton.clickButton(driver.findElement(By.xpath("//td[contains(text(),'"+ExcelFileData.category1Name()+"')]//following-sibling::td//i[@class='icon-tasks']"))); // reportsL.getDocumentReports()
				Thread.sleep(3000);
				reportsAct.documentReports();   // calling the function to generate doc reports
				
				Thread.sleep(3000);
				WebButton.clickButton(driver.findElement(By.xpath("//td[contains(text(),'"+ExcelFileData.category2Name()+"')]//following-sibling::td//i[@class='icon-tasks']")));
				Thread.sleep(3000);
				reportsAct.documentReports();  // calling the function to generate doc reports
				
					//To generate reports for sub categories which are inside first category name in sheet
					// for child category 1
					Thread.sleep(3000);
					WebButton.clickButton(driver.findElement(By.xpath("//li[text()='Article Category']")));
					Thread.sleep(3000);
					WebButton.clickButton(driver.findElement(By.xpath("//td[contains(text(),'"+ExcelFileData.childCatgeory1()+"')]//following-sibling::td//i[@class='icon-tasks']"))); // reportsL.getDocumentReports()
						// //td[contains(text(),'"+ExcelFileData.childCatgeory1()+"')]//following-sibling::td//i[@class='icon-tasks']
					Thread.sleep(3000);
					reportsAct.documentReports();   // calling the function to generate doc reports
					
					// for child category 2
					Thread.sleep(3000);
					WebButton.clickButton(driver.findElement(By.xpath("//li[text()='Article Category']")));
					Thread.sleep(3000);
					WebButton.clickButton(driver.findElement(By.xpath("//td[contains(text(),'"+ExcelFileData.childCatgeory2()+"')]//following-sibling::td//i[@class='icon-tasks']"))); // reportsL.getDocumentReports()
					Thread.sleep(3000);
					reportsAct.documentReports();   // calling the function to generate doc reports
					
					
					reportsAct.masterReports();     // calling the function to generate Master reports
				
		   } // if
		} // for-each
		
	} // function
	
	
	// To generated Document Report 
	public void documentReports() throws InterruptedException, IOException {
		
		XSSFSheet sheet = ExcelFileReader.sheet;
		
		for(int row=73; row<=77; row++) { // 82   86  // 84  88  // 72 76
		
		String reportName = sheet.getRow(row).getCell(0).toString();
		String reportType = sheet.getRow(row).getCell(1).toString();
			
		WebButton.clickButton(reportsL.getButtonNewReport());
		Thread.sleep(2000);
		WebTextBox.sendInput(reportsL.getReportName(), reportName);  
		Thread.sleep(1000);
		WebButton.clickButton(reportsL.getReportType()); 
		Thread.sleep(2000);
		WebTextBox.sendInput(reportsL.getReportTypeSearchbox(), reportType ); 
		Thread.sleep(1000);
		WebTextBox.sendKeys(reportsL.getReportTypeSearchbox(), Keys.ENTER);
		Thread.sleep(2000);
		
		if(reportsL.imFields.size() != 0) {
			for(WebElement imField : reportsL.imFields) {
				WebButton.clickButton(imField);
				Thread.sleep(2000);
			}
		}
		if(reportsL.igFields.size() != 0) {
			for(WebElement igField : reportsL.igFields) {
				WebButton.clickButton(igField);
				Thread.sleep(2000);
			}
		}
		
		Thread.sleep(2000);
		WebButton.clickButton(reportsL.getPeriodDropdown());
		Thread.sleep(1000);
		WebTextBox.sendInput(reportsL.getPeriodSearchbox(), ExcelFileData.reportSpan()); 
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebButton.clickButton(reportsL.getChoosePeriodInNumber());
		Thread.sleep(2000);
		WebTextBox.sendInput(reportsL.getNumberPeriodSearchbox(), ExcelFileData.reportPeriod_inNumber());  
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebButton.clickButton(reportsL.getAddButton());
		Thread.sleep(5000);
			
			Reporter.log(reportType + " : Generated" + "<br>");
			
		}
			Thread.sleep(2000);
			driver.findElement(By.linkText("Categories")).click();
	}
	

	
	// Master Reports Actions
	public void masterReports() throws InterruptedException, IOException {
		Reports_Action reportsAct  = new Reports_Action(driver);
		
		Thread.sleep(8000); 
		
		WebButton.clickButton(reportsL.getLinkDMS());     
		Thread.sleep(2000);
		WebButton.clickButton(reportsL.getIconIM());      		// : opens in new tab, switch to newly opened tab
		Thread.sleep(2000);
			Set<String> handles = driver.getWindowHandles();
			for(String handle:handles) {
				driver.switchTo().window(handle); 
			Thread.sleep(2000);
			}
		WebButton.clickButton(driver.findElement(By.xpath("//td[contains(text(),'"+ExcelFileData.im1Name()+"')]/following-sibling::td//i[@class='icon-tasks']")));  // reportsL.getMasterReport()
		Thread.sleep(2000);
		
		reportsAct.generateMasterReports();    // Calling function to generate reports for master 1
		
		Thread.sleep(4000);
		WebButton.clickButton(driver.findElement(By.xpath("//a[text()='Index  Master']")));
		Thread.sleep(4000);
		
		WebButton.clickButton(driver.findElement(By.xpath("//td[contains(text(),'"+ExcelFileData.im2Name()+"')]/following-sibling::td//i[@class='icon-tasks']")));  // reportsL.getMasterReport()
		Thread.sleep(2000);
		
		reportsAct.generateMasterReports();    // Calling function to generate reports for master 2
	}		
		
	
	public void generateMasterReports() throws InterruptedException, IOException {
		
			XSSFSheet sheet = ExcelFileReader.sheet;
		
		for(int row=84; row<=87; row++) { // 93  97 // 95   100  // 83  88
			
			String reportName = sheet.getRow(row).getCell(0).toString();
			String reportType = sheet.getRow(row).getCell(1).toString();
			System.out.println("NAME:: " + reportName + "  TYPE::  " + reportType); 
			
		WebButton.clickButton(reportsL.getButtonNewReport());
		Thread.sleep(2000);
		WebTextBox.sendInput(reportsL.getIMreportName(), reportName);        // ------------ 
		Thread.sleep(2000);
		WebButton.clickButton(reportsL.getReportType());
		Thread.sleep(2000);
		WebTextBox.sendInput(reportsL.getReportTypeSearchbox(), reportType); // ------------
		Thread.sleep(1000);
		WebTextBox.sendKeys(reportsL.getReportTypeSearchbox(), Keys.ENTER);
		Thread.sleep(2000);
		for(WebElement indexMasterField : reportsL.indexMasterFields) {
			WebButton.clickButton(indexMasterField);
			Thread.sleep(2000);
		} 
		WebButton.clickButton(reportsL.getPeriodDropdown());
		Thread.sleep(3000); 
		WebTextBox.sendInput(reportsL.getPeriodSearchbox(), ExcelFileData.reportSpan());      
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebButton.clickButton(reportsL.getReportPeriodInNumber());
		Thread.sleep(2000);
		WebTextBox.sendInput(reportsL.getNumberPeriodSearchbox(), ExcelFileData.reportPeriod_inNumber());  //   getNumberOfMonthsSearchbox masterReportPeriod
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		Thread.sleep(4000);
		
		if(driver.findElements(By.xpath("//span[text()='Choose...']")).size() > 0 
				&& driver.findElement(By.xpath("//span[text()='Choose...']")).isDisplayed()){
			Thread.sleep(2000);
			WebButton.clickButton(driver.findElement(By.xpath("//span[text()='Choose...']")));
			Thread.sleep(2000);
			WebTextBox.sendKeys(driver.findElement(By.xpath("(//div[@class='chzn-search']//input)[8]")), Keys.ENTER);
			
			Thread.sleep(2000);
			WebButton.clickButton(driver.findElement(By.xpath("//input[@value='Choose a  category']")));
			Thread.sleep(2000);
			WebTextBox.sendKeys(driver.findElement(By.xpath("//input[@value='Choose a  category']")), Keys.ENTER);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@class='chk_field']")).click();     // //input[@id='chk_field_2']
		}
	Thread.sleep(2000);
	WebButton.clickButton(reportsL.getAddButton());  	// Add button
	Thread.sleep(5000);

		
			Reporter.log(reportType + " : Generated" + "<br>");
	}
	
		/*
		for(int i=0; i<=reportsL.viewReports.size()-1; i++) {
			WebButton.clickButton(reportsL.viewReports.get(i));
			
			
				// To Download Entire Report  
				WebButton.clickButton(reportsL.getActionDropdown());		// 1. Click Action dropDown  
				Thread.sleep(2000);   
			    WebButton.clickButton(reportsL.getDownloadEntireReport());  // 2. Click 'Download Entire Report'    
			    Thread.sleep(2000);
			    WebButton.clickButton(reportsL.getReceiveMail());           // 3. Click Receive Through Mail checkBox  
			    Thread.sleep(2000);
			    WebButton.clickButton(reportsL.getSubmitButton());          // 4. Click 'Submit' button  
			    Thread.sleep(2000); 
			    if(reportsL.popUpWindows.size() != 0 ) {
			    	System.out.println(reportsL.popUpWindow.getText());
			    		Reporter.log(reportsL.popUpWindow.getText() + "<br>");
			    	Thread.sleep(2000); 
			    	WebButton.clickButton(reportsL.getButtonClose());
			    	Thread.sleep(2000); 
			    }
			
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", reportsL.getResultsDiv());
			Thread.sleep(2000);
			Reporter.log(reportsL.getResultsDiv().getText() + "<br>");
				
					System.out.print(driver.findElement(By.xpath("//h3[@class='page-header']")).getText() + " : "+ 
														driver.findElement(By.xpath("//div[@class='dataTables_info ']")).getText() ); 
						System.out.println(" ");
						Reporter.log(driver.findElement(By.xpath("//h3[@class='page-header']")).getText() + " : "+ 
														driver.findElement(By.xpath("//div[@class='dataTables_info ']")).getText() + "<br>" );
				
			// scroll into view : element - data tables info 
		Thread.sleep(15000); 
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_UP).perform();
		Thread.sleep(5000);
		WebButton.clickButton(reportsL.getIMreportDashboard()); 
		Thread.sleep(4000);
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);  
		}  */
	}
	
	
	public void pagination() throws InterruptedException {
		Thread.sleep(5000);
		WebButton.clickButton(driver.findElement(By.partialLinkText("Analytics")));
		Thread.sleep(5000);
		WebButton.clickButton(reportsL.getDMSicon());
		Thread.sleep(5000);
	}
}
  