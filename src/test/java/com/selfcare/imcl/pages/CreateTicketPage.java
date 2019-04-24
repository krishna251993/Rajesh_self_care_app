package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class CreateTicketPage extends BasePage {
    @FindBy(xpath = "//android.widget.Spinner[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/spinner_cat1']")
    private WebElement selectCategory;

    @FindBy(xpath = "//android.widget.TextView[1]")
    private WebElement billing;

    @FindBy(xpath = "//android.widget.TextView[2]")
    private WebElement hardware;

    @FindBy(xpath = "//android.widget.TextView[3]")
    private WebElement modification;

    @FindBy(xpath = "//android.widget.TextView[4]")
    private WebElement order;

    @FindBy(xpath = "//android.widget.TextView[5]")
    private WebElement service;

    @FindBy(xpath = "//android.widget.Spinner[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/spinner_cat2']")
    private WebElement selectDescription;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='android.debug:id/text1'][1]")
    private WebElement description;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/textview_description']")
    private WebElement reason;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_create_ticket']")
    private WebElement ticketButton;

    private WebElement randomDescSelected;

    public CreateTicketPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void ticketCreate() throws InterruptedException {
        System.out.println("CreateTicketPage======ticketCreate" + "\n");
        waitTillElementIsVisible(ticketButton);
        ticketButton.click();
        Thread.sleep(3000);
        selectCategory.click();

        String[] status = new String[10];

        status[0] = billing.getText();
        status[1] = hardware.getText();
        status[2] = modification.getText();
        status[3] = order.getText();
        status[4] = service.getText();

        int index = (int) (Math.random() * 10);
        String a = status[index];

        if (a.equals(status[0])) {
            billing.click();
            selectDescription.click();
            //need to click billing descriptions
            ticketDescription(Integer.toString(randomselection(3))).click();
        } else if (a.equals(status[1])) {
            hardware.click();
            selectDescription.click();
            //need to click hardware descriptions
            ticketDescription(Integer.toString(randomselection(8))).click();
        } else if (a.equals(status[2])) {
            modification.click();
            selectDescription.click();
            //need to click modification descriptions
            ticketDescription(Integer.toString(randomselection(4))).click();
        } else if (a.equals(status[3])) {
            order.click();
            selectDescription.click();
            //need to click order descriptions
            ticketDescription(Integer.toString(randomselection(10))).click();
        } else {
            service.click();
            selectDescription.click();
            //need to click order descriptions
            ticketDescription(Integer.toString(randomselection(13))).click();
        }
        //description.click();
        reason.sendKeys("testing");
        ticketButton.click();
    }
    public WebElement ticketDescription(String index)
    {
        String option = "//android.widget.TextView[" + index + "]";
        WebElement desc = driver.findElement(By.xpath(option));
        return desc;
    }
    public int randomselection(int i)
    {
        Random random=new Random();
        int randomnumber = random.nextInt(i);
        if(randomnumber==0)
        {
            randomnumber++;
        }
        return randomnumber;
    }
}