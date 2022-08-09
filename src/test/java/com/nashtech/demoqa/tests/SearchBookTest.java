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

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchBookTest extends BaseTest {
    LoginPage loginPage;
    ProfilePage profilePage;
    BookStorePage bookStorePage;
    NavigatePage navigatePage;
    AlertHandling alertHandling;

    @BeforeMethod
    public void Preconditions() throws IOException, InterruptedException {
        navigatePage = new NavigatePage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        bookStorePage = new BookStorePage(driver);
        alertHandling = new AlertHandling(driver);

        navigatePage.navigate(UrlConstants.LOGIN_URL);
        loginPage.Login();
        navigatePage.navigate(UrlConstants.BOOKSTORE_URL);
    }

    @Test
    public void SearchBookSuccessfully() {
        // “Learning JavaScript Design Patterns” and “Designing Evolvable Web APIs with ASP.NET”
        bookStorePage.inputSearchText("Design");
        assertThat("Verify Message:","Learning JavaScript Design Patterns",equalTo(bookStorePage.getBookName("Learning JavaScript Design Patterns")));
        assertThat("Verify Message:","Designing Evolvable Web APIs with ASP.NET",equalTo(bookStorePage.getBookName("Designing Evolvable Web APIs with ASP.NET")));
    }
}
