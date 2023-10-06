import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;

import java.awt.*;

public class RenamePlayListTest extends BaseTest {

    LoginPage loginPage = new LoginPage(getDriver());
    @Test
    public void renamePlayListTest() {
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");

        loginPage.clickToElement(loginButton);

        WebElement playList = getDriver().findElement(By.xpath("//li[contains(@class, 'playlist')][3]"));

        String newName = generateName();
        actions.doubleClick(playList).perform();
        playList.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
        playList.sendKeys(newName);
        playList.sendKeys(Keys.ENTER);

        Assert.assertEquals(playList.getText(), newName);
    }
}
