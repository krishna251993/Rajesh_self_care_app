package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.constants.PageNavigation;
import com.selfcare.imcl.pages.Error7Page;
import org.testng.annotations.Test;

public class Error7Test extends BaseTest {
    PageNavigation pagenavigation;
    Error7Page errorpage;

    @Test(priority = 10,enabled = false)
    public void errorSeven() throws InterruptedException {
        pagenavigation = new PageNavigation(driver);
        errorpage = new Error7Page(driver);

        pagenavigation.SupportCenter_Error7_Navigation();
        errorpage.sendmail();
    }
}