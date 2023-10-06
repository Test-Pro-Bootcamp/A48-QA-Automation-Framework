package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void inputEmailForRegistration(String email) {
        WebElement registrationEmailInput = findWebElement(By.cssSelector("input[name='email']"));
        WebElement submitRegistrationButton = findWebElement(By.cssSelector("#button"));

        clickToElement(registrationEmailInput);
        sendKeysToElement(registrationEmailInput, email);
        clickToElement(submitRegistrationButton);
    }
}
