package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/noaccount']")
    private WebElement homepage_signUpHere_link;

    @FindBy(xpath = "//android.widget.Spinner[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/spinner_aunthicate_using']")
    private WebElement authenticatingUseing;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/edittext_custid']")
    private WebElement customerid;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_signup']")
    private WebElement proceedButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview' and text()='Login']")
    private WebElement loginButton;

    public SignupPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void signup() throws InterruptedException {
        System.out.println("Signup" + "\n");
        homepage_signUpHere_link.click();
        String userName = enterUsername();
        authenticatingUseing.click();

        WebElement element = getUserLoginType(userName);
        element.click();

        customerid.sendKeys(registerCustomer());
        proceedButton.click();

        errorMgs();
    }
}