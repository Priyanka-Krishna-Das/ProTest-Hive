package com.test;

import org.testng.annotations.BeforeClass;
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
			System.out.println("Testing");
		}
	
	
    //Create Client Info
	@Test(priority = 2)
	public void createWorkfile() throws InterruptedException
	{
		 td = new TcDashboard(driver);

		    // ===== CREATE WORK FILE =====
		 
		    td.clickDropdownChangeLang(); 
		    td.clickSelectEng();
		    td.clickSectionMyClients();
		    td.clickSectionMyWorkFile();
		    td.clickBtnCreateAWorkFile();
		    Thread.sleep(2000);
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
		    
		 // ===== CREATE APPOINTMENT =====
		    td.clickTabClientAppt();
		    Thread.sleep(10);
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
	@Test(dataProvider = "calculation",
		      dataProviderClass = ExcelReaderUsingLoopCalculation.class, priority = 3)
		public void completeWorkFlow(
		        String atticWidthL,
		        String atticWidthL1,
		        String atticWidthL2,
		        String atticWidthL3,
		        String h,
		        String h1,
		        String h2,
		        String floorThickness,
		        String totalSurface,
		        String totalSurface1,
		        String totalSurface2,
		        String surfaceToInsulate,
		        String insulationThicknessToInstall,
		        String finalResult) throws InterruptedException {
		    
		    td = new TcDashboard(driver);

		    Thread.sleep(8000);

//		    // ===== PREVISIT (Excel Data) =====
//		    td.clickTabTechnical();
//		    td.clickBtnStartPrevisit();
//		    td.clickBtnAttic();
//		    td.enterTxtFlooreThickness(flooreThickness);
//		    td.enterTxtAtticLength(atticLength);
//		    td.enterTxtAtticWidth(atticWidth);
//		    td.enterTxtInternalRidgeHeight(internalRidgeHeight);
//		    td.enterTxtHalfSpan(halfSpan);
//		    td.enterTxtSurfaceToInsulate(surfaceToInsulate);
//		    td.enterTxtTotalSurface(totalSurface);
//		    td.enterTxtReccomenedThickness(reccomenedThickness);
//		    td.clickBtnNextAttic();

		 // ===== PREVISIT (Excel Data) =====
		    System.out.println("Click on technical tab");
		    td.clickTabTechnical();
			td.clickBtnStartPrevisit();
			td.clickBtnAttic();
		    td.enterTxtAtticWidthL(atticWidthL);
			td.enterTxtAtticWidthL1(atticWidthL1);
			td.enterTxtAtticWidthL2(atticWidthL2);
			td.enterTxtAtticWidthL3(atticWidthL3);
			td.enterTxtH(h);
			td.enterTxtH1(h1);
			td.enterTxtH2(h2);
			td.clickDropDownAtticType();
			td.clickDropDownAccessType();
			td.clickBtnEditFloorType();
			td.clickSelectFloorType();
			td.enterTxtFloorThickness(floorThickness);
			td.clickBtnAddFloorType();
			td.clickBtnCross();
			td.enterTxttotalSurface("5");
			td.enterTxttotalSurface1("89.3");
			td.enterTxttotalSurface2("100");
			td.enterTxtSurfaceToInsulate("130");
			td.clickDropDownSelectInsulationType();
			td.clickDropDownSelectVentilation();
			//material
			td.clickDropDownSelectMaterialToInstall();
			td.enterTxtInsulationThicknessToInstall("100");
			//Roof slope
			td.clickDropDownRampantsTypes();
			td.clickDropDownRampantsTypes();
			td.clickDropDownAirLeaks();
			td.clickBtnNextAttic();
		    
		    // ===== AUDIT =====
			td.clickTabAudit();
			td.clickDropDownManufacturer();
			//td.clickSelectManufacturer();
			td.clickDropDownReference();
			//td.clickSelectReference();
			Thread.sleep(2000);
			td.dispTxtAETotal1(finalResult);
			td.clickBtnAuditConfirm();
			Thread.sleep(3000);
			td.clickTabAudit();
			
			
			//old
//		    td.clickTabAudit();
//		    td.clickDropDownManufacturer();
//		    //td.clickSelectManufacturer();
//		    td.clickDropDownReference();
//		    //td.clickSelectReference();
//		    td.clickBtnAuditConfirm();
		}

}
