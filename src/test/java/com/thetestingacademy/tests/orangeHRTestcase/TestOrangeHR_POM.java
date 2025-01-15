package com.thetestingacademy.tests.orangeHRTestcase;

import com.thetestingacademy.pages.pageObjectModel.orangeHR.EmployeeListHomePage;
import com.thetestingacademy.pages.pageObjectModel.orangeHR.LoginHRPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestOrangeHR_POM {
    @Owner("PRAMOD")
    @Description("Verify that the login to the OrangeHR ")
    @Test
    public void testLoginPositive() {
        WebDriver driver = new EdgeDriver();



        LoginHRPage loginHRPage = new LoginHRPage(driver);
        loginHRPage.loginToHRCreds("admin","Hacker@4321");

        EmployeeListHomePage dashboardPagePom = new EmployeeListHomePage(driver);
        String loggedInUserName = dashboardPagePom.loggedInUserName();

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName,"PIM");


    }

}
