package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.constants.PageNavigation;
import com.selfcare.imcl.pages.AddonsPage;
import com.selfcare.imcl.pages.PaymentsPage;
import org.testng.annotations.Test;

public class AddonsTest extends BaseTest {
    PageNavigation pagenavigation;
    AddonsPage addonspage;
    PaymentsPage paymentpage;

    @Test(priority = 5,enabled = false)
    public void activateAddons() throws InterruptedException {
        pagenavigation = new PageNavigation(driver);
        addonspage = new AddonsPage(driver);
        paymentpage = new PaymentsPage(driver);

        pagenavigation.Plans_AddAddons_Navigation();
        addonspage.addons();
        //paymentpage.payment();
    }
}