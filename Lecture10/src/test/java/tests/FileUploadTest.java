package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FileUploadPage;

public class FileUploadTest {
    private WebDriver driver;
    private FileUploadPage fileUploadPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/upload");
    }

    @Test
    public void uploadAndCheckFilename() {
        fileUploadPage = new FileUploadPage(driver);

        fileUploadPage.chooseFile()
                      .uploadFile();

        Assert.assertEquals(fileUploadPage.getFilename(), "lol.png");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
