import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    @Parameters({"qaUrl"})
    public void addSongToPlaylist(String qaUrl) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        provideEmail("iana.kocharian@testpro.io");
        providePassword("CwqOPgQw");
        loginButton.click();
        WebElement allSongs = driver.findElement(By.cssSelector("a[class='songs']"));
        wait.until(ExpectedConditions.elementToBeClickable(allSongs));
        allSongs.click();
        WebElement anySong = driver.findElement(By.cssSelector("table tr[draggable='true']"));
        anySong.click();
        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToButton.click();
        WebElement inputField = driver.findElement(By.cssSelector("input[type='text']"));
        inputField.click();
        inputField.sendKeys("test");
        WebElement submitButton = driver.findElement(By.cssSelector("form button[type='submit']"));
        submitButton.click();
        WebElement successMessage = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(successMessage.isDisplayed());
        driver.quit();
    }
}
