package com.thetestingacademy.pages.pageFactory;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF extends CommonToAllPage {

    // Page Locators

    public LoginPage_PF(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;


    // Page Actions
    public String loginToVWOInvalidCreds() {
        enterInput(username, PropertiesReader.readKey("invalid_username"));
        enterInput(password, PropertiesReader.readKey("invalid_password"));
        clickElement(signButton);
        custom_wait();
        return getText(error_message);

    }





}
