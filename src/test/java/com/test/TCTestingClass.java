package com.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class TCTestingClass extends BaseClass {
	
	@Test
	public void testing() throws IOException
	{
		//setUp("chrome");
		System.out.println("Testing");
	}
	
	@DataProvider(name="ExcelData")
	public Object[][] excelData()
	{
		Object[][] arrObje= getExcelData("C:\\Users\\Priyanka D\\git\\repository\\ProTest\\src\\main\\java\\com\\utility\\HiveExcelLogin.xlsx", "Sheet1");
		return arrObje;
	}
	public String[][] getExcelData(String fileName,String sheetName)
	{
		String[][] data=null;	
		
		try {
			
			FileInputStream file = new FileInputStream(fileName);
			XSSFWorkbook wb =new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			
			int noOfRows = sheet.getPhysicalNumberOfRows(); //get number of row in sheet
			int noOfCols = row.getLastCellNum(); 
			
			Cell cell;
			
			data = new String [noOfRows-1][noOfCols]; //ittrate like - 0,0  /0,1  /0,2 ....
			
			for(int i=1;i< noOfRows ; i++) //first row will be header so starting from 1
			{
				for(int j=0;i<noOfCols;j++)
				{
					row = sheet.getRow(i);
					cell = row.getCell(j);
					//System.out.println("Reading cell index: " + j);
					
					if(cell != null)
					{
						data[i-1][j] = cell.getStringCellValue();
					}
					
				}
			}
			
		} catch (Exception e) {
			System.out.println("test exception is: "+e.getMessage());
		}
		
		return data;
		
	}

	
}
