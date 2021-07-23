package tests;

import com.codeborne.selenide.Configuration;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import utils.Files;

import java.io.File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class DownloadFileTests {
    @Test
// DOC: https://selenide.org/2019/12/10/advent-calendar-download-files/
    void selenideDownloadReadmeTest() throws IOException {
        Configuration.downloadsFolder = "downloads";
        open("https://github.com/selenide/selenide/blob/master/README.md");
        File downloadedFile = $("#raw-url").download();
        String fileContent = Files.readTextFromFile(downloadedFile);
        assertThat(fileContent, containsString("Selenide = UI Testing Framework powered by Selenium WebDriver"));
        FileUtils.deleteDirectory(new File("downloads"));
    }
}
