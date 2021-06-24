package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.*;

public class PdfFileTest {
    @Test
    void txtTest() throws IOException {
        String pdfFilePath = "src/test/resources/files/1.pdf";
        String expectedData = "Online ROM Flash Component";

        PDF pdf = getPdf(pdfFilePath);
        assertThat(pdf, containsText(expectedData));
    }
}
