package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Error5Page extends BasePage {
    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/buttopn_retrack']")
    private WebElement retrackButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_cancel_error5']")
    private WebElement cancelButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/snackbar_text']")
    private WebElement error;

    public Error5Page(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void retrack() {
        System.out.println("error5" + "\n");
        waitTillElementIsVisible(retrackButton);
        retrackButton.click();
        waitTillElementIsVisible(error);
        try {
            if (error.isDisplayed()) {
                System.out.println(error.getText());
            }
        } catch (Exception e) {

        }
    }
}