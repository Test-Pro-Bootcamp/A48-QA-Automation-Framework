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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));

        WebElement soundBar = getDriver().findElement(By.cssSelector("[data-testid='sound-bar-play']"));

        Assert.assertTrue(soundBar.isDisplayed());
        Assert.assertEquals(playSongPage.findWebElements(By.cssSelector("[class='song-item']")).size(), 66);
    }
}
