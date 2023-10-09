import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.PlaySongPage;

import java.util.List;

public class PlaySongTest extends BaseTest {
    LoginPage loginPage;
    PlaySongPage playSongPage;

    @Test
    public void playSongTest() {
        loginPage = new LoginPage(getDriver());
        playSongPage = new PlaySongPage(getDriver());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickLoginButton();

        getDriver().get("https://qa.koel.app/#!/songs");

        playSongPage.playSong();
        playSongPage.waitUntilSongBarDisplayed();

        Assert.assertTrue(playSongPage.isSongBarDisplayed());
        Assert.assertEquals(playSongPage.getSongsCount(), 66);
    }
}
