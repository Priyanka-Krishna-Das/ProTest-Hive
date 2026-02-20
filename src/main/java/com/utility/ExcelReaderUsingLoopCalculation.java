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

                String flooreThickness = formatter.formatCellValue(row.getCell(0));
                String atticLength = formatter.formatCellValue(row.getCell(1));
                String atticWidth = formatter.formatCellValue(row.getCell(2));
                String internalRidgeHeight = formatter.formatCellValue(row.getCell(3));
                String halfSpan = formatter.formatCellValue(row.getCell(4));
                String surfaceToInsulate = formatter.formatCellValue(row.getCell(5));
                String totalSurface = formatter.formatCellValue(row.getCell(6));
                String reccomenedThickness = formatter.formatCellValue(row.getCell(7));

                data.add(new Object[]{
                        flooreThickness,
                        atticLength,
                        atticWidth,
                        internalRidgeHeight,
                        halfSpan,
                        surfaceToInsulate,
                        totalSurface,
                        reccomenedThickness
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
