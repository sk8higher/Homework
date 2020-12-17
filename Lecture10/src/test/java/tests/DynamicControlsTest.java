package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;

public class DynamicControlsTest {
    private WebDriver driver;
    private DynamicControlsPage dynamicControlsPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void checkboxTest() {
        dynamicControlsPage = new DynamicControlsPage(driver);

        Assert.assertTrue(dynamicControlsPage.findCheckbox());

        dynamicControlsPage.clickRemoveButton();
    }

    @Test
    public void inputTest() {
        dynamicControlsPage = new DynamicControlsPage(driver);

        Assert.assertEquals(dynamicControlsPage.isInputDisabled(), "true");

        dynamicControlsPage.clickEnableFieldButton();

        Assert.assertNull(dynamicControlsPage.isInputDisabled());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
