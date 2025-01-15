package com.thetestingacademy.pages.pageObjectModel.orangeHR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHRPage {

    WebDriver driver;
    public LoginHRPage(WebDriver driver)
    {
        this.driver = driver;
    }

    // page locators

    private By username = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By submit_btn = By.xpath("//button[normalize-space()='Login']");


    public void loginToHRCreds(String user, String pwd) {
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(submit_btn).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }



}
