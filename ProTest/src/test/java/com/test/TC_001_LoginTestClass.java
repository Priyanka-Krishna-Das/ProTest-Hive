package com.test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.LoginPage;
import com.utility.DataProviderClass;
import com.utility.DataReader;
import com.utility.ExcelReaderUsingLoop;

public class TC_001_LoginTestClass extends BaseClass{
	
	LoginPage lp;
	static DataReader datareader;
	ExcelReaderUsingLoop excelloop;
	
	//Through config file
	//@Test(priority = 1)
	public void TC_001_LoginTest_Admin() throws InterruptedException
	{
		lp = new LoginPage(driver);
		//lp.txtUserName(getUserNameAdmin("userNameAdmin"));
		lp.txtUserName(getUserNameAdmin("userNameAdmin"));
		lp.txtPass(getPassAdmin("passAdmin"));
		lp.clickBtnSubmit();
		lp.clickLogout();
		
	}
	
	//Through excel loop - "Class name- ExcelReaderUsingLoop"
	//@Test(dataProvider = "loginData",dataProviderClass = ExcelReaderUsingLoop.class)
		public void TC_001_LoginTest_AdminUsingExcelLoop(String username, String password) throws InterruptedException
		{
		if (username == null) {
	        System.out.println("X SKIPPING TEST - Username is NULL");
	        return;
	    }
	    if (password == null) {
	        password = ""; // Ensure password is never null
	    }
	    
	    System.out.println(" >> Testing login for: '" + username + "'");
			lp = new LoginPage(driver);
			lp.txtUserName(username);
			lp.txtPass(password);
			lp.clickBtnSubmit();
			lp.clickLogout();
			
		}
	
	
	//By using excel reader "Class name- DataReader"
	//@Test(priority = 1)
	public void TC_001_LoginTest_AdminUsingExcel() throws IOException, InterruptedException
	{
		lp = new LoginPage(driver);
		lp.txtUserName(DataReader.readUserName1());
		lp.txtPass(DataReader.readPass1());
		lp.clickBtnSubmit();
		lp.clickLogout();
		
	}
	
	//Through data provider  - "Class name- DataProviderClass"
	@Test(priority = 1, dataProvider = "loginTest", dataProviderClass = DataProviderClass.class)
	public void TC_001_LoginTest_Admin_DataProvider(String user, String pass) throws IOException, InterruptedException
	{
		lp = new LoginPage(driver);
		lp.txtUserName(user);
		lp.txtPass(pass);
		lp.clickBtnSubmit();
		lp.clickLogout();
		
	}
	

	@Test(priority = 2)
	public void logoutMethodAdmin() throws InterruptedException
	{
		lp = new LoginPage(driver);
		lp.clickLogout();
	}
}
