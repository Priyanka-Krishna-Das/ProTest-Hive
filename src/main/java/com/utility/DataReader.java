package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataReader {
	
	public static String readUserName1() throws IOException
	{
		String path =System.getProperty("user.dir")+"\\src\\main\\java\\com\\utility\\HiveExcelLogin.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//User pass - 1
		String user1=workbook.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		
		return user1;
	}

	public static String readPass1() throws IOException
	{
		String path =System.getProperty("user.dir")+"\\src\\main\\java\\com\\utility\\HiveExcelLogin.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//User pass - 1
		String pass1=workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		
		return pass1;
	}

}
