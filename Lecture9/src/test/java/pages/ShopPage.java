package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    public WebDriver driver;

    @FindBy(xpath = "(//button[text() = 'ADD TO CART'])[1]")
    private WebElement productOne;

    @FindBy(xpath = "//a[@href='./cart.html']")
    private WebElement cart;

    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        productOne.click();
    }

    public void goToCart() {
        cart.click();
    }
}
