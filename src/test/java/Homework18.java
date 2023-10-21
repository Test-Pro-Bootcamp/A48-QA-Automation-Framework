import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest {
    @Test
    @Parameters({"qaUrl"})
    public void playSong(String qaUrl) {

        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        provideEmail("iana.kocharian@testpro.io");
        providePassword("CwqOPgQw");
        loginButton.click();
        WebElement allSongs = driver.findElement(By.cssSelector("a[class='songs']"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(allSongs));
        allSongs.click();
        WebElement anySong = driver.findElement(By.cssSelector("table tr[draggable='true']"));
        Actions action = new Actions(driver);
        action.doubleClick(anySong).perform();
        WebElement soundBar = driver.findElement(By.cssSelector("div [data-test='soundbars']"));
        wait.until(ExpectedConditions.visibilityOf(soundBar));
        Assert.assertTrue(soundBar.isDisplayed());
        driver.quit();
    }
}
