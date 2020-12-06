import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopPage {
    public WebDriver driver;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> products;

    @FindBy(linkText = "ADD TO CART")
    private List<WebElement> productsAddToCartButtons;

    @FindBy(xpath = "//a[@href='./cart.html']")
    private WebElement cart;

    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        productsAddToCartButtons.get(0).click();
    }

    public void goToCart() {
        cart.click();
    }
}
