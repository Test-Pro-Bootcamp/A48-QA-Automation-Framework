package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void renameProfile(String newName) {
        WebElement inputProfileName = findWebElement(By.cssSelector("#inputProfileName"));
        clickToElement(inputProfileName);
        sendKeysToElement(inputProfileName, newName);
        WebElement currentPasswordField = findWebElement(By.cssSelector("#inputProfileCurrentPassword"));
        clickToElement(currentPasswordField);
        sendKeysToElement(currentPasswordField, "te$t$tudent");
        WebElement saveButton = findWebElement(By.cssSelector(".btn-submit"));
        clickToElement(saveButton);
    }}
