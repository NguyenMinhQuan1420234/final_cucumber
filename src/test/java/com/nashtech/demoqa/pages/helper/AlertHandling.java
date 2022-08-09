package com.nashtech.demoqa.pages.helper;

import com.nashtech.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class AlertHandling extends BasePage {

    public AlertHandling(WebDriver driver) throws IOException {
        super(driver);
    }

    public void dismiss() {
        waitForAlertToBePresent();
        driver.switchTo().alert().dismiss();
    }

    public void accept() {
        waitForAlertToBePresent();
        driver.switchTo().alert().accept();
    }

    public void getText() {
        waitForAlertToBePresent();
        driver.switchTo().alert().getText();
    }

    public void sendKeys(String text) {
        waitForAlertToBePresent();
        driver.switchTo().alert().sendKeys(text);
    }
}
