package actions;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import dataSourceReader.ExcelFileData;
import dataSourceReader.ExcelFileReader;
import locators.Category_Loactor;
import webCommonFunctions.WebButton;
import webCommonFunctions.WebTextBox;

public class Category_Action {
	// Category and sub category creation Actions
	
	// Instance
	WebDriver driver = null;
	Category_Loactor catLocator = null;
	 
	ExcelFileReader excelRead;
	
	// Constructor
	public Category_Action(WebDriver driver) throws IOException {
		this.driver = driver;
		catLocator = new Category_Loactor(driver);
		
		excelRead = new ExcelFileReader();
	}
	   
	
	// To enter into deal room (i. e. Test Room)
	public void clickDealRoom() {
		WebButton.clickButton(catLocator.getDr());
	}
	
	public void categoryCreate_CategoryIndexing() throws IOException, InterruptedException, InvalidFormatException {
		Category_Action catAct = new Category_Action(driver);
		
		catAct.firstNewCatCreate();    		     // Creating First category
		catAct.setIndexesToFirstCat();           // Category indexing for 1st created category
		Thread.sleep(4000);
		
		catAct.create_childCategory1();   		 // Creating child category 1 , with First category as parent cat (cloned indexing of parent category)
		catAct.create_childCategory2();          // Creating child category 2 , with First category as parent cat (cloned indexing of parent category)
		Thread.sleep(4000);
		
		catAct.secondNewCatCreate();    		 // Creating Second category
		catAct.setIndexesToSecondCat();          // Category indexing for 2nd created category

	}
	 
	
	
	// method to create new category -- To create FIRST Category
	public void firstNewCatCreate() throws InterruptedException, IOException {
		WebButton.clickButton(catLocator.getDms());   // To enter into DMS / To click on DMS
		Reporter.log("Entered into DMS" + "<br>");
		
		String winID = driver.getWindowHandle();
		
		WebButton.clickButton(catLocator.getAddCat()); // To click on add category button
		Reporter.log("Clicked on Create Category button" + "<br>");
			Thread.sleep(3000);
			
			Set<String> handles = driver.getWindowHandles();
			for(String handle:handles) {
				if(!handle.equals(winID)) {
					driver.switchTo().window(handle);
					Thread.sleep(2000);
				}
			}
			
		WebTextBox.sendInput(catLocator.getNewCatName(),ExcelFileData.category1Name());
			Reporter.log("Entered category name: " + ExcelFileData.category1Name() + "<br>");
		catLocator.getNewCatName().sendKeys(Keys.ENTER);
		try {
			Thread.sleep(1000);
			System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']")).getText());
			Reporter.log(driver.findElement(By.xpath("//div[@class='modal-body']")).getText() + "<br>"); 
		} catch (NoSuchElementException e) {
			System.out.println(e);
			// TODO: handle exception
		} 
	}
	
	
	// SET INDEXES TO FIRST CATEGORY
			public void setIndexesToFirstCat() throws InterruptedException, IOException {
				// To click 'Set indexes to category' button against specific category 
				
				Thread.sleep(4000); 
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_DOWN).perform();
				Thread.sleep(4000);
				WebButton.clickButton(driver.findElement(By.xpath("//td[contains(text(),'"+ExcelFileData.category1Name()+"')]/following-sibling::td//i[@class='icon-retweet']"))); // catLocator.getSetIndexesToFirstCat()
				Thread.sleep(2000);
				// To enter IM into Select Index Master(s): TextBox
				WebButton.clickButton(catLocator.getSelectIM());
				WebTextBox.sendInput(catLocator.getSelectIM(), ExcelFileData.im1Name());
				WebTextBox.sendKeys(catLocator.getSelectIM(), Keys.ARROW_DOWN);
				WebTextBox.sendKeys(catLocator.getSelectIM(), Keys.ENTER);
					
				// To enter Mandatory IM into TextBox
				//WebButton.clickButton(catLocator.getMandatoryIM());
				//WebTextBox.sendInput(catLocator.getMandatoryIM(), excelRead.imName);			
				Thread.sleep(1000);
				//WebTextBox.sendKeys(catLocator.getMandatoryIM(), Keys.ARROW_DOWN);
				//WebTextBox.sendKeys(catLocator.getMandatoryIM(), Keys.ENTER);
				
				// To enter IG into TextBox
					try {
						catLocator.getSelectIG().click();
						Thread.sleep(1000);
						catLocator.getSelectIG().sendKeys(ExcelFileData.ig1Name());
						Thread.sleep(2000);
						catLocator.getSelectIG().sendKeys(Keys.ENTER);
						Thread.sleep(2000);
							action.sendKeys(Keys.ESCAPE).perform();
							Thread.sleep(3000);
						catLocator.getSelectIG().sendKeys(Keys.ESCAPE);
							Thread.sleep(2000);
							action.sendKeys(Keys.ESCAPE).perform();
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception : as  element click intercepted: exception occurring - other element may have received click 
					}
				
				// To click Select Doc Set DropDown arrow
				WebButton.clickButton(catLocator.getSelectDocSet());
				WebTextBox.sendInput(catLocator.getDocSetDropdownTextbox(), ExcelFileData.docset1Name());
				Thread.sleep(1000);
				catLocator.getDocSetDropdownTextbox().sendKeys(Keys.ENTER);
				
				// To click all Doc Set DropDown Values at once              
				Thread.sleep(1000);
				try {
					for(WebElement dcSetValue : catLocator.docSetValues) {
						Thread.sleep(1000);
						WebButton.clickButton(dcSetValue);
					}
				} catch (Exception e) {
					// TODO: handle exception    
				}
				
			  // To click 'Save' button on Set Indexes to Category page
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				WebButton.clickButton(catLocator.getSaveButton());
				
				Reporter.log("Category indexed with IG, IM and DocSet" + "<br>");
				
				// To find pop-up window on success of 'Set Indexes to category' 
				if(catLocator.getPopUpwindow().isDisplayed()) {
					System.out.println(catLocator.getTextSuccessful().getText());
					Reporter.log(catLocator.getTextSuccessful().getText() + "</br>");
					Thread.sleep(2000);
					if(driver.findElements(By.xpath("//a[@class='btn btn-success']")).size() >0) {
						Thread.sleep(2000);
						WebButton.clickButton(catLocator.getCloseButton());
						Thread.sleep(2000);
					}else if(driver.findElements(By.xpath("//a[text()='OK']")).size() >0) {
						Thread.sleep(2000);
						driver.findElement(By.xpath("//a[text()='OK']")).click();
						Thread.sleep(2000);
					}
					
				}
				
				WebButton.clickButton(catLocator.getBackButton());
			}

	
	
	
	
				// function to create child category 1 with parent category category -- Article Category (with cloned indexing of parent cat )
				public void create_childCategory1() throws InterruptedException, IOException {	
					Thread.sleep(5000);
					WebButton.clickButton(driver.findElement(By.xpath("//li[contains(text(),'"+ExcelFileData.category1Name()+"')]")));
					Thread.sleep(3000);
					
					WebButton.clickButton(catLocator.getCreateCat());               							// To click on add category button
					Reporter.log("Clicked on Create Category button" + "<br>");
						Thread.sleep(3000);
					WebTextBox.sendInput(catLocator.getNewCatName(),ExcelFileData.childCatgeory1());
					Reporter.log("Entered category name: " + ExcelFileData.childCatgeory1() + "<br>");
					
						Thread.sleep(2000);
						WebButton.clickButton(catLocator.getCloneCategory());       							// To click 'Clone from this Category:' dropDown 
						Thread.sleep(2000);
						WebTextBox.sendInput(catLocator.getReplicateCategory(), ExcelFileData.category1Name()); // To send category to Replicate
						Thread.sleep(2000);
						
						WebTextBox.sendKeys(catLocator.getReplicateCategory(), Keys.ENTER);
						Thread.sleep(2000);
						catLocator.getNewCatName().sendKeys(Keys.ENTER);
						
						try {
							Thread.sleep(1000);
							System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']")).getText());
							Reporter.log(driver.findElement(By.xpath("//div[@class='modal-body']")).getText() + "<br>"); 
						} catch (NoSuchElementException e) {
							System.out.println(e);
							// TODO: handle exception
						}	
						Thread.sleep(2000);
				}
				
				
				// // method to create child category 2 with parent category category -- Article Category (with cloned indexing of parent cat )
				public void create_childCategory2() throws InterruptedException, IOException {
					Thread.sleep(4000);
					
					WebButton.clickButton(catLocator.getCreateCat());               							// To click on add category button
					Reporter.log("Clicked on Create Category button" + "<br>");
						Thread.sleep(3000);
					WebTextBox.sendInput(catLocator.getNewCatName(),ExcelFileData.childCatgeory2());
					Reporter.log("Entered category name: " + ExcelFileData.childCatgeory2() + "<br>");
					
						Thread.sleep(2000);
						WebButton.clickButton(catLocator.getCloneCategory());       							// To click 'Clone from this Category:' dropDown 
						Thread.sleep(2000);
						WebTextBox.sendInput(catLocator.getReplicateCategory(), ExcelFileData.category1Name()); // To send category to Replicate
						Thread.sleep(2000);
						
						WebTextBox.sendKeys(catLocator.getReplicateCategory(), Keys.ENTER);
						Thread.sleep(2000);
						catLocator.getNewCatName().sendKeys(Keys.ENTER);
						
						try {
							Thread.sleep(1000);
							System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']")).getText());
							Reporter.log(driver.findElement(By.xpath("//div[@class='modal-body']")).getText() + "<br>"); 
						} catch (NoSuchElementException e) {
							System.out.println(e);
							// TODO: handle exception
						}	
						Thread.sleep(2000);
				
				}
				
	
	
	// method to create new category -- To create SECOND Category : With QC auto approve
	public void secondNewCatCreate() throws InterruptedException, IOException {	
		Thread.sleep(5000);
		WebButton.clickButton(catLocator.getHomeIcon());                // To click on home icon to navigate to previous 'Category Details' page (i.e. parent category)
		Thread.sleep(3000);
		
		WebButton.clickButton(catLocator.getCreateCat()); 			    // To click on add category button
		Reporter.log("Clicked on Create Category button" + "<br>");
			Thread.sleep(3000);
			
			
		WebTextBox.sendInput(catLocator.getNewCatName(),ExcelFileData.category2Name());
			Reporter.log("Entered category name: " + ExcelFileData.category2Name() + "<br>");
			
		WebButton.clickButton(catLocator.getTurnOffQCApproval()) ;      // To Tick 'QC Approval CheckBox' checkBox 
		Thread.sleep(2000);
			
		catLocator.getNewCatName().sendKeys(Keys.ENTER);
			try {
				Thread.sleep(1000);
				System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']")).getText());
				Reporter.log(driver.findElement(By.xpath("//div[@class='modal-body']")).getText() + "<br>"); 
			} catch (NoSuchElementException e) {
				System.out.println(e);
				// TODO: handle exception
			}
			
	}
	
	
	
	// SET INDEXES TO SECOND CATEGORY
			public void setIndexesToSecondCat() throws InterruptedException, IOException {
				// To click 'Set indexes to category' button against specific category 
				
				Thread.sleep(4000); 
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_DOWN).perform();
				Thread.sleep(4000);
				WebButton.clickButton(driver.findElement(By.xpath("//td[contains(text(),'"+ExcelFileData.category2Name()+"')]/following-sibling::td//i[@class='icon-retweet']")));  // catLocator.getSetIndexesToThirdCat()
				Thread.sleep(2000); 
				// To enter IM into Select Index Master(s): TextBox
				WebButton.clickButton(catLocator.getSelectIM());
				WebTextBox.sendInput(catLocator.getSelectIM(), ExcelFileData.im2Name());
				WebTextBox.sendKeys(catLocator.getSelectIM(), Keys.ARROW_DOWN);
				WebTextBox.sendKeys(catLocator.getSelectIM(), Keys.ENTER);
					
				// To enter Mandatory IM into TextBox
				//WebButton.clickButton(catLocator.getMandatoryIM());
				//WebTextBox.sendInput(catLocator.getMandatoryIM(), excelRead.imName);			
				Thread.sleep(1000);
				//WebTextBox.sendKeys(catLocator.getMandatoryIM(), Keys.ARROW_DOWN);
				//WebTextBox.sendKeys(catLocator.getMandatoryIM(), Keys.ENTER);
				
				// To enter IG into TextBox
					try {
						catLocator.getSelectIG().click();
						Thread.sleep(1000);
						catLocator.getSelectIG().sendKeys(ExcelFileData.ig2Name());
						Thread.sleep(2000);
						catLocator.getSelectIG().sendKeys(Keys.ENTER);
						Thread.sleep(2000);
							action.sendKeys(Keys.ESCAPE).perform();
							Thread.sleep(3000);
						catLocator.getSelectIG().sendKeys(Keys.ESCAPE);
							Thread.sleep(2000);
							action.sendKeys(Keys.ESCAPE).perform();
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception : as  element click intercepted: exception occurring - other element may have received click 
					}
				
				// To click Select Doc Set DropDown arrow
				WebButton.clickButton(catLocator.getSelectDocSet());
				WebTextBox.sendInput(catLocator.getDocSetDropdownTextbox(), ExcelFileData.docset2Name());
				Thread.sleep(1000);
				catLocator.getDocSetDropdownTextbox().sendKeys(Keys.ENTER);
				
				// To click all Doc Set DropDown Values at once              
				Thread.sleep(1000);
				try {
					for(WebElement dcSetValue : catLocator.docSetValues) {
						Thread.sleep(1000);
						WebButton.clickButton(dcSetValue);
					}
				} catch (Exception e) {
					// TODO: handle exception    
				}
				
			  // To click 'Save' button on Set Indexes to Category page
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				WebButton.clickButton(catLocator.getSaveButton());
				
				Reporter.log("Category indexed with IG, IM and DocSet" + "<br>");
				
				// To find pop-up window on success of  'Set Indexes to category' 
				if(catLocator.getPopUpwindow().isDisplayed()) {
					System.out.println(catLocator.getTextSuccessful().getText());
					Reporter.log(catLocator.getTextSuccessful().getText() + "</br>");
					Thread.sleep(2000);
					if(driver.findElements(By.xpath("//a[@class='btn btn-success']")).size() >0) {
					Thread.sleep(2000);
					WebButton.clickButton(catLocator.getCloseButton());
					Thread.sleep(2000);
					}else if(driver.findElements(By.xpath("//a[text()='OK']")).size() >0) {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//a[text()='OK']")).click();
					Thread.sleep(2000);
					}
				}
				
				WebButton.clickButton(catLocator.getBackButton());
			}
		
		
}
