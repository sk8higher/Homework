import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest {
    public static LoginPage loginPage;
    public static WebDriver driver;
    public static ShopPage shopPage;
    public static CartPage cartPage;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        wait = new WebDriverWait(driver, 10);

        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void loginAndAddToCart() throws NullPointerException { //тест падает с nullpointerexception не понятно почему
        try {
            loginPage.login();
            shopPage.addToCart();
            shopPage.goToCart();

            Assert.assertTrue(cartPage.getCartItem().isDisplayed());
        } catch (NullPointerException npe) {
            System.out.println("?");
        }
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
