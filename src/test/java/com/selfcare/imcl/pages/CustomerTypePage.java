package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import com.selfcare.imcl.constants.PageNavigation;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

public class CustomerTypePage extends BasePage {
    HomePage homepage = new HomePage(driver);
    SubscriberCornerPage subscribercorner = new SubscriberCornerPage(driver);
    PageNavigation navigation = new PageNavigation(driver);

    public CustomerTypePage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void customerType() throws InterruptedException {
        System.out.println("CustomerTypePage ======= customertype()" + "\n");
        navigation.HomePage_Navigation();
        String customer = homepage.wallet();
        Thread.sleep(1000);
        navigation.SubscriberCorner_Navigation();
        Thread.sleep(1000);
        String customer1 = subscribercorner.customer();
        Thread.sleep(1000);

        System.out.println("checking " + customer + "\t" + customer1);
    }
}