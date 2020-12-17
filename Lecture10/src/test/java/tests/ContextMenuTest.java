package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTest {
    private WebDriver driver;
    private ContextMenuPage contextMenuPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }

    @Test(description = "Right click on context menu and check what is the text in the alert")
    public void checkAlertContains() {
        contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.clickOnBox();
        Assert.assertEquals(contextMenuPage.checkAlert(), "You selected a context menu");
        contextMenuPage.closeAlert();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
