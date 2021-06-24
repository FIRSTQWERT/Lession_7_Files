package utils;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Files {
    public static String readTextFromFile(File file) throws IOException {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }
    public static String readTextFromPath(String path) throws IOException {
        return readTextFromFile(getFile(path));
    }
    public static File getFile (String path) {
        return new File(path);
    }
    public static PDF getPdf (String path) throws IOException {
        return new PDF(getFile(path));
    }
    public static XLS getXls (String path) {
        return new XLS(getFile(path));
    }
    public static String getXlsx(String xlsxFilePath, int rowNumber, int cellNumber) throws IOException {
        File excelFile = new File(xlsxFilePath);
        FileInputStream fis = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(rowNumber);
        String cell = row.getCell(cellNumber).toString();

        workbook.close();
        fis.close();
        return cell;
    }

}
