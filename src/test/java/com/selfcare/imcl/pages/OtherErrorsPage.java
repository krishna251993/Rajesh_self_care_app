package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtherErrorsPage extends BasePage {
    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_dialog_cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/snackbar_text']")
    private WebElement error;

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/design_navigation_view']")
    private WebElement navigationDrawer;

    public OtherErrorsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void othererrors() {
        waitTillElementIsVisible(cancelButton);
        System.out.println("OtherErrors" + "\n");
        cancelButton.click();
        // waitTillElementIsVisible(otherError);

        /*int start = navigationDrawer.getLocation().getX();// get start co-ordinate of seekbar
        System.out.println(start);
        int end = navigationDrawer.getSize().getWidth();//Get width of seekbar
        System.out.println(end);
        int y = navigationDrawer.getLocation().getY();//get location of seekbar vertically
        System.out.println(y);
        //TouchAction action=new TouchAction(driver);// Select till which position you want to move the seekbar
        int moveTo = (int) (end * 0.95);//Move it 40%
        System.out.println(moveTo);*/

        //action.press(PointOption.point(start, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)));
        //action.moveTo(PointOption.point(moveTo, y)).release().perform();

        try {
            if (error.isDisplayed()) {
                System.out.println(error.getText());
            }
        } catch (Exception e) {

        }
    }
}