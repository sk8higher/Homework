package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public WebDriver driver;

    @FindBy(className = "cart_item")
    private WebElement cartItem;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean isProductDisplayed() {
        return cartItem.isDisplayed();
    }
}
