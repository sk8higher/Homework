package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ShopPage;

public class AddToCartTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ShopPage shopPage;
    private CartPage cartPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/index.html");
    }

    @Test
    public void loginAndAddToCart() {
        loginPage = new LoginPage(driver);
        loginPage.login();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        shopPage = new ShopPage(driver);
        shopPage.addToCart();
        shopPage.goToCart();

        cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductDisplayed());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
