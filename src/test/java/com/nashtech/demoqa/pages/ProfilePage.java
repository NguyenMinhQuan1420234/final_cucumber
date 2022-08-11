package com.nashtech.demoqa.pages;

import com.nashtech.demoqa.pages.locators.AddDeleteSearchBookLocators;

import static com.nashtech.demoqa.pages.locators.AddDeleteSearchBookLocators.TXT_SEARCH_BOOK;

public class ProfilePage extends BasePage {
    public boolean checkBookExist() {
        return isDisplayed(AddDeleteSearchBookLocators.LBL_BOOKS_IN_COLLECTION);
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
        return getText(AddDeleteSearchBookLocators.selectBookByName(text));
    }
    public void inputSearchText(String text) {
        inputText(TXT_SEARCH_BOOK, text);
    }

    public String getNoBook() {
        return getText(AddDeleteSearchBookLocators.TXT_NO_BOOKS);
    }
}
