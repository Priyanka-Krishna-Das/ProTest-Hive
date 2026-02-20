package com.pom;


import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class DelegateDashboard {

	private WebDriver driver;
	SoftAssert sa = new SoftAssert();
	
	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	//Const
	public DelegateDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // PageFactory initialization
    }
	
	//Xpath
	 @FindBy(xpath = "//*[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb']")
	 private WebElement dropdownChangeLang;
	 
	 @FindBy(xpath = "//*[contains(text(),'English')]")
	 private WebElement selectEng;
	 
	 //Batch
	 @FindBy(xpath = "//h6[contains(text(),'My Clients')]")
	 private WebElement sectionMyClientsDelegate;
	 
	 @FindBy(xpath = "//*[contains(text(),'My Batch')]")
	 private WebElement sectionMyBatch;
	 
	 @FindBy(xpath = "//button[contains(text(),'Create Batch')]")
	 private WebElement btnCreateBatch;
	 
	 @FindBy(xpath = "//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused')]")
	 private WebElement dropdownCAEOpe;  //Sendkeys -> enter
	 
	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[5]")
	 private WebElement dropDownAutoCommunity;  //keyDown -> enter
	 
	 @FindBy(xpath = "(//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')])[6]")
	 private WebElement dropDownStatus;  //keyDown -> enter
	 
	 @FindBy(xpath = "//button[contains(text(),'Save')]")
	 private WebElement btnSaveBatch;
	 
	 
	 //External partners
	 //CRO - Collab req
	 @FindBy(xpath = "//h6[contains(text(),'My Partn')]")
	 private WebElement sectionMyPartner;
	 
	 @FindBy(xpath = "//button[contains(text(),'Create a New Partner')]")
	 private WebElement btnNewCollabReq;
	 
	 @FindBy(xpath = "//input[contains(@name,'cifNumber')]")
	 private WebElement txtBoxCifNumber;
	 
	 @FindBy(xpath = "//button[contains(text(),'Enter')]")
	 private WebElement btnEnter;
	 
	 @FindBy(xpath = "//button[contains(text(),'Request for collaboration')]")
	 private WebElement btnRequestForCollab;
	 
	 @FindBy(xpath = "(//button[contains(text(),'Request')])[2]")
	 private WebElement btnRequest;
	 
	 //Req pop up pending ********************
	 @FindBy(xpath = "//*[contains(text(),'My Partn')]")
	 private WebElement sectionMyPartner1;
	 
	 //Deals
	 @FindBy(xpath = "//h6[contains(text(),'Settings')]")
	 private WebElement sectionSetting;
	 
	 @FindBy(xpath = "//h6[contains(text(),'My Deals')]")
	 private WebElement sectionMyDealsDelegate;
	 
	 @FindBy(xpath = "//button[contains(text(),'Create Deal')]")
	 private WebElement btnCreateDeals;
	 
	 @FindBy(xpath = "//span[contains(text(),'Select Partner')]")
	 private WebElement dropdownSelectPartner; //tc name
	 
	 @FindBy(xpath = "//li[contains(text(),'Ochoa and Barrett Plc')]")
	 private WebElement selectTcFromDropDown;
	 
	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd')])[1]")
	 private WebElement txtCommitmentvolume;
	 
	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd')])[2]")
	 private WebElement txtBuybackrateBtoC;
	 
	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd')])[3]")
	 private WebElement txtBuybackrateBtoB;
	 
	 @FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd')])[4]")
	 private WebElement txtExecutionDeadline;
	 
	 @FindBy(xpath = "//input[@name='businessIntroducer']/preceding-sibling::div[@role='combobox']")
	 private WebElement dropdownBusinessIntroducer;
	 
	 
	 @FindBy(xpath = "//li[contains(text(),'Galloway Franks Plc')]")
	 private WebElement selectBusinessIntroducer;
	 
	 @FindBy(xpath = "//button[contains(text(),'Validate')]")
	 private WebElement btnValidation;
	 
	 
	 //Action Method
	 public void clickdDropdownChangeLanguage()
	 {
		 dropdownChangeLang.click();
	 }
	 
	 public void clickSelectEngLang()
	 {
		 selectEng.click();
	 }
	 
	 //Batch
	 public void clickSectionMyClientsDelegate()
	 {
		 sectionMyClientsDelegate.click();
	 }
	 
	 public void clickSectionMyBatch()
	 {
		 sectionMyBatch.click();
	 }
	 
	 
	 public void clickBtnCreateBatch()
	 {
		 btnCreateBatch.click();
	 }
	 
	 
	 public void clickDropdownCAEOpe(String selectCAEOpe)
	 {
		 dropdownCAEOpe.click();
		 dropdownCAEOpe.sendKeys(selectCAEOpe);
		 System.out.println("click");
		 
//		 WebElement option = wait.until(ExpectedConditions
//		            .visibilityOfElementLocated(By.xpath("//li[contains(@class,'MuiAutocomplete-option') and contains(text(),'" 
//                            + selectCAEOpe.toUpperCase() + "')]")
//          ));
//		 
//		 option.click();

		 Actions act = new Actions(driver);
		    act.sendKeys(Keys.DOWN).pause(300).sendKeys(Keys.ENTER).perform();
	 }
	 

	 public void clickDropDownAutoCommunity(String AutoCommunity)
	 {
		 Actions act = new Actions(driver);
		 dropDownAutoCommunity.click();
		
		 act.sendKeys(Keys.UP).pause(300).sendKeys(Keys.ENTER).perform();

	 }
	 
	 public void clickDropDownStatus()
	 {
		 dropDownStatus.click();
		 
		 Actions act = new Actions(driver);
		
		 act.sendKeys(Keys.DOWN).pause(300).sendKeys(Keys.ENTER).perform();
	 }
	 
	 public void clickBtnSaveBatch()
	 {
		 btnSaveBatch.click();
	 }
	 
	 
	//External partners
	//CRO - Collab req
	 public void clickSectionMyPartner()
	 {
		 sectionMyPartner.click();
	 }
	 
	 
	 public void clickBtnNewCollabReq()
	 {
		 btnNewCollabReq.click();
	 }
	 

	 public void clickTxtBoxCifNumber(String cif)
	 {
		 txtBoxCifNumber.sendKeys(cif);
	 }
	 

	 public void clickBtnEnter()
	 {
		 btnEnter.click();
	 }
	 
	 public void clickBtnRequestForCollab()
	 {
		 btnRequestForCollab.click();
	 }
	 

	 public void clickBtnRequest()
	 {
		 btnRequest.click();
	 }
	 
	 
	 //Deals
	 
	 public void clickSectionSetting()
	 {
		 sectionSetting.click();
	 }

	 public void clickSectionMyDealsDelegate()
	 {
		 sectionMyDealsDelegate.click();
	 }
	 
	 
	 public void clickBtnCreateDeals()
	 {
		 btnCreateDeals.click();
	 }
	 

	 public void clickDropdownSelectPartner()
	 {
		 dropdownSelectPartner.click();
	 }
	 
	 public void clickSelectTcFromDropDown()
	 {
		 selectTcFromDropDown.click();
	 }
	 

	 public void enterTxtCommitmentvolume()
	 {
		 String commitmentvolume= RandomStringUtils.randomNumeric(2);
		 txtCommitmentvolume.sendKeys(commitmentvolume);
	 }
	 

	 public void enterTxtBuybackrateBtoC()
	 {
		 String buybackrateBtoC= RandomStringUtils.randomNumeric(2);
		 txtBuybackrateBtoC.sendKeys(buybackrateBtoC);
	 }
	 
	 
	 public void enterTxtBuybackrateBtoB()
	 {
		 String buybackrateBtoB= RandomStringUtils.randomNumeric(2);
		 txtBuybackrateBtoB.sendKeys(buybackrateBtoB);
	 }
	 
	 
	 public void enterTxtExecutionDeadline()
	 {
		 String executionDeadline= RandomStringUtils.randomNumeric(2);
		 txtExecutionDeadline.sendKeys(executionDeadline);
	 }
	 

	 public void clickDropdownBusinessIntroducer() throws InterruptedException
	 {
		 Thread.sleep(3000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 //js.executeScript("window.scrollBy(0, 500)");
		 js.executeScript("arguments[0].scrollIntoView(true);", dropdownBusinessIntroducer);
		 System.out.println(dropdownBusinessIntroducer.isDisplayed());
		 
		 js.executeScript("arguments[0].click()", dropdownBusinessIntroducer);

		 //dropdownBusinessIntroducer.click();
	     selectBusinessIntroducer.click();

	 }

	 public void clickBtnValidation()
	 {
		 btnValidation.click();
	 }
	 
}
