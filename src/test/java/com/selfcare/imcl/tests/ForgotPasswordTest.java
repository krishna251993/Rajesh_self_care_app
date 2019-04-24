package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.pages.ForgotPasswordPage;
import com.selfcare.imcl.pages.OTPPage;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {
    ForgotPasswordPage forgotpasswordpage;
    OTPPage otppage;

    @Test(priority = 1,enabled = false)
    public void forgotPassword() throws InterruptedException {
        forgotpasswordpage = new ForgotPasswordPage(driver);
        otppage = new OTPPage(driver);

        forgotpasswordpage.forgotpwd();
        //otppage.verifyOTP();
    }
}