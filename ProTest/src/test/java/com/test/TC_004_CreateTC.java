package com.test;

import org.apache.commons.compress.harmony.pack200.BcBands;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.AdminDashboard;
import com.pom.LoginPage;



public class TC_004_CreateTC extends BaseClass{
	
	BaseClass bc;
	AdminDashboard admin;
	
	//Login
	@Test(priority = 1)
	public void login() throws InterruptedException
	{
		bc = new BaseClass();
		bc.LoginPage();
	}
	
	//Create TC
	@Test(priority = 2)
	public void createTC() throws InterruptedException
	{
		admin = new AdminDashboard(driver);
		
		admin.clickdDropdownChangeLanguage();
		admin.clickSelectEngLang();
		admin.clickProcessAdmin();
		admin.clickSectionClient();
		admin.clickBtnCreateNewClient();
		
		//tc form creation
		admin.enterCIF("123");
		admin.enterCompany("AutomationTC");
		admin.enterCommercialRegister("CommercialRegister-AutomationTC");
		admin.enterVATNo("1122");
		admin.enterAddress("SpainTest");
		admin.enterPostalCode("23564");
		admin.enterCity("Gadchiroli");
		admin.enterCountry("Spain");
		admin.enterPhoneNumber("9876545678");
		admin.enterPosition("2");
		admin.enterNIF("980");
		admin.enterFirstName("TestingTC");
		admin.enterLastName("AutoLastNameTC");
		admin.enterMobileNo("9090909090");
		admin.enterEmail("tctestingautomation@test.com");
		admin.enterPwd("Password@123");
		admin.clickCheckBoxLegal();
		admin.enterSMS("Creating TC");
		admin.enterEmailExtension("tctestautomation@test.com");
		admin.clickBtnConfirmAndNext();
		admin.clickBtnConfirmAndNext();
		admin.clickBtnSave();
		
	}

}
