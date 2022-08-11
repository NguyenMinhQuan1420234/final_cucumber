package com.nashtech.demoqa.steps;

import com.nashtech.demoqa.contents.UrlConstants;
import com.nashtech.demoqa.context.ScenarioContext;
import com.nashtech.demoqa.pages.BookStorePage;
import com.nashtech.demoqa.pages.LoginPage;
import com.nashtech.demoqa.pages.ProfilePage;
import com.nashtech.demoqa.pages.shared.ModalDialog;
import com.nashtech.demoqa.utils.api.contents.AccountHelper;
import com.nashtech.demoqa.utils.api.contents.BookstoreHelper;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddBookSteps {
    LoginPage loginPage = new LoginPage();
    BookStorePage bookStorePage = new BookStorePage();
    AccountHelper accountHelper = new AccountHelper();
    BookstoreHelper bookstoreHelper = new BookstoreHelper();
    ScenarioContext scenarioContext = new ScenarioContext();
    ModalDialog modal = new ModalDialog();
    ProfilePage profilePage = new ProfilePage();

    Response token = accountHelper.generateTokenString(System.getProperty("USERNAME"), System.getProperty("PASSWORD"));
    String tokenValue = token.jsonPath().getString("token");

    public AddBookSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @Before(order = 1)
    public void precondition() {
        bookstoreHelper.deleteAllBooks(tokenValue, System.getProperty("USER_ID"));
    }

    @Given("the user logs into application")
    public void theUserLogsIntoApplication() {
        loginPage.apiLoginWithDefaultAccount(System.getProperty("USERNAME"), System.getProperty("USER_ID"), token);
    }

    @And("the user is on Book Store page")
    public void theUserIsOnBookStorePage() {
        loginPage.navigate(UrlConstants.BOOKSTORE_URL);
    }

    @When("the user selects a book {string}")
    public void theUserSelectsABook(String book) {
        scenarioContext.setContext("book", book);
        bookStorePage.clickOnBook(book);
    }

    @And("the user clicks on Add To Your Collection")
    public void theUserClicksOnAddToYourCollection() {
        bookStorePage.clickAddButton();
    }

    @Then("an alert {string} is shown")
    public void anAlertIsShown(String message) {
        assertThat(
                "verify alert message: ",
                modal.getText(),
                equalTo(message)
        );
        modal.dismiss();
    }

    @And("book is shown in your profile")
    public void bookIsShownInYourProfile() {
        bookStorePage.navigate(UrlConstants.PROFILE_URL);
        String book = scenarioContext.getContext("book", String.class);
        assertThat(
                "verify alert message: ",
                profilePage.checkBookExist(),
                equalTo(true)
        );

    }
}
