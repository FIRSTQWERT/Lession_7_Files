package utils;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Section;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Files {
    public static String readTextFromFile(File file) throws IOException {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }

    public static String readTextFromPath(String path) throws IOException {
        return readTextFromFile(getFile(path));
    }

    public static File getFile(String path) {
        return new File(path);
    }

    public static PDF getPdf(String path) throws IOException {
        return new PDF(getFile(path));
    }

    public static XLS getXls(String path) {
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

    public static String getDocx(String docxFilePath) throws InvalidFormatException, IOException {
        StringBuilder text = new StringBuilder();
        XWPFDocument doc = new XWPFDocument(OPCPackage.open(docxFilePath));
        for (XWPFParagraph p : doc.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            for (XWPFRun r : runs) {
                text.append(r.getText(0));
            }
        }
        return text.toString();
    }

    public static String getDoc(String docFilePath) throws IOException {
        StringBuilder text = new StringBuilder();

        HWPFDocument doc = new HWPFDocument(new FileInputStream(docFilePath));
        Range r = doc.getRange();
        Section section = r.getSection(r.numSections() - 1);

        for (int np = 0; np < section.numParagraphs(); np++) {
            Paragraph para = section.getParagraph(np);
            text.append(para.text());
        }
        return text.toString();
    }

}