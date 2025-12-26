package org.thetestingacademy.utilsexcel;



import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilExcel
{


    public static String SHEET_PATH = System.getProperty("user.dir") + "/src/test/Resource/TestData.xlsx";
    static Workbook book;
    static Sheet sheet;


    public static Object[][] getTestDataFromExcel(String sheetName) {

        // Apache POI
        // Read the File - TestData.xlsX
        //  Workbook Create
        // Sheet
        // Row and Cell
        // 2D Object  - getData()

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(SHEET_PATH);
            book = WorkbookFactory.create(fileInputStream);
            sheet = book.getSheet(sheetName);

        } catch (IOException e) {
            System.out.println("File not found");
        }


        Object[][] data = new Object[sheet.getLastRowNum()][2];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i + 1); // skip header
            for (int j = 0; j < 2; j++) {

                // First row email, password -> column name - skip - header
                Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                data[i][j] = cell.toString();

            }
        }


        return data;
    }


}