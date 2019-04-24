package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RenewAddonsPage extends BasePage {
    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/etSearch']")
    private WebElement searchTextField;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/ivSearch']")
    private WebElement searchButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Plan Name']")
    private WebElement planName;

    @FindBy(xpath = "//android.widget.TextView[@text='Plan Code']")
    private WebElement planCode;

    @FindBy(xpath = "//android.widget.TextView[@text='Validity']")
    private WebElement validity;

    @FindBy(xpath = "//android.widget.TextView[@text='Price']")
    private WebElement price;

    @FindBy(xpath = "//android.widget.TextView[@text='Remaining']")
    private WebElement remaining;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_plan_name_tag']")
    private WebElement PlanNameText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_plan_code_tag']")
    private WebElement PlanCodeText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_validity_tag']")
    private WebElement PlanValidityText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_price_tag']")
    private WebElement PriceText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_expiry_date']")
    private WebElement RemainingText;

    @FindBy(xpath = "//android.widget.RadioButton[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_select_tag']")
    private WebElement radioButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_subscribe_homefragment']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//android.widget.Button[@id='mobiotics.com.lcoselfcareimpl:id/button_procced_topay']")
    private WebElement proceedToPayButton;

    public RenewAddonsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void renew() throws InterruptedException {
        System.out.println("Renew Addons Page" + "\n");
        waitTillElementIsVisible(searchTextField);
        searchTextField.sendKeys("STAR ");
        Thread.sleep(1000);
        searchButton.click();

        Thread.sleep(1000);
        try {
            if (radioButton.isEnabled()) {
                radioButton.click();
                Thread.sleep(1000);

                String plannametext = PlanNameText.getText();
                String planname = planName.getText();
                String plancodetext = PlanCodeText.getText();
                String plancode = planCode.getText();
                String planvaliditytext = PlanValidityText.getText();
                String planvalidity = validity.getText();
                String planpricetext = PriceText.getText();
                String planprice = price.getText();

                System.out.println("\n" + planname + " == " + plannametext + "\n");
                System.out.println(plancode + " == " + plancodetext + "\n");
                System.out.println(planvalidity + " == " + planvaliditytext + "\n");
                System.out.println(planprice + " == " + planpricetext + "\n");

                subscribeButton.click();
                Thread.sleep(5000);
                //proceedToPayButton.click();
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
                Thread.sleep(1000);
                //Thread.sleep(1000);
            }
            }
        catch (Exception E)
        {
            System.out.println("This customer is not able to renew any plans.");
        }
    }
}