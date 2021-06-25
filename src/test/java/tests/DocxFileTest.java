package tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getDocx;

public class DocxFileTest {
        @Test
        void docxTest () throws InvalidFormatException, IOException {
                String docxFilePath = "src/test/resources/files/1.docx";
                String expectedData = "Simple docx test";
                String text = getDocx(docxFilePath);

                assertThat(text, containsString(expectedData));
        }
}