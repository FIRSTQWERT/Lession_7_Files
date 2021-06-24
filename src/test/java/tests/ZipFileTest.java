package tests;

import net.lingala.zip4j.ZipFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static utils.Files.readTextFromPath;

public class ZipFileTest {
@Test
    public static void main(String[] args) throws IOException {
        String zipFilePath = "src/test/resources/files/1.zip";
        String unzipFilePath = "src/test/resources/files/unzip";
        String unzipFileName = "2.txt";
        String password = "1234567890";
        String expectedData = "Simple zip test";

        new ZipFile(zipFilePath, password.toCharArray()).extractFile(unzipFileName, unzipFilePath);

        String actualData = readTextFromPath(unzipFilePath + "/" + unzipFileName);

        assertThat(actualData, containsString(expectedData));
    }

}