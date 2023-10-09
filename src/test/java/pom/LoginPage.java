package pom;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    @FindBy(css = "input[type='email']")
    WebElement emailField;

    @FindBy(css = "input[type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//div/a[contains(text(), 'Registration')]")
    WebElement registrationButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage provideEmail(String email) {
        clickToElement(emailField);
        sendKeysToElement(emailField, email);
        return this;
    }

    public LoginPage providePassword(String password) {
        clickToElement(passwordField);
        sendKeysToElement(passwordField, password);
        return this;
    }

    public void clickLoginButton() {
        clickToElement(loginButton);
    }

    public void clickToRegistrationButton() {
        clickToElement(registrationButton);
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    public void waitUntilLoginButtonDisplayed() {
        waiUntilWebElementDisplayed(loginButton);
    }
}
