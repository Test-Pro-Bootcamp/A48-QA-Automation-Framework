import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTests extends BaseTest {
    @Test
    public void loginEmailPasswordTest() throws InterruptedException {

        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        clickToElement(emailField);
        sendKeyToElement(emailField, "demo@class.com");
        clickToElement(passwordField);
        sendKeyToElement(passwordField,"te$t$tudent");
        clickToElement(loginButton);
        Thread.sleep(5000);

        WebElement avatar = getDriver().findElement(By.cssSelector(".avatar"));
        loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        Assert.assertTrue(avatar.isDisplayed());
        Assert.assertFalse(loginButton.isDisplayed());

    }

    @Test
    public void loginWithNotExistEmailTest() throws InterruptedException {

        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
        clickToElement(emailField);
        sendKeyToElement(emailField, "notExist@class.com");
        clickToElement(passwordField);
        sendKeyToElement(passwordField,"te$t$tudent");
        clickToElement(loginButton);

        Thread.sleep(5000);
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @Test
    public void loginWithoutPasswordTest() throws InterruptedException {

        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        clickToElement(emailField);
        sendKeyToElement(emailField, "notExist@class.com");
        clickToElement(loginButton);
        Thread.sleep(5000);
        Assert.assertTrue(loginButton.isDisplayed());
    }

}

