package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.constants.PageNavigation;
import com.selfcare.imcl.pages.OtherErrorsPage;
import org.testng.annotations.Test;

public class OtherErrorsTest extends BaseTest {
    PageNavigation pagenavigation;
    OtherErrorsPage otherErrors;

    @Test(priority = 11,enabled = false)
    public void otherError() throws InterruptedException {
        pagenavigation = new PageNavigation(driver);
        otherErrors = new OtherErrorsPage(driver);

        pagenavigation.SupportCenter_OtherErrors_Navigation();
        otherErrors.othererrors();
        pagenavigation.HomePage_Navigation();
    }
}