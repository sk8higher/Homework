import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;

public class InputsTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/inputs");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test(description = "Check if you can enter different numeric " +
                        "and non-numeric values using Keys.ARROW_UP" +
                        "and Keys.ARROW_DOWN")
    public void inputTest() { //17
        WebElement inputField = driver.findElement(By.tagName("input")); //Finding input field
        inputField.sendKeys("1234", Keys.ARROW_UP); //Sending 1234 and clicking arrow up
        Assert.assertEquals(inputField.getAttribute("value"), "1235"); // Passed

        inputField.clear();
        inputField.sendKeys("12.32", Keys.ARROW_DOWN); //Checking floating numbers
        Assert.assertEquals(inputField.getAttribute("value"), "12.31"); //It will fail with 12

        inputField.clear();
        inputField.sendKeys("12E", Keys.ARROW_DOWN); //Sending a value with a letter
        Assert.assertEquals(inputField.getAttribute("value"), "12E"); // Passed

        inputField.clear();
        inputField.sendKeys("qwefs", Keys.ARROW_UP); //Sending a string containing only letters
        Assert.assertEquals(inputField.getAttribute("value"), "qwefs"); // Passed

        String longNumber = "12345678901234111"; //Line contains a number of 17 digits, tests fail for numbers from 17 digits and more

        inputField.clear();
        inputField.sendKeys(longNumber, Keys.ARROW_UP, Keys.ARROW_UP);
        Assert.assertEquals(inputField.getAttribute("value"), "12345678901234113"); // arrow up and down don't work here anymore, the result is 12345678901234112, failed

        inputField.clear();
        inputField.sendKeys(longNumber, Keys.ARROW_DOWN);
        Assert.assertEquals(inputField.getAttribute("value"), "12345678901234110"); // the result is 12345678901234112, failed
    }
}
