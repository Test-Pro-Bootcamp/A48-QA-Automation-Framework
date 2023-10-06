package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlaySongPage extends BasePage {

    public PlaySongPage(WebDriver driver) {
        super(driver);
    }

    public void playSong() {
        List<WebElement> songs = findWebElements(By.cssSelector("[class='song-item']"));
        actions.contextClick(songs.get(0)).perform();
        WebElement playButtonByContextMenu = findWebElement(By.cssSelector("[class='playback']"));
        clickToElement(playButtonByContextMenu);
    }
}
