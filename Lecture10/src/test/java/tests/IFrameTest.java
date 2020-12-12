package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.IFramePage;

public class IFrameTest {
    private WebDriver driver;
    private IFramePage iFramePage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void textEqualsTest() {
        iFramePage = new IFramePage(driver);
        Assert.assertEquals(iFramePage.getEditorText(), "Your content goes here.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
