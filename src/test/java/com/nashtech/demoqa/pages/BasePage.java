package com.nashtech.demoqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.nashtech.demoqa.steps.StepHooks.driver;


public class BasePage {
    public WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("TIMEOUT_IN_SECOND"))));

    public void navigate(String url) {
        driver.get(System.getProperty("BASE_URL") + url);
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
