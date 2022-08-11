package com.nashtech.demoqa.pages;

import com.nashtech.demoqa.steps.StepHooks;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;

import static com.nashtech.demoqa.steps.StepHooks.driver;

public class LoginPage extends BasePage {

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
    public void apiLoginWithDefaultAccount(String username, String userID, Response token) {
        StepHooks.driver.manage().addCookie(new Cookie("userID", userID));
        StepHooks.driver.manage().addCookie(new Cookie("userName", username));
        StepHooks.driver.manage().addCookie(new Cookie("token", token.jsonPath().getString("token")));
        StepHooks.driver.manage().addCookie(new Cookie("expires", token.jsonPath().getString("expires")));
    }

}
