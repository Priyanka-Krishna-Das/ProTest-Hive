package com.pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

//import com.sun.tools.javac.util.List;


public class AdminDashboard {

	private WebDriver driver;
	SoftAssert sa = new SoftAssert();

    //Used IDE
	
	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	//Const
	public AdminDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // PageFactory initialization
    }
	
	//Xpath
	 @FindBy(xpath = "//*[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb']")
	 private WebElement dropdownChangeLang;
	 
	 @FindBy(xpath = "//*[contains(text(),'Anglais')]")
	 private WebElement selectEng;
	 
	 @FindBy(xpath = "//*[contains(text(),'Forms/Proc...')]")
	 private WebElement processAdmin;
	
	 @FindBy(xpath = "//*[text()='Clients']")
	 private WebElement sectionClient;
	 
	 @FindBy(xpath = "//*[contains(text(),'Create a New Client')]")
	 private WebElement btnCreateNewClient;
	 
	 //form for TC/Delegate
	 @FindBy(xpath = "//*[@name='cifNumber']")
	 private WebElement txtBoxCIF;
	 
	 
	 @FindBy(xpath = "//*[@name='companyName']")
	 private WebElement txtBoxCompanay;
	 
	 @FindBy(xpath = "//*[@name='commercialRegister']")
	 private WebElement txtBoxCommercialRegister;
	 
	 @FindBy(xpath = "//*[@name='VATNo']")
	 private WebElement txtBoxVATNo;

	 @FindBy(xpath = "//*[@name='address']")
	 private WebElement txtBoxAddress;
	 
	 @FindBy(xpath = "//*[@name='postalCode']")
	 private WebElement txtBoxPostalCode;
	 
	 @FindBy(xpath = "//*[@name='city']")
	 private WebElement txtBoxCity;
	 
	 @FindBy(xpath = "//*[@name='country']")
	 private WebElement txtBoxCountry;
	 
	 @FindBy(xpath = "//*[@name='phoneNumber']")
	 private WebElement txtBoxPhoneNumber;
	 
	 @FindBy(xpath = "//*[@name='keyContacts.function']")
	 private WebElement txtBoxPosition;
	 
	 @FindBy(xpath = "//*[@name='keyContacts.nif']")
	 private WebElement txtBoxNif;
	 
	 @FindBy(xpath = "//*[@name='keyContacts.firstName']")
	 private WebElement txtBoxFirstName;
	 
	 @FindBy(xpath = "//*[@name='keyContacts.name']")
	 private WebElement txtBoxLastName;
	 
	 @FindBy(xpath = "//*[@name='keyContacts.mobileNumber']")
	 private WebElement txtBoxMobileNo;
	 
	 @FindBy(xpath = "//*[@name='keyContacts.email']")
	 private WebElement txtBoxEmail;
	 
	 @FindBy(xpath = "//*[contains(@type,'password')]")
	 private WebElement txtBoxPass;
	 
	 @FindBy(xpath = "//label/p[contains(text(),'Legal ')]")
	 private WebElement checkBoxLegal;
	 
	 @FindBy(xpath = "//*[@name='extContact.sms']")
	 private WebElement txtBoxSMS;
	 
	 @FindBy(xpath = "//*[@name='extContact.email']")
	 private WebElement txtBoxEmailExtension;
	 
	 @FindBy(xpath = "//*[contains(text(),'Confirm & Next')]")
	 private WebElement btnConfirmAndNext;
	 
	 @FindBy(xpath = "//*[contains(text(),'Save')]")
	 private WebElement btnSave;
	 
	 
	 //Create Delegate
	 @FindBy(xpath = "//button[contains(text(),'CAE Partner')]")
	 private WebElement btnCAEPartnerDele;
	 
	 @FindBy(xpath = "//button[contains(text(),'Create a New Client')]")
	 private WebElement btnCreateNewDelegate;
	 
	 //Create convention operation
	 @FindBy(xpath = "//*[contains(text(),'Conventio')]")
	 private WebElement sectionConventOpe;
	 
	 @FindBy(xpath = "//*[contains(text(),'Create an Operation Conventioned')]")
	 private WebElement btnCreateNewConveOpe;
	 
	 @FindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2')]//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')]")
	 private WebElement selectDelegateDropDown;
	 
//	 @FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters Mui-selected MuiMenuItem-root MuiMenuItem-gutters Mui-selected css-1ray37a']")
//	 private List<WebElement> selectDelegateName;
	 
	 @FindBy(xpath = "//ul//li[contains(text(),'AutomationDel')]")
     private WebElement selectDelegateName;
	 
//	 @FindBy(css = "ul.MuiList-root.MuiMenu-list")
//	 private WebElement muiDropdownList;
	 
//	 @FindBy(css = "li.MuiButtonBase-root.MuiMenuItem-root")
//	 private List<WebElement> selectDelegateName;
	 
	 @FindBy(xpath = "//button[contains(text(),'Next')]")
	 private WebElement btnNext;
	 
	 @FindBy(xpath = "//*[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused')]")
	 private WebElement btnOperationDropDown;
	 
	 @FindBy(xpath = "//li[contains(text(),'RES020 Rehabilitación de')]")
	 private WebElement selectBoxOperation;
	 
	 @FindBy(xpath = "//input[contains(@name,'agreementRef')]")
	 private WebElement txtBoxOperationRef;
	 
	 @FindBy(xpath = "//button[contains(text(),'Next')]")
	 private WebElement btnNext2;
	 
	 @FindBy(xpath = "//button[contains(text(),'Next')]")
	 private WebElement btnNext3;
	 
	// ************************
	 @FindBy(xpath = "//button[contains(text(),'Documentos Principales')]")
	 private WebElement togglePortadaTemplete;
	 
	 @FindBy(xpath = "//button[contains(text(),'Documentos Principales')]")
	 private WebElement tab2DocumentosPrincipales;
	 
	 @FindBy(xpath = "//*[contains(@class,'MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary')]")
	 private List<WebElement> togglesDocumentosPrincipalesTemplete;
	 
	 @FindBy(xpath = "//button[contains(text(),'Convenio CAE')]")
	 private List<WebElement> tabConvenioCAE;
	 
	 @FindBy(xpath = "//p[contains(text(),'Edit')]")
	 private WebElement buttonEdit;
	 
	 @FindBy(xpath = "//label[@class='MuiFormControlLabel-root Mui-disabled MuiFormControlLabel-labelPlacementEnd css-1jaw3da']")
	 private List<WebElement> checkBoxDoc;
	 
	 @FindBy(xpath = "//button[contains(text(),'View&Save')]")
	 private WebElement btnViewAndSave;
	 
	 @FindBy(xpath = "(//*[contains(@class,'MuiButton-icon MuiButton-startIcon MuiButton-iconSizeMedium')])[1]")
	 private WebElement btnAddTechniDoc;
	 
	 @FindBy(xpath = "//*[contains(@class,'PrivateSwitchBase-input css-1m9pwf3')]")
	 private List<WebElement> checkBoxTechniDoc;
	 //btnViewAndSave need to call
	 
	 @FindBy(xpath = "(//*[contains(@class,'MuiButton-icon MuiButton-startIcon MuiButton-iconSizeMedium')])[2]")
	 private WebElement btnAddAlbum;
	 
	 @FindBy(xpath = "//*[contains(@class,'PrivateSwitchBase-input css-1m9pwf3')]")
	 private List<WebElement> checkBoxAlbum;
	 //btnViewAndSave need to call
	 
	 
	 @FindBy(xpath = "//button[contains(text(),'Save')]")
	 private WebElement btnSaveConvOpe;
	 
	 
	 //Methods
	 //Create TC
	 public void clickdDropdownChangeLanguage()
	 {
		 dropdownChangeLang.click();
	 }
	 
	 public void clickSelectEngLang()
	 {
		 selectEng.click();
	 }
	 
	 public void clickProcessAdmin()
	 {
		 processAdmin.click();
	 }
	 
	 public void clickSectionClient()
	 {
		 sectionClient.click();
	 }
	 
	 public void clickBtnCreateNewClient()
	 {
		 btnCreateNewClient.click();
	 }
	 
	 //TC form
	 public void enterCIF(String cif)
	 {
		 txtBoxCIF.sendKeys(cif);
	 }
	 
	 public void enterCompany(String company)
	 {
		 txtBoxCompanay.sendKeys(company);
	 }
	 
	 public void enterCommercialRegister(String CommercialRegister)
	 {
		 txtBoxCommercialRegister.sendKeys(CommercialRegister);
	 }
	 
	 public void enterVATNo(String VATNo)
	 {
		 txtBoxVATNo.sendKeys(VATNo);
	 }
	 
	 public void enterAddress(String Address)
	 {
		 txtBoxAddress.sendKeys(Address);
	 }
	 
	 public void enterPostalCode(String PostalCode)
	 {
		 txtBoxPostalCode.sendKeys(PostalCode);
	 }
	 
	 public void enterCity(String city)
	 {
		 txtBoxCity.sendKeys(city);
	 }
	 
	 public void enterCountry(String Country)
	 {
		 txtBoxCountry.sendKeys(Country);
	 }
	 
	 public void enterPhoneNumber(String PhoneNumber)
	 {
		 txtBoxPhoneNumber.sendKeys(PhoneNumber);
	 }
	 
	 public void enterPosition(String Position)
	 {
		 txtBoxPosition.sendKeys(Position);
	 }
	 
	 public void enterNIF(String nif)
	 {
		 txtBoxNif.sendKeys(nif);
	 }
	 
	 public void enterFirstName(String firstName)
	 {
		 txtBoxFirstName.sendKeys(firstName);
	 }
	 
	 public void enterLastName(String lastName)
	 {
		 txtBoxLastName.sendKeys(lastName);
	 }
	 
	 public void enterMobileNo(String mobileNo)
	 {
		 txtBoxMobileNo.sendKeys(mobileNo);
	 }
	 
	 public void enterEmail(String email)
	 {
		 txtBoxEmail.sendKeys(email);
	 }
	
	 public void enterPwd(String pwd)
	 {
		 txtBoxPass.sendKeys(pwd);
	 }
	
	 public void clickCheckBoxLegal()
	 {
		 checkBoxLegal.click();
	 }
	 
	 public void enterSMS(String sms)
	 {
		 txtBoxSMS.sendKeys(sms);
	 }
	 
	 public void enterEmailExtension(String emailExtension)
	 {
		 txtBoxEmailExtension.sendKeys(emailExtension);
	 }
	 
	 public void clickBtnConfirmAndNext()
	 {

		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", btnConfirmAndNext);
	 }
	 
	 public void clickBtnSave()
	 {

		 btnSave.click();
	 }
	 
	 //Create Delegate
	 
	 public void clickBtnCAEPartnerDele()
	 {

		 btnCAEPartnerDele.click();
	 }
	 
	 public void clickBtnCreateNewDelegate()
	 {

		 btnCreateNewDelegate.click();
	 }
	 
	 //Conv Ope Creation
	 public void clickBtnsectionConventOpe()
	 {

		 sectionConventOpe.click();
	 }
	 
	 public void clickBtnCreateNewConveOpe()
	 {

		 btnCreateNewConveOpe.click();
	 }
	 
	 public void clickDelegateDropDown()
	 {

		 selectDelegateDropDown.click();
	 }
	 
	 
//	 public void selectDelegateName(String selectDel)
//	 {
//
//		 /**
//		     * Select an option from MUI dropdown using visible text
//		     */
//
//		        // Wait for dropdown list
//		        //wait.until(ExpectedConditions.visibilityOf(muiDropdownList));
//
//		        // Loop through dynamic options
//		        for (WebElement option : selectDelegateName) {
//		            if (option.getText().trim().equalsIgnoreCase(selectDel.trim())) {
//		                wait.until(ExpectedConditions.elementToBeClickable(option)).click();
//		                break;
//		            }
//		        }
//	 }
	 
	 public void selectDelegateName(String selectDel)
	 {

		 selectDelegateName.click();
	 }
	 
	 public void clickBtnNext()
	 {

		 wait.until(ExpectedConditions.elementToBeClickable(btnNext)).click();
	 }
	 
	 public void clickBtnOperationDropDown()
	 {

		 btnOperationDropDown.click();
	 }
	 
	 public void selectDropDownBoxOperation(String selectOperation) {
		 btnOperationDropDown.sendKeys(selectOperation);
		 btnOperationDropDown.sendKeys(Keys.DOWN);   // Move to the first item
		 btnOperationDropDown.sendKeys(Keys.ENTER);  // Select the item
		}
	 
//	 public void selectDropDownBoxOperation(String selectOperation) {
//		    selectBoxOperation.sendKeys(selectOperation);
//
//		    Actions act = new Actions(driver);
//		    act.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
//		}
	 
	 public void  txtBoxOperationRef()
	 {

		 String refConvOpe= "test" + RandomStringUtils.randomNumeric(2) + "@gmail.com";
		 txtBoxOperationRef.sendKeys(refConvOpe);
	 }
	 
	 public void clickBtnNext2()
	 {

		 btnNext2.click();
	 }
	 
	 public void clickBtnNext3()
	 {

		 btnNext3.click();
	 }
	 
	 
	 public void clickTogglePortadaTemplete()
	 {

		 togglePortadaTemplete.click();
	 }

	 
	 public void clickTab2DocumentosPrincipales()
	 {

		 tab2DocumentosPrincipales.click();
	 }
	 
	 
	 public void clickTogglesDocumentosPrincipalesTemplete()
	 {

		 for(WebElement toggle1: togglesDocumentosPrincipalesTemplete)
		 {
			 toggle1.click();
		 }
	 }
	 
	 
	 public void clickTabConvenioCAE()
	 {

		 for(WebElement toggle2: tabConvenioCAE)
		 {
			 toggle2.click();
		 }
	 }
	 
	 
	 public void clickButtonEdit()
	 {

		 buttonEdit.click();
	 }
	 
	 
	 public void clickCheckBoxDoc()
	 {

		 for(WebElement check1: checkBoxDoc)
		 {
			 check1.click();
		 }
	 }

	 public void clickBtnViewAndSave()
	 {

		 btnViewAndSave.click();
	 }
	 
	 
	 public void clickBtnAddTechniDoc()
	 {

		 btnAddTechniDoc.click();
	 }
	 

	 
	 public void clickCheckBoxTechniDoc()
	 {

		 for(WebElement check2: checkBoxTechniDoc)
		 {
			 check2.click();
		 }
	 }
	 
 
	 public void btnViewAndSave()
	 {

		 btnViewAndSave.click();
	 }
	 //btnViewAndSave need to call
	 
	 public void clickBtnAddAlbum()
	 {

		 btnAddAlbum.click();
	 }
	  
	 
	 public void clickCheckBoxAlbum()
	 {

		 for(WebElement check3: checkBoxAlbum)
		 {
			 check3.click();
		 }
	 }
	 
	 public void clickBtnViewAndSave2()
	 {

		 btnViewAndSave.click();
	 }
	 //btnViewAndSave need to call
	 
	
	 public void clickBtnSaveConvOpe()
	 {

		 btnSaveConvOpe.click();
         System.out.println("Git testing--------");
	 }
	 
}
