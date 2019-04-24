package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomeSignupPage extends BasePage {
    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/edittext_custdid_fragment']")
    private WebElement customerid;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/edittext_newpassword']")
    private WebElement password;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/edittext_confirmpassword']")
    private WebElement confirmpwd;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/edittext_mobile']")
    private WebElement mobilenum;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/edittext_email']")
    private WebElement emailid;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_signup']")
    private WebElement signupButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_enterotp']")
    private WebElement enter_otp;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_login']")
    private WebElement loginLink;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/snackbar_text']")
    private WebElement error;

    public WelcomeSignupPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void signup() throws InterruptedException {
        System.out.println("Signup Page" + "\n");
        waitTillElementIsVisible(customerid);
        if (customerid.getText().equals(un)) {
            Thread.sleep(1000);
            moveToElement(password);
            password.sendKeys(enterPwd());
            Thread.sleep(1000);
            try {
                driver.hideKeyboard();
            } catch (Exception e) {
            }
            moveToElement(confirmpwd);
            confirmpwd.sendKeys(enterPwd());
            Thread.sleep(1000);
            try {
                driver.hideKeyboard();
            } catch (Exception e) {
            }
            moveToElement(mobilenum);
            mobilenum.sendKeys(mobileNumber());
            Thread.sleep(1000);
            try {
                driver.hideKeyboard();
            } catch (Exception e) {
            }
            moveToElement(emailid);
            emailid.sendKeys(email_id());
            Thread.sleep(1000);
            try {
                driver.hideKeyboard();
            } catch (Exception e) {
            }
            moveToElement(signupButton);
            signupButton.click();
            //	otp enter and submittion

            waitTilIsAlertPresent();
            OTPPage otpPage=new OTPPage(driver);

            try {
                if (error.isDisplayed()) {
                    System.out.println(error.getText());
                    if(error.getText().equalsIgnoreCase("OTP  Verification pending"))
                    {
                        enter_otp.click();
                        otpPage.verifyOTP();
                    }
                    else
                    {
                        loginLink.click();
                    }
                }
            } catch (Exception e) {
                otpPage.verifyOTP();
            }
        }
    }
}