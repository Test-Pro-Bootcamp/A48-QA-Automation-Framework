import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;

public abstract class BaseTest {

    private WebDriver driver = null;
    String prodUrl = "https://koel.dev/";
    Actions actions;
    Wait<WebDriver> wait;
    public static final String QA_URL = "https://qa.koel.app/#!/home";

    @BeforeMethod
    @Parameters({"qaUrl"})
    public void setup(String url) throws MalformedURLException {

        pickDriver(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void closeDriver() {
        getDriver().quit();
    }


    public String generateName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public WebDriver pickDriver(String browser) throws MalformedURLException {
        String gridUrl = "http://192.168.1.178:4444";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                return driver;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                return driver;
            case "grid-chrome":
                desiredCapabilities.setBrowserName("chrome");
                driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), desiredCapabilities);
                return driver;
            case "grid-firefox":
                desiredCapabilities.setCapability("browserName", "firefox");
                driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), desiredCapabilities);
                return driver;
            default:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                return driver;
        }
    }

    public WebDriver getLambdaDriver() throws MalformedURLException {
        String userName = "";
        String authKey = "";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "106.0");
        capabilities.setCapability("resolution", "1024x768");
        capabilities.setCapability("build", "TestNG With Java");
        capabilities.setCapability("name", this.getClass().getName());
        capabilities.setCapability("plugin", "git-testng");

        return new RemoteWebDriver(new URL("https://" + userName + ":" + authKey + hub), capabilities);
    }
}