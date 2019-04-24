package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.pages.CustomerTypePage;
import org.testng.annotations.Test;

public class CustomerTypeTest extends BaseTest {
    CustomerTypePage customertypepage;

    @Test(priority = 4,enabled = false)
    public void customertype() throws InterruptedException {
        customertypepage = new CustomerTypePage(driver);
        customertypepage.customerType();
    }
}