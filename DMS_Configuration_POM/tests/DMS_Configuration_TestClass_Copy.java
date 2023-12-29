package tests;

import java.awt.AWTException;
import java.io.*;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import actions.*;
import dataSourceReader.ExcelFileData;
import initializer.BaseClass;
import webCommonFunctions.WebButton;

public class DMS_Configuration_TestClass_Copy {	
	
	WebDriver driver                          = null; 
	Login_DealRoom_Action loginDealRoomAction = null;
	
	GroupRights_Action groupRightsAction      = null;
	DocSet_Action docSetAct                   = null;
	Category_Action categoryAction            = null;
	IndexMaster_Action indexMaster            = null;
	IndexGroup_Action indexGroupAction        = null;
	Doc_Uploading_Action docUploadAction      = null;
	Reports_Action reportsAction              = null;
	ThumbRights_Action thumbRightsAction      = null;
	UserGroups_Actions userGroupAction        = null; 
	Department_Actions departmentAction       = null;
	
	
	@BeforeClass
	public void setUpBrowser() throws IOException, AWTException {
		driver = BaseClass.launchBrowserWith("chrome");
		loginDealRoomAction = new Login_DealRoom_Action(driver);
		
		driver.get(ExcelFileData.url());
		driver.manage().window().maximize();
		
		loginDealRoomAction.enterUsername(ExcelFileData.username());
		loginDealRoomAction.enterPassword(ExcelFileData.password());
		loginDealRoomAction.clickLoginButton();
		
		try {
			Thread.sleep(3000);
			if(driver.findElements(By.xpath("//div[@role='dialog']")).size()>0) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[text()='Ok, Log-in']")).click();
			}
		} catch (Exception e) {
			
		}
		
		groupRightsAction   = new GroupRights_Action(driver);
		userGroupAction     = new UserGroups_Actions(driver);
		loginDealRoomAction = new Login_DealRoom_Action(driver);
		departmentAction    = new Department_Actions(driver);
		docSetAct           = new DocSet_Action(driver);
		indexMaster         = new IndexMaster_Action(driver);
		indexGroupAction    = new IndexGroup_Action(driver);
		categoryAction      = new Category_Action(driver);
		docUploadAction     = new Doc_Uploading_Action(driver);
		reportsAction       = new Reports_Action(driver);
		thumbRightsAction   = new ThumbRights_Action(driver);
	}
	
	
	
	// To Assign Rights To 'Users' group
	//:- contains creating 'Users' group, creating 1 user account, Assign Group Rights & Assign IM Field Rights+IG Rights from Thumb Rights
	@Test (priority = 1)
	public void assign_GroupRights() throws InterruptedException, IOException {
		groupRightsAction.create_UserGroup();
		Thread.sleep(5000);
		groupRightsAction.create_UserAccount();
		Thread.sleep(5000);
		groupRightsAction.assign_GroupRights();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='Recall']")).click();
		Thread.sleep(5000);
	
	}
	
	
	// Deal Room
	@Test (priority = 2)
	public void dealRoom_Test() throws InterruptedException, IOException {
		//	Thread.sleep(2000);
		//	loginDealRoomAction.dealRoomCreation();
			Thread.sleep(2000);
			loginDealRoomAction.enterIntoDealRoom(); 
			Thread.sleep(2000);
		}
		
	
	// Doc-Set 
	@Test (priority = 3)
	public void docSet_Test() throws IOException, InterruptedException {
				
			Thread.sleep(4000);
			Reporter.log("<b>----- Doc-Set Creation Report -----</b>" + "<br>");
			
			docSetAct.docSet1Creation();
			Thread.sleep(2000);
			docSetAct.addDset1Values();
			Thread.sleep(2000);
			
			docSetAct.docSet2Creation();
			Thread.sleep(2000);
			docSetAct.addDset2Values();
			Thread.sleep(2000);
			
			docSetAct.docSet3Creation();
			Thread.sleep(2000);
			docSetAct.addDset3Values();
			Thread.sleep(2000);
			
			docSetAct.assignDocsetPermissions();
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[contains(text(), 'Analytics')]")).click();
			} 

	
	// Index Master
	@Test(priority = 4) 
	public void indexMaster_Test() throws InterruptedException, IOException {
			Reporter.log("<b>----- Index Master and Fields Report -----</b>" + "<br>");

			indexMaster.imNavigate();		
		
			Thread.sleep(4000);
			List<WebElement> button_createIM = driver.findElements(By.xpath("//button[contains(text(),'New Index Master')]")) ;
			if(button_createIM.size() !=0 ) {
				Thread.sleep(2000);
				indexMaster.creatingIndexMaster1();
				indexMaster.popUpHandle();
		
				indexMaster.creatingIndexMaster2();
				indexMaster.popUpHandle();
		
				indexMaster.creatingIM1fields();	
				Thread.sleep(3000);
					
				driver.findElement(By.xpath("//a[text()='Index Master']")).click();
				Thread.sleep(2000); 
		 
				indexMaster.creatingIM2fields();
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//a[text()='Index Master']")).click();
				Thread.sleep(2000);
				
				
				Thread.sleep(7000);
				driver.findElement(By.partialLinkText("Analytics")).click();
			}	
		}
	
	
	// Index Group 
	@Test(priority = 5)
	public void indexGroup_Test() throws InterruptedException, IOException {
			Reporter.log("<b>----- Index Group Report -----</b>" + "</br>");
			
				indexGroupAction.indexGroup1Creation(); 
				
				Thread.sleep(3000);
				indexGroupAction.addIG1Fields(); 
				
				Thread.sleep(3000);
				WebButton.clickButton(driver.findElement(By.linkText("Index Group")));
				Thread.sleep(2000);
				
				indexGroupAction.indexGroup2Creation(); 
				
				Thread.sleep(3000);
				indexGroupAction.addIG2Fields(); 
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[contains(text(), 'Analytics')]")).click();
		 } 
		
	
	// Category
	@Test(priority = 6) 
	public void category_Test() throws IOException, InterruptedException, InvalidFormatException {  
			
			Reporter.log("<b>----- Create New Category & Set Indexes to Category Report -----</b>" + "</br>");
			
				categoryAction.categoryCreate_CategoryIndexing();
			 
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[contains(text(), 'Analytics')]")).click(); 
		} 

	
			
	// To Upload Documents
	@Test(priority = 7)  
	public void uploadDocuments_Test() throws InterruptedException, IOException, AWTException {
		Reporter.log("<b>----- Documents Upload Report -----</b>" + "<br>");
		
		Thread.sleep(5000);
		
		docUploadAction.upload_Documents();
		//docUploadAction.SingleDocumentUploading(); 
		
		//docUploadAction.multipleDocumentUploading();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(), 'Analytics')]")).click(); 
	}
	
	
	
	// To generate Document & Master Reports
	@Test(priority = 8)
	public void generate_Reports_Test() throws InterruptedException, IOException {
		reportsAction.generateDocumentReports();
		Thread.sleep(4000);
		
		reportsAction.masterReports();
		Thread.sleep(5000);
		
		WebButton.clickButton(driver.findElement(By.partialLinkText("Analytics")));
		Thread.sleep(4000);
	}
	
	
	
	// To Assign Thumb Rights
	@Test (priority = 9)
	public void assign_ThumbRights() throws InterruptedException, IOException {
		Thread.sleep(5000);
		thumbRightsAction.assign_IMfieldsRights_IGRights();  
		Thread.sleep(5000);
		thumbRightsAction.assign_IM_Rights();
		Thread.sleep(5000);
		thumbRightsAction.assign_Category_Rights();
		Thread.sleep(5000);
	}
 
	
	
	// User Group
	@Test (priority = 10)
	public void userGroup_Test() throws InterruptedException, IOException {
		Thread.sleep(2000);
		Reporter.log("<b>----- User Group Creation Report -----</b>" + "</br>");
		
		userGroupAction.creatingUSerGroups();
		Thread.sleep(2000);
	}
		
	
	
	// Department 
	@Test (priority = 11)
	public void department_Test() throws InterruptedException {
		Thread.sleep(2000);
		Reporter.log("<b>----- Department Creation Report -----</b>" + "</br>");
		
		departmentAction.departmentCreation();
		Thread.sleep(2000);
	}
	
	
	
	// To capture screenshot when Test fails
	@AfterMethod (description = "To capture Screenshot on Test FAILURE")
	public void failScreenshot(ITestResult result) throws IOException {
		if(result.getStatus() == result.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(".//Screenshots/dmacq_v9_new_Fail/" + result.getName() + ".png");
			FileUtils.copyFile(src, dest);
		}
	}
	 
	
	
	// To delete cookies and to close the driver
//	@AfterClass
	public void browserClose() {
		driver.close();
		driver.manage().deleteAllCookies();
	}
	
	
	
}
