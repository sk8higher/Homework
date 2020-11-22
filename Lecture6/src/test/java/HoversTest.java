import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoversTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/hovers");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test(description = "Hover onto the profile, check name, click on the link," +
            "check if there a 404 error")
    public void firstUserHoversTest() {
        Actions action = new Actions(driver);
        List<WebElement> listOfUsers = driver.findElements(By.className("figure")); //List of users

        action.moveToElement(listOfUsers.get(0)).perform(); //hover on to first user
        WebElement firstUserName = driver.findElement(By.tagName("h5")); //finding the name
        Assert.assertEquals(firstUserName.getText(), "name: user1");

        WebElement firstProfile = driver.findElement(By.linkText("View profile"));
        firstProfile.click();
        WebElement firstNotFound = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(firstNotFound.getText(), "Not Found"); //checking if there a 404 error
    }

    @Test(description = "Doing the same for the second profile")
    public void secondUserHoversTest() {
        Actions action = new Actions(driver);
        List<WebElement> listOfUsers = driver.findElements(By.className("figure"));

        action.moveToElement(listOfUsers.get(1)).perform();
        WebElement secondUserName = driver.findElement(By.tagName("h5"));
        Assert.assertEquals(secondUserName.getText(), "name: user2");

        WebElement secondProfile = driver.findElement(By.linkText("View profile"));
        secondProfile.click();
        WebElement secondNotFound = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(secondNotFound.getText(), "Not Found");
    }

    @Test(description = "Doing the same for the third profile")
    public void thirdUserHoversTest() {
        Actions action = new Actions(driver);
        List<WebElement> listOfUsers = driver.findElements(By.className("figure"));

        action.moveToElement(listOfUsers.get(2)).perform();
        WebElement thirdUserName = driver.findElement(By.tagName("h5"));
        Assert.assertEquals(thirdUserName.getText(), "name: user3");

        WebElement thirdProfile = driver.findElement(By.linkText("View profile"));
        thirdProfile.click();
        WebElement thirdNotFound = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(thirdNotFound.getText(), "Not Found");
    }
}
