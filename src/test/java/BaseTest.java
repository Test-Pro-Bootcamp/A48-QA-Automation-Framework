import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import javax.swing.*;
import java.time.Duration;
import java.util.UUID;

public abstract class BaseTest {
    String url = "https://qa.koel.app/";
    String userEmail = "iana.kocharian@testpro.io";
    String userPassword = "CwqOPgQw";
    WebDriver driver;
    Actions actions;


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(url);

    }
    public WebDriver getDriver () {
        return driver;
    }
    @AfterMethod
    public void closeDriver (){
        getDriver().quit();
    }
    public void clickToElement (WebElement element){
        element.click();
    }
    public void sendKeyToElement (WebElement element, String text){
        element.sendKeys(text);
    }
    public String generateName(){
        return UUID.randomUUID().toString().replace("-", " ");
    }
}