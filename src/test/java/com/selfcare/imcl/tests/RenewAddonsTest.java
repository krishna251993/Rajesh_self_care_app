package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.constants.PageNavigation;
import com.selfcare.imcl.pages.PaymentsPage;
import com.selfcare.imcl.pages.RenewAddonsPage;
import org.testng.annotations.Test;

public class RenewAddonsTest extends BaseTest {
    PageNavigation pagenavigation;
    RenewAddonsPage renewAddonsPage;
    PaymentsPage paymentpage;

    @Test(priority = 6,enabled = false)
    public void RenewAddons() throws InterruptedException {
        pagenavigation = new PageNavigation(driver);
        renewAddonsPage = new RenewAddonsPage(driver);
        paymentpage = new PaymentsPage(driver);

        pagenavigation.Plans_RenewAddons_Navigation();
        renewAddonsPage.renew();
        paymentpage.payment();
    }
}