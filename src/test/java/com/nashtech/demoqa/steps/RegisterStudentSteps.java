package com.nashtech.demoqa.steps;

import com.nashtech.demoqa.contents.UrlConstants;
import com.nashtech.demoqa.context.ScenarioContext;
import com.nashtech.demoqa.pages.RegisterStudentPage;
import com.nashtech.demoqa.steps.modals.StudentData;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterStudentSteps {
    RegisterStudentPage registerStudentPage = new RegisterStudentPage();
    StudentData studentData;
    ScenarioContext scenarioContext;

    public RegisterStudentSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @DataTableType
    public StudentData studentInfo(Map<String, String> info) {
        return new StudentData(
            info.get("First Name"),
            info.get("Last Name"),
            info.get("Email"),
            info.get("Gender"),
            info.get("Mobile"),
            info.get("Date of birth"),
            info.get("Subjects"),
            info.get("Hobbies"),
            info.get("Picture"),
            info.get("Current Address"),
            info.get("State"),
            info.get("City")
        );
    }
    @And("the user is on Student Registration Form")
    public void theUserIsOnStudentRegistrationForm() {
        registerStudentPage.navigate(UrlConstants.REGISTER_STUDENT_URL);
    }

    @When("the user input valid data into all fields.")
    public void theUserInputValidDataIntoAllFields(List<StudentData> data) {

        studentData = data.get(0);
        scenarioContext.setContext("studentData", studentData);

        registerStudentPage.inputFirstName(studentData.firstName); //
        registerStudentPage.inputLastName(studentData.lastName); //
        if (studentData.email != null) registerStudentPage.inputEmail(studentData.email);
        registerStudentPage.selectGender(studentData.gender); //
        registerStudentPage.inputMobile(studentData.mobile); //
        if (studentData.dateOfBird != null) registerStudentPage.inputDateOfBird(studentData.dateOfBird);
        if (studentData.subject != null) registerStudentPage.inputSubject(studentData.subject);
        if (studentData.hobby != null) registerStudentPage.selectHobby(studentData.hobby);
        if (studentData.picture != null) registerStudentPage.selectPicture(studentData.picture);
        if (studentData.currentAddress != null) registerStudentPage.inputCurrentAddress(studentData.currentAddress);
        if (studentData.state != null) registerStudentPage.selectState(studentData.state);
        if (studentData.city != null) registerStudentPage.selectCity(studentData.city);
    }

    @And("the user clicks on Submit button")
    public void theUserClicksOnSubmitButton() {
        registerStudentPage.clickSubmitButton();
    }

    @Then("a successful message {string} is shown")
    public void aSuccessfulMessageIsShown(String message) {
        assertThat(
                "verify successful submit message: ",
                registerStudentPage.getSuccessfulMessage(),
                equalTo(message)
        );
    }
    @And("all information of the student form is shown correctly.")
    public void allInformationOfTheStudentFormIsShownCorrectly() {
        StudentData student = scenarioContext.getContext("studentData", StudentData.class);

        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Student Name"), equalTo(student.firstName + " " + student.lastName));

        if (studentData.email != null)
            assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Student Email"), equalTo(student.email));

        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Gender"), equalTo(student.gender));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Mobile"), equalTo(student.mobile));

        if (studentData.dateOfBird != null)
            assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Date of Birth"), equalTo(student.dateOfBird));
        if (studentData.subject != null)
            assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Subjects"), equalTo(student.subject));
        if (studentData.hobby != null)
            assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Hobbies"), equalTo(student.hobby));
        if (studentData.picture != null)
            assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Picture"), equalTo(student.picture));
        if (studentData.currentAddress != null)
            assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Address"), equalTo(student.currentAddress));
        if (studentData.state != null)
            assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("State and City"), equalTo(student.state + " " + student.city));
    }


}
