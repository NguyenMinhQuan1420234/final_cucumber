package com.nashtech.demoqa.pages.locators;

import org.openqa.selenium.By;

public class AddDeleteSearchBookLocators {
    // Shared
    public static final By SELECT_BOOK_NAME(String text) { // Git Pocket Guide
        return By.xpath(String.format("//span[@id='see-book-%s']/a", text));
    }
    // Profile Page
    public static final By BTN_DELETE_BOOK_OK = By.id("closeSmallModal-ok");
    public static final By BTN_DELETE_BOOK_CANCEL = By.id("closeSmallModal-cancel");
    public static final By BTN_DELETE_ALL_BOOKS = By.xpath("(//button[text()='Delete All Books'])[1]");
    public static final By BTN_GOTO_BOOK_STORE = By.id("gotoStore");
    public static final By TXT_NO_BOOKS = By.xpath("//div[contains(text(),'No rows found')]");
    // BookStorePage
    public static final By BTN_ADD = By.xpath("//button[contains(text(),'Add')]");
    public static final By TXT_SEARCH_BOOK = By.id("searchBox");
}
