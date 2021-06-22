package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import static com.codeborne.xlstest.XLS.containsText;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getXls;

public class XlsFileTest {
    @Test
    void xlsTest() {
        String xlsFilePath = "src/test/resources/files/1.xls";
        String expectedData = "Simple xls test";

        XLS xls = getXls(xlsFilePath);
        assertThat(xls, containsText(expectedData));
    }
}
