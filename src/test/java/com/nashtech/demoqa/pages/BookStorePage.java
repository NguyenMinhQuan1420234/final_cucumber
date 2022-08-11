package com.nashtech.demoqa.pages;

import org.openqa.selenium.WebElement;

import java.util.List;

import static com.nashtech.demoqa.pages.locators.AddDeleteSearchBookLocators.*;

public class BookStorePage extends BasePage {


    public void clickOnBook(String text) {
        clickElement(selectBookByName(text));
    }

    public void clickAddButton() {
        clickElement(BTN_ADD);
    }

    public void inputSearchText(String text) {
        inputText(TXT_SEARCH_BOOK, text);
    }

    public String getBookName(String text) {

        return getText(selectBookByName(text));
    }
    public String checkBookExist(String expectedBook) {
        List<WebElement>  books = waitForListOfElementToBeVisible(LBL_BOOKS_IN_COLLECTION);
        for(WebElement book: books) {
            if(book.getText().equals(expectedBook))
                return book.getText();
        }
        return null;
    }
}
