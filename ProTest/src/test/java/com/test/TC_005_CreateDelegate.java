package com.test;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.AdminDashboard;

public class TC_005_CreateDelegate extends BaseClass{

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
	public void createDelegate() throws InterruptedException
	{
		admin = new AdminDashboard(driver);
		
		admin.clickdDropdownChangeLanguage();
		admin.clickSelectEngLang();
		admin.clickProcessAdmin();
		admin.clickSectionClient();
		admin.clickBtnCAEPartnerDele();
		admin.clickBtnCreateNewDelegate();
		
		//tc form creation
		admin.enterCIF("123");
		admin.enterCompany("AutomationDel");
		admin.enterCommercialRegister("CommercialRegister-AutomationDel");
		admin.enterVATNo("1122");
		admin.enterAddress("SpainTestDel");
		admin.enterPostalCode("23564");
		admin.enterCity("GadchiroliDel");
		admin.enterCountry("SpainDel");
		admin.enterPhoneNumber("2354678964");
		admin.enterPosition("23");
		admin.enterNIF("9800");
		admin.enterFirstName("TestingDel");
		admin.enterLastName("AutoLastNameDel");
		admin.enterMobileNo("9090909090");
		admin.enterEmail("del1testingautomation@test.com");
		admin.enterPwd("Password@123");
		admin.clickCheckBoxLegal();
		admin.enterSMS("Creating Del");
		admin.enterEmailExtension("del2testautomation@test.com");
		admin.clickBtnConfirmAndNext();
		admin.clickBtnConfirmAndNext();
		admin.clickBtnSave();
		
	}
}
