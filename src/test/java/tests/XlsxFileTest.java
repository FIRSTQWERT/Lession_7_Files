package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static utils.Files.getXlsx;

public class XlsxFileTest {
@Test
    public static void main(String[] args) throws IOException {
        String xlsxFilePath = "src/test/resources/files/1.xlsx";
        String expectedData = "Simple xlsx test";
        String actualData = getXlsx(xlsxFilePath, 3, 1);

        assertThat(actualData, containsString(expectedData));
    }

}