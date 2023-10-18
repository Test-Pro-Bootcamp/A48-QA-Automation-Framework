package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlaySongPage extends BasePage {

    @FindBy(css = "[class='song-item']")
    List<WebElement> songs;

    @FindBy(css = "[class='playback']")
    WebElement playButtonByContextMenu;

    @FindBy(css = "[title='Play or resume']")
    WebElement playPauseButton;

    @FindBy(css = "[data-testid='sound-bar-play']")
    WebElement soundBar;

    public PlaySongPage(WebDriver driver) {
        super(driver);
    }

    public void playSong() {
        actions.contextClick(songs.get(0)).perform();
        clickToElement(playButtonByContextMenu);
    }

    public void startPlaySong() {
        // WebElement buttonPlayOrResume = driver.findElement(By.cssSelector("[title='Play or resume']"));
        actions
                .moveToElement(playPauseButton)
                .perform();
        playPauseButton.click();
    }

    public void waitUntilSongBarDisplayed() {
        waiUntilWebElementDisplayed(soundBar);
    }

    public boolean isSongBarDisplayed() {
        return soundBar.isDisplayed();
    }

    public int getSongsCount() {
        return songs.size();
    }
}
