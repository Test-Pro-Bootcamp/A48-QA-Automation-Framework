import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void registrationWithNonApproveEmailTest() throws InterruptedException {
        WebElement registrationButton = getDriver().findElement(By.xpath("//div/a[contains(text(), 'Registration')]"));

        clickToElement(registrationButton);
        Thread.sleep(5000);

        WebElement registrationEmailInput = getDriver().findElement(By.cssSelector("input[name='email']"));
        WebElement submitRegistrationButton = getDriver().findElement(By.cssSelector("#button"));

        clickToElement(registrationEmailInput);
        sendKeysToElement(registrationEmailInput, "nonApproveEmail@gmaul.com");
        clickToElement(submitRegistrationButton);

        Thread.sleep(3000);

        WebElement errorMessage = getDriver().findElement(By.cssSelector(".errors"));

        Assert.assertEquals(errorMessage.getText(), "Sorry, only certain emails are allowed, please do not use your personal email");

    }
}
