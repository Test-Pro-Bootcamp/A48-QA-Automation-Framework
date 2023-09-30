import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "loginParameters", dataProviderClass = DataProviderClass.class)
    public void loginEmailPasswordTest(String email, String password) throws InterruptedException {

        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        provideEmail(email);
        providePassword(password);

        clickToElement(loginButton);
        Thread.sleep(5000);

        WebElement avatar = getDriver().findElement(By.cssSelector(".avatar"));
        loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        Assert.assertEquals(getDriver().getCurrentUrl(), QA_URL);
        Assert.assertTrue(avatar.isDisplayed());
        Assert.assertFalse(loginButton.isDisplayed());
    }

    @Test(dataProvider = "incorrectCredentials", dataProviderClass = DataProviderClass.class)
    public void loginWithIncorrectCredentialTest(String email, String password) throws InterruptedException {

        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        provideEmail(email);
        providePassword(password);

        clickToElement(loginButton);
        Thread.sleep(5000);
        Assert.assertTrue(loginButton.isDisplayed());
    }
}

