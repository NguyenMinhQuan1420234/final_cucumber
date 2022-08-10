package com.nashtech.demoqa.pages;

import com.nashtech.demoqa.pages.locators.RegisterStudentLocators;
import org.openqa.selenium.Keys;

public class RegisterStudentPage extends BasePage {

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
        String clickAll = "";
        if(System.getProperty("os.name").equals("Mac OS X"))
            clickAll = Keys.chord(Keys.COMMAND, "a"); //macos
        else
            clickAll = Keys.chord(Keys.CONTROL, "a"); //window
        inputText(RegisterStudentLocators.TXT_DATEOFBIRD, clickAll);
        inputText(RegisterStudentLocators.TXT_DATEOFBIRD, text);
        sendKeysFromKeyBoard(RegisterStudentLocators.TXT_DATEOFBIRD,Keys.ENTER);
    }

    public void inputSubject(String text) {
        String[] listOfSubjects = text.split(",");
        for(String subject: listOfSubjects) {
            inputText(RegisterStudentLocators.TXT_SUBJECT, subject);
            sendKeysFromKeyBoard(RegisterStudentLocators.TXT_SUBJECT, Keys.ENTER);
        }
    }

    public void selectHobby(String text) {
        String[] listOfHobbies = text.split(",");
        for (String hobby: listOfHobbies)
            clickElement(RegisterStudentLocators.selectHobby(text));
    }

    public void selectPicture(String text){
        String filepath = System.getProperty("user.dir") + "/" + System.getProperty("DATA_PATH") + text;
        inputText(RegisterStudentLocators.IMG_SELECT, filepath);
    }

    public void inputCurrentAddress(String text) {
        inputText(RegisterStudentLocators.TXA_CURRENT_ADDRESS, text);
    }

    public void selectState(String text) {
        clickElement(RegisterStudentLocators.DDL_STATE);
        clickElement(RegisterStudentLocators.selectStateCity(text));
    }

    public void selectCity(String text) {
        clickElement(RegisterStudentLocators.DDL_CITY);
        clickElement(RegisterStudentLocators.selectStateCity(text));
    }

    public void clickSubmitButton() {
        sendKeysFromKeyBoard(RegisterStudentLocators.TXA_CURRENT_ADDRESS, Keys.TAB);
        sendKeysFromKeyBoard(RegisterStudentLocators.TXA_CURRENT_ADDRESS, Keys.TAB);
        // clickElement(StudentRegistrationLocators.BTN_SUBMIT);
        sendKeysFromKeyBoard(RegisterStudentLocators.BTN_SUBMIT, Keys.ENTER);
    }

    public String getSuccessfulMessage() {
        return getText(RegisterStudentLocators.MSG_SUCCESS);
    }
    public String getVerifyTextValue(String text) {
        return getText(RegisterStudentLocators.verifySubmitValue(text));
    }
}
