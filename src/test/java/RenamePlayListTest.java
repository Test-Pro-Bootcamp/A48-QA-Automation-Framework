import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

import java.awt.*;

public class RenamePlayListTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void renamePlayListTest() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickLoginButton();

        String newName = generateName();
        homePage.renamePlayList(newName);

        Assert.assertEquals(homePage.getPlayListName(), newName);
    }
}
