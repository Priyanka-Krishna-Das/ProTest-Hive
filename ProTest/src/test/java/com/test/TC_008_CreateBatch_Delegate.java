package com.test;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.AdminDashboard;
import com.pom.DelegateDashboard;

public class TC_008_CreateBatch_Delegate extends BaseClass{
	
	BaseClass bc;
	AdminDashboard admin;
	DelegateDashboard delegate;
	
	//Login
	@Test(priority = 1)
	public void login() throws InterruptedException
	{
		bc = new BaseClass();
		bc.LoginPage();
	}
	
	
    //Create Batch
	@Test(priority = 2)
	public void createBatch()
	{
		delegate = new DelegateDashboard(driver);
		delegate.clickdDropdownChangeLanguage();
		delegate.clickSelectEngLang();
		delegate.clickSectionMyClientsDelegate();
		delegate.clickSectionMyBatch();
		delegate.clickBtnCreateBatch();
		delegate.clickDropdownCAEOpe("res020");
		delegate.clickDropDownAutoCommunity("A");
		delegate.clickDropDownStatus();
		delegate.clickBtnSaveBatch();
		
	}
}
