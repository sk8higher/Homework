import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationMessagesTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test(description = "Click the button, wait until the notification appears" +
                        "check the text")
    public void notificationIsSuccessfulTest() {
        WebElement mainButton = driver.findElement(By.xpath("//a[@href='/notification_message']")); //Finding click here button
        mainButton.click();
        WebElement notification = driver.findElement(By.id("flash")); //Finding notification
        Assert.assertEquals(notification.getText(), "Action successful"); //Checking if the action is successful
    }

}
