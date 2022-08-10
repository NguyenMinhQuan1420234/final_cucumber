package com.nashtech.demoqa.pages.shared;

import com.nashtech.demoqa.pages.BasePage;

import static com.nashtech.demoqa.steps.StepHooks.driver;

public class ModalDialog extends BasePage {

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
