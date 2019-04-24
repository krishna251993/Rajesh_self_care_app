package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Scanner;

public class OTPPage extends BasePage {
    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/edittext_custid_otp']")
    private WebElement customerIDTextfield;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/edittext_otp']")
    private WebElement OTPTextfield;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/snackbar_text']")
    private WebElement error;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_regenotp']")
    private WebElement resendOTP;

    public OTPPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyOTP() throws InterruptedException {
        System.out.println("verify OTP" + "\n");
        Thread.sleep(25000);
        //customerIDTextfield.clear();
        //customerIDTextfield.sendKeys(register);
        //resendOTP.click();
        /*if (error.isDisplayed())
        {
            System.out.println(error.getText());
        }*/
        OTPTextfield.click();
        Thread.sleep(10000);
        submitButton.click();

    }
}