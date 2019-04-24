package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivationReportPage extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textView_search_here_report']")
    private WebElement filter;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/search_plan_report']")
    private WebElement planNameTextfield;
    @FindBy(xpath = "//android.widget.Spinner[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/spnner_status_report']")
    private WebElement StatusDropdown;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_todate_report']")
    private WebElement fromDate;
    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_pln_cancel']")
    private WebElement cancelButton;
    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_go_search_report']")
    private WebElement goButton;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Select Status']")
    private WebElement selectStatusOption;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='ACTIVE']")
    private WebElement activeStatus;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='PENDING']")
    private WebElement pendingStatus;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='FAILED']")
    private WebElement failedStatus;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='CANCELED']")
    private WebElement cancelledstatus;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/snackbar_text']")
    private WebElement error;

    public ActivationReportPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void activations() throws InterruptedException {

        System.out.println("ActivationReportPage===Activations()" + "\n");
        waitTillElementIsVisible(filter);
        filter.click();
        System.out.println("filter clicked");
        planNameTextfield.sendKeys("Banglore");
        StatusDropdown.click();
        System.out.println("clicked on status");

        String[] status = new String[10];
        status[0] = selectStatusOption.getText();
        status[1] = activeStatus.getText();
        status[2] = pendingStatus.getText();
        status[3] = failedStatus.getText();
        status[4] = cancelledstatus.getText();

        int index = (int) (Math.random() * 4);
        String a = status[index++];
        System.out.println(index++);

        if (a.equals(status[1]))
            activeStatus.click();
        else if (a.equals(status[2]))
            pendingStatus.click();
        else if (a.equals(status[3]))
            failedStatus.click();
        else if (a.equals(status[4]))
            cancelledstatus.click();

        //calander
		/*DatePicker date=new DatePicker();
		date.datePicker(fromDate);*/

        driver.hideKeyboard();

        //goButton.click();
        Thread.sleep(1000);
        try {
            if (error.isDisplayed())
                System.out.println(error.getText());
        } catch (Exception e) {
        }
    }
}