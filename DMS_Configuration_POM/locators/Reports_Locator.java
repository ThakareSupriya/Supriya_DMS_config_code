package locators;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import webCommonFunctions.WebElementWait;

public class Reports_Locator {
	
	WebDriver driver = null;
	
	public Reports_Locator(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	// ----------Locators for Document Report----------
	
	@FindBy(xpath = "//span[text()='DMS']")
	private WebElement dmsIcon;
	
	public WebElement getDMSicon(){
		if(WebElementWait.waitToElementClickable(driver, dmsIcon) != null) {
			return dmsIcon;
		}else 
			return null;
	}
	
	@FindBy(xpath = "//i[@class='icon-folder-open']")
	private WebElement viewCategoryIcon;
	
	public WebElement getViewCategoryIcon(){
		if(WebElementWait.waitToElementClickable(driver, viewCategoryIcon) != null) {
			return viewCategoryIcon;
		}else 
			return null;
	}
	
	@FindBy(xpath = "//div[@id='div_category_lists']")
	public List <WebElement> categoryList;
	
	@FindBy(xpath = "//td[contains(text(),'HR Management')]/following-sibling::td//i[@class='icon-tasks']")
	private WebElement documentReports;
	
	public WebElement getDocumentReports(){
		if(WebElementWait.waitToElementClickable(driver, documentReports) != null) {
			return documentReports;
		}else
			return null;
	}
	
	@FindBy(xpath = "//button[text()='New Report']")
	private WebElement buttonNewReport;
	
	public WebElement getButtonNewReport(){
		if(WebElementWait.waitToElementClickable(driver, buttonNewReport) != null) {
			return buttonNewReport;
		}else
			return null;
	}
	
	@FindBy(id = "doc_report_name")
	private WebElement reportName;
	
	public WebElement getReportName(){
		if(WebElementWait.waitToElementClickable(driver, reportName) != null) {
			return reportName;
		}else
			return null;
	}
	
	@FindBy(xpath  = "//span[text()='Choose a report type...']")
	private WebElement reportType;
	
	public WebElement getReportType(){
		if(WebElementWait.waitToElementClickable(driver, reportType) != null) {
			return reportType;
		}else
			return null;
	}
	
	@FindBy(xpath  = "//div[@class='chzn-search']//input")
	private WebElement reportTypeSearchbox;
	
	public WebElement getReportTypeSearchbox(){
		if(WebElementWait.waitToElementClickable(driver, reportTypeSearchbox) != null) {
			return reportTypeSearchbox;
		}else
			return null;
	}
	 
	@FindBy(xpath = "//input[@name='index_master_fields[]']//following-sibling::label")
	public List <WebElement> imFields;
	
	@FindBy(xpath = "//input[@name='index_group_fields[]']//following-sibling::label")
	public List <WebElement> igFields;
	
	
	@FindBy(xpath  = "//span[text()='Choose a Period...']")
	private WebElement periodDropdown;
	
	public WebElement getPeriodDropdown(){
		if(WebElementWait.waitToElementClickable(driver, periodDropdown) != null) {
			return periodDropdown;
		}else
			return null;   
	}
	 
	@FindBy(xpath  = "(//div[@class='chzn-search']//input)[2]")
	private WebElement periodSearchbox;
	
	public WebElement getPeriodSearchbox(){
		if(WebElementWait.waitToElementClickable(driver, periodSearchbox) != null) {
			return periodSearchbox;
		}else
			return null;   
	}
	
	@FindBy(id  = "yearsDiv") // (//span[contains(text(),'Choose')])[3]
	private WebElement choosePeriodInNumber;
	
	public WebElement getChoosePeriodInNumber(){
		if(WebElementWait.waitToElementClickable(driver, choosePeriodInNumber) != null) {
			return choosePeriodInNumber;
		}else
			return null;   
	}
	
	@FindBy(xpath  = "(//div[@class='chzn-search']//input)[6]")  
	private WebElement numberPeriodSearchbox;
	
	public WebElement getNumberPeriodSearchbox(){
		if(WebElementWait.waitToElementClickable(driver, numberPeriodSearchbox) != null) {
			return numberPeriodSearchbox;
		}else
			return null;   
	}
	
	@FindBy(xpath  = "//button[@type='submit']")
	private WebElement addButton;
	
	public WebElement getAddButton(){
		if(WebElementWait.waitToElementClickable(driver, addButton) != null) {
			return addButton;
		}else
			return null;   
	}
	
	@FindBy(xpath  = "//i[@class='icon-bar-chart']")
	public List <WebElement> viewReports;
	 

	@FindBy(xpath  = "//i[@class='icon-bar-chart']")
	private WebElement viewReport;
	
	public WebElement getViewReport(){
		if(WebElementWait.waitToElementClickable(driver, viewReport) != null) {
			return viewReport;
		}else
			return null;   
	}
	
	
	@FindBy(xpath = "//div[@id='data-table_info']")
	private WebElement resultsDiv;
	
	public WebElement getResultsDiv(){
		if(WebElementWait.waitToElementClickable(driver, resultsDiv) != null) {
			return resultsDiv;
		}else
			return null;   
	}
	
	
	@FindBy(linkText = "Document Report - Dashboard")
	private WebElement reportDashboard;
	
	public WebElement getReportDashboard(){
		if(WebElementWait.waitToElementClickable(driver, reportDashboard) != null) {
			return reportDashboard;
		}else
			return null;   
	}
	
	// --------------- Pagination Locators ---------------
	
	@FindBy(linkText = "DMS")
	private WebElement linkDMS;
	
	public WebElement getLinkDMS(){
		if(WebElementWait.waitToElementClickable(driver, linkDMS) != null) {
			return linkDMS;
		}else
			return null;   
	}
	
	@FindBy(xpath  = "//i[@class='icon-credit-card']")
	private WebElement iconIM;
	
	public WebElement getIconIM(){
		if(WebElementWait.waitToElementClickable(driver, iconIM) != null) {
			return iconIM;
		}else
			return null;   
	}
	
	// --------------- Locators for Master Report ---------------
	@FindBy(xpath  = "//td[contains(text(),'Employee Information')]/following-sibling::td//i[@class='icon-tasks']")
	private WebElement masterReport;
	
	public WebElement getMasterReport(){
		if(WebElementWait.waitToElementClickable(driver, masterReport) != null) {
			return masterReport;
		}else
			return null;   
	}
	
	// 'New Report' button  -:: Same Locator as for Document Report Locator ::-
	
	@FindBy(id  = "im_report_name")
	private WebElement imReportName;
	
	public WebElement getIMreportName(){
		if(WebElementWait.waitToElementClickable(driver, imReportName) != null) {
			return imReportName;
		}else
			return null;   
	}
	
	// 'Report Type' DropDown  -:: Same Locator as for Document Report Locator ::-
	
	// 'Report Type SearchBox'  -:: Same Locator as for Document Report Locator ::-

	@FindBy(xpath  = "//div[@id='divIndexMasterFields']//label")  	//Index Master Fields
	public List <WebElement> indexMasterFields;
	
	// 'Period DropDown' -:: Same Locator as for Document Report Locator ::-
	// 'Period SearchBox' 
	
	@FindBy(id  = "yearsDiv")  //   monthsDiv
	private WebElement reportPeriodInNumber;
	
	public WebElement getReportPeriodInNumber(){
		if(WebElementWait.waitToElementClickable(driver, reportPeriodInNumber) != null) {
			return reportPeriodInNumber;
		}else
			return null;   
	}
	
	@FindBy(xpath  = "(//div[@class='chzn-search']//input)[5]")  
	private WebElement numberOfMonthsSearchbox;
	
	public WebElement getNumberOfMonthsSearchbox(){
		if(WebElementWait.waitToElementClickable(driver, numberOfMonthsSearchbox) != null) {
			return numberOfMonthsSearchbox;
		}else
			return null;   
	}
	
	// 'Add Button' -:: Same Locator as for Document Report Locator ::-
	
	@FindBy(linkText = "Master Report - Dashboard") // Master Report - DashBoard  Index Master Report
	private WebElement imReportDashboard;
	
	public WebElement getIMreportDashboard(){
		if(WebElementWait.waitToElementClickable(driver, imReportDashboard) != null) {
			return imReportDashboard;
		}else
			return null;   
	}
	
		//-----'Download Entire Report' locators -:: Here used 'Receive Through Mail On Your Registered Email ID' ::- Hence each report will be sent via eMail ----- 
	
			@FindBy(xpath = "//button[@data-toggle='dropdown']")   // Click on 'Action' DropDown
			private WebElement actionDropdown;
			
			public WebElement getActionDropdown(){
				if(WebElementWait.waitToElementClickable(driver, actionDropdown) != null) {
					return actionDropdown;
				}else
					return null;   
			}
			
			@FindBy(linkText = "Download Entire Report")          // Click on 'Download Entire Report' DropDown
			private WebElement downloadEntireReport;
			
			public WebElement getDownloadEntireReport(){
				if(WebElementWait.waitToElementClickable(driver, downloadEntireReport) != null) {
					return downloadEntireReport;
				}else
					return null;   
			}
			
			@FindBy(name = "receive_mail")          			 // Tick receive_mail 'CheckBox' 
			private WebElement receiveMail;
			
			public WebElement getReceiveMail(){
				if(WebElementWait.waitToElementClickable(driver, receiveMail) != null) {
					return receiveMail;
				}else
					return null;   
			}
			
			@FindBy(xpath = "//button[text()='Submit']")         // Click 'Submit' button 
			private WebElement submitButton;
			
			public WebElement getSubmitButton(){
				if(WebElementWait.waitToElementClickable(driver, submitButton) != null) {
					return submitButton;
				}else
					return null;   
			}
			
			
					// To find pop-up window "Downloading has started. Please Check After Few Minutes, Depending on the records in Report."
					@FindBy(xpath = "//div[@class='bootbox modal fade in']")         
					public List <WebElement> popUpWindows;
					
					
						@FindBy(xpath = "//div[@class='bootbox modal fade in']")         
						public WebElement popUpWindow;
					
					
					// To find 'Close' button on pop-up window
					@FindBy(linkText = "Close")         
					private WebElement buttonClose;
					
					public WebElement getButtonClose(){
						if(WebElementWait.waitToElementClickable(driver, buttonClose) != null) {
							return buttonClose;
						}else
							return null;   
					}
					
					
 }
