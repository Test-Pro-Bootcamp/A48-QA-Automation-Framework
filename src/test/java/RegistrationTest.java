import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTest extends BaseTest {

    @Test
    public void registrationWithNonApproveEmailTest() {
        WebElement registrationButton = getDriver().findElement(By.xpath("//div/a[contains(text(), 'Registration')]"));

        clickToElement(registrationButton);

        Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email']")));

        WebElement registrationEmailInput = getDriver().findElement(By.cssSelector("input[name='email']"));
        WebElement submitRegistrationButton = getDriver().findElement(By.cssSelector("#button"));

        clickToElement(registrationEmailInput);
        sendKeysToElement(registrationEmailInput, "nonApproveEmail@gmaul.com");
        clickToElement(submitRegistrationButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".errors")));

        WebElement errorMessage = getDriver().findElement(By.cssSelector(".errors"));
        Assert.assertEquals(errorMessage.getText(), "Sorry, only certain emails are allowed, please do not use your personal email");

    }
}
