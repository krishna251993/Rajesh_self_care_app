package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentReportPage extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textView_search_here_report']")
    private WebElement filter;
    @FindBy(xpath = "//android.widget.Spinner[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/spnner_status_report']")
    private WebElement status;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_todate_report']")
    private WebElement fromDate;
    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_go_search_report']")
    private WebElement goButton;
    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_pln_cancel']")
    private WebElement cancelButton;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='ALL']")
    private WebElement all;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='PAID']")
    private WebElement paid;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='REFUNDED']")
    private WebElement refunded;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='PENDING']")
    private WebElement pending;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='CANCELLED']")
    private WebElement cancelled;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='FAILED']")
    private WebElement failed;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/snackbar_text']")
    private WebElement error;

    public PaymentReportPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void paymentReport() throws InterruptedException {
        System.out.println("Payment Report" + "\n");
        waitTillElementIsVisible(filter);
        filter.click();
        status.click();

        String[] status = new String[10];
        status[0] = all.getText();
        status[1] = paid.getText();
        status[2] = refunded.getText();
        status[3] = pending.getText();
        status[4] = cancelled.getText();
        status[5] = failed.getText();

        int index = (int) (Math.random() * 5);
        String a = status[index++];

        if (a.equals(status[0])) {
            all.click();
        } else if (a.equals(status[1])) {
            paid.click();
        } else if (a.equals(status[2])) {
            refunded.click();
        } else if (a.equals(status[3])) {
            pending.click();
        } else if (a.equals(status[4])) {
            cancelled.click();
        } else if (a.equals(status[5])) {
            failed.click();
        }

        //calender
		/*DatePicker date=new DatePicker();
		date.datePicker(fromDate);*/

        goButton.click();
        try {
            if (error.isDisplayed())
                System.out.println(error.getText());
        } catch (Exception e) {
                System.out.println("Success");
        }
        Thread.sleep(1000);
    }
}