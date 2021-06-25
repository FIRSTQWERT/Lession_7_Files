package tests;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static utils.Files.getDoc;
import java.io.IOException;

public class DocFileTest {
        @Test
        void docTest() throws IOException {
        String docFilePath = "src/test/resources/files/1.doc";
        String expectedData = "Simple doc test";
        String text = getDoc(docFilePath);

        assertThat(text, containsString(expectedData));
        }
}