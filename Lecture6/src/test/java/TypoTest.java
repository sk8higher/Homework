import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TypoTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/typos");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test(description = "Check if there are typos in a paragraph.")
    public void checkingTypos() {
        List<WebElement> listOfParagraphs = driver.findElements(By.tagName("p")); //Finding all the paragraphs on page
        WebElement typoParagraph = listOfParagraphs.get(1); //Getting a certain paragraph
        Assert.assertEquals(typoParagraph.getText(), "Sometimes you'll see a typo, other times you won't."); //Checking if the paragraph contains a typo
    }
}