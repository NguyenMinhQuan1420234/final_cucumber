package com.nashtech.demoqa.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import com.nashtech.demoqa.utils.PropertiesFileUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;


public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver driver) throws IOException {
        Properties properties = PropertiesFileUtil.loadPropertiesFromFile(System.getProperty("env.properties"));
        PropertiesFileUtil.appendSystemProperties(properties);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("TIMEOUT_IN_SECOND"))));
    }

    public Select selectElement(By locator) {
        WebElement selectElement = waitForElementToBeClickable(locator);
        Select selectObject = new Select(selectElement);
        return selectObject;
    }

    public void inputText(By locator, String text) {
        WebElement element = waitForElementToBeClickable(locator);
        element.sendKeys(text);
    }

    public void sendKeysFromKeyBoard(By locator, Keys key ) {
        WebElement element = waitForElementToBeClickable(locator);
        element.sendKeys(key);
    }

    public void clickElement(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        element.click();
    }

    public String getTextAttribute(By locator, String attribute) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getAttribute(attribute);
    }

    public String getText(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getText();   
    }

    public void moveToElement(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.perform();
    }

    public boolean isDisplayed(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        return element.isDisplayed();
    }

    public void waitForAlertToBePresent() {
        Alert element = wait.until(ExpectedConditions.alertIsPresent());
    }

    public List<WebElement> waitForListOfElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
