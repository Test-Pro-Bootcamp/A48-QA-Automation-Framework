package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".avatar")
    WebElement avatar;

    @FindBy(xpath = "//li[contains(@class, 'playlist')][3]")
    WebElement playList;

    public boolean isAvatarDisplayed() {
        return avatar.isDisplayed();
    }
    public void waitUntilAvatarDisplayed() {
        waiUntilWebElementDisplayed(avatar);
    }

    public void renamePlayList(String newName) {
        actions.doubleClick(playList).perform();
        playList.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
        playList.sendKeys(newName);
        playList.sendKeys(Keys.ENTER);
    }

    public String getPlayListName() {
        return playList.getText();
    }
}
