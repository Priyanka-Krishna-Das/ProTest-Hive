package com.test;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.TcDashboard;
import com.utility.ExcelReaderUsingLoop;
import com.utility.ExcelReaderUsingLoopCalculation;

public class TC_014_CalculationUsingExcel extends BaseClass{
	
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
		Thread.sleep(2000);
		td.clickDropdownSelectLead();
		td.clickSelectLeadFromDropDown();
		Thread.sleep(3000);
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
		@Test(priority = 4, dataProvider = "calculation", dataProviderClass = ExcelReaderUsingLoopCalculation.class)
			public void previsitForm(
			        String flooreThickness,
			        String atticLength,
			        String atticWidth,
			        String internalRidgeHeight,
			        String halfSpan,
			        String surfaceToInsulate,
			        String totalSurface,
			        String reccomenedThickness) throws InterruptedException {
			
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
			td.enterTxtFlooreThickness(flooreThickness);
			td.clickDropDownInsulationType();
			td.clickSelectIsulationType();
			td.clickDropDownVentilation();
			td.clickSelectVentilation();
			td.enterTxtAtticLength(atticLength);
			td.enterTxtAtticWidth(atticWidth);
			td.enterTxtInternalRidgeHeight(internalRidgeHeight);
			td.enterTxtHalfSpan(halfSpan);
			td.enterTxtSurfaceToInsulate(surfaceToInsulate);
			td.enterTxtTotalSurface(totalSurface);
			td.clickDropDownRecommendedMaterial();
			td.enterTxtReccomenedThickness(reccomenedThickness);
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
