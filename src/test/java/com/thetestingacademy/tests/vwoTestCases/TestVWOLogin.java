package com.thetestingacademy.tests.vwoTestCases;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLogin {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");


        WebDriver driver = new EdgeDriver(edgeOptions);
//        driver.navigate().to("https://app.vwo.com");
        driver.get("https://app.vwo.com");

        // 1. Find the email inputbox and enter the email

        // <input  -->  open HTML Tag
        // type="email"  -->  key == value ( attributes)
        // class="text-input W(100%)"
        // name="username"
        // id="login-username"
        // data-qa="hocewoqisi"
        //
        // >   -->  close HTML Tag

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");


        // 2. Find the password inputbox and enter the password

        // input
        // type="password"
        // class="text-input W(100%)"
        // name="password"
        // data-qa="jobodapuxe"
        //
        // >


        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin");


        // 3. Find the submit button and click on it.
        // <button
        // type="submit"
        // id="js-login-btn"
        // class="btn btn--positive btn--inverted W(80%) H(48px) Fz(16px)"
        // onclick="login.login(event)"
        // data-qa="sibequkica"
        // >

        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        Thread.sleep(3000);


        // 4. Find the invalid error message and verify.
        // <div
        // class="notification-box-description"
        // data-qa="rixawilomi">
        // Your email, password, IP address or location did not match</div>

        WebElement error_message = driver.findElement(By.className("notification-box-description"));

        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");


        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null


    }

}
