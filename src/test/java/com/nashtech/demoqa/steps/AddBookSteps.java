package com.nashtech.demoqa.steps;

import com.nashtech.demoqa.contents.UrlConstants;
import com.nashtech.demoqa.context.ScenarioContext;
import com.nashtech.demoqa.pages.BookStorePage;
import com.nashtech.demoqa.pages.LoginPage;
import com.nashtech.demoqa.pages.shared.ModalDialog;
import com.nashtech.demoqa.utils.api.contents.AccountHelper;
import com.nashtech.demoqa.utils.api.contents.BookstoreHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class AddBookSteps {
    LoginPage loginPage = new LoginPage();
    BookStorePage bookStorePage = new BookStorePage();
    AccountHelper accountHelper = new AccountHelper();
    BookstoreHelper bookstoreHelper = new BookstoreHelper();
    ScenarioContext scenarioContext = new ScenarioContext();
    ModalDialog modal = new ModalDialog();

    public AddBookSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @Given("the user logs into application")
    public void theUserLogsIntoApplication() {
        Response token = accountHelper.generateTokenString(System.getProperty("USERNAME"),System.getProperty("PASSWORD"));
        loginPage.apiLoginWithDefaultAccount(System.getProperty("USERNAME"),System.getProperty("USER_ID"),token);
    }

    @And("the user is on Book Store page")
    public void theUserIsOnBookStorePage() {
        loginPage.navigate(UrlConstants.BOOKSTORE_URL);
    }

    @When("the user selects a book {string}")
    public void theUserSelectsABook(String book) {
        bookStorePage.clickOnBook(book);
    }

    @And("the user clicks on Add To Your Collection")
    public void theUserClicksOnAddToYourCollection() {
        bookStorePage.clickAddButton();
    }

    @Then("an alert {string} is shown")
    public void anAlertIsShown(String message) {

    }

    @And("book is shown in your profile")
    public void bookIsShownInYourProfile() {
        bookStorePage.navigate(UrlConstants.PROFILE_URL);
    }
}
