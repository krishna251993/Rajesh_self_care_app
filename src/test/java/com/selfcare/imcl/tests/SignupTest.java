package com.selfcare.imcl.tests;

import com.selfcare.imcl.constants.BaseTest;
import com.selfcare.imcl.pages.LoginPage;
import com.selfcare.imcl.pages.OTPPage;
import com.selfcare.imcl.pages.SignupPage;
import com.selfcare.imcl.pages.WelcomeSignupPage;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {
    SignupPage signuppage;
    LoginPage loginpage;
    WelcomeSignupPage welcomesignuppage;
    OTPPage otpPage;

    @Test(priority = 0,enabled = false)
    public void signupCustomer() throws InterruptedException {
        signuppage = new SignupPage(driver);
        welcomesignuppage = new WelcomeSignupPage(driver);
        otpPage = new OTPPage(driver);

        signuppage.signup();
        welcomesignuppage.signup();
        /*otpPage.verifyOTP();*/
    }
}