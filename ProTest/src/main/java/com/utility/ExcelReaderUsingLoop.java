package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReaderUsingLoop {
	
	public static Object[][] getLoginData(String filePath) {
        List<Object[]> data = new ArrayList<>();
        
        System.out.println("=== START ===");
        
        
        
        try (FileInputStream file = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            
            XSSFSheet sheet = workbook.getSheetAt(0);	
            
            System.out.println(" Reading sheet: " + sheet.getSheetName());
            System.out.println(" Total rows: " + (sheet.getLastRowNum() + 1));
            
            for (int i = 1; i <=sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                
                if (row == null) {
                	
                	System.out.println("➖ Row " + i + " is NULL - skipping");
                	continue;
   
                }
                String username = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();
                
                data.add(new Object[]{username, password});
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(" Error reading Excel: " + e.getMessage());
        }
        
        return data.toArray(new Object[0][]);
    }
	
	// Simple DataProvider that reads from Excel
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
    	System.out.println("=== DATA PROVIDER START ===");
        return ExcelReaderUsingLoop.getLoginData(System.getProperty("user.dir") + "\\src\\main\\java\\com\\utility\\HiveExcelLogin.xlsx");
    }
    
    
 // Simple DataProvider that reads from Excel
    @DataProvider(name = "calculation")
    public Object[][] getCalculation() {
    	System.out.println("=== DATA PROVIDER START ===");
        return ExcelReaderUsingLoop.getLoginData(System.getProperty("user.dir") + "\\src\\main\\java\\com\\utility\\HiveExcelLogin.xlsx");
    }

}
