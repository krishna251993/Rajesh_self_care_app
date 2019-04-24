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

public class HomePage extends BasePage {
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    private WebElement moreoptions;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    private WebElement humbergerIcon;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_top_up_wallet']")
    private WebElement topUpWallet;
    @FindBy(xpath = "//android.widget.TextView[@text='Home']")
    private WebElement header;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/edittext_enter_amount']")
    private WebElement amountTextfield;
    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_recharge_mywallet']")
    private WebElement payButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/customertype_homefragment_vale']")
    private WebElement customer_Type;

    public HomePage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void TopUpWallet() throws InterruptedException {
        System.out.println("Topup Wallet" + "\n");
        //Thread.sleep(2000);
        waitTillElementIsVisible(customer_Type);
        try {
            if (topUpWallet.isDisplayed()) {
                topUpWallet.click();
                System.out.println(header.getText());
                String numberAsString = String.valueOf(100);
                amountTextfield.sendKeys(numberAsString);
                payButton.click();
                Thread.sleep(1000);
                //driver.hideKeyboard();
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
            }
        } catch (Exception e) {

        }
    }

    public String wallet() throws InterruptedException {
        System.out.println("checking the wallet" + "\n");
        Thread.sleep(1000);
        waitTillElementIsVisible(customer_Type);
        try {
            if (topUpWallet.isDisplayed()) {
                frCAN = customer_Type.getText();
                System.out.println(frCAN + "\n");
                return frCAN;
            }
        } catch (Exception e) {
            System.out.println("no wallet");
        }
        return frCAN;
    }
}