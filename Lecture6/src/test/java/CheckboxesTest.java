import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckboxesTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test(description = "Check if the first checkbox is unchecked, check first checkbox, check if it is checked." +
                        "Check if the second checkbox is checked, do uncheck, check if it is unchecked.")
    public void checkingAndUncheckingCheckboxes() {
        ArrayList<WebElement> checkboxesList = new ArrayList<>(driver.findElements(By.tagName("input"))); //Finding the checkboxes

        WebElement firstCheckbox = checkboxesList.get(0); //Getting the first checkbox
        Assert.assertFalse(firstCheckbox.isSelected()); //Checking if the first checkbox is unchecked
        firstCheckbox.click(); //Checking the first checkbox
        Assert.assertTrue(firstCheckbox.isSelected()); //Checking if the first checkbox is checked

        WebElement secondCheckbox = checkboxesList.get(1); //Getting the second checkbox
        Assert.assertTrue(secondCheckbox.isSelected()); //Checking if the second checkbox is checked
        secondCheckbox.click(); //Unchecking the second checkbox
        Assert.assertFalse(secondCheckbox.isSelected()); //Checking if the second checkbox is unchecked
    }
}
