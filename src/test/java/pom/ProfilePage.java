package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(css = "#inputProfileName")
    WebElement inputProfileName;

    @FindBy(css = "#inputProfileCurrentPassword")
    WebElement currentPasswordField;

    @FindBy(css = ".btn-submit")
    WebElement saveButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void renameProfile(String newName) {
        clickToElement(inputProfileName);
        sendKeysToElement(inputProfileName, newName);
        clickToElement(currentPasswordField);
        sendKeysToElement(currentPasswordField, "te$t$tudent");
        clickToElement(saveButton);
    }

    public void waitUntilProfileInputDisplayed() {
        waiUntilWebElementDisplayed(inputProfileName);
    }

    public String getProfileNameText() {
        return inputProfileName.getText();
    }
}
