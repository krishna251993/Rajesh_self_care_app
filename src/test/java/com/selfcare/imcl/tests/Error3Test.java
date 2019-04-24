package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.constants.PageNavigation;
import com.selfcare.imcl.pages.Error3Page;
import org.testng.annotations.Test;

public class Error3Test extends BaseTest {
    PageNavigation pagenavigation;
    Error3Page errorpage;

    //AppDriver = (AppiumDriver)Driver.Get();

    @Test(priority = 8,enabled = false)
    public void errorthree() throws InterruptedException {
        pagenavigation = new PageNavigation(driver);
        errorpage = new Error3Page(driver);

        pagenavigation.SupportCenter_Error3_Navigation();
        errorpage.sendmail();
    }
}