package com.thetestingacademy.pages.pageObjectModel.orangeHR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListHomePage {

    WebDriver driver;

    public EmployeeListHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Locators
    By userNameOnDashboard = By.xpath("//h6[normalize-space()='PIM']");


    // Page Actions
    public String loggedInUserName() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return driver.findElement(userNameOnDashboard).getText();
    }



}
