import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTest extends BaseTest {

    @Test(testName = "Check updating profile's name")
    public void renameProfileTest() {

        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");

        clickToElement(loginButton);

        Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(loginButton));

        WebElement avatar = getDriver().findElement(By.cssSelector(".avatar"));
        clickToElement(avatar);

        WebElement inputProfileName = getDriver().findElement(By.cssSelector("#inputProfileName"));
        clickToElement(inputProfileName);
        String newName = generateName();
        sendKeysToElement(inputProfileName, newName);

        WebElement currentPasswordField = getDriver().findElement(By.cssSelector("#inputProfileCurrentPassword"));
        clickToElement(currentPasswordField);
        sendKeysToElement(currentPasswordField, "te$t$tudent");
        WebElement saveButton = getDriver().findElement(By.cssSelector(".btn-submit"));
        clickToElement(saveButton);

        getDriver().navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputProfileName")));

        inputProfileName = getDriver().findElement(By.cssSelector("#inputProfileName"));
        Assert.assertEquals(inputProfileName.getText(), newName);
    }
}
