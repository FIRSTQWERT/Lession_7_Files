package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;

public class PdfFileTest {
    @Test
    void txtTest() throws IOException {
        String pdfFilePath = "src/test/resources/files/1.pdf";
        String expectedData = "Hello World!!!111";
        String actualData = readTextFromPath(pdfFilePath);

        assertThat(actualData, containsString(expectedData));
    }
    

}
