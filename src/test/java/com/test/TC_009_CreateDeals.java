package com.test;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.AdminDashboard;
import com.pom.DelegateDashboard;

public class TC_009_CreateDeals extends BaseClass{
	
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
	public void createBatch() throws InterruptedException
	{
		delegate = new DelegateDashboard(driver);
		delegate.clickdDropdownChangeLanguage();
		delegate.clickSelectEngLang();
		delegate.clickSectionSetting();
		delegate.clickSectionMyDealsDelegate();
		delegate.clickBtnCreateDeals();
		delegate.clickDropdownSelectPartner();
		delegate.clickSelectTcFromDropDown();
		delegate.enterTxtCommitmentvolume();
		delegate.enterTxtBuybackrateBtoC();
		delegate.enterTxtBuybackrateBtoB();
		delegate.enterTxtExecutionDeadline();
		delegate.clickDropdownBusinessIntroducer();
		delegate.clickBtnValidation();
	}

}
