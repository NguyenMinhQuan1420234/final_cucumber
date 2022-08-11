package com.nashtech.demoqa.steps;

import com.nashtech.demoqa.contents.APIConstant;
import com.nashtech.demoqa.contents.UrlConstants;
import com.nashtech.demoqa.context.ScenarioContext;
import com.nashtech.demoqa.pages.BookStorePage;
import com.nashtech.demoqa.pages.LoginPage;
import com.nashtech.demoqa.pages.ProfilePage;
import com.nashtech.demoqa.pages.shared.ModalDialog;
import com.nashtech.demoqa.utils.api.contents.AccountHelper;
import com.nashtech.demoqa.utils.api.contents.BookstoreHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DeleteBookSteps {
    LoginPage loginPage = new LoginPage();
    AccountHelper accountHelper = new AccountHelper();
    BookstoreHelper bookstoreHelper = new BookstoreHelper();
    ModalDialog modal = new ModalDialog();
    ProfilePage profilePage = new ProfilePage();

    Response token = accountHelper.generateTokenString(System.getProperty("USERNAME"), System.getProperty("PASSWORD"));
    String tokenValue = token.jsonPath().getString("token");

    @Given("there is a book named “Git Pocket Guide”")
    public void thereIsABookNamedGitPocketGuide() {
        bookstoreHelper.addNewBooks(tokenValue, System.getProperty("USER_ID"),APIConstant.NEW_BOOK_ID);
    }

    @And("the user logs into the application")
    public void theUserLogsIntoTheApplication() {
        loginPage.navigate(UrlConstants.LOGIN_URL);
        loginPage.apiLoginWithDefaultAccount(System.getProperty("USERNAME"),System.getProperty("USER_ID"),token);
    }

    @And("the user is on the Profile page")
    public void theUserIsOnTheProfilePage() {
        profilePage.navigate(UrlConstants.PROFILE_URL);
    }
    @When("the user search book {string}")
    public void theUserSearchBook(String bookName) {
        profilePage.inputSearchText(bookName);
    }

    @And("the user clicks on Delete icon")
    public void theUserClicksOnDeleteIcon() {
        profilePage.clickDeleteButton();
    }

    @And("the user clicks on OK button")
    public void theUserClicksOnOKButton() {
        profilePage.clickOkButton();
    }

    @And("the user clicks on OK button of alert “Book deleted.”")
    public void theUserClicksOnOKButtonOfAlertBookDeleted() {
        modal.accept();
    }

    @And("the book is not shown")
    public void theBookIsNotShown() {
        assertThat(
                "verify Book is not show: ",
                profilePage.getNoBook(),
                equalTo("No rows found")
        );
    }


}
