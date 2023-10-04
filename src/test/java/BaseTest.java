import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;

import javax.swing.*;

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
}
