import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Homework18 extends BaseTest {
    @Test
    @Parameters({"qaUrl"})
    public void playSong(String qaUrl) {
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        provideEmail("iana.kocharian@testpro.io");
        providePassword("CwqOPgQw");
        loginButton.click();
        WebElement allSongs = driver.findElement(By.cssSelector("a[class='songs']"));
        clickToElement(allSongs);
        List<WebElement> songs = driver.findElements(By.cssSelector("table tr[draggable='true']"));
        wait.until(ExpectedConditions.elementToBeClickable(songs.get(0)));
        actions.doubleClick(songs.get(0)).perform();
        WebElement soundBar = driver.findElement(By.cssSelector("div [data-test='soundbars']"));
        wait.until(ExpectedConditions.visibilityOf(soundBar));
        Assert.assertTrue(soundBar.isDisplayed());
        Assert.assertEquals(songs.size(), 66);
        driver.quit();
    }
}
