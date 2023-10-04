import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PlaySongTest extends BaseTest {

    @Test
    public void playSongTest() {
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");

        clickToElement(loginButton);

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//a[contains(@class, 'home')]")));

        getDriver().get("https://qa.koel.app/#!/songs");

        List<WebElement> songs = getDriver().findElements(By.cssSelector("[class='song-item']"));

        actions.contextClick(songs.get(0)).perform();

        WebElement playButtonByContextMenu = getDriver().findElement(By.cssSelector("[class='playback']"));
        clickToElement(playButtonByContextMenu);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));

        WebElement soundBar = getDriver().findElement(By.cssSelector("[data-testid='sound-bar-play']"));

        Assert.assertTrue(soundBar.isDisplayed());
        Assert.assertEquals(songs.size(), 66);

        actions.clickAndHold(soundBar).perform();
        actions.release();
    }
}
