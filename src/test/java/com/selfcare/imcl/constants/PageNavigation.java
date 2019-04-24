package com.selfcare.imcl.constants;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageNavigation extends BasePage {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    private WebElement humbergerIcon;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Home']")
    private WebElement home;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Plans']")
    private WebElement plans;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='     Add addons']")
    private WebElement addAddons;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='     Renew addons']")
    private WebElement renewAddons;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Subscriber Corner']")
    private WebElement subscriberCorner;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Payment']")
    private WebElement payment;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='     Wallet Recharge']")
    private WebElement walletRecharge;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Report']")
    private WebElement Report;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='     Payment Report']")
    private WebElement paymentReport;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='     Activation Report']")
    private WebElement activationReport;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Tickets']")
    private WebElement ticket;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Support center']")
    private WebElement supportCenter;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='     Error 3']")
    private WebElement error3;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='     Error5']")
    private WebElement error5;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='     Error7']")
    private WebElement error7;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='     Other Errors']")
    private WebElement otherErrors;

    public PageNavigation(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void HomePage_Navigation() throws InterruptedException {
        Thread.sleep(5000);

        try {
            if(home.isDisplayed())
            {
                home.click();
            }
        }catch (Exception E)
        {
            waitTillElementIsVisible(humbergerIcon);
            Thread.sleep(1000);
            humbergerIcon.click();
            try {
                driver.hideKeyboard();
            }catch (Exception E1)
            {
            }
            Thread.sleep(2000);
            home.click();
            Thread.sleep(2000);
        }
    }

    public void Plans_AddAddons_Navigation() throws InterruptedException {
        Thread.sleep(2000);
        waitTillElementIsVisible(humbergerIcon);
        Thread.sleep(1000);
        humbergerIcon.click();
        Thread.sleep(2000);
        try {
            driver.hideKeyboard();
        }catch (Exception E)
        {
        }
        plans.click();
        Thread.sleep(2000);
        addAddons.click();
        Thread.sleep(2000);
    }

    public void Plans_RenewAddons_Navigation() throws InterruptedException {
        Thread.sleep(2000);
        waitTillElementIsVisible(humbergerIcon);
        Thread.sleep(1000);
        humbergerIcon.click();
        Thread.sleep(2000);
        try {
            driver.hideKeyboard();
        }catch (Exception E)
        {
        }
        try {
            if (/*renewAddons.isDisplayed()||*/ renewAddons.isEnabled()) {
                Thread.sleep(1000);
                renewAddons.click();
            }
        } catch (Exception e) {
            plans.click();
            scroll("Report");
            try {
                if (renewAddons.isDisplayed()) {
                    renewAddons.click();
                }
            } catch (Exception e2) {
                plans.click();
                renewAddons.click();
            }
        }
        Thread.sleep(2000);
    }

    public void SubscriberCorner_Navigation() throws InterruptedException {
        Thread.sleep(2000);
        waitTillElementIsVisible(humbergerIcon);
        humbergerIcon.click();
        Thread.sleep(2000);
        try {
            driver.hideKeyboard();
        }catch (Exception E)
        {
        }
        subscriberCorner.click();
        Thread.sleep(2000);
    }

    public void Payment_WalletRecharge_Navigation() throws InterruptedException {
        Thread.sleep(2000);
        //waitTillElementIsVisible(humbergerIcon);
        //humbergerIcon.click();
        //Thread.sleep(2000);
        payment.click();
        //Thread.sleep(2000);
        //walletRecharge.click();
        Thread.sleep(2000);
    }

    public void Ticket_Navigation() throws InterruptedException {
        Thread.sleep(2000);
        waitTillElementIsVisible(humbergerIcon);
        Thread.sleep(2000);
        humbergerIcon.click();
        Thread.sleep(2000);
        try {
            driver.hideKeyboard();
        }catch (Exception E)
        {
        }
        ticket.click();
        Thread.sleep(2000);
    }

    public void SupportCenter_Error3_Navigation() throws InterruptedException {
        Thread.sleep(1000);
        waitTillElementIsVisible(humbergerIcon);
        Thread.sleep(1000);
        humbergerIcon.click();
        Thread.sleep(2000);
        try {
            driver.hideKeyboard();
        }catch (Exception E)
        {
        }
        try {
            if (error3.isDisplayed()) {
                error3.click();
            }
        } catch (Exception e) {
            supportCenter.click();
            scroll("Report");
            try {
                error3.click();
            } catch (Exception e2) {
                //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Support center\"))").click();
                Thread.sleep(2000);
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"     Error 3\"))");
                error3.click();
                Thread.sleep(2000);
            }
        }
    }

    public void SupportCenter_Error5_Navigation() throws InterruptedException {
        Thread.sleep(1000);
        waitTillElementIsVisible(humbergerIcon);
        Thread.sleep(1000);
        humbergerIcon.click();
        Thread.sleep(2000);
        try {
            driver.hideKeyboard();
        }catch (Exception E)
        {
        }
        try {
            if (error5.isDisplayed()) {
                error5.click();
            }
        } catch (Exception e) {
            subscriberCorner.click();
            scroll("Report");
            try {
                if (error5.isDisplayed()) {
                    error5.click();
                }
            } catch (Exception e2) {
                //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Support center\"))").click();
                Thread.sleep(1000);
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"     Error 5\"))");
                error5.click();
                Thread.sleep(2000);
            }
        }
    }

    public void SupportCenter_Error7_Navigation() throws InterruptedException {
        Thread.sleep(2000);
        waitTillElementIsVisible(humbergerIcon);
        Thread.sleep(1000);
        humbergerIcon.click();
        Thread.sleep(2000);
        try {
            driver.hideKeyboard();
        }catch (Exception E)
        {
        }
        try {
            if (error7.isDisplayed()) {
                error7.click();
            }
        } catch (Exception e) {
            subscriberCorner.click();
            scroll("Report");
            try {
                if (error7.isDisplayed()) {
                    error7.click();
                }
            } catch (Exception e2) {
                //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Support center\"))").click();
                Thread.sleep(2000);
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"     Error 7\"))");
                error7.click();
                Thread.sleep(2000);
            }
        }
    }

    public void SupportCenter_OtherErrors_Navigation() throws InterruptedException {
        Thread.sleep(2000);
        waitTillElementIsVisible(humbergerIcon);
        Thread.sleep(1000);
        humbergerIcon.click();
        Thread.sleep(2000);
        try {
            driver.hideKeyboard();
        }catch (Exception E)
        {
        }
        try {
            if (otherErrors.isDisplayed()) {
                otherErrors.click();
            }
        } catch (Exception e) {
            supportCenter.click();
            try {
                if (otherErrors.isDisplayed()) {
                    otherErrors.click();
                }
            } catch (Exception e2) {
                //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Support center\"))").click();
                Thread.sleep(1000);
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"     Other Errors\"))");
                otherErrors.click();
                Thread.sleep(2000);
            }
        }
    }

    public void Reports_ActivationReports_Navigation() throws InterruptedException {
        Thread.sleep(2000);
        waitTillElementIsVisible(humbergerIcon);
        Thread.sleep(1000);
        humbergerIcon.click();
        Thread.sleep(2000);
        try {
            driver.hideKeyboard();
        }catch (Exception E)
        {
        }
        try {
            if (activationReport.isDisplayed()) {
                activationReport.click();
            }
        } catch (Exception e) {
            Report.click();
            try {
                if (activationReport.isDisplayed()) {
                    activationReport.click();
                }
            } catch (Exception e2) {
               /* driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Report\"))");
                Report.click();
                Thread.sleep(2000);*/
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"     Activation Report\"))");
                /*scroll("     Activation Report");*/
                Thread.sleep(1000);
                activationReport.click();
                Thread.sleep(2000);
            }
        }
    }

    public void Reports_PaymentReports_Navigation() throws InterruptedException {
        Thread.sleep(2000);
        waitTillElementIsVisible(humbergerIcon);
        Thread.sleep(1000);
        humbergerIcon.click();
        Thread.sleep(2000);
        try {
            driver.hideKeyboard();
        }catch (Exception E)
        {
        }
        try {
            if (paymentReport.isDisplayed()) {
                paymentReport.click();
            }
        } catch (Exception e) {
            Report.click();
            try {
                if (paymentReport.isDisplayed()) {
                    paymentReport.click();
                }
            } catch (Exception e2) {
                //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Report\"))");
                /*Report.click();
                Thread.sleep(2000);*/
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"     Payment Report\"))");

                paymentReport.click();
                Thread.sleep(2000);
            }
        }
    }
}