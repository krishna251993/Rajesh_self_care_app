package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.pages.LogoutPage;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    LogoutPage logoutpage;

    @Test(priority=15,enabled = true)
    public void logoutApp() {
        logoutpage = new LogoutPage(driver);
        logoutpage.logoutApp();
    }
}