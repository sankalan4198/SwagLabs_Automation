package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    private static final String TEST_DATA_FILE="testdata.xlsx";

    public static List<String> getProductKeys(String sheetName) throws IOException {
        List<String> productKeys= new ArrayList<>();

        try(InputStream inputStream=ExcelReader.class.getClassLoader().getResourceAsStream(TEST_DATA_FILE))
        {
            if(inputStream==null){
                throw new RuntimeException("testdata.xlsx file not found in folder!");
            }

            Workbook workbook= new XSSFWorkbook(inputStream);
            Sheet sheet= workbook.getSheet(sheetName);

            if(sheet==null)
            {
                throw new RuntimeException("Sheet "+sheetName+" not found in testdata.xlsx");
            }

            int firstRow= sheet.getFirstRowNum() +1;//Skipping header
            int lastRow= sheet.getLastRowNum();

            for(int i= firstRow;i<=lastRow;i++)
            {
                Row row=sheet.getRow(i);
                if(row==null)
                    continue;

                Cell cell= row.getCell(0);
                if(cell==null)
                    continue;

                String productKey = cell.getStringCellValue().trim();


                if(productKey!=null && !productKey.trim().isEmpty())
                {
                    productKeys.add(productKey.trim());
                }
            }
            workbook.close();
        }catch (Exception e){
            throw new RuntimeException("Failed to read productKeys from excel file");
        }

        return productKeys;
    }
}
