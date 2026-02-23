package com.test;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.AdminDashboard;

public class TC_006_CreateConvOperation extends BaseClass{

	BaseClass bc;
	AdminDashboard admin;
	
	//Login
	@Test(priority = 1)
	public void login() throws InterruptedException
	{
		bc = new BaseClass();
		bc.LoginPage();
	}
	
	
    //Create Conv Ope
	@Test(priority = 2)
	public void createConvOpe()
	{
		admin = new AdminDashboard(driver);
		admin.clickdDropdownChangeLanguage();
		 
		 
		admin.clickSelectEngLang();
		 
		admin.clickProcessAdmin();
		admin.clickBtnsectionConventOpe();
		admin.clickBtnCreateNewConveOpe();
		 
		admin.clickDelegateDropDown();
		admin.selectDelegateName("Delegate2");
		 
		//admin.selectDelegateName("Delegate2");
		 
		admin.clickBtnNext();
		 
		admin.clickBtnOperationDropDown();
		

		admin.selectDropDownBoxOperation("AGR010 Pantallas térmicas en invernaderos");
		 
		
		//admin.txtBoxOperationRef("AGR010-1");
		
		admin.txtBoxOperationRef();

		 
		admin.clickBtnNext2();
		 
		 
		admin.clickBtnNext3();
		
		 
		 
		admin.clickTogglePortadaTemplete();
		

		 
		admin.clickTab2DocumentosPrincipales();
		 
		 
		 
		admin.clickTogglesDocumentosPrincipalesTemplete();
		 
		 
		 
		 admin.clickTabConvenioCAE();
		 
		 
		admin.clickButtonEdit();
		
		 
		admin.clickCheckBoxDoc();
		 

		admin.clickBtnViewAndSave();
		 
		 
		 
		admin.clickBtnAddTechniDoc();
		

		 
		admin.clickCheckBoxTechniDoc();
		 
		 
	 
		admin.btnViewAndSave();
		
		 //btnViewAndSave need to call
		 
		admin.clickBtnAddAlbum();
		 
		 
		admin.clickCheckBoxAlbum();
		
		 
		admin.clickBtnViewAndSave2();
		
		 //btnViewAndSave need to call
		 
		
		admin.clickBtnSaveConvOpe();
		 
	}
}
