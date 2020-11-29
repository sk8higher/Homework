import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DropdownTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test(description = "Take all drop-down elements and check their availability. " +
                        "Select the first one, check that it is selected, " +
                        "select the second one, check that it is selected")
    public void dropdownElementsTest() {
        WebElement selectElement = driver.findElement(By.id("dropdown")); //Finding the dropdown element
        Select select = new Select(selectElement); //Initialising dropdown element as select
        List<WebElement> listOfOptions = select.getOptions(); //Getting options from dropdown
        Assert.assertEquals(listOfOptions.size(), 3); //There are two options, but the zero indexed one is "Please select the element" dummy

        WebElement firstOption = listOfOptions.get(1); //Getting "Option 1"
        firstOption.click(); //Choosing first option
        Assert.assertTrue(firstOption.isSelected()); //Checking if first option is selected

        WebElement secondOption = listOfOptions.get(2); //Getting "Option 2"
        secondOption.click(); //Choosing second option
        Assert.assertTrue(secondOption.isSelected()); //Checking if second option is selected
    }
}
