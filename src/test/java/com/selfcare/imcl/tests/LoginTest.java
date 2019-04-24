package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginpage;

    @Test(priority = 2,enabled = true)
    public void loginToApp() throws InterruptedException {
        loginpage = new LoginPage(driver);
        loginpage.login();
    }
}