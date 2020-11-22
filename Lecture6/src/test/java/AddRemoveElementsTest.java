import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElementsTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test(description = "Add 2 elements, delete an element, check the amount of elements")
    public void addingDeletingElements() {
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']")); //Add button element
        addButton.click(); //Adding two elements
        addButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']")); //Delete button on existing element
        deleteButton.click(); //Deleting one element

        List<WebElement> count = driver.findElements(By.xpath("//button[text()='Delete']")); //List with added elements

        Assert.assertEquals(count.size(), 1); //Checking if count of elements is 1 after deleting
    }
}
