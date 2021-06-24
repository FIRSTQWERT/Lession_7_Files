package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class XlsxFileTest {
@Test
    public static void main(String[] args) throws IOException {
        String xlsFilePath = "src/test/resources/files/1.xlsx";
        String expectedData = "Simple xlsx test";

        File excelFile = new File(xlsFilePath);
        FileInputStream fis = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(3);
        String cell = row.getCell(1).toString();

        assertThat(cell, containsString(expectedData));

        workbook.close();
        fis.close();
    }

}