import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        provideEmail("iana.kocharian@testpro.io");
        providePassword("CwqOPgQw");
        loginButton.click();
        WebElement addPlaylistButton = driver.findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));
        clickToElement(addPlaylistButton);
        WebElement newPlaylistButton = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        clickToElement(newPlaylistButton);
        WebElement inputField = driver.findElement(By.cssSelector("input[placeholder='↵ to save']"));
        inputField.sendKeys("test1");
        Actions actions = new Actions(driver);
        actions.sendKeys(inputField, Keys.RETURN).perform();
        WebElement playList = driver.findElement(By.xpath("//a[text()='test1']"));
        actions.contextClick(playList).perform();
        WebElement deleteSongButton = driver.findElement(By.xpath("//li[contains(@data-testid, 'playlist-context-menu-delete')]"));
        clickToElement(deleteSongButton);
        //WebElement submitDeleteButton = driver.findElement(By.cssSelector("nav button[class='ok']"));
        //clickToElement(submitDeleteButton);
        WebElement successNotify = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(successNotify.isDisplayed());
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        Assert.assertFalse(isDisplayed(By.xpath("//a[text()='test1']")));
        // Assert.assertFalse(getDriver().findElement(By.xpath("//a[text()='test1']")).isDisplayed());
        //Assert.assertFalse(playList.isDisplayed());

    }

}