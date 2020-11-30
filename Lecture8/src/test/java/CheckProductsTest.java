import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;


import java.util.List;

public class CheckProductsTest {
    private static final Logger log = Logger.getLogger(CheckProductsTest.class);
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/index.html");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
    }

    @Test
    public void productsTest() {
        WebElement userNameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        String username = "standard_user";
        String password = "secret_sauce";

        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        List<WebElement> prodNames = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<WebElement> prodPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        for (int i = 0; i < products.size(); i++) {
            log.warn("Product Name: " + prodNames.get(i).getText() +     //warn logging for checking in console
                     "\nProduct Price: " + prodPrice.get(i).getText());
        }

    }

}
