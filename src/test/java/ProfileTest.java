import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.ProfilePage;

import java.time.Duration;

public class ProfileTest extends BaseTest {
    LoginPage loginPage;
    ProfilePage profilePage;

    @Test(testName = "Check updating profile's name")
    public void renameProfileTest() {
        loginPage = new LoginPage(getDriver());
        profilePage = new ProfilePage(getDriver());
        String newName = generateName();

        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickLoginButton();

        wait.until(ExpectedConditions.invisibilityOf(loginButton));

        profilePage.renameProfile(newName);

        getDriver().navigate().refresh();

        profilePage.waitUntilProfileInputDisplayed();
        Assert.assertEquals(profilePage.getProfileNameText(), newName);
    }
}
