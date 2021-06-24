package utils;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

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
    public static XLS getXlsx(String path) throws IOException {

        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(path));
        HSSFSheet myExcelSheet = myExcelBook.getSheet("Birthdays");
        HSSFRow row = myExcelSheet.getRow(0);


        myExcelBook.close();

        return new XLS(getFile(path));
    }
}
