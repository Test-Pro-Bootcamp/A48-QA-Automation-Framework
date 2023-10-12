import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class LoginTests extends BaseTest {
    @Test
    @Parameters({"qaUrl"})
    public void loginEmailPasswordTest(String qaUrl) throws InterruptedException {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
        clickToElement(loginButton);
        Thread.sleep(5000);

        WebElement avatar = getDriver().findElement(By.cssSelector(".avatar"));
        loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        Assert.assertTrue(avatar.isDisplayed());
        Assert.assertFalse(loginButton.isDisplayed());

    }

    @Test
    public void loginWithNotExistEmailTest() throws InterruptedException {

        provideEmail("notExist@class.com");
        providePassword("te$t$tudent");
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
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

