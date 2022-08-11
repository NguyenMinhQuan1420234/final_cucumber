package com.nashtech.demoqa.steps;

import com.nashtech.demoqa.contents.APIConstant;
import com.nashtech.demoqa.context.ScenarioContext;
import com.nashtech.demoqa.pages.BookStorePage;
import com.nashtech.demoqa.pages.LoginPage;
import com.nashtech.demoqa.pages.ProfilePage;
import com.nashtech.demoqa.pages.shared.ModalDialog;
import com.nashtech.demoqa.utils.api.contents.AccountHelper;
import com.nashtech.demoqa.utils.api.contents.BookstoreHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchBookSteps {
    BookStorePage bookStorePage = new BookStorePage();
    BookstoreHelper bookstoreHelper = new BookstoreHelper();
    ScenarioContext scenarioContext = new ScenarioContext();

    @Given("there are books named {string} and {string}")
    public void thereAreBooksNamedAnd(String book1, String book2) {
        scenarioContext.setContext("book1", book1);
        scenarioContext.setContext("book2",book2);
        bookstoreHelper.getOneBookInfo(APIConstant.PUBLIC_BOOK_ID[0]);
        bookstoreHelper.getOneBookInfo(APIConstant.PUBLIC_BOOK_ID[1]);
    }

    @When("the user inputs book name Design or design")
    public void theUserInputsBookNameDesignOrDesign(List<Map<String, String>> input) {
        String searchData = input.get(0).get("input");
        bookStorePage.inputSearchText(searchData);
    }

    @Then("all books match with input criteria will be displayed.")
    public void allBooksMatchWithInputCriteriaWillBeDisplayed() {
        String expectedBook1 = scenarioContext.getContext("book1", String.class);
        String expectedBook2 = scenarioContext.getContext("book2", String.class);

        assertThat(
                "Verify Message:",
                bookStorePage.checkBookExist(expectedBook1),
                equalTo(expectedBook1)
        );

        assertThat("Verify Message:",
                bookStorePage.checkBookExist(expectedBook2),
                equalTo(expectedBook2)
        );
    }


}
