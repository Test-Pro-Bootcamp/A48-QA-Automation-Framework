import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "loginParameters", dataProviderClass = DataProviderClass.class)
    public void loginEmailPasswordTest(String email, String password) {

        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        provideEmail(email);
        providePassword(password);

        clickToElement(loginButton);
        String newName = generateName();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".avatar")));


        loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        Assert.assertEquals(getDriver().getCurrentUrl(), QA_URL);
        Assert.assertTrue(getDriver().findElement(By.cssSelector(".avatar")).isDisplayed());
        Assert.assertFalse(loginButton.isDisplayed());
    }

    @Test(dataProvider = "incorrectCredentials", dataProviderClass = DataProviderClass.class)
    public void loginWithIncorrectCredentialTest(String email, String password) {

        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        provideEmail(email);
        providePassword(password);

        clickToElement(loginButton);

        wait.until(ExpectedConditions.visibilityOf(loginButton));

        Assert.assertTrue(loginButton.isDisplayed());
    }
}

