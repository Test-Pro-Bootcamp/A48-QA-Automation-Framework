package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(css = "input[name='email']")
    WebElement registrationEmailInput;

    @FindBy(css = "#button")
    WebElement submitRegistrationButton;

    @FindBy(css = ".errors")
    WebElement errorMessage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void inputEmailForRegistration(String email) {
        clickToElement(registrationEmailInput);
        sendKeysToElement(registrationEmailInput, email);
        clickToElement(submitRegistrationButton);
    }

    public void waitUntilErrorMessageDisplayed() {
        waiUntilWebElementDisplayed(errorMessage);
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
