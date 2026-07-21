package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReaderUsingLoopCalculation {
	
	 // Excel reading method
    public static Object[][] getCalculationData(String filePath) {

        List<Object[]> data = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream file = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                if (row == null) continue;

                String atticWidthL = formatter.formatCellValue(row.getCell(0));
                String atticWidthL1 = formatter.formatCellValue(row.getCell(1));
                String atticWidthL2 = formatter.formatCellValue(row.getCell(2));
                String atticWidthL3 = formatter.formatCellValue(row.getCell(3));
                String h = formatter.formatCellValue(row.getCell(4));
                String h1 = formatter.formatCellValue(row.getCell(5));
                String h2 = formatter.formatCellValue(row.getCell(6));
                String floorThickness = formatter.formatCellValue(row.getCell(7));
                String totalSurface = formatter.formatCellValue(row.getCell(8));
                String totalSurface1 = formatter.formatCellValue(row.getCell(9));
                String totalSurface2 = formatter.formatCellValue(row.getCell(10));
                String surfaceToInsulate = formatter.formatCellValue(row.getCell(11));
                String insulationThicknessToInstall = formatter.formatCellValue(row.getCell(12));

                data.add(new Object[] {
                        atticWidthL,
                        atticWidthL1,
                        atticWidthL2,
                        atticWidthL3,
                        h,
                        h1,
                        h2,
                        floorThickness,
                        totalSurface,
                        totalSurface1,
                        totalSurface2,
                        surfaceToInsulate,
                        insulationThicknessToInstall
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.toArray(new Object[0][]);
    }

    // DataProvider
    @DataProvider(name = "calculation")
    public static Object[][] getCalculation() {

        String path = System.getProperty("user.dir")
                + "\\src\\main\\java\\com\\utility\\Calculation.xlsx";

        return getCalculationData(path);
    }

}
