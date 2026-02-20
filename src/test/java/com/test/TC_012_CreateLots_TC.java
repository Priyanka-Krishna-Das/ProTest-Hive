package com.test;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.TcDashboard;

public class TC_012_CreateLots_TC extends BaseClass{
	
	BaseClass bc;
	TcDashboard td;
	
	//Login
	@Test(priority = 1)
	public void login() throws InterruptedException
	{
		bc = new BaseClass();
		bc.LoginPage();
	}
	
	
    //Create Batch
	@Test(priority = 2)
	public void createLots() throws InterruptedException
	{
		
		td = new TcDashboard(driver);
		td.clickDropdownChangeLang();
		td.clickSelectEng();
		td.clickSectionMyClients();
		td.clickSectionLots();
		td.clickBtnCreateLot();
		td.clickDropDownCAEPartner();
		td.clickDropDownRefOpeartion("res020");
		td.clickDropDownAutonomusComunity();
		td.clickDropDownStatus();
		
	}

}
