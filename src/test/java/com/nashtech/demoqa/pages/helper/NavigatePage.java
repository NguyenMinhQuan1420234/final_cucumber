package com.nashtech.demoqa.pages.helper;

import org.openqa.selenium.WebDriver;

import com.nashtech.demoqa.pages.BasePage;

import java.io.IOException;

public class NavigatePage extends BasePage {

    public NavigatePage(WebDriver driver) throws IOException {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    
    public void navigate(String url) throws InterruptedException {
        Thread.sleep(3000);
        driver.get(System.getProperty("BASE_URL") + url);
    }

}
