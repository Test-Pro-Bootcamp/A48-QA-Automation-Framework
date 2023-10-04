import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework18 extends BaseTest {
    @Test
    public void playSong () {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']")) ;
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']")) ;
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']")) ;

        emailField.click();
        emailField.sendKeys(userEmail);
        passwordField.click();
        passwordField.sendKeys(userPassword);
        loginButton.click();
        WebElement allSongs = driver.findElement(By.cssSelector("a[class='songs']"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(allSongs));
        allSongs.click();
        WebElement anySong = driver.findElement(By.cssSelector("table tr[draggable='true']"));
        Actions action = new Actions(driver);
        action.doubleClick(anySong).perform();
        WebElement soundBar = driver.findElement(By.cssSelector("div [data-test='soundbars']"));
        wait.until(ExpectedConditions.visibilityOf(soundBar));
        Assert.assertTrue(soundBar.isDisplayed());
        driver.quit();
    }
}
