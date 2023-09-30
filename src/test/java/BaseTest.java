import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    String url = "https://qa.koel.app/";
    String userEmail = "iana.kocharian@testpro.io";
    String userPassword = "CwqOPgQw";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
}
