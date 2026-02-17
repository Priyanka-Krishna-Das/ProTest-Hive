package com.test;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.TcDashboard;

public class TC_013_CreateWorkFile extends BaseClass{
	
	BaseClass bc;
	TcDashboard td;
	
	//Login
	@Test(priority = 1)
	public void login() throws InterruptedException
	{
		bc = new BaseClass();
		bc.LoginPage();
	}
	
	
    //Create Client Info
	@Test(priority = 2)
	public void createClientInformation() throws InterruptedException
	{
		
		td = new TcDashboard(driver);
		td.clickDropdownChangeLang();
		td.clickSelectEng();
		td.clickSectionMyClients();
		td.clickSectionMyWorkFile();
		td.clickBtnCreateAWorkFile();
		td.clickDropdownSelectLead();
		td.clickSelectLeadFromDropDown();
		td.clickBtnNext1();
		td.clickDropDownValoPartner("DelegateDocTest");
		td.clickDropdownConvOpe();
		td.clickSelectConvOpeFromDropDown();
		td.clickDropDownCAEDeals();
		td.clickSelectCAEDeals();
		td.clickDropdownSelectlot();
		td.clickSelectLots();
		td.clickBtnNext2();
		td.clickDropDwonSelctOpeServices();
		td.clickDropDwonDesignOffice();
		td.clickSelctDesignOffice();
		td.clickBtnConfirm();
		Thread.sleep(3000);
		
		
	}
	
	//Create Client Appt.
		@Test(priority = 3)
		public void createCustAppt() throws InterruptedException
		{
			
			td = new TcDashboard(driver);
			td.clickTabClientAppt();
			td.clickBtnCreateAppt();
			td.clickDropDownApptType();
			td.clickSelectApptType();
			td.clickSelectTypeOfPrevisit();
			td.clickDropDownTechnicianName();
			td.clickSelectTechni();
			td.enterTxtDate("06022026");
			td.clickDropDwonHours("15:15");
			td.clickBtnSaveClientAppt();
		}

		// //WorkFile -> Tab technical -> previsit
		@Test(priority = 4)
		public void previsitForm() throws InterruptedException
		{
			
			td = new TcDashboard(driver);
			td.clickTabTechnical();
			td.clickBtnStartPrevisit();
			td.clickBtnAttic();
			//td.clickBtnAttic();
			td.clickDropdownAtticType();
			td.clickSelectAtticType();
			td.clickDropDownAccessType();
			td.clickSelectAccessType();
			td.clickDropDownFloorType();
			td.clickSelectFloorType();
			td.enterTxtFlooreThickness("11");
			td.clickDropDownInsulationType();
			td.clickSelectIsulationType();
			td.clickDropDownVentilation();
			td.clickSelectVentilation();
			td.enterTxtAtticLength("8.9");
			td.enterTxtAtticWidth("2.4");
			td.enterTxtInternalRidgeHeight("5.2");
			td.enterTxtHalfSpan("5");
			td.enterTxtSurfaceToInsulate("89.3");
			td.enterTxtTotalSurface("100");
			td.clickDropDownRecommendedMaterial();
			td.enterTxtReccomenedThickness("220");
			td.clickDropDownRampantsTypes();
			td.clickDropDownRampantsTypes();
			td.clickDropDownAirLeaks();
			td.clickBtnNextAttic();
			
		}
		
		
		//Audit
		@Test(priority = 5)
		public void setDataInAtticSection() throws InterruptedException
		{
			
			td = new TcDashboard(driver);
			td.clickTabAudit();
			td.clickDropDownManufacturer();
			td.clickSelectManufacturer();
			td.clickDropDownReference();
			td.clickSelectReference();
			Thread.sleep(2000);
			//td.dispTxtAETotal();
			td.clickBtnAuditConfirm();
			Thread.sleep(2000);
			td.clickTabAudit1();
			//td.dispTxtAETotal();
			Thread.sleep(2000);
			td.clickBtnView();
			Thread.sleep(2000);
			td.clickTxtAETotalAfterView();
		}
		
}










