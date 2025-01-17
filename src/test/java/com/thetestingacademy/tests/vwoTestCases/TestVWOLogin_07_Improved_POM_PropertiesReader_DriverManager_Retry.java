package com.thetestingacademy.tests.vwoTestCases;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.listeners.RetryAnalyzer;
import com.thetestingacademy.pages.pageObjectModel.vwo.normal.DashBoardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.normal.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_07_Improved_POM_PropertiesReader_DriverManager_Retry extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_07_Improved_POM_PropertiesReader_DriverManager_Retry.class);

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() {

        logger.info("Starting the Testcases Page Object Model");


        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage_VWO.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));


        logger.info("End of the testLoginNegativeVWO !");

        // Assertion AssertJ
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();

        // Assertion TestNG
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));


    }

    @Owner("PRAMOD")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {

        logger.info("Starting the Testcases |  Verify that valid creds dashboard page is loaded");


        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage  = new DashBoardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();


        logger.info("End and Asserting testLoginPositiveVWO");

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));



    }

    @Owner("PRAMOD")
    @Description("Verify that valid creds dashboard page Failed")
    @Test
    public void testLoginPositiveFailedVWO() {

        logger.info("Starting the Testcases |  Verify that valid creds dashboard page is loaded");


        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage  = new DashBoardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();


        logger.info("End and Asserting testLoginPositiveVWO");

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Pramod");



    }



}
