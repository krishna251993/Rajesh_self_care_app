package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddonsPage extends BasePage {
    @FindBy(xpath = "//android.widget.Spinner[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/spinner_planname']")
    private WebElement addonsPlanList;
    @FindBy(xpath = "//android.widget.RadioButton[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_select_tag']")
    private WebElement radioButton;
    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_subscribe_homefragment']")
    private WebElement subscribeButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl:id/textview_top_up_wallet']")
    private WebElement topUpWalletLink;
    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='BANGALORE EXPRESS (KANNADA)']")
    private WebElement banglore;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='BANGALORE EXPRESS (KANNADA)']")
    private WebElement banglore1;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/etSearch']")
    private WebElement search;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/ivSearch']")
    private WebElement searchbutton;
    @FindBy(xpath = "//android.widget.TextView[@text='Plan Name']")
    private WebElement planNameText;
    @FindBy(xpath = "//android.widget.TextView[@text='Plan Code']")
    private WebElement planCodeText;
    @FindBy(xpath = "//android.widget.TextView[@text='Validity']")
    private WebElement validityText;
    @FindBy(xpath = "//android.widget.TextView[@text='Price']")
    private WebElement priceText;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_plan_name']")
    private WebElement planName;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_plan_code_tag']")
    private WebElement planCode;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_validity_tag']")
    private WebElement validity;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_price_tag']")
    private WebElement price;
    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_procced_topay']")
    private WebElement ProceedToPayButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/snackbar_text']")
    private WebElement error;

    public AddonsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addons() throws InterruptedException {
        System.out.println("AddonsPage===addons()" + "\n");
        waitTillElementIsVisible(search);
        String searchString = "Banglore";
        search.sendKeys(searchString);
        searchbutton.click();

        try {
            System.out.println(error.getText());
        } catch (Exception e) {

            String plannametext = planNameText.getText();
            String planname = planName.getText();
            String plancodetext = planCodeText.getText();
            String plancode = planCode.getText();
            String planvaliditytext = validityText.getText();
            String planvalidity = validity.getText();
            String planpricetext = priceText.getText();
            String planprice = price.getText();

            if (plannametext.contains(searchString)) {
                radioButton.click();
                Thread.sleep(1000);

                waitTillElementIsVisible(subscribeButton);
                subscribeButton.click();
                Thread.sleep(1000);

                System.out.println("\n" + plannametext + " == " + planname + "\n");
                System.out.println(plancodetext + " == " + plancode + "\n");
                System.out.println(planvaliditytext + " == " + planvalidity + "\n");
                System.out.println(planpricetext + " == " + planprice + "\n");

                Thread.sleep(1000);
                //ProceedToPayButton.click();
                //Thread.sleep(1000);
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
                Thread.sleep(1000);
                //driver.pressKey(new KeyEvent(AndroidKey.BACK));
            }
        }
    }
}