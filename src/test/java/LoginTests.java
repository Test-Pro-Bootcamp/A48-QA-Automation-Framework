import org.assertj.core.api.SoftAssertions;
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
import org.testng.asserts.SoftAssert;
import pom.HomePage;
import pom.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @Test(dataProvider = "loginParameters", dataProviderClass = DataProviderClass.class)
    public void loginEmailPasswordTest(String email, String password) {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());

        loginPage.provideEmail(email)
                .providePassword(password)
                .clickLoginButton();

        homePage.waitUntilAvatarDisplayed();

        SoftAssertions.assertSoftly(a -> {
            a.assertThat(getDriver().getCurrentUrl()).isEqualTo(QA_URL).as("Urls are not equal");
            a.assertThat(homePage.isAvatarDisplayed()).isTrue().as("Avatar is not displayed");
//            a.assertThat(loginPage.isLoginButtonDisplayed()).isTrue().as("Login button is not displayed");
        });

//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(getDriver().getCurrentUrl(), QA_URL);
//        softAssert.assertTrue(homePage.isAvatarDisplayed());
//        softAssert.assertTrue(loginPage.isLoginButtonDisplayed());
//        softAssert.assertAll();
    }

    @Test(dataProvider = "incorrectCredentials", dataProviderClass = DataProviderClass.class)
    public void loginWithIncorrectCredentialTest(String email, String password) {
        loginPage = new LoginPage(getDriver());
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickLoginButton();

        loginPage.waitUntilLoginButtonDisplayed();

        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }
}