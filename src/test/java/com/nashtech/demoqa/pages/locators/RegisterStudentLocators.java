package com.nashtech.demoqa.pages.locators;

import org.openqa.selenium.By;

public class RegisterStudentLocators {
    public static final By TXT_FIRSTNAME = By.id ("firstName"); // required
    public static final By TXT_LASTNAME = By.id("lastName"); // required
    public static final By TXT_EMAIL = By.id("userEmail");
    public static final By GENDER(String text) {
        return By.xpath(String.format("//input[@name='gender']/following-sibling::label[text()='%s']",text));
    }
    public static final By RDO_GENDER_MALE = By.xpath("//input[@value='Male']");    // required
    public static final By RDO_GENDER_FEMALE = By.xpath("//input[@value='Female']");
    public static final By RDO_GENDER_OTHER = By.xpath("//input[@value='Other']");
    public static final By TXT_MOBILE_NUMBER = By.id("userNumber"); // required
    public static final By TXT_DATEOFBIRD = By.id("dateOfBirthInput");
    public static final By TXT_SUBJECT = By.id("subjectsInput");
    public static final By CHK_HOBBIES_SPORTS = By.xpath("//div[@id='hobbiesWrapper']//label[contains(text(),'Sports')]");
    public static final By CHK_HOBBIES_READING = By.xpath("//div[@id='hobbiesWrapper']//label[contains(text(),'Reading')]");
    public static final By CHK_HOBBIES_MUSIC = By.xpath("//div[@id='hobbiesWrapper']//label[contains(text(),'Music')]");
    public static final By IMG_SELECT = By.xpath("//input[@id='uploadPicture']"); // sendKeys("image filepath")
    public static final By DDL_STATE_CITY(String text) {
        return By.xpath(String.format("//div[@id='stateCity-wrapper']//div[text()='%s']", text));
    }
    public static final By DDL_STATE = By.xpath("//div[text()='Select State']");
    public static final By DDL_CITY = By.xpath("//div[text()='Select City']");
    public static final By TXA_CURRENT_ADDRESS = By.id("currentAddress");
    public static final By BTN_SUBMIT = By.id("submit");
    public static final By MSG_SUCCESS = By.xpath("//div[@id='example-modal-sizes-title-lg']");
    public static final By VERIFY_SUBMIT_VALUE(String text) {
        return By.xpath(String.format("//tr[td[text()='%s']]/td[2]", text));
    }

}
