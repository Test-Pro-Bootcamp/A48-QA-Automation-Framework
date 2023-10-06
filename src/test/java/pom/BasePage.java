package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    private WebDriver driver;
    Actions actions;
    Wait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickToElement(WebElement element) {
        element.click();
    }

    public void sendKeysToElement(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public WebElement findWebElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findWebElements(By locator) {
        return driver.findElements(locator);
    }
}
