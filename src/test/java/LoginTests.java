import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test(groups = "smoke")
    public void loginEmailPasswordTest() throws InterruptedException {

        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

//        emailField.click();
        clickToElement(emailField);

//        emailField.sendKeys("demo@class.com");
        sendKeysToElement(emailField, "demo@class.com");

//        passwordField.click();
        clickToElement(passwordField);

//        passwordField.sendKeys("te$t$tudent");
        sendKeysToElement(passwordField, "te$t$tudent");

//        loginButton.click();
        clickToElement(loginButton);
        Thread.sleep(5000);

        WebElement avatar = getDriver().findElement(By.cssSelector(".avatar"));
        loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        Assert.assertEquals(getDriver().getCurrentUrl(), url);
        Assert.assertTrue(avatar.isDisplayed());
        Assert.assertFalse(loginButton.isDisplayed());
    }


    @Test(groups = "Regression", description = "Login to service with not exist email", testName = "Check login test")
    public void loginWithNotExistEmailTest() throws InterruptedException {

        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        clickToElement(emailField);
        sendKeysToElement(emailField, "notExist@class.com");

        clickToElement(passwordField);
        sendKeysToElement(passwordField, "te$t$tudent");


        clickToElement(loginButton);
        Thread.sleep(5000);
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @Test
    public void loginWithoutPasswordTest() throws InterruptedException {

        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        clickToElement(emailField);
        sendKeysToElement(emailField, "demo@class.com");

        loginButton.click();
        Thread.sleep(5000);
        Assert.assertTrue(loginButton.isDisplayed());
    }
}

