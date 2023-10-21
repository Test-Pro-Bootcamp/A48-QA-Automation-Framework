import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.security.spec.ECPoint;

public class ProfileTest extends BaseTest {
    @Test(groups = "Registration")
    @Parameters({"qaUrl"})
    public void changeProfileName() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        provideEmail("iana.kocharian@testpro.io");
        providePassword("CwqOPgQw");
        loginButton.click();
        WebElement avatar = getDriver().findElement(By.cssSelector(".avatar"));
        wait.until(ExpectedConditions.visibilityOf(avatar));
        clickToElement(avatar);
        WebElement currentPasswordField = getDriver().findElement(By.cssSelector("input#inputProfileCurrentPassword"));
        WebElement submitButton = getDriver().findElement(By.cssSelector("button.btn-submit"));
        WebElement inputName = getDriver().findElement(By.cssSelector("input#inputProfileName"));
        wait.until(ExpectedConditions.elementToBeClickable(currentPasswordField));
        String newName = generateName();
        clickToElement(currentPasswordField);
        sendKeyToElement(currentPasswordField, userPassword);
        clickToElement(inputName);
        inputName.clear();
        sendKeyToElement(inputName, newName);
        clickToElement(submitButton);

        WebElement successNotification = getDriver().findElement(By.cssSelector("div[class='success show']"));
        wait.until(ExpectedConditions.visibilityOf(successNotification));
        Assert.assertTrue(successNotification.isDisplayed());
        // узнать как определить/убрать скрытый текст
//        getDriver().navigate().refresh();
//        inputName = getDriver().findElement(By.cssSelector("input#inputProfileName"));
//        wait.until(ExpectedConditions.visibilityOf(inputName));
//        Assert.assertEquals(inputName.getText(),newName);
    }
}
