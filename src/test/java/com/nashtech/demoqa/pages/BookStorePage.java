package com.nashtech.demoqa.pages;

import com.nashtech.demoqa.pages.locators.AddDeleteSearchBookLocators;

public class BookStorePage extends BasePage {


    public void clickOnBook(String text) {
        clickElement(AddDeleteSearchBookLocators.SELECT_BOOK_NAME(text));
    }

    public void clickAddButton() {
        clickElement(AddDeleteSearchBookLocators.BTN_ADD);
    }

    public void inputSearchText(String text) {
        inputText(AddDeleteSearchBookLocators.TXT_SEARCH_BOOK, text);
    }

    public String getBookName(String text) {
        return getText(AddDeleteSearchBookLocators.SELECT_BOOK_NAME(text));
    }
}
