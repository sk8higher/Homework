import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortableDataTablesTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test(description = "Check the contents of some table cells")
    public void dataTablesTest() {
        WebElement firstCellFirstLine = driver.findElement(By.xpath("//table//tr[1]//td[1]"));
        Assert.assertEquals(firstCellFirstLine.getText(), "Smith");

        WebElement thirdCellSecondLine = driver.findElement(By.xpath("//table//tr[2]//td[3]"));
        Assert.assertEquals(thirdCellSecondLine.getText(), "fbach@yahoo.com");

        WebElement fifthCellThirdLine = driver.findElement(By.xpath("//table//tr[3]//td[5]"));
        Assert.assertEquals(fifthCellThirdLine.getText(), "http://www.jdoe.com");

        WebElement fourthCellFirstLine = driver.findElement(By.xpath(("//table//tr[1]//td[4]")));
        Assert.assertEquals(fourthCellFirstLine.getText(), "$50.00");
    }
 }
