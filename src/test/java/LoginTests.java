import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
// это еще одна попытка сделать нормально пуш
public class LoginTests extends BaseTest {
    @Test
    public void loginEmailPasswordTest() throws InterruptedException {

        String url = "https://qa.koel.app/#!/home";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        emailField.click();
        emailField.sendKeys("demo@class.com");

        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        loginButton.click();
        Thread.sleep(5000);

        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        Assert.assertEquals(driver.getCurrentUrl(), url);
        Assert.assertTrue(avatar.isDisplayed());
        Assert.assertFalse(loginButton.isDisplayed());

        driver.quit();

    }

    @Test
    public void loginWithNotExistEmailTest() throws InterruptedException {

        String url = "https://qa.koel.app/#!/home";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        emailField.click();
        emailField.sendKeys("notExist@class.com");

        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        loginButton.click();
        Thread.sleep(5000);
        Assert.assertTrue(loginButton.isDisplayed());

        driver.quit();
    }

    @Test
    public void loginWithoutPasswordlTest() throws InterruptedException {

        String url = "https://qa.koel.app/#!/home";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        emailField.click();
        emailField.sendKeys("demo@class.com");

        loginButton.click();
        Thread.sleep(5000);
        Assert.assertTrue(loginButton.isDisplayed());

        driver.quit();
    }
}

