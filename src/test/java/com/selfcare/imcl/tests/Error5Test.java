package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.constants.PageNavigation;
import com.selfcare.imcl.pages.Error5Page;
import org.testng.annotations.Test;

public class Error5Test extends BaseTest {
    PageNavigation pagenavigation;
    Error5Page errorpage;

    @Test(priority = 9,enabled = false)
    public void errorfive() throws InterruptedException {
        pagenavigation = new PageNavigation(driver);
        errorpage = new Error5Page(driver);

        pagenavigation.SupportCenter_Error5_Navigation();
        errorpage.retrack();
    }
}