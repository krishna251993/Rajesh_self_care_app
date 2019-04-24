package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.constants.PageNavigation;
import com.selfcare.imcl.pages.OTPPage;
import com.selfcare.imcl.pages.SubscriberCornerPage;
import org.testng.annotations.Test;

public class SubscriberCornerTest extends BaseTest {
    PageNavigation pagenavigation;
    SubscriberCornerPage subscribercornerpage;
    OTPPage otp;

    @Test(priority = 12,enabled = false)
    public void updateCustomerDetails() throws InterruptedException {
        pagenavigation = new PageNavigation(driver);
        subscribercornerpage = new SubscriberCornerPage(driver);
        otp = new OTPPage(driver);

        pagenavigation.SubscriberCorner_Navigation();
        subscribercornerpage.subscriberupdate();
        otp.verifyOTP();
    }
}