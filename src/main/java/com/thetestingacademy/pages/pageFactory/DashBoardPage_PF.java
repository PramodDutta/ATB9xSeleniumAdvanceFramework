package com.thetestingacademy.pages.pageFactory;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage_PF extends CommonToAllPage {

    WebDriver driver;

    public DashBoardPage_PF(WebDriver driver) {
        this.driver = driver;
    }

    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");


    // Page Actions
    public String loggedInUserName() {
        visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }

}
