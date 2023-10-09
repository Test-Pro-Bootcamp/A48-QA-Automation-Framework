import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration extends BaseTest {
    @Test
    public void RegistrationNavigation() {
        WebElement registrationButton = getDriver().findElement(By.cssSelector("a[href='registration']"));
        registrationButton.click();
        WebElement submitButton = getDriver().findElement(By.cssSelector("input#button"));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://qa.koel.app/registration");
        Assert.assertTrue(submitButton.isDisplayed());
    }
}
