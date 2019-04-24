package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketPage extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_create_ticket']")
    private WebElement newTicket;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textView_search_here_report']")
    private WebElement filter;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='NEW']")
    private WebElement newStatus;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='PENDING']")
    private WebElement pendingStatus;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='CLOSED']")
    private WebElement closedStatus;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/snackbar_text']")
    private WebElement error;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/search_plan_report']")
    private WebElement enterTicketNumber;

    @FindBy(xpath = "//android.widget.Spinner[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/spnner_status_report']")
    private WebElement ticketStatus;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_todate_report']")
    private WebElement startDate;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_enddate_report']")
    private WebElement endDate;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_go_plan_search_report']")
    private WebElement goButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_pln_cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/close_ticket']")
    private WebElement closeTicket;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Select Ticket Status']")
    private WebElement selectStatus;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement calender;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_todate_report']")
    private WebElement fromDate;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
    private WebElement CalanderCancel;

    public TicketPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void filterTicket() {
        System.out.println("ticket====filter" + "\n");
        waitTillElementIsVisible(filter);
        filter.click();
        enterTicketNumber.sendKeys("3246188");
        ticketStatus.click();

        String[] status = new String[10];
        status[0] = selectStatus.getText();
        status[1] = newStatus.getText();
        status[2] = pendingStatus.getText();
        status[3] = closedStatus.getText();

        System.out.println(status[1] + "\n" + status[2] + "\n" + status[3] + "\n");

        int index = (int) (Math.random() * 3);
        index++;
        System.out.println(index);
        String a = status[index];
        System.out.println(a);

        if (a.equals(status[1]))
            newStatus.click();
        else if (a.equals(status[2]))
            pendingStatus.click();
        else if (a.equals(status[3]))
            closedStatus.click();

        //calander
//			DatePicker date=new DatePicker();
//			date.datePicker(fromDate);

//			Actions action = new Actions(driver);
//			action.doubleClick(fromDate).perform();

//			fromDate.clear();
//			fromDate.sendKeys("11-11-2018");

//		((JavascriptExecutor) driver).executeScript
//		("document.getElementById('mobiotics.com.lcoselfcareimpl.debug:id/textview_todate_report').value='08-10-2018'");

        goButton.click();

        try {
            if (closeTicket.isDisplayed()) {
                closeTicket.click();
            }
        } catch (Exception e) {
        }

        try {
            if (error.isDisplayed())
                System.out.println(error.getText());
        } catch (Exception e) {
        }
    }
}