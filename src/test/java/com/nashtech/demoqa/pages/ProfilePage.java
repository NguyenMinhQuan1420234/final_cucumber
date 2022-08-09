package com.nashtech.demoqa.pages;

import com.nashtech.demoqa.pages.locators.AddDeleteSearchBookLocators;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) throws IOException {
        super(driver);
    }

    public boolean checkBookExist(String text) {
        return isDisplayed(AddDeleteSearchBookLocators.SELECT_BOOK_NAME(text));
    }

    public void goToBookStore() {
        clickElement(AddDeleteSearchBookLocators.BTN_GOTO_BOOK_STORE);
    }
    public void clickDeleteButton() {
        clickElement(AddDeleteSearchBookLocators.BTN_DELETE_ALL_BOOKS);
    }

    public void clickOkButton() {
        clickElement(AddDeleteSearchBookLocators.BTN_DELETE_BOOK_OK);
    }

    public void clickCancelButton() {
        clickElement(AddDeleteSearchBookLocators.BTN_DELETE_BOOK_CANCEL);
    }

    public String getBookName(String text) {
        return getText(AddDeleteSearchBookLocators.SELECT_BOOK_NAME(text));
    }

    public String getNoBook() {
        return getText(AddDeleteSearchBookLocators.TXT_NO_BOOKS);
    }
}
