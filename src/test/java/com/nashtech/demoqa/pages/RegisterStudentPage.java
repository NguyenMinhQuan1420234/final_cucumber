package com.nashtech.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.nashtech.demoqa.pages.locators.RegisterStudentLocators;

import java.io.IOException;

public class RegisterStudentPage extends BasePage {

    public RegisterStudentPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public void inputFirstName(String text) {
        inputText(RegisterStudentLocators.TXT_FIRSTNAME, text);
    }

    public void inputLastName(String text) {
        inputText(RegisterStudentLocators.TXT_LASTNAME, text);
    }

    public void inputEmail(String text) {
        inputText(RegisterStudentLocators.TXT_EMAIL, text);
    }

    public void selectGender(String text) {
        clickElement(RegisterStudentLocators.GENDER(text));
    }

    public void inputMobile(String text) {
        inputText(RegisterStudentLocators.TXT_MOBILE_NUMBER, text);
    }

    public void inputDateOfBird(String text) {
        clickElement(RegisterStudentLocators.TXT_DATEOFBIRD);
        String clickAll = Keys.chord(Keys.CONTROL, "a"); //window
//        String clickAll = Keys.chord(Keys.COMMAND, "a"); //macos
        inputText(RegisterStudentLocators.TXT_DATEOFBIRD, clickAll);
        inputText(RegisterStudentLocators.TXT_DATEOFBIRD, text);
        sendKeysFromKeyBoard(RegisterStudentLocators.TXT_DATEOFBIRD,Keys.ENTER);
    }

    public void inputSubject(String text) {
        inputText(RegisterStudentLocators.TXT_SUBJECT, text);
        sendKeysFromKeyBoard(RegisterStudentLocators.TXT_SUBJECT,Keys.ENTER);
    }

    public void selectHobbySports() {
        clickElement(RegisterStudentLocators.CHK_HOBBIES_SPORTS);
    }

    public void selectPicture(String text){
        inputText(RegisterStudentLocators.IMG_SELECT, text);
    }

    public void inputCurrentAddress(String text) {
        inputText(RegisterStudentLocators.TXA_CURRENT_ADDRESS, text);
    }

    public void selectState(String text) {
        clickElement(RegisterStudentLocators.DDL_STATE);
        clickElement(RegisterStudentLocators.DDL_STATE_CITY(text));
    }

    public void selectCity(String text) {
        clickElement(RegisterStudentLocators.DDL_CITY);
        clickElement(RegisterStudentLocators.DDL_STATE_CITY(text));
    }

    public void ClickSubmitButton() {
        sendKeysFromKeyBoard(RegisterStudentLocators.TXA_CURRENT_ADDRESS, Keys.TAB);
        sendKeysFromKeyBoard(RegisterStudentLocators.TXA_CURRENT_ADDRESS, Keys.TAB);
        // clickElement(StudentRegistrationLocators.BTN_SUBMIT);
        sendKeysFromKeyBoard(RegisterStudentLocators.BTN_SUBMIT, Keys.ENTER);
    }

    public String getSuccessfulMessage() {
        return getText(RegisterStudentLocators.MSG_SUCCESS);
    }
    public String getVerifyTextValue(String text) {
        return getText(RegisterStudentLocators.VERIFY_SUBMIT_VALUE(text));
    }
}
