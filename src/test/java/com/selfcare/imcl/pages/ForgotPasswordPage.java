package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage {
    /*@AndroidFindBy(id = "mobiotics.com.lcoselfcareimpl.debug:id/textview_forgotpassword")
    private WebElement forgotPasswordLink;*/

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_forgotpassword']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_custid']")
    private WebElement customerid;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_newpassword']")
    private WebElement newpwd;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_confirmpassword']")
    private WebElement confirmpwd;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_reset']")
    private WebElement submit_button;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_cancel']")
    private WebElement cancel_button;

    public ForgotPasswordPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        // PageFactory.initElements(new AppiumFieldDecorator(driver,
        // Duration.ofSeconds(5)), this);
        PageFactory.initElements(driver, this);
    }

    public void forgotpwd() throws InterruptedException {
        System.out.println("forgotPassword password" + "\n");
        waitTillElementIsVisible(forgotPasswordLink);
        forgotPasswordLink.click();

        customerid.sendKeys(enterUsername());
        Thread.sleep(1000);
        newpwd.sendKeys(enterNewPassword());
        Thread.sleep(1000);
        confirmpwd.sendKeys(enterNewPassword());
        Thread.sleep(1000);
        driver.hideKeyboard();
        Thread.sleep(1000);

        /*submit_button.click();
        Thread.sleep(1000);*/

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1000);
    }
}