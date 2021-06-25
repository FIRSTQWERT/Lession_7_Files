package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static utils.Files.getXls;

public class XlsFileTest {
    @Test
    void XlsCellTest() {
        String xlsFilePath = "src/test/resources/files/1.xls";
        String expectedData = "Hello World!!!";

        XLS xls = getXls(xlsFilePath);
        String actualData = xls.excel.getSheetAt(0).getRow(2).getCell(1).toString();
        assertThat(actualData, containsString(expectedData));
    }
}
