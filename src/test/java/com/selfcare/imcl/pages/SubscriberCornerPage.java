package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.selfcare.imcl.constants.Constants.frCAN;

public class SubscriberCornerPage extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_creditblance']")
    private WebElement current_balance;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_header_text']")
    private WebElement profileHeader;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_update']")
    private WebElement update;

    @FindBy(xpath = "//android.widget.TextView[text()='Subscribed Plans']")
    private WebElement subscribedPlans;

    @FindBy(xpath = "//android.widget.TextView[text()='Hardware Details']")
    private WebElement hardwareDetails;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_update_aadhar_no']")
    private WebElement aadhar;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_update_email']")
    private WebElement email_id;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_update_mobileno']")
    private WebElement mobilenum;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_id_proof']")
    private WebElement idProof;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/buttton_address_proof']")
    private WebElement attachAddressProof;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_update']")
    private WebElement updateButton;

    public SubscriberCornerPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String customer() {
        System.out.println("subscriber corner page ==== type of customer" + "\n");
        waitTillElementIsVisible(updateButton);
        updateButton.click();
        try {
            //scroll("ID PROOF");
            scroll("UPDATE");
            if (idProof.isDisplayed() && attachAddressProof.isDisplayed()) {
                frCAN = "DP CUSTOMERS";
                System.out.println(frCAN);
            }
        } catch (Exception e) {
            frCAN = "LCO CUSTOMERS";
            System.out.println(frCAN);
        }
        return frCAN;
    }

    public void subscriberupdate() throws InterruptedException {
        System.out.println("Subscriber corner page=====subscriber update");
        waitTillElementIsVisible(current_balance);
        System.out.println(current_balance.getText());
        updateButton.click();

        String oldAadharnum = "990036870111";
        String newAadharnum = "990099009900";
        String presentAadhar = aadhar.getText();

        String oldEmail = email_id();
        String newEmail = "akshatha191294@gmail.com";
        String presentEmail = email_id.getText();

        String oldMobileNum = mobileNumber();
        String newMobileNum = "9513146101";
        String presentMobileNum = mobilenum.getText();

        moveToElement(aadhar);
        aadhar.clear();
        try {
            driver.hideKeyboard();
        }
        catch (Exception e){

        }
        moveToElement(email_id);
        email_id.clear();
        try {
            driver.hideKeyboard();
        }
        catch (Exception e){

        }
        moveToElement(mobilenum);
        mobilenum.clear();
        try {
            driver.hideKeyboard();
        }
        catch (Exception e){

        }
        if (presentAadhar.equals(oldAadharnum) && presentEmail.equals(oldEmail) && presentMobileNum.equals(oldMobileNum)) {
            moveToElement(aadhar);
            aadhar.sendKeys(newAadharnum);
            Thread.sleep(1000);
            try {
                driver.hideKeyboard();
            }
            catch (Exception e){
            }
            moveToElement(email_id);
            email_id.sendKeys(newEmail);
            Thread.sleep(1000);
            try {
                driver.hideKeyboard();
            }
            catch (Exception e){

            }
            moveToElement(mobilenum);
            Thread.sleep(1000);
            mobilenum.sendKeys(newMobileNum);
            try {
                driver.hideKeyboard();
            }
            catch (Exception e){

            }
        } else {
            moveToElement(aadhar);
            aadhar.sendKeys(oldAadharnum);
            Thread.sleep(1000);
            try {
                driver.hideKeyboard();
            }
            catch (Exception e){
            }
            moveToElement(email_id);
            email_id.sendKeys(oldEmail);
            Thread.sleep(1000);
            try {
                driver.hideKeyboard();
            }
            catch (Exception e){

            }
            moveToElement(mobilenum);
            mobilenum.sendKeys(oldMobileNum);
            Thread.sleep(1000);
            try {
                driver.hideKeyboard();
            }
            catch (Exception e){
            }
        }
        scroll("Update");
        try {
            System.out.println(frCAN);
            if (frCAN.equalsIgnoreCase("DP CUSTOMERS"))
            {
                if (idProof.isDisplayed() && attachAddressProof.isDisplayed()) {
                    moveToElement(idProof);
                    idProof.click();
                    Thread.sleep(1000);
                    driver.pressKey(new KeyEvent(AndroidKey.BACK));
                    moveToElement(attachAddressProof);
                    attachAddressProof.click();
                    Thread.sleep(1000);
                    driver.pressKey(new KeyEvent(AndroidKey.BACK));
                }
                else
                    System.out.println("idproof and addressproof buttons are not visible");
            }
        } catch (Exception e) {
            if (frCAN.equalsIgnoreCase("LCO CUSTOMERS")) {
                System.out.println("For LCO customers there will no KYC updation");
            }
        }
        Thread.sleep(1000);
        moveToElement(updateButton);
        updateButton.click();
    }
}