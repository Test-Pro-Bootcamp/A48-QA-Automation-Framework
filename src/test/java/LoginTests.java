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
import pom.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    LoginPage loginPage;

    @Test(dataProvider = "loginParameters", dataProviderClass = DataProviderClass.class)
    public void loginEmailPasswordTest(String email, String password) {
        loginPage = new LoginPage(getDriver());
        String newName = generateName();

        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickLoginButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".avatar")));

        Assert.assertEquals(getDriver().getCurrentUrl(), QA_URL);
        Assert.assertTrue(getDriver().findElement(By.cssSelector(".avatar")).isDisplayed());
        Assert.assertFalse(loginPage.findWebElement(By.cssSelector("button[type='submit']")).isDisplayed());
    }

    @Test(dataProvider = "incorrectCredentials", dataProviderClass = DataProviderClass.class)
    public void loginWithIncorrectCredentialTest(String email, String password) {
        loginPage = new LoginPage(getDriver());
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickLoginButton();

        wait.until(ExpectedConditions.visibilityOf(loginPage.findWebElement(By.cssSelector("button[type='submit']"))));

        Assert.assertTrue(loginPage.findWebElement(By.cssSelector("button[type='submit']")).isDisplayed());
    }
}

