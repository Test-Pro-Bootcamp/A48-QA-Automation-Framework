import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
    @Parameters({"qaUrl"})
    public void RegistrationNavigation() {
        String url = "https://qa.koel.app/";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get(url);
        WebElement registrationButton = webDriver.findElement(By.cssSelector("a[href='registration']"));
        registrationButton.click();
        WebElement submitButton = webDriver.findElement(By.cssSelector("input#button"));
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://qa.koel.app/registration");
        Assert.assertTrue(submitButton.isDisplayed());
        webDriver.quit();
    }
}