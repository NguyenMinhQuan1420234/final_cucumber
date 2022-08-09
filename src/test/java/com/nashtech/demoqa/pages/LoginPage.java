package com.nashtech.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public static final By TXT_USERNAME = By.id("userName");
    public static final By TXT_PASSWORD = By.id("password");
    public static final By BTN_LOGIN = By.id("login");

    public void Login() {
        String zoomOut = "document.body.style.zoom='0.75'";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(zoomOut);
        inputText(TXT_USERNAME, System.getProperty("USERNAME"));
        inputText(TXT_PASSWORD, System.getProperty("PASSWORD"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", driver.findElement(BTN_LOGIN));
        moveToElement(BTN_LOGIN);
        clickElement(BTN_LOGIN);
    }


}
