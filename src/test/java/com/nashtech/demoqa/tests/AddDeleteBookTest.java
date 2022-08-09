package com.nashtech.demoqa.tests;

import com.nashtech.demoqa.contents.UrlConstants;
import com.nashtech.demoqa.pages.BookStorePage;
import com.nashtech.demoqa.pages.LoginPage;
import com.nashtech.demoqa.pages.ProfilePage;
import com.nashtech.demoqa.pages.helper.AlertHandling;
import com.nashtech.demoqa.pages.helper.NavigatePage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddDeleteBookTest extends BaseTest {
    LoginPage loginPage;
    ProfilePage profilePage;
    BookStorePage bookStorePage;
    NavigatePage navigatePage;
    AlertHandling alertHandling;
    @BeforeMethod
    public void Preconditions() throws IOException, InterruptedException, AWTException {
        navigatePage = new NavigatePage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        bookStorePage = new BookStorePage(driver);
        alertHandling = new AlertHandling(driver);

        navigatePage.navigate(UrlConstants.LOGIN_URL);
        loginPage.Login();

    }

    @Test
    public void AddBookToCollectionSuccessfully() throws InterruptedException {
        try {
            if (profilePage.checkBookExist("Git Pocket Guide")) {
                profilePage.clickDeleteButton();
                profilePage.clickOkButton();
                alertHandling.dismiss();
            }
            profilePage.goToBookStore();
        }
        catch (Exception e) {
            profilePage.goToBookStore();
        }
        bookStorePage.clickOnBook("Git Pocket Guide");
        bookStorePage.clickAddButton();
        alertHandling.dismiss();
        navigatePage.navigate(UrlConstants.PROFILE_URL);

        assertThat("Veriffy That:","Git Pocket Guide",equalTo(profilePage.getBookName("Git Pocket Guide")));
    }

    @Test
    public void DeleteBookSuccessfully() throws InterruptedException {
        try {
            if (profilePage.checkBookExist("Git Pocket Guide")) {
                profilePage.clickDeleteButton();
                profilePage.clickOkButton();
                alertHandling.dismiss();
            }

        }
        catch (Exception e) {
            profilePage.goToBookStore();
            bookStorePage.clickOnBook("Git Pocket Guide");
            bookStorePage.clickAddButton();
            alertHandling.dismiss();
            navigatePage.navigate(UrlConstants.PROFILE_URL);
            profilePage.clickDeleteButton();
            profilePage.clickOkButton();
            alertHandling.dismiss();
        }
        assertThat("Verify Message:","No rows found",equalTo(profilePage.getNoBook()));
    }
}
