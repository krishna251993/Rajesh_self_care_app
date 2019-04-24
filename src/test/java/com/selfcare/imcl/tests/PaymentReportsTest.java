package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.constants.PageNavigation;
import com.selfcare.imcl.pages.CustomerTypePage;
import com.selfcare.imcl.pages.PaymentReportPage;
import com.selfcare.imcl.pages.SubscriberCornerPage;
import org.testng.annotations.Test;

import static com.selfcare.imcl.constants.Constants.frCAN;

public class PaymentReportsTest extends BaseTest {
    PageNavigation pagenavigation;
    PaymentReportPage paymentreportpage;

    @Test(priority = 14,enabled = false)
    public void paymentReports() throws InterruptedException {
        pagenavigation = new PageNavigation(driver);
        paymentreportpage = new PaymentReportPage(driver);

        //need to check the type of customer
        //System.out.println(frCAN + " type of customer");
        if(frCAN.equalsIgnoreCase("DP CUSTOMERS"))
        {
            pagenavigation.Reports_PaymentReports_Navigation();
            paymentreportpage.paymentReport();
            pagenavigation.HomePage_Navigation();
        }else
            System.out.println("LCO CUSTOMER don't have Payment page");
    }
}