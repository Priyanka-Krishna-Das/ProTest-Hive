package com.utility;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="loginTest")
	public Object[][] getLoginData()
	{
		return new Object[][]{{"techdoc@mailinator.com","Password@123"},
			{"hiveadmin@test.com","Password@123"},
			{"havuvu@mailinator.com","Password@123"},
			{"muxekivyq@mailinator.com","Password@123"},
			{"pirocyjow@mailinator.com","Password@123"},
			{"zetov@mailinator.com","Password@123"},
			{"ziva@mailinator.com","Password@123"},
			{"xafiwep@mailinator.com","Password@123"},
			{"mymehatipo@mailinator.com","Password@123"},
			{"pirocyjow@mailinator.com","Password@123"}};
			
	}
	
	

}
