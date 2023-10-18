package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import pom.HomePage;
import pom.LoginPage;
import pom.PlaySongPage;

import java.net.URI;
import java.net.MalformedURLException;
import java.time.Duration;

public class StepDefinitions {

    public static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    public static WebDriver driver = null;

    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }

    @Before
    public void openBrowser() throws MalformedURLException {
        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown(){
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.0.159:4444";
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-safari":
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
//            case "cloud":
//                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
                // options.addArguments("--headless=new");
                return driver = new ChromeDriver(options);
        }
    }

    @Given("I open Login Page")
    public void openLoginPage(){
        getThreadLocal().get("https://qa.koel.app/");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.providePassword(password);
    }

    @And("I click submit")
    public void iClickSubmit() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.clickLoginButton();
    }

    @Then("I logged in")
    public void iLoggedIn() {
        HomePage homePage = new HomePage(getThreadLocal());
        homePage.waitUntilAvatarDisplayed();
    }

    @And("I click play button")
    public void clickPlayBtn(){
        PlaySongPage playSongPage = new PlaySongPage(getThreadLocal());
        playSongPage.startPlaySong();
    }

    @Then("I see equalizer")
    public void iSeeEqualizer() {
        PlaySongPage playSongPage = new PlaySongPage(getThreadLocal());
        Assert.assertTrue(playSongPage.isSongBarDisplayed());
    }

}
