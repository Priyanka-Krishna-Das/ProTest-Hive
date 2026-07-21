package com.pom;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TcDashboard {
	
	private WebDriver driver;
	SoftAssert sa = new SoftAssert();
	
	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	//Const
	public TcDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // PageFactory initialization
    }
	
	//Xpath
	 @FindBy(xpath = "//*[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb']")
	 private WebElement dropdownChangeLang;
	 
	 @FindBy(xpath = "//*[contains(text(),'English')]")
	 private WebElement selectEng;
	 
	 //Create technician
	 @FindBy(xpath = "//h6[contains(text(),'Office')]")
	 private WebElement sectionOffice;
	 
	 @FindBy(xpath = "//h6[contains(text(),'Internal T')]")
	 private WebElement sectionInternalTeam;
	 
	 @FindBy(xpath = "//button[contains(text(),'On site Technique')]")
	 private WebElement btnOnSiteTechni;
	 
	 @FindBy(xpath = "//button[contains(text(),'Create a new collaborator')]")
	 private WebElement btnCreateNewCollabTechni;
	 
	 @FindBy(xpath = "//input[contains(@name,'f_name')]")
	 private WebElement txtFirstNameTechni;
	 
	 @FindBy(xpath = "//input[contains(@name,'l_name')]")
	 private WebElement txtLastNameTechni;
	 
	 @FindBy(xpath = "//input[contains(@name,'mobile')]")
	 private WebElement txtMobileTechni;
	 
	 @FindBy(xpath = "//input[contains(@name,'email')]")
	 private WebElement txtEmailTechni;
	 
	 @FindBy(xpath = "//input[contains(@name,'newPassword')]")
	 private WebElement txtPassTechni;

	 @FindBy(xpath = "//input[contains(@name,'truckRegNo')]")
	 private WebElement txtTruckRegNoTechni;
	
	 @FindBy(xpath = "//input[contains(@name,'teamName')]")
	 private WebElement txtTeamNameTechni;

	 @FindBy(xpath = "//button[contains(text(),'Save')]")
	 private WebElement btnSaveTechni;
	 
	 //Lots
	 
	 @FindBy(xpath = "//*[contains(text(),'My Clients')]")
	 private WebElement sectionMyClients;
	 
	 @FindBy(xpath = "//*[contains(text(),'My Lots')]")
	 private WebElement sectionLots;
	 
	 @FindBy(xpath = "//button[contains(text(),'Create a Lot')]")
	 private WebElement btnCreateLot;
	 
	 @FindBy(xpath = "(//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl')])[8]")
	 private WebElement dropDownCAEPartner;
	 
	 @FindBy(xpath = "//li[contains(text(),'DelegateDocTest')]")
	 private WebElement listValueCAEPartner;
	 
	 @FindBy(xpath = "//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused')]")
	 private WebElement dropDownRefOpeartion;
	 
	 
	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[10]")
	 private WebElement dropDownAutonomusComunity;
	 
	 @FindBy(xpath = "(//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl')])[12]")
	 private WebElement dropDownStatus;
	 
	 @FindBy(xpath = "//button[contains(text(),'Save')]")
	 private WebElement btnSaveLot;
	 
	 //Work file creation
	 @FindBy(xpath = "//span[contains(text(),'My Work Files')]")
	 private WebElement sectionMyWorkFile;
	 
	 @FindBy(xpath = "//button[contains(text(),'Create a Works File')]")
	 private WebElement btnCreateAWorkFile;
	 
	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[2]")
	 private WebElement dropdownSelectLead;
	 
	 @FindBy(xpath = "//li[contains(text(),'(L/VC-10797) Priyanka1 Das')]")
	 private WebElement selectLeadFromDropDown;
	 
	 @FindBy(xpath = "//button[contains(text(),'Next')]")
	 private WebElement btnNext1;
	 
	 @FindBy(xpath = "//div[contains(@class,'MuiAutocomplete-endAdornment')]")
	 private WebElement dropDownValoPartner; //SendKeys "del" ->keydown->enter
	 
	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[2]")
	 private WebElement dropdownConvOpe;
	 
	 @FindBy(xpath = "//li[contains(text(),'new')]")
	 private WebElement selectConvOpeFromDropDown;
	 
	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput')])[3]")
	 private WebElement dropDownCAEDeals;
	 
	 @FindBy(xpath = "//li[contains(text(),'DEAL-DE985/OC968/10157')]")
	 private WebElement selectCAEDeals;
	 
	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput')])[4]")
	 private WebElement dropdownSelectlot;
	 
	 @FindBy(xpath = "//li[contains(text(),'LOT-DE985/VC-RES020/10905')]")
	 private WebElement selectLots;
	 
	 @FindBy(xpath = "//button[contains(text(),'Next')]")
	 private WebElement btnNext2;
	 
	 @FindBy(xpath = "//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused')]")
	 private WebElement dropDwonSelctOpeServices; //click>>down>enter
	 
	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[2]")
	 private WebElement dropDwonDesignOffice;
	 
	 @FindBy(xpath = "//li[contains(text(),'Glover and Blair Inc')]")
	 private WebElement selctDesignOffice;
	 
	 @FindBy(xpath = "//button[contains(text(),'Confirm')]")
	 private WebElement btnConfirm;
	 
	 //Workfile>>Cust Appt
//	 @FindBy(xpath = "//span[contains(text(),'Customer Appointments')]")
//	 private WebElement tabClientAppt;
	 
	 @FindBy(xpath = "(//div[@role='tabpanel']//span[normalize-space()='Customer Appointments'])[2]")
	 private WebElement tabClientAppt;
	 
	 @FindBy(xpath = "//button[contains(text(),'Create a new appointment')]")
	 private WebElement btnCreateAppt;
	 
	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[2]")
	 private WebElement dropDownApptType;
	 
	 @FindBy(xpath = "//li[contains(text(),'Previsit Appt.')]")
	 private WebElement selectApptType;
	 
	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[3]")
	 private WebElement dropDownTypeOfPrevisit;
	 
	 @FindBy(xpath = "//li[contains(text(),'Presential')]")
	 private WebElement selectTypeOfPrevisit;
	 
	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[4]")
	 private WebElement dropDownTechnicianName;
	 
	 @FindBy(xpath = "//li[contains(text(),'Mobile Testing')]")
	 private WebElement selectTechni;
	 
	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[2]")
	 private WebElement txtDate;
	 
	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]")
	 private WebElement dropDwonHours;  //sendkeys->down->enter
	 
	 @FindBy(xpath = "//button[contains(text(),'Save')]")
	 private WebElement btnSaveClientAppt;

	 
	 //WorkFile -> Tab technical
	 @FindBy(xpath = "//span[contains(text(),'Technical')]")
	 private WebElement tabTechnical;
	 
	 //Start previsit form
	 @FindBy(xpath = "//button[contains(text(),'Start Previsit')]")
	 private WebElement btnStartPrevisit;
	 
	 @FindBy(xpath = "//button[contains(text(),'Attic')]")
	 private WebElement btnAttic;
	 
//	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[3]")
//	 private WebElement dropdownAtticType;
//	 
//	 @FindBy(xpath = "//li[contains(text(),'Lost')]")
//	 private WebElement selectAtticType;
//	 
//	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[4]")
//	 private WebElement dropDownAccessType;
//	 
//	 @FindBy(xpath = "//li[contains(text(),'Retractable Stairs')]")
//	 private WebElement selectAccessType;
//	 
//	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[5]")
//	 private WebElement dropDownFloorType;
//	 
//	 @FindBy(xpath = "//li[contains(text(),'Brick')]")
//	 private WebElement selectFloorType;
//	 
//	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[1]")
//	 private WebElement txtFlooreThickness;
//	 
//	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[6]")
//	 private WebElement dropDownInsulationType;
//	 
//	 @FindBy(xpath = "//li[contains(text(),'No Insulation')]")
//	 private WebElement selectIsulationType;
//	 
//	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[7]")
//	 private WebElement dropDownVentilation;
//	 
//	 @FindBy(xpath = "//li[contains(text(),'Natural Ventilation')]")
//	 private WebElement selectVentilation;
//	 
//	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[2]")
//	 private WebElement txtAtticLength;
//	 
//	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]")
//	 private WebElement txtAtticWidth;
//	 
//	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[4]")
//	 private WebElement txtInternalRidgeHeight;
//	 
//	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[5]")
//	 private WebElement txtHalfSpan;
//	 
//	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[6]")
//	 private WebElement txtSurfaceToInsulate;
//	 
//	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[7]")
//	 private WebElement txtTotalSurface;
//	 
//	 @FindBy(xpath = "(//div[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[8]")
//	 private WebElement dropDownRecommendedMaterial;
//	 
//	 @FindBy(xpath = "//li[contains(text(),'Blown mineral wool')]")
//	 private WebElement selectRecommendedMaterial;
//	 
//	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[8]")
//	 private WebElement txtReccomenedThickness;
	 
	 
	 @FindBy(xpath = "//input[contains(@name,'atticWidth')]")
	 private WebElement txtAtticWidthL;
	 
	 @FindBy(xpath = "(//input[contains(@name,'attic.atticHalfSpanHorizontal')])[1]")
	 private WebElement txtAtticWidthL1;
	 
	 @FindBy(xpath = "(//input[contains(@name,'attic.atticHalfSpanHorizontal')])[2]")
	 private WebElement txtAtticWidthL2;
	 
	 @FindBy(xpath = "(//input[contains(@name,'attic.atticHalfSpanHorizontal')])[3]")
	 private WebElement txtAtticWidthL3;
	 
	 @FindBy(xpath = "(//input[contains(@name,'attic.h')])[1]")
	 private WebElement txtH;
	 
	 @FindBy(xpath = "//input[contains(@name,'attic.h1')]")
	 private WebElement txtH1;
	 
	 @FindBy(xpath = "//input[contains(@name,'attic.h2')]")
	 private WebElement txtH2;
	 
	 @FindBy(xpath = "//select[contains(@name,'atticType')]")
	 private WebElement selectAtticType;
	 
	 @FindBy(xpath = "//select[contains(@name,'accessType')]")
	 private WebElement selectAccessType;
	 
	 @FindBy(xpath = "//button[contains(@type,'button') and contains(@class,'flex items-center gap-1 text-[10px] font-semibold text-bl')]")
	 private WebElement BtnEditFloorType;
	 
	 @FindBy(xpath = "//select[contains(@class,'w-full px-3 py-2 text-sm border border-slate-200 rounded-lg')]")
	 private WebElement selectFloorType;
	 
	 
	 @FindBy(xpath = "//input[contains(@class,'w-full px-3 py-2 text-sm border border-slate-200')]")
	 private WebElement txtFloorThickness;
	 
	 
	 @FindBy(xpath = "//button[contains(text(),'Add Floor Type')]")
	 private WebElement btnAddFloorType;
	 
	 
	 @FindBy(xpath = "//button[contains(@class,'p-1 rounded-lg hover:bg-blue-100 transition-colors')]")
	 private WebElement btnCross;
	 
	 
	 @FindBy(xpath = "//input[contains(@name,'attic.totalSurface')]")
	 private WebElement txttotalSurface;
	 
	 @FindBy(xpath = "//input[contains(@name,'attic.attic1')]")
	 private WebElement txttotalSurface1;
	 
	 @FindBy(xpath = "//input[contains(@name,'attic.attic2')]")
	 private WebElement txttotalSurface2;
	 
	 @FindBy(xpath = "//input[contains(@name,'attic.surfaceToInsulate')]")
	 private WebElement txtSurfaceToInsulate;
	 
	 
	 @FindBy(xpath = "//select[@name='attic.insulationType']")
	 private WebElement selectInsulationType;
	 
	 
	 @FindBy(xpath = "//select[@name='attic.ventilation']")
	 private WebElement selectVentilation;
	 
	 
	 //material
	 
	 @FindBy(xpath = "//select[@name='attic.materialToInstall']")
	 private WebElement selectMaterialToInstall;
	 
	 @FindBy(xpath = "//input[@name='attic.insulationThicknessToInstall']")
	 private WebElement txtInsulationThicknessToInstall;

	 
	 //Roof slopes
	 
	 @FindBy(xpath = "//select[@name='roofSlopes.rampantsType']")
	 private WebElement selectRampantsTypes;
	
	 
	 @FindBy(xpath = "//select[@name='roofSlopes.roofType']")
	 private WebElement selectRoofType;
	 
	 
	 @FindBy(xpath = "//select[@name='roofSlopes.imperfectionsAirLeaks']")
	 private WebElement selectAirLeaks;
	 
	 @FindBy(xpath = "//button[contains(text(),'Next')]")
	 private WebElement btnNextAttic;
	 
	 //WorkFile -> Audit tab
	 @FindBy(xpath = "//span[contains(text(),'Audit')]")	
	 private WebElement tabAudit;
	 
	 @FindBy(xpath = "//select[contains(@name,'calculation.manufacturer')]")	
	 private WebElement dropDownManufacturer;
	 
	 
	 @FindBy(xpath = "//select[contains(@name,'calculation.reference')]")	
	 private WebElement dropDownReference;	
	 
	 
	 @FindBy(xpath = "//button[contains(text(),'Confirm')]")	
	 private WebElement btnAuditConfirm;
	 
	 @FindBy(xpath = "//input[contains(@class,'w-full px-3 py-2 border border-gray-200 rounded-lg text-sm text-gray-900 focus:outline-none focus:ring-2 focus:ring-teal-500 focus:border-transparent bg-gray-50 text-gray-500 cursor-not-allowed')]")	
	 private WebElement txtAETotal; //getText
	 
//	 @FindBy(xpath = "//button[contains(text(),'View')]")	
//	 private WebElement btnView;
//	 
//	 @FindBy(xpath = "(//h6[contains(@class,'MuiTypography-root MuiTypography-h6 css-13h6wm')])[6]")	
//	 private WebElement txtAETotalAfterView;  //getText
	 


	 //Action method
	 
	 public void clickDropdownChangeLang()
	 {
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.elementToBeClickable(dropdownChangeLang));
	     ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].click();", dropdownChangeLang);
	     // System.out.println("the -----");
	 }
	 
	 public void clickSelectEng()
	 {
		 selectEng.click();
	 }
	 
	 //Create technician
	
	 public void clickSectionOffice()
	 {
		 sectionOffice.click();
	 }
	 

	 public void clickSectionInternalTeam()
	 {
		 sectionInternalTeam.click();
	 }
	 

	 public void clickBtnOnSiteTechni()
	 {
		 btnOnSiteTechni.click();
	 }
	 

	 public void clickBtnCreateNewCollabTechni()
	 {
		 btnCreateNewCollabTechni.click();
	 }
	 

	 public void enterTxtFirstNameTechni()
	 {
		 String TechniFirstName= "testTechni" + RandomStringUtils.randomNumeric(2);
		 txtFirstNameTechni.sendKeys(TechniFirstName);
	 }
	 

	 public void enterTxtLastNameTechni()
	 {
		 String TechniLastName= "LastName" + RandomStringUtils.randomNumeric(2);
		 txtLastNameTechni.sendKeys(TechniLastName);
	 }
	 

	 public void enterTxtMobileTechni()
	 {
		 String techniMobile= RandomStringUtils.randomNumeric(10);
		 txtMobileTechni.sendKeys(techniMobile);
	 }
	 

	 public void enterTxtEmailTechni()
	 {

		 String techniEmail= "testEmail" + RandomStringUtils.randomNumeric(2) + "@gmail.com";
		 txtEmailTechni.sendKeys(techniEmail);
	 }
	 

	 public void enterTxtPassTechni()
	 {
		 String techniPass= "Password@123";
		 txtPassTechni.sendKeys(techniPass);
	 }

	 public void enterTxtTruckRegNoTechni()
	 {
		 String techniTruckRegNo= "123" + RandomStringUtils.randomNumeric(2);
		 txtTruckRegNoTechni.sendKeys(techniTruckRegNo);
	 }
	

	 public void enterTxtTeamNameTechni()
	 {
		 String techniTeamName= "Techniteam" + RandomStringUtils.randomNumeric(2) + RandomStringUtils.randomAlphabetic(2);
		 txtTeamNameTechni.sendKeys(techniTeamName);
	 }


	 public void clickBtnSaveTechni()
	 {
		 btnSaveTechni.click();
	 }
	 
	 
	 //Create lot
	 
	 public void clickSectionMyClients()
	 {
		 sectionMyClients.click();
	 }
	 
	 
	 public void clickSectionLots()
	 {
		// sectionLots.click();
		 ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].click();", sectionLots);
	 }
	 
	 
	 public void clickBtnCreateLot()
	 {
		 btnCreateLot.click();
	 }
	 
	 public void clickDropDownCAEPartner()
	 {
		 dropDownCAEPartner.click();
		 listValueCAEPartner.click();
	 }
	 
	 
	 public void clickDropDownRefOpeartion(String refOpeartion)
	 {
		 dropDownRefOpeartion.click();
		 dropDownRefOpeartion.sendKeys(refOpeartion);
		 Actions act = new Actions(driver);
			
		 act.sendKeys(Keys.DOWN).pause(300).sendKeys(Keys.ENTER).perform();
		 
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		    // 1. Wait and click to focus
//		    wait.until(ExpectedConditions.elementToBeClickable(dropDownRefOpeartion))
//		        .click();
//
//		    Actions actions = new Actions(driver);
//
//		    // 2. Pass text
//		    // 3. Key DOWN
//		    // 4. ENTER
//		    actions.sendKeys(refOpeartion)
//		           .pause(Duration.ofMillis(300))
//		           .sendKeys(Keys.DOWN)
//		           .pause(Duration.ofMillis(200))
//		           .sendKeys(Keys.ENTER)
//		           .build()
//		           .perform();
//		
 }
	 

	 public void clickDropDownAutonomusComunity()
	 {
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	     wait.until(ExpectedConditions.elementToBeClickable(dropDownAutonomusComunity));
//	     ((JavascriptExecutor) driver)
//	        .executeScript("arguments[0].click();", dropDownAutonomusComunity);	 
		 
		 dropDownAutonomusComunity.click();
		 Actions act = new Actions(driver);
		
		 act.sendKeys(Keys.UP).pause(300).sendKeys(Keys.ENTER).perform();
	 }
	 
	 
	 public void clickDropDownStatus()
	 {
		 dropDownStatus.click();
		 Actions act = new Actions(driver);
			
		 act.sendKeys(Keys.DOWN).pause(300).sendKeys(Keys.ENTER).perform();
	 }
	 

	 public void clickBtnSaveLot()
	 {
		 btnSaveLot.click();
		 
	 }
	 
	//Work file creation
		
		 public void clickSectionMyWorkFile()
		 {
			 sectionMyWorkFile.click();
		 }
		 

		 public void clickBtnCreateAWorkFile()
		 {
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnCreateAWorkFile);
		 }
		 

		 public void clickDropdownSelectLead()
		 {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].scrollIntoView(true);", dropdownSelectLead);
			 dropdownSelectLead.click();
			// dropdownSelectLead.click();
		 }
		 

		 public void clickSelectLeadFromDropDown()
		 {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].scrollIntoView(true);", selectLeadFromDropDown);
			 selectLeadFromDropDown.click();
		 }
		 

		 public void clickBtnNext1()
		 {
			 //btnNext1.click();
//			 JavascriptExecutor js = (JavascriptExecutor) driver;
//			 js.executeScript("arguments[0].click();", btnNext1);
			 
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			 WebElement nextBtn = wait.until(
			         ExpectedConditions.elementToBeClickable(btnNext1)
			 );
			 nextBtn.click();
		 }
		 

		 public void clickDropDownValoPartner(String valoPartner) throws InterruptedException
		 {
				/*
				 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 * 
				 * wait.until(ExpectedConditions.elementToBeClickable(dropDownValoPartner));
				 * 
				 * Actions act = new Actions(driver); act.moveToElement(dropDownValoPartner)
				 * .click() .sendKeys(valoPartner) .sendKeys(Keys.DOWN) .sendKeys(Keys.ENTER)
				 * .build() .perform();
				 */
			 
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			    WebElement dropdown = wait.until(
			            ExpectedConditions.elementToBeClickable(dropDownValoPartner));

			    // 1️⃣ Click dropdown
			    dropdown.click();

			    // 2️⃣ Wait small time for panel to open
			    try {
			        Thread.sleep(1000);
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }

			    // 3️⃣ Send keys to ACTIVE element (important change)
			    WebElement activeElement = driver.switchTo().activeElement();

			    activeElement.sendKeys(valoPartner);

			    Thread.sleep(1000);

			    activeElement.sendKeys(Keys.DOWN);
			    activeElement.sendKeys(Keys.ENTER);
		 }
		 
		 
		 public void clickDropdownConvOpe()
		 {
			 dropdownConvOpe.click();
		 }
		 

		 public void clickSelectConvOpeFromDropDown()
		 {
			 selectConvOpeFromDropDown.click();
		 }
		 

		 public void clickDropDownCAEDeals()
		 {
			 dropDownCAEDeals.click();
		 }
		 

		 public void clickSelectCAEDeals()
		 {
			 selectCAEDeals.click();
		 }
		 

		 public void clickDropdownSelectlot()
		 {
			 dropdownSelectlot.click();
		 }
		 

		 public void clickSelectLots()
		 {
			 selectLots.click();
		 }
		 

		 public void clickBtnNext2()
		 {
			 btnNext2.click();
		 }
		 

		 public void clickDropDwonSelctOpeServices() throws InterruptedException
		 {
			 dropDwonSelctOpeServices.click();
			 Thread.sleep(5000);
			 Actions act = new Actions(driver);
			 act.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		 }
		 

		 public void clickDropDwonDesignOffice()
		 {
			 dropDwonDesignOffice.click();
		 }
		 

		 public void clickSelctDesignOffice()
		 {
			 selctDesignOffice.click();
		 }
		 

		 public void clickBtnConfirm()
		 {
			 btnConfirm.click();
		 }
		 
		 //Workfile>>Cust Appt

		 public void clickTabClientAppt()
		 {
			 
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.elementToBeClickable(tabClientAppt));
			 
//			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//			 System.out.println("Clicking Customer Appointment Tab");
//
//
//			    WebElement tab = wait.until(ExpectedConditions.visibilityOfElementLocated(
//			            By.xpath("(//span[normalize-space()='Customer Appointments'])[1]")));
//
//			    JavascriptExecutor js = (JavascriptExecutor) driver;
//			    js.executeScript("arguments[0].click();", tab);
			    
			 
//			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//			    for (int i = 0; i < 2; i++) {
//			        try {
//			            //wait.until(ExpectedConditions.elementToBeClickable(tabClientAppt)).click();
//			        	JavascriptExecutor js = (JavascriptExecutor) driver;
//						 js.executeScript("arguments[0].click();", tabClientAppt);
//			            
//			            break;
//			        } catch (StaleElementReferenceException e) {
//			            // retry
//			        }
//			    }
			    
//			    JavascriptExecutor js = (JavascriptExecutor) driver;
//				 js.executeScript("arguments[0].click();", tabClientAppt);
//				 selectLeadFromDropDown.click();
		 }
		 

		 public void clickBtnCreateAppt()
		 {
			 btnCreateAppt.click();
		 }
		 

		 public void clickDropDownApptType()
		 {
			 dropDownApptType.click();
		 }
		 

		 public void clickSelectApptType()
		 {
			 selectApptType.click();

		 }
		 
		 public void clickSelectTypeOfPrevisit()
		 {
			 
//			 JavascriptExecutor js = (JavascriptExecutor) driver;
//			 js.executeScript("arguments[0].click();", dropDownTypeOfPrevisit);
			 
//			 Actions actions = new Actions(driver);
//			 actions.moveToElement(dropDownTypeOfPrevisit).click().perform();
			 
			 WebElement refreshedElement = wait.until(ExpectedConditions.refreshed(
				        ExpectedConditions.elementToBeClickable(dropDownTypeOfPrevisit)));
				refreshedElement.click();
			 
//			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//			 WebElement dropDownTypeOfPrevisit1 = wait.until(ExpectedConditions.elementToBeClickable(dropDownTypeOfPrevisit));
//			 
//			 JavascriptExecutor js = (JavascriptExecutor) driver;
//			 js.executeScript("arguments[0].click();", dropDownTypeOfPrevisit1);
			 

			 selectTypeOfPrevisit.click();
		 }
		 

		 public void clickDropDownTechnicianName()
		 {
			 dropDownTechnicianName.click();
		 }
		 

		 public void clickSelectTechni()
		 {
			 //selectTechni.click();
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].click();", selectTechni);
		 }
		 

		 public void enterTxtDate(String date)
		 {
			 txtDate.sendKeys("date");
			 Actions act = new Actions(driver);
			 act.sendKeys("date");
		 }
		 

		 public void clickDropDwonHours(String hours)
		 {
			 dropDwonHours.sendKeys(hours);
			 Actions act = new Actions(driver);
			 act.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		 }
		 

		 public void clickBtnSaveClientAppt()
		 {
			 btnSaveClientAppt.click();
		 }

		 
		 //WorkFile -> Tab technical

		 public void clickTabTechnical()
		 {
			 tabTechnical.click();
		 }
		 
		 //Start previsit form

		 public void clickBtnStartPrevisit()
		 {
			 btnStartPrevisit.click();
		 }
		 

		 public void clickBtnAttic()
		 {

			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].click();", btnAttic);
		 }
		 

//		 public void clickDropdownAtticType()
//		 {
//			 //dropdownAtticType.click();
////			 WebElement refreshedElement = wait.until(ExpectedConditions.refreshed(
////				        ExpectedConditions.elementToBeClickable(dropdownAtticType)));
////				refreshedElement.click();
//			 
//			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//			    for (int i = 0; i < 2; i++) {
//			        try {
//			            WebElement refreshedElement = wait.until(
//			                    ExpectedConditions.elementToBeClickable(dropdownAtticType));
//
//			            refreshedElement.click();
//			            break;  // exit loop if success
//			        } 
//			        catch (StaleElementReferenceException e) {
//			            System.out.println("Stale element, retrying...");
//			        }
//			    }
//		 }
		 

//		 public void clickSelectAtticType()
//		 {
//			 selectAtticType.click();
//		 }
//		 
//
//		 public void clickDropDownAccessType()
//		 {
//			 dropDownAccessType.click();
//		 }
//		 
//
//		 public void clickSelectAccessType()
//		 {
//			 selectAccessType.click();
//		 }
//		 
//
//		 public void clickDropDownFloorType()
//		 {
//			 dropDownFloorType.click();
//		 }
//		 
//
//		 public void clickSelectFloorType()
//		 {
//			 selectFloorType.click();
//		 }
//		 
//
//		 public void enterTxtFlooreThickness(String flooreThickness)
//		 {
//			 txtFlooreThickness.sendKeys(flooreThickness);
//		 }
//		 
//
//		 public void clickDropDownInsulationType()
//		 {
//			 dropDownInsulationType.click();
//		 }
//		 
//
//		 public void clickSelectIsulationType()
//		 {
//			 selectIsulationType.click();
//		 }
//		 
//
//		 public void clickDropDownVentilation()
//		 {
//			 dropDownVentilation.click();
//		 }
//		 
//
//		 public void clickSelectVentilation()
//		 {
//			 selectVentilation.click();
//		 }
//		 
//
//		 public void enterTxtAtticLength(String atticLength)
//		 {
//			 txtAtticLength.sendKeys(atticLength);
//		 }
//		 
//
//		 public void enterTxtAtticWidth(String atticWidth)
//		 {
//			 txtAtticWidth.sendKeys(atticWidth);
//		 }
//		 
//
//		 public void enterTxtInternalRidgeHeight(String internalRidgeHeight)
//		 {
//			 txtInternalRidgeHeight.sendKeys(internalRidgeHeight);
//		 }
//		 
//
//		 public void enterTxtHalfSpan(String halfSpan)
//		 {
//			 txtHalfSpan.sendKeys(halfSpan);
//		 }
//		 
//
//		 public void enterTxtSurfaceToInsulate(String surfaceToInsulate)
//		 {
//			 txtSurfaceToInsulate.sendKeys(surfaceToInsulate);
//		 }
//		 
//
//		 public void enterTxtTotalSurface(String totalSurface)
//		 {
//			 txtTotalSurface.sendKeys(totalSurface);
//		 }
//		 
//
//		 public void clickDropDownRecommendedMaterial()
//		 {
//			 dropDownRecommendedMaterial.click();
//			 selectRecommendedMaterial.click();
//		 }
//		 
//
//		 public void enterTxtReccomenedThickness(String recommendationThickness)
//		 {
//			 txtReccomenedThickness.sendKeys(recommendationThickness);
//		 }
		 
		 

		 public void enterTxtAtticWidthL(String atticWidthL)
		 {
			 txtAtticWidthL.sendKeys(atticWidthL);		 }
		 

		 public void enterTxtAtticWidthL1(String atticWidthL1)
		 {
			 txtAtticWidthL1.sendKeys(atticWidthL1);

		 }
		 
		 public void enterTxtAtticWidthL2(String atticWidthL2)
		 {
			 txtAtticWidthL2.sendKeys(atticWidthL2);
		 }
		 

		 public void enterTxtAtticWidthL3(String atticWidthL3)
		 {
			 txtAtticWidthL3.sendKeys(atticWidthL3);
		 }

		 public void enterTxtH(String H)
		 {
			 txtH.sendKeys(H);

		 }
		 

		 public void enterTxtH1(String H1)
		 {
			 txtH1.sendKeys(H1);
		 }
		 

		 public void enterTxtH2(String H2)
		 {
			 txtH2.sendKeys(H2);
		 }
		 
		 public void clickDropDownAtticType()
		 {
			 
			 Select atticType = new Select(selectAtticType);
			 atticType.selectByVisibleText("Lost");
		 }
		 

		 public void clickDropDownAccessType()
		 {
			 Select accessType = new Select(selectAccessType);
			 accessType.selectByVisibleText("Fixed Stairs");
		 }
		 

		 public void clickBtnEditFloorType()
		 {
			 BtnEditFloorType.click();

		 }
		 

		 public void clickSelectFloorType()
		 {
			 Select floorType = new Select(selectFloorType);
			 floorType.selectByVisibleText("Plaster");
		 }
		 
		 
		 public void enterTxtFloorThickness(String floorthickness)
		 {
			 txtFloorThickness.sendKeys(floorthickness);
		 }
		 
		 
		 public void clickBtnAddFloorType()
		 {
			 btnAddFloorType.click();
		 }
		 
		 
		 public void clickBtnCross()
		 {
			 btnCross.click();
		 }
		 
		 
		 public void enterTxttotalSurface(String totalSurface)
		 {
			 txttotalSurface.sendKeys(totalSurface);
		 }
		 

		 public void enterTxttotalSurface1(String totalSurface1)
		 {
			 txttotalSurface1.sendKeys(totalSurface1);
		 }
		 

		 public void enterTxttotalSurface2(String totalSurface2)
		 {
			 txttotalSurface2.sendKeys(totalSurface2);
		 }
		 
		 public void enterTxtSurfaceToInsulate(String SurfaceToInsulate)
		 {
			 txtSurfaceToInsulate.sendKeys(SurfaceToInsulate);
		 }
		 
		 

		 public void clickDropDownSelectInsulationType()
		 {
			 Select insulationType = new Select(selectInsulationType);
			 insulationType.selectByVisibleText("No Insulation");
		 }
		 
		 
		 public void clickDropDownSelectVentilation()
		 {
			 Select Ventilation = new Select(selectVentilation);
			 Ventilation.selectByVisibleText("Mechanical Ventilation");
		 }
		 
		 
		 //material
		 
		 public void clickDropDownSelectMaterialToInstall()
		 {
			 Select materialToInstall = new Select(selectMaterialToInstall);
			 materialToInstall.selectByVisibleText("Blown mineral wool");
		 }
		 

		 public void enterTxtInsulationThicknessToInstall(String insulationThicknessToInstall)
		 {
			 txtInsulationThicknessToInstall.sendKeys(insulationThicknessToInstall);
		 }
		 
		 
		 
		 //WorkFile -> previst form -> Attic -> Roof slopes

		 public void clickDropDownRampantsTypes()
		 {
			 Select rampantsTypes = new Select(selectRampantsTypes);
			 rampantsTypes.selectByVisibleText("Wood");
		 }
		 

		 public void clickDropDownRoofType()
		 {
			 Select roofType = new Select(selectRoofType);
			 roofType.selectByVisibleText("Two Slopes");
		 }
		 

		 public void clickDropDownAirLeaks()
		 {
			 Select airLeaks = new Select(selectAirLeaks);
			 airLeaks.selectByVisibleText("YES");
		 }

		 public void clickBtnNextAttic()
		 {
			 btnNextAttic.click();
		 }
		 
		 
		 //WorkFile -> Audit tab

		 public void clickTabAudit()
		 {
			//tabAudit.click();
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].click();", tabAudit);
			 
//			 WebElement refreshedElement = wait.until(ExpectedConditions.refreshed(
//				        ExpectedConditions.elementToBeClickable(tabAudit)));
//				refreshedElement.click();
			 
			 
		 }
		 

		 public void clickDropDownManufacturer()
		 {
			// dropDownManufacturer.click();
			 Select manufacture = new Select(dropDownManufacturer);
			 manufacture.selectByVisibleText("ISOVER");
		 }
		 

//		 public void clickSelectManufacturer()
//		 {
//			 //selectManufacturer.click();
//			 JavascriptExecutor js = (JavascriptExecutor) driver;
//			 js.executeScript("arguments[0].click();", selectManufacturer);
//		 }
		 

		 public void clickDropDownReference()
		 {
			 //dropDownReference.click();
			 Select refrence = new Select(dropDownReference);
			 refrence.selectByVisibleText("ISOLENE4");
			 
		 }
		 

//		 public void clickSelectReference() throws InterruptedException
//		 {
//			 //selectReference.click();
//			 JavascriptExecutor js = (JavascriptExecutor) driver;
//			 js.executeScript("arguments[0].click();", selectReference);
//			 Thread.sleep(2000);
//		 }
		 

		 public void clickBtnAuditConfirm()
		 {
			 //btnAuditConfirm.click();
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].click();", btnAuditConfirm);
		 }
		 
		 public void clickTabAudit1()
		 {
			//tabAudit.click();
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].click();", tabAudit);
			 
		 }

		 public void dispTxtAETotal() throws InterruptedException
		 {
	
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			 WebElement total = wait.until(ExpectedConditions.visibilityOf(txtAETotal));

//			 String displayTextAETotal2 = txtAETotal.getAttribute("value");
//			 System.out.println("AE Total: " + displayTextAETotal2);
			 
			 String displayTextAETotal1=total.getAttribute("value");// bcz here tag is input so need need to fetch input value not text
			 System.out.println("AE total is: "+displayTextAETotal1);
			 
			 //SoftAssert sf = new SoftAssert();
			 if(displayTextAETotal1.equalsIgnoreCase("15007"))
			 {
				 sa.assertTrue(true, "Calculation passed");
				 System.out.println("Calculation passed-15007 : "+displayTextAETotal1);
			 }
			 else {
				 sa.assertTrue(false, "Calculation failed");
				 System.out.println("Calculation failed - "+displayTextAETotal1);
			 
			 }
			 
			 
//			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//			    wait.until(driver ->  !txtAETotal.getAttribute("value").trim().isEmpty() );
//
//			    String displayTextAETotal1 = txtAETotal.getAttribute("value").trim();
//
//			    System.out.println("AE total is: " + displayTextAETotal1);
//
//			    Assert.assertEquals(displayTextAETotal1, "24252", "Calculation failed");
		 }
		 

//		 public void clickBtnView()
//		 {
//			 //btnView.click();
//			 
//			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//			 WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(btnView));
//			 
//			 JavascriptExecutor js = (JavascriptExecutor) driver;
//			 js.executeScript("arguments[0].click();", btn);
//		 }
//		 
//
//		 public void clickTxtAETotalAfterView() throws InterruptedException
//		 {
//			 //btnCreateLot.click();
//			 Thread.sleep(3000);
//			 
//			 String displayTextAETotal1=txtAETotalAfterView.getText();
//			 System.out.println("AE total after view: "+displayTextAETotal1);
//			 
//			 //SoftAssert sf = new SoftAssert();
//			 if(displayTextAETotal1.equalsIgnoreCase("15007"))
//			 {
//				 sa.assertTrue(true, "Calculation passed");
//			 }
//			 else {
//				 sa.assertTrue(false, "Calculation failed");
//			 }
//		 }
}

