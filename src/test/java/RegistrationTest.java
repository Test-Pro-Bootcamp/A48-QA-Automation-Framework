import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.RegistrationPage;

import java.time.Duration;

public class RegistrationTest extends BaseTest {
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @Test
    public void registrationWithNonApproveEmailTest() {
        loginPage = new LoginPage(getDriver());
        registrationPage = new RegistrationPage(getDriver());

        loginPage.clickToRegistrationButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email']")));

        registrationPage.inputEmailForRegistration("nonApproveEmail@gmaul.com");

        registrationPage.waitUntilErrorMessageDisplayed();
        Assert.assertEquals(registrationPage.getErrorMessageText(), "Sorry, only certain emails are allowed, please do not use your personal email");

    }
}
