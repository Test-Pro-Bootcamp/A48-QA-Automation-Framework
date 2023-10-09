import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest{
    @Test (groups = "Registration")
            public void changeProfileName() throws InterruptedException {
    WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
    WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
    WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

    clickToElement(emailField);
    sendKeyToElement(emailField, userEmail);
    clickToElement(passwordField);
    sendKeyToElement(passwordField,userPassword);
    clickToElement(loginButton);
        Thread.sleep(5000);
    WebElement avatar = getDriver().findElement(By.cssSelector(".avatar"));
    clickToElement(avatar);
        Thread.sleep(5000);
    WebElement currentPasswordField = getDriver().findElement(By.cssSelector("input#inputProfileCurrentPassword"));
    WebElement submitButton = getDriver().findElement(By.cssSelector("button.btn-submit"));
    WebElement inputName = getDriver().findElement(By.cssSelector("input#inputProfileName"));
    String newName = generateName();
    clickToElement(currentPasswordField);
    sendKeyToElement(currentPasswordField, userPassword);
    clickToElement( inputName);
    inputName.clear();
        sendKeyToElement(inputName,newName);
        clickToElement(submitButton);

    WebElement successNotification = getDriver().findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(successNotification.isDisplayed());
        // узнать как определить/убрать скрытый текст
//        getDriver().navigate().refresh();
//    inputName = getDriver().findElement(By.cssSelector("input#inputProfileName"));
//        Thread.sleep(3000);
//        Assert.assertEquals(inputName.getText(),newName);
}
}
