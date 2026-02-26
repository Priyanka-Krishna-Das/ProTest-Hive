package com.test;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.AdminDashboard;
import com.pom.DelegateDashboard;

public class TC_011_CreateTechnician extends BaseClass{
	
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
	public void createTcCollabReq() throws InterruptedException
	{
		delegate = new DelegateDashboard(driver);
		delegate.clickdDropdownChangeLanguage();
		delegate.clickSelectEngLang();
		delegate.clickSectionMyPartner();
		delegate.clickBtnNewCollabReq();
		System.out.println("-------");
	}

}
