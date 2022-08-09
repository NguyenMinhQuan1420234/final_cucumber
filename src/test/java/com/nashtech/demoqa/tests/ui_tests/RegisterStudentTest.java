package com.nashtech.demoqa.tests.ui_tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.nashtech.demoqa.contents.UrlConstants;
import com.nashtech.demoqa.pages.RegisterStudentPage;
import com.nashtech.demoqa.pages.helper.NavigatePage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterStudentTest extends BaseTest {
//    StudentData studentData = new StudentData();
    RegisterStudentPage registerStudentPage;
    NavigatePage navigatePage;

    public RegisterStudentTest() throws FileNotFoundException {
    }

    //    JsonUtil JsonUtil;
    @BeforeMethod
    public void Precondition() throws IOException, InterruptedException {
        registerStudentPage = new RegisterStudentPage(driver);
        navigatePage = new NavigatePage(driver);
        navigatePage.navigate(UrlConstants.PRACTICE_FORM_URL);
    }
    
    @Test
    public void RegisterStudentFormWithAllFieldsSuccessfully() throws FileNotFoundException {

        registerStudentPage.inputFirstName(studentData.firstName);
        registerStudentPage.inputLastName(studentData.lastName);
        registerStudentPage.inputEmail(studentData.email);
        registerStudentPage.selectGender(studentData.gender);
        registerStudentPage.inputMobile(studentData.mobile);
        registerStudentPage.inputDateOfBird(studentData.dateOfBird);
        registerStudentPage.inputSubject(studentData.subject);
        registerStudentPage.selectHobbySports();
        registerStudentPage.selectPicture(studentData.picture);
        registerStudentPage.inputCurrentAddress(studentData.currentAddress);
        registerStudentPage.selectState(studentData.state);
        registerStudentPage.selectCity(studentData.city);
        registerStudentPage.ClickSubmitButton();

        assertThat("Verify Message:",registerStudentPage.getSuccessfulMessage(),equalTo("Thanks for submitting the form"));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Student Name"), equalTo(studentData.firstName + " " + studentData.lastName));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Student Email"), equalTo(studentData.email));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Gender"), equalTo(studentData.gender));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Mobile"), equalTo(studentData.mobile));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Date of Birth"), equalTo(studentData.dateOfBirdFormat));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Subjects"), equalTo(studentData.subject));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Hobbies"), equalTo(studentData.hobby));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Picture"), equalTo(studentData.pictureName));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Address"), equalTo(studentData.currentAddress));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("State and City"), equalTo(studentData.state + " " + studentData.city));

    }

    @Test
    public void RegisterStudentFormWithMandatoryFieldsSuccessfully() throws FileNotFoundException {

        registerStudentPage.inputFirstName(studentData.firstName);
        registerStudentPage.inputLastName(studentData.lastName);
        registerStudentPage.selectGender(studentData.gender);
        registerStudentPage.inputMobile(studentData.mobile);
        registerStudentPage.ClickSubmitButton();

        assertThat("Verify Message:",registerStudentPage.getSuccessfulMessage(),equalTo("Thanks for submitting the form"));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Student Name"), equalTo(studentData.firstName + " " + studentData.lastName));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Gender"), equalTo(studentData.gender));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Mobile"), equalTo(studentData.mobile));

    }

}
