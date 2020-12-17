package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillUserNameField(String inputUsername) {
        username.sendKeys(inputUsername);
    }

    public void fillPasswordField(String inputPassword) {
        password.sendKeys(inputPassword);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login() {
        fillUserNameField("standard_user");
        fillPasswordField("secret_sauce");
        clickLoginButton();
    }
}
