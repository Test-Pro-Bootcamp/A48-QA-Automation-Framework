import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {
   @Test
   @Parameters({"qaUrl"})
   public void addSongToPlaylist (String qaUrl) throws InterruptedException{
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
       WebDriver driver = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.get(qaUrl);
       WebElement emailField = driver.findElement(By.cssSelector("[type='email']")) ;
       WebElement passwordField = driver.findElement(By.cssSelector("[type='password']")) ;
       WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']")) ;
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
       wait.until(ExpectedConditions.visibilityOf(emailField));
       emailField.click();
       emailField.sendKeys(userEmail);
       passwordField.click();
       passwordField.sendKeys(userPassword);
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
