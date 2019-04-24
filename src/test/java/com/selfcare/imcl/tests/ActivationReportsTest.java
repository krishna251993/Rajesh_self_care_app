package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.constants.PageNavigation;
import com.selfcare.imcl.pages.ActivationReportPage;
import org.testng.annotations.Test;

public class ActivationReportsTest extends BaseTest {
    PageNavigation pagenavigation;
    ActivationReportPage activationreportpage;

    @Test(priority = 7,enabled = false)
    public void activationReport() throws InterruptedException {
        pagenavigation = new PageNavigation(driver);
        activationreportpage = new ActivationReportPage(driver);

        pagenavigation.Reports_ActivationReports_Navigation();
        activationreportpage.activations();
    }
}