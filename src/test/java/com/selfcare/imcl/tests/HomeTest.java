package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.constants.PageNavigation;
import com.selfcare.imcl.pages.HomePage;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    HomePage homepage;
    PageNavigation pagenavigation;

    @Test(priority = 3,enabled = false)
    public void home() throws InterruptedException {
        homepage = new HomePage(driver);
        pagenavigation = new PageNavigation(driver);

        pagenavigation.HomePage_Navigation();
        homepage.TopUpWallet();
    }
}